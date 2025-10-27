open -a Docker


docker pull postgres:16
docker pull grafana/grafana:latest
docker pull grafana/tempo:latest
docker pull grafana/loki:latest
docker pull prom/prometheus:latest
docker pull otel/opentelemetry-collector-contrib:latest
docker pull sonarqube:community
docker pull hashicorp/vault:1.17


docker compose build --no-cache mfms


docker compose up -d
