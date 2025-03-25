FILESEXTRAPATHS:prepend := "${THISDIR}/linux-aspeed:"
SRC_URI:append = " \
                   file://aspeed-ast2600-evb.dts \
                   file://mctp.scc \
                 "

do_patch:append() {
  cp ${UNPACKDIR}/aspeed-ast2600-evb.dts ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/aspeed/
}

