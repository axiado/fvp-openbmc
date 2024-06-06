SUMMARY = "Enable Redfish HI ethernet"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI += " \
            file://00-bmc-eth0.network \
"

do_install() {
    install -d ${D}${sysconfdir_native}/systemd/network/
    install -m 0644 ${UNPACKDIR}/00-bmc-eth0.network ${D}${sysconfdir_native}/systemd/network
}

