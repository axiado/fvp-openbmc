FILESEXTRAPATHS:prepend := "${THISDIR}/linux-aspeed:"
SRC_URI:append = " \
                   file://aspeed-ast2600-evb.dts \
                   file://aspeed-g6.dtsi \
                   file://mctp.scc \
                   file://i3c.scc \
                 "

do_patch:append() {
  cp ${UNPACKDIR}/aspeed-ast2600-evb.dts ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/aspeed/
  cp ${UNPACKDIR}/aspeed-g6.dtsi ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/aspeed/
}

