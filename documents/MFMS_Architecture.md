# MFMS – Architecture

**Date:** 2025-10-28  
**Owner:** MFMS Team (Backend: Spring Boot)  
**Purpose:** Describe the current architecture of the Mutual Fund Management System (MFMS) and how it fulfills the functional/technical requirements. It also highlights intentional deviations and next steps.

---

## 1. Executive Summary

MFMS is a RESTful backend for a Mutual Fund platform. It supports:
- **User lifecycle** (enrollment/authentication, role-based access)
- **Admin operations** (fund/script & NAV management, user management)
- **Trading** (buy/redeem) against **current-day NAV only**
- **Holdings & portfolio view** with atomic updates and auditability

The service is built with **Java + Spring Boot**, **Spring Data JPA** on **PostgreSQL**, with **observability** (OpenTelemetry, Prometheus, Grafana, Loki/Tempo) and **quality gates** (JUnit5, JaCoCo, SonarQube).

---

## 2. Requirements Traceability (Summary)

MFMS implements the FRD items for user enrollment/authentication, admin/user operations, current-day NAV constraint, validation/error handling, and unit testing & coverage. The system’s endpoints are documented via **OpenAPI/Swagger**, and project structure follows standard controller–service–repository layering. (See “Appendix A: Mapping” for details.)

> Functional/Technical requirements reference: Mutual Fund Management – Evaluation Problem (uploaded).

---

## 3. High-Level Architecture

```
[Client Apps] ──HTTP/JSON──> [API Layer (Spring MVC, Controllers)]
                                 │
                                 ▼
                         [Service Layer]
                   (Domain logic, validation,
                  NAV constraint enforcement)
                                 │
                                 ▼
                          [Repository Layer]
                      (Spring Data JPA/Hibernate)
                                 │
                                 ▼
                           [PostgreSQL DB]
                                 │
                                 ├── [Flyway Migrations]
                                 └── [Transaction Mgmt]
                                 
Observability:
  [OpenTelemetry Java Agent] → [OTel Collector] → [Prometheus | Tempo | Loki] → [Grafana]
Quality:
  [JUnit5] + [Mockito] + [Testcontainers (opt)] + [JaCoCo] + [SonarQube]
```

**Key Principles**
- **Layered Architecture** (API → Service → Repository) for separation of concerns.  
- **DTOs** for API input/output; **Entities** for persistence.  
- **Transactional integrity** for buy/redeem & NAV updates (service-level `@Transactional`).  
- **Idempotency** patterns considered for re-tries (API clients) via business keys where applicable.  
- **12‑factor**-style configuration via environment variables & profiles.

---

## 4. Core Domain Model

**Entities (canonical):**
- `UserAccount`: `id`, `username` (unique), `passwordHash`, `role` (`ADMIN`/`USER`), `createdAt`.
- `Fund`: `id`, `symbol` (unique), `name`, `active`.
- `Nav`: `id`, `fundId`, `navDate`, `value` (BigDecimal). **One per fund per day.**
- `Holding`: `id`, `userId`, `fundId`, `units` (BigDecimal).
- `Trade`: `id`, `userId`, `fundId`, `units`, `tradeType` (`BUY`/`REDEEM`), `navAtTrade`, `tradeTime`. (Optional for full audit)

**Invariants & Constraints:**
- **Current‑day NAV only:** buy/redeem must use `Nav(navDate = today)`.  
- **Units ≥ 0:** no negative balances; redeem ≤ units held.  
- **Unique keys:** `UserAccount.username`, `Fund.symbol`, `(Nav.fundId, Nav.navDate)`.

---

## 5. API & Workflow

- **Enrollment (public):** register new users; password hashing (BCrypt).  
- **Authentication:** via Spring Security; endpoints secured by role and ownership.  
- **Admin:**
  - Create/update funds
  - Upsert **today’s** NAV per fund
  - Manage users (list/create/deactivate) without deleting historical trades
- **User:**
  - **Buy** units at **today’s** NAV → increments `Holding.units`; record `Trade`
  - **Redeem** units at **today’s** NAV → decrements `Holding.units`; record `Trade`
  - **Portfolio** view returns holdings and computed value (`units * today’s NAV`)

**Error Handling (examples):**
- 400 Bad Request – invalid NAV/units; redeem exceeds holdings.  
- 401/403 – unauthenticated/unauthorized access.  
- 404 – fund/user not found.  
- 409 – concurrency/state conflict (rare; retriable).

**API Documentation:** OpenAPI/Swagger is generated (springdoc). The produced `mfms-openapi.yaml` is source-of-truth and imported to Swagger UI / Postman.

---

## 6. Persistence & Transactions

- **Spring Data JPA (Hibernate)** with **PostgreSQL**.  
- **Flyway** for versioned schema migrations.  
- **Transaction boundaries** at service layer:
  - **Buy/Redeem** are atomic:
    1. Lookup `todayNav` for `fund`
    2. Validate quantities & balances
    3. Update `Holding` (upsert if first-time buy)
    4. Persist `Trade` (audit)
  - **Isolation:** default `READ_COMMITTED`; optimistic locking (`@Version`) may be added to `Holding` to prevent lost updates in high-concurrency environments.

**Indexes:**
- `UserAccount(username)` unique
- `Fund(symbol)` unique
- `Nav(fundId, navDate)` unique
- `Holding(userId, fundId)` unique

