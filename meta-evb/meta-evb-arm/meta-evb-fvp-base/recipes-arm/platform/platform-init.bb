SUMMARY = "Base FVP Platform Init"

PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit systemd
inherit obmc-phosphor-systemd

DEPENDS += "systemd"
RDEPENDS:${PN} += "libsystemd"
RDEPENDS:${PN} += "bash"

SRC_URI += " \
    file://platform-init.service \
    file://platform-init.sh \
    file://host_check.sh \
"

S = "${UNPACKDIR}"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "platform-init.service"

do_install() {
    install -d ${D}${sbindir}
    install -m 0755 ${UNPACKDIR}/*.sh ${D}${sbindir}/

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${UNPACKDIR}/platform-init.service ${D}${systemd_unitdir}/system
}

