SERIAL_DEVICE = "ttyVUART1"

PACKAGECONFIG:remove = "transport-null"
PACKAGECONFIG:append = " \
    transport-serial \
    arm-sbmr \
"
