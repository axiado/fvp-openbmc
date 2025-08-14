FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# increase the timeouts for our use-case,
# refer to this layer's README.md

EXTRA_OEMESON:append = " \
  -Dresponse-time-out=10000 \
  -Ddbus-timeout-value=20 \
"

SRC_URI:append = " file://host_eid "

SYSTEMD_SERVICE:${PN}:remove = " \
                                pldmSoftPowerOff.service \
                               "
SRC_URI:remove = "file://pldm-softpoweroff"

do_install:append() {
    install -d ${D}/usr/share/pldm/bios
    install -D -m 0644 ${UNPACKDIR}/host_eid ${D}/usr/share/pldm

    LINK="${D}${systemd_unitdir}/obmc-host-shutdown@0.target.wants/pldmSoftPowerOff.service"
    rm -f $LINK
    LINK="${D}${systemd_unitdir}/obmc-host-warm-reboot@0.target.wants/pldmSoftPowerOff.service"
    rm -f $LINK
    rm -f ${D}${systemd_unitdir}/system/pldmSoftPowerOff.service
    rm -rf ${D}/${bindir}/pldm-softpoweroff
}
