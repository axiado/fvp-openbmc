SRCREV = "1a1d852d66ff350ffba612a1fa91cc714cae0ea8"
SRCBRANCH = "dev-6.18-axiado"
SRC_URI = "git://github.com/axiado/linux-axiado;protocol=https;branch=${SRCBRANCH}"
SRC_URI += "file://kernel.scc \
            file://kernel.cfg \
            file://0000-nv-lstp-poc.patch \
            file://0001-debug-ssif-master-slave-in-one-BMC.patch \
            file://0002-add-lstp-bridge-side-uart-forwarder.patch \
            "

LINUX_VERSION = "6.18.20"
PV = "${LINUX_VERSION}+git"

require recipes-kernel/linux/linux-axiado.inc
