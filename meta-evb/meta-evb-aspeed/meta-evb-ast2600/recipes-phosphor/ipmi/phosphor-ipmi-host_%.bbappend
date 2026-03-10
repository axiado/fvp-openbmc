FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SERIAL_DEVICE = "ttyS2"

PACKAGECONFIG:remove = "transport-null"
PACKAGECONFIG:append = " \
    transport-serial \
    arm-sbmr \
"

SRC_URI += " \
    file://0001-Support-Redfish-Host-Interface-commands.patch \
    file://0002-Add-IPMI-Arm-OEM-Command.patch \
    file://0003-meta-evb-meta-evb-arm-Add-Send-Platform-Error-Record.patch \
"
