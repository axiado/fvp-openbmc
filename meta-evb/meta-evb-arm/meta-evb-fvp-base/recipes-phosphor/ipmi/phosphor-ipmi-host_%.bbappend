FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# remove xyz.openbmc_project.Ipmi.Internal.SoftPowerOff.service
SOFT_SVC = ""
SOFT_TGTFMT = ""
SOFT_FMT = ""

RDEPENDS:${PN}:remove = "phosphor-watchdog"

SERIAL_DEVICE = "ttyAMA2"

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

