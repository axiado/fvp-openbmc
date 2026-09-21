SRCREV = "89ce7062c57ed2e1e854eb31c4430d66e7dfa537"
SRCBRANCH = "release/release-0.18.0"
SRC_URI = "git://bitbucket.org/ax-engg/kernel-6.6.git;protocol=https;branch=${SRCBRANCH}"
SRC_URI += "file://kernel.scc \
            file://kernel.cfg \
            file://0000-merge-nv-lstp-host.patch \
            file://0001-fix-build-error.patch \
            file://0002-spidev-create-device-node.patch \
            "

LINUX_VERSION = "6.6.16"
PV = "${LINUX_VERSION}+dev"

require recipes-kernel/linux/linux-axiado.inc
