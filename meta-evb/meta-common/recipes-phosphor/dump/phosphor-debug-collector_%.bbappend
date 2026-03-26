SRC_URI += "git://git.gitlab.arm.com/server_management/phosphor-debug-collector.git;branch=fvp_devel;protocol=https"
SRC_URI:remove = "git://github.com/openbmc/phosphor-debug-collector;branch=master;protocol=https"
SRCREV = "82f817f99af46879f79f5cd6dcfa0bbb63669415"

PACKAGECONFIG[arm-dumps-extension] = " \
       -Darm-dumps-extension=enabled, \
       -Darm-dumps-extension=disabled  \
"

