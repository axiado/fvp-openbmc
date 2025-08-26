LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"
DEPENDS = " \
    boost \
    cli11 \
    gtest \
    libpam \
    libtinyxml2 \
    nghttp2 \
    nlohmann-json \
    openssl \
    sdbusplus \
    zlib \
    ${@bb.utils.contains('PTEST_ENABLED', '1', 'gtest', '', d)} \
    ${@bb.utils.contains('PTEST_ENABLED', '1', 'gmock', '', d)} \
"
SRCREV = "a28e1e3a042f5b5f579d07bc1d7a3cad92e04151"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://git.gitlab.arm.com/server_management/bmcweb.git;branch=fvp_devel;protocol=https"
SRC_URI += " \
    file://run-ptest \
"

S = "${WORKDIR}/git"
SYSTEMD_SERVICE:${PN} += "bmcweb.service bmcweb.socket"

inherit systemd
inherit useradd
inherit pkgconfig meson ptest

PACKAGECONFIG ??= "mutual-tls-auth"
PACKAGECONFIG[insecure-redfish-expand]="-Dinsecure-enable-redfish-query=enabled"
PACKAGECONFIG[mutual-tls-auth]="-Dmutual-tls-auth=enabled,-Dmutual-tls-auth=disabled"

MUTUAL_TLS_PARSING="CommonName"

EXTRA_OEMESON = " \
    --buildtype=minsize \
    -Dtests=${@bb.utils.contains('PTEST_ENABLED', '1', 'enabled', 'disabled', d)} \
    ${@bb.utils.contains('PACKAGECONFIG', 'mutual-tls-auth', \
        '-Dmutual-tls-common-name-parsing-default=' + d.getVar('MUTUAL_TLS_PARSING', True), \
        '', d)} \
"

do_install_ptest() {
        install -d ${D}${PTEST_PATH}/test
        cp -rf ${B}/*_test ${D}${PTEST_PATH}/test/
}

RDEPENDS:${PN} += " \
    jsnbd \
    phosphor-objmgr \
"

FILES:${PN} += "${datadir}/** "

USERADD_PACKAGES = "${PN}"
# add a user called httpd for the server to assume
USERADD_PARAM:${PN} = "-r -s /sbin/nologin bmcweb"

GROUPADD_PARAM:${PN} = "web; redfish; hostconsole"
FULL_OPTIMIZATION:append = " -Os"
