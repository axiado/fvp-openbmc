require recipes-bsp/u-boot/u-boot-axiado.inc

SRCREV = "18712c51f68656fd181e703b409734a3123e34ed"
SRCBRANCH = "master"
SRC_URI = "git://github.com/axiado/u-boot-ax3005;protocol=https;branch=${SRCBRANCH}"

UBOOT_ENV_SRC = "build/u-boot-initial-env"

do_compile:append() {
    ${B}/tools/mkenvimage -s ${UBOOT_ENV_SIZE} -o ${B}/${UBOOT_ENV_BINARY} ${B}/u-boot-initial-env
}

PV = "2026.04+git"