---

## 7. Security

- **Authentication:** Spring Security. (FRD asks for **Basic Auth**; codebase may already support **JWT Bearer** — see “Deltas” below.)  
- **Authorization:** Role-based (`ADMIN` vs `USER`), plus **ownership** checks for user-specific data.  
- **Password storage:** BCrypt hashes; no plaintext.  
- **Transport:** TLS termination at gateway/ingress (env‑specific).  
- **Swagger exposure:** Swagger & `/v3/api-docs` endpoints behind auth in non‑dev environments.

---

## 8. Observability & Ops

- **Metrics:** Spring / Micrometer → Prometheus (via OTel Collector).  
- **Traces:** OpenTelemetry → Tempo.  
- **Logs:** JSON via Logback encoder → Loki; correlation with `traceId`/`spanId`.  
- **Dashboards:** Grafana boards for latency, throughput, error rate, DB health.  
- **Profiles:** `local`, `dev`, `prod`; sensitive config via env/secret stores.

**Quality Gates**
- **Testing:** JUnit5 + Mockito (+ Testcontainers optional).  
- **Coverage:** JaCoCo ≥80%; integrated with **SonarQube**.  
- **CI:** Gradle tasks (build, test, coverage, sonar).  
- **CD:** Docker images; Compose for local, Helm/K8s optional for prod.

---

## 9. Deployment Topology (Reference)

```
[Client] → [API Gateway/Ingress] → [MFMS Service (Spring Boot)]
                                     │
                                     └──→ [PostgreSQL]
Observability sidecars/adjacents:
  [OTel Collector] ← MFMS Java Agent → [Prometheus | Tempo | Loki] → [Grafana]
```

- **Scale-out:** Stateless service; horizontal replicas behind load balancer.  
- **DB:** Single primary (HA options via managed Postgres if required).  
- **Config:** Externalized via env/profiles; secrets from Vault/KMS (env‑specific).

---

## 10. Deltas vs FRD & Remediation Plan

| Area | FRD Expectation | Current Implementation | Action |
|---|---|---|---|
| Authentication | **Basic Auth** | If code uses **JWT Bearer** (common in production), or default auth; | a) Keep JWT for production-grade flows, or b) add a BasicAuth profile for parity. Update Swagger security scheme accordingly. |
| Transaction History | “Optional” | Recommended `Trade` table for auditability | Keep; enables statements & troubleshooting |
| Test Coverage | ≥80% | JaCoCo wired; verify actual %. | Shore up tests for edge cases; gate in CI |
| NAV Constraint | “Current-day NAV only” | Enforced in Service | Unit tests + boundary tests (TZ, EOD) |
| Error Model | Clear messages | Provide `ApiError` shape consistently | Add global `@ControllerAdvice` if missing |

---

## 11. Non-Functional Requirements

- **Performance:** P99 latency < 200ms for standard operations; pagination on list endpoints.  
- **Security:** OWASP controls; input validation; rate limiting at edge if exposed publicly.  
- **Reliability:** Graceful shutdown; health/readiness probes; retries on idempotent reads (client-side).  
- **Data:** Backups & retention policies per environment; GDPR alignment where applicable.

---

## 12. Requirement Mapping (Selected)

- **User Enrollment & Auth** → `AuthController`, `UserService`, `Spring Security` (password hashing, roles).  
- **Admin: Fund & NAV** → `FundController`, `NavController`, `FundService`, `NavService`.  
- **User: Buy/Redeem** → `TradeController` (or `PortfolioController`), `TradeService` / `PortfolioService`.  
- **Holdings** → `HoldingService`, `HoldingRepository`; portfolio aggregation service.  
- **Validation** → `jakarta.validation` on DTOs + service-level guards.  
- **DB Schema & Consistency** → JPA entities, Flyway scripts.  
- **Testing & Coverage** → JUnit5/Mockito, JaCoCo; Sonar rules.  
- **Documentation** → Springdoc OpenAPI; `mfms-openapi.yaml` exported.

---

## 13. Data Model (Text ERD)

```
UserAccount( id PK, username UNIQUE, passwordHash, role, createdAt )
Fund( id PK, symbol UNIQUE, name, active )
Nav( id PK, fundId FK→Fund.id, navDate, value, UNIQUE(fundId, navDate) )
Holding( id PK, userId FK→UserAccount.id, fundId FK→Fund.id, units, UNIQUE(userId, fundId) )
Trade( id PK, userId FK→UserAccount.id, fundId FK→Fund.id, tradeType, units, navAtTrade, tradeTime )
```

---

## 14. Runbook (Local)

- **Build:** `./gradlew clean build`  
- **Run (local):** `SPRING_PROFILES_ACTIVE=local java -jar build/libs/*.jar`  
- **Docker Compose:** `docker compose up -d` (db + observability stack)  
- **Swagger UI:** `http://localhost:8080/swagger-ui.html` (or `/swagger-ui/index.html` with springdoc starter)  
- **Health:** `GET /actuator/health` (if enabled)

---

## 15. Need to do

- **Clock/timezone dependence** for “today’s NAV” logic → pin TZ, evaluate trading day cutoff rules.  
- **Concurrent trading** → add optimistic locking on `Holding`.  
- **Rate limits & abuse** → add throttling at gateway; audit trail with `Trade`.  
- **Secrets mgmt** → externalize DB creds; avoid plaintext in configs.

