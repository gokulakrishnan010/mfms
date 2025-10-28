
# MFMS — Mutual Fund Management System

Last updated: 2025-10-28

A production-grade Spring Boot service for managing mutual funds, NAVs, trades (buy/redeem), and user portfolios with strong observability and CI/CD hooks.

---

## Features
- REST API with Spring MVC + springdoc-openapi (Swagger UI)
- Security with Spring Security (supports JWT/Bearer; BasicAuth profile optional)
- PostgreSQL with Flyway migrations
- Observability: OpenTelemetry Java agent -> OTel Collector -> Prometheus/Loki/Tempo -> Grafana
- Quality gates: JUnit 5, JaCoCo coverage, SonarQube
- Docker Compose for local infra (DB + observability stack)

---

## Prerequisites
- Java 25 (Temurin recommended)
- Gradle 9.1+ (wrapper included)
- Docker & Docker Compose
- Git

Check versions:
```bash
java -version
./gradlew --version
docker --version
docker compose version
```

---

## Quick Start (Local Dev)

1) Clone & open
```bash
git clone https://github.com/gokulakrishnan010/mfms.git
cd mfms
```

2) Start infra (DB + Observability)
```bash
docker compose up -d
```
Notes:
- Remove deprecated 'version:' key in docker-compose.yml if warned.
- If you see 'services.tempo.ports.1 must be a number', ensure ports are not wrapped in quotes.

3) Configure environment
Create a .env.local file (used by your IDE/run config) with sensible defaults:

```env
# --- App ---
APP_ENV=local
SERVER_PORT=8080
SPRING_PROFILES_ACTIVE=local

# --- PostgreSQL ---
DB_HOST=localhost
DB_PORT=5432
DB_NAME=postgres
DB_SCHEMA=mfms
DB_USERNAME=mfms
DB_PASSWORD=mfms

SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres?currentSchema=mfms
SPRING_DATASOURCE_USERNAME=mfms
SPRING_DATASOURCE_PASSWORD=mfms

# --- OpenTelemetry (optional in local) ---
JAVA_TOOL_OPTIONS=-javaagent:/otel-agent/opentelemetry-javaagent.jar -Dotel.instrumentation.logback-appender.enabled=true
OTEL_SERVICE_NAME=mfms
OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4317
OTEL_METRICS_EXPORTER=otlp
OTEL_TRACES_EXPORTER=otlp
OTEL_LOGS_EXPORTER=otlp
```

4) Build & run
```bash
./gradlew clean build
SPRING_PROFILES_ACTIVE=local java -jar build/libs/*-SNAPSHOT.jar
```
Or via IntelliJ: run MfmsApplication with SPRING_PROFILES_ACTIVE=local.

If using the OTel Java agent, mount /otel-agent in Docker or configure the agent path in your run configuration.

5) Verify
- Health: GET http://localhost:8080/actuator/health
- Swagger UI:
  - Starter (new): http://localhost:8080/swagger-ui/index.html
  - Legacy (ui module): http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

