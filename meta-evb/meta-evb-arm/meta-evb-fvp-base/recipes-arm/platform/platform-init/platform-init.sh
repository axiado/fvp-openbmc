#!/bin/bash

PGOOD="/tmp/hostsharedir/pgood"

# Re-mount as RW file system
mount -o remount,rw /dev/mmcblk0p4 /

# Enable share file with Host Machine for power operation
mkdir /tmp/hostsharedir/
mount -t 9p -o trans=virtio,version=9p2000.L FM /tmp/hostsharedir

# Check PGood State
if [ -f "$PGOOD" ]; then
  value=$(cat $PGOOD)
  if [ "$value" == "1" ]; then
    # Set System On
    obmcutil poweron
  fi
fi
