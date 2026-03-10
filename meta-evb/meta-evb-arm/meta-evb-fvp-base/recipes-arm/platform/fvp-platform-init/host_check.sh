#!/bin/bash

# checking for Host state
if [ $# -lt 1 ]; then
  echo "Insufficient parameter = $#"
  exit 0;
fi

# Time out checking for Host is 120s
cnt=120
while [ "$cnt" -gt 0 ];
do
  cnt=$((cnt - 1))
  st=$(cat /tmp/hostsharedir/pgood)
  if [ "$st" == "$1" ]; then
    busctl set-property xyz.openbmc_project.State.Host0 \
        /xyz/openbmc_project/state/host0 xyz.openbmc_project.State.Host \
        CurrentHostState s xyz.openbmc_project.State.Host.HostState.Running
    exit 0
  fi
  sleep 1
done

exit 1

