#!/usr/bin/env bash
set -euo pipefail
. "$(dirname "$0")/lib/common.sh"

ci::log "JaCoCo coverage"
./gradlew clean test jacocoTestReport -Dspring.profiles.active="${SPRING_PROFILE}"

[[ -f "${COVERAGE_XML}" ]] || { echo "❌ Missing coverage XML at ${COVERAGE_XML}"; exit 1; }
echo "✅ Coverage XML: ${COVERAGE_XML}"