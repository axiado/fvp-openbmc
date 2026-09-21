SERIAL_DEVICE = "ttyPS0"

PACKAGECONFIG:remove = "transport-null"
PACKAGECONFIG:append = " \
    transport-serial \
    arm-sbmr \
"
