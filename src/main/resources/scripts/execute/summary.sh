#!/usr/bin/env bash
set -euo pipefail
. "$(dirname "$0")/lib/common.sh"

ci::log "Artifacts summary"
echo "Test log: ${LOG_DIR}/gradle-test.log"
echo "Coverage: ${COVERAGE_XML}"