#!/usr/bin/env bash
set -euo pipefail
. "$(dirname "$0")/lib/common.sh"

ci::log "Gradle test (profile=${SPRING_PROFILE})"
ci::require ./gradlew

# Capture logs for later inspection
./gradlew test --info -Dspring.profiles.active="${SPRING_PROFILE}" \
  | tee "${LOG_DIR}/gradle-test.log"

# Fail build if real Postgres was touched (tune regex if you use Testcontainers)
if grep -E -i 'postgres|jdbc:postgresql|org\.postgresql|PostgreSQL' "${LOG_DIR}/gradle-test.log" >/dev/null; then
  echo "❌ Postgres-related logs detected during unit tests. Ensure test profile uses fakes/in-memory."
  exit 1
fi
echo "✅ No Postgres logs detected."