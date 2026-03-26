PACKAGECONFIG = "abi-development"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-transport-af-mctp-Fix-TID-lookup-with-MCTP_NET_ANY.patch"

