chmod +x ./setup.sh
#!/usr/bin/env bash
set -euo pipefail

# --- helpers ---
ci::require() { command -v "$1" >/dev/null 2>&1 || { echo "Missing: $1"; exit 127; }; }
ci::need_env() { [[ -n "${!1:-}" ]] || { echo "Env var required: $1"; exit 2; }; }
ci::repo_root() { git rev-parse --show-toplevel 2>/dev/null || pwd; }
ci::log() { printf "\n==== %s ====\n" "$*"; }

# --- defaults (overridable via env) ---
export SPRING_PROFILE="${SPRING_PROFILE:-test}"
export SONAR_HOST_URL="${SONAR_HOST_URL:-http://localhost:9000}"
export LOG_DIR="${LOG_DIR:-build/qa-logs}"
export COVERAGE_XML="${COVERAGE_XML:-build/reports/jacoco/test/jacocoTestReport.xml}"
export GRADLE_OPTS="${GRADLE_OPTS:-"-Dorg.gradle.daemon=false -Dorg.gradle.jvmargs='-Xmx2g'"}"

mkdir -p "${LOG_DIR}"