#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
LOG="$ROOT/logs/Aralbayev_Bexultan_system_report.log"
{
  echo 'Student: Bexultan Aralbayev'
  echo "Date and time: $(date '+%Y-%m-%d %H:%M:%S %Z')"
  echo "Username: $(whoami)"
  echo 'Operating system:'
  grep '^PRETTY_NAME=' /etc/os-release || uname -s
  echo "Kernel: $(uname -r)"
  echo 'CPU information:'
  lscpu | grep -E '^(Architecture|CPU\(s\)|Model name):' || true
  echo 'Memory information:'
  free -h
  echo 'Disk usage and available space:'
  df -h .
} | tee "$LOG"