If Swagger UI prompts for login, ensure your security config permits /swagger-ui/** and /v3/api-docs/** in local profile.

---

## Database

Initialize / inspect
```bash
# psql inside container
docker exec -it mfms-db psql -U postgres

# readiness
docker exec -it mfms-db pg_isready -U postgres -d postgres

# list schemas/tables
\dn
\dt mfms.*
```

Common queries
```sql
-- Switch DB
\c postgres;

-- Create roles (if not done via init)
CREATE ROLE mfms WITH LOGIN PASSWORD 'mfms';
ALTER ROLE mfms SET search_path TO mfms,public;

-- Create schema
CREATE SCHEMA IF NOT EXISTS mfms AUTHORIZATION mfms;
GRANT ALL ON SCHEMA mfms TO mfms;
```

Do not use CREATE DATABASE IF NOT EXISTS in Postgres (syntax error).

Flyway
- Migrations live under src/main/resources/db/migration
- On app start, Flyway auto-applies pending migrations.

---

## Observability Stack

Pipeline
App (OTel Java Agent) -> OTel Collector (4317 gRPC) -> Prometheus/Loki/Tempo -> Grafana

Useful endpoints
- App metrics: http://localhost:8889/metrics (if Micrometer/Prometheus enabled)
- Grafana: http://localhost:3000/ (admin/admin by default; change in Compose)
- Loki push: http://localhost:3100/v1/logs (use POST)
- Tempo: usually port 3200/4317 depending on Compose

Run with agent (example)
```bash
JAVA_TOOL_OPTIONS="-javaagent:/otel-agent/opentelemetry-javaagent.jar -Dotel.instrumentation.logback-appender.enabled=true" OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4317 SPRING_PROFILES_ACTIVE=local java -jar build/libs/*-SNAPSHOT.jar
```

---

## Security

- Default: Spring Security.
- For JWT/Bearer: Set Authorization: Bearer <token> in API calls.
- For Basic Auth profile (optional for FRD parity): expose a 'basic' profile and attach a Swagger security scheme of type http/basic.

Permit Swagger in local
```java
.requestMatchers("/v3/api-docs/**","/swagger-ui/**","/swagger-ui.html").permitAll()
```

---

## Tests & Coverage
```bash
# run unit tests
./gradlew test

# generate coverage report (HTML + XML)
./gradlew jacocoTestReport

# open report
open build/reports/jacoco/test/html/index.html
```

In CI, prefer failing the build if coverage < threshold (e.g., 80%).

---

## SonarQube (optional)
```bash
# Local server at http://localhost:9000
./gradlew test jacocoTestReport sonarqube   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=<YOUR_TOKEN>
```
Where to configure
- In build.gradle using sonarqube { properties { ... } }, or
- Create sonar-project.properties / sonar-project.yml at repo root.

---

## Script Helpers

If you use the scripts under src/main/resources/scripts/execute:
```bash
# make scripts executable
chmod +x src/main/resources/scripts/execute/*.sh

# run setup
/bin/zsh src/main/resources/scripts/execute/setup.sh
```

If 'permission denied', verify executable bit and shell path; on macOS use /bin/zsh.

---

## Run Everything in Docker (App + DB)

Option A: JVM app locally + Dockerized infra (recommended for dev — see Quick Start).
Option B: App also in Docker (port 8080).

Build & run app image:
```bash
docker build -t mfms-app:local .
docker run --name mfms-app --rm   -p 8080:8080   --env-file .env.local   mfms-app:local
```

On macOS, --network host has limitations; alternatively, pass DB_HOST=host.docker.internal and map ports explicitly.

---

## Troubleshooting

- Gradle download slow: Use Gradle wrapper cache; verify internet proxy.
- Swagger 404: Use correct path based on your dependency:
  - springdoc-openapi-starter-webmvc-ui -> /swagger-ui/index.html
  - springdoc-openapi-ui (legacy) -> /swagger-ui.html
- 'tempo.ports must be a number': Remove quotes around port numbers in docker-compose.yml.
- lsof to find port conflicts:
  ```bash
  lsof -i :8080
  lsof -i :5432
  ```
- DB connection refused: Ensure container is up: docker ps; check env DB_HOST/PORT/USERNAME/PASSWORD.
- Flyway checksum mismatch: Don’t edit applied migration files; create a new Vxxx__patch.sql instead.

---

## API Docs

You can import the generated OpenAPI file into Swagger UI / Postman:
- OpenAPI YAML: mfms-openapi.yaml
- Markdown API: MFMS_API_Document.md

---

## Project Structure (abridged)

```
mfms/
 ├─ src/main/java/com/acme/mutualfund/...
 │   ├─ config/           # SecurityConfig, Swagger config
 │   ├─ controller/       # REST controllers
 │   ├─ service/          # Business logic
 │   ├─ repository/       # Spring Data JPA
 │   ├─ dto/              # API DTOs
 │   └─ entity/           # JPA entities
 ├─ src/main/resources/
 │   ├─ application-*.yml
 │   ├─ db/migration/     # Flyway scripts
 │   └─ scripts/execute/  # helper scripts
 ├─ docker-compose.yml
 ├─ build.gradle
 └─ README.md
```

---
