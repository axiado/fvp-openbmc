FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SERIAL_DEVICE = "ttyAMA2"

PACKAGECONFIG:remove = "transport-null"
PACKAGECONFIG:append = " \
    transport-serial \
"
EXTRA_OEMESON= " \
  -Darm-sbmr=enabled \
"

SRC_URI += " \
    file://0001-Support-Redfish-Host-Interface-commands.patch \
    file://0002-Add-IPMI-Arm-OEM-Command.patch \
"
