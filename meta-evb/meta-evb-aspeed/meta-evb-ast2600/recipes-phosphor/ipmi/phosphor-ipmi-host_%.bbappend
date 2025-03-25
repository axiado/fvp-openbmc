SERIAL_DEVICE = "ttyS2"

PACKAGECONFIG:remove = "transport-null"
PACKAGECONFIG:append = " \
    transport-serial \
"

EXTRA_OEMESON= " \
  -Darm-sbmr=enabled \
"

