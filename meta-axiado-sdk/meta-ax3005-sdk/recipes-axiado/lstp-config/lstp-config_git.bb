# Copyright (c) 2021-26 Axiado Corporation (or its affiliates). All rights reserved.
SUMMARY = "LSTP configuration tool"
DESCRIPTION = "Userspace tool that reads and writes LSTP device configuration \
over libusb, importing and exporting the configuration as YAML"
HOMEPAGE = "https://github.com/NVIDIA/lstp-config"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44b1a6d36426b67ca4b9e75c9d3b288b"

PV = "1.0+git"

SRCBRANCH = "main"
SRCREV = "951266d9e276b3b6d58e82932149bb5bcd9a8fcf"
SRC_URI = "git://github.com/NVIDIA/lstp-config.git;protocol=https;branch=${SRCBRANCH} \
           file://lstp_ch_config.yaml \
           "

DEPENDS = "libusb1 libyaml"

# The upstream Makefile targets fixed x86/armhf toolchains and vendors static
# copies of libusb and libyaml downloaded at build time. Compile the sources
# directly with the Yocto toolchain against the staged libraries instead, and
# keep the upstream binary name.
LSTP_CONFIG_TOOL = "lstp_config_tool_ARM"

LSTP_CONFIG_SRCS = "main.c lstp_usb.c lstp_config_usb.c lstp_config_compare.c \
                    yaml_config.c lstp_wire_str.c lstp_util.c"

do_compile() {
    ${CC} -std=c11 -Wall -Wextra ${CFLAGS} ${CPPFLAGS} ${LDFLAGS} \
        -o ${B}/${LSTP_CONFIG_TOOL} ${LSTP_CONFIG_SRCS} \
        -lyaml -lusb-1.0 -pthread
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/${LSTP_CONFIG_TOOL} ${D}${bindir}

    install -d ${D}${sysconfdir}
    install -m 0644 ${UNPACKDIR}/lstp_ch_config.yaml ${D}${sysconfdir}/lstp_ch_config.yaml
}

FILES:${PN} = "${bindir}/${LSTP_CONFIG_TOOL} \
               ${sysconfdir}/lstp_ch_config.yaml \
               "
