require recipes-bsp/u-boot/u-boot-axiado.inc

DEPENDS += "bc-native"

SRCREV = "b08355f003675f0ed0043af40b20645b2439f7a8"
SRCBRANCH = "u-boot-2019.04-axiado"
SRC_URI = "git://github.com/axiado/u-boot-axiado;protocol=https;branch=${SRCBRANCH}"
SRC_URI += "file://u-boot-axiado-env"

# 2019.04 does not have u-boot-initial-env target to build
UBOOT_INITIAL_ENV = ""

UBOOT_ENV_SRC = "u-boot-axiado-env"

do_compile:append() {
    ${B}/tools/mkenvimage -s ${UBOOT_ENV_SIZE} -o ${B}/${UBOOT_ENV_BINARY} ${UNPACKDIR}/u-boot-axiado-env
}

PV = "2019.04+git"
