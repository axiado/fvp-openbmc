FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:evk-ax3005-fvp = " file://ax3005-fvp.dts"
SRC_URI:append:evk-ax3005-fvp-github = " file://ax3005-fvp-github.dts"

do_configure:append:evk-ax3005-fvp() {
    cp ${UNPACKDIR}/ax3005-fvp.dts ${S}/arch/arm64/boot/dts/axiado/
}

do_configure:append:evk-ax3005-fvp-github() {
    cp ${UNPACKDIR}/ax3005-fvp-github.dts ${S}/arch/arm64/boot/dts/axiado/
}
