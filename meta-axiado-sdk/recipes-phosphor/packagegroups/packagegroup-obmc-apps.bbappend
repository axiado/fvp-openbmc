RDEPENDS:${PN}-network += " ax-net iptables iproute2 net-tools"
RDEPENDS:${PN}-system += "phosphor-sel-logger"
RDEPENDS:${PN}-extras += "axiado-eip-firmware \
                          boot-state \
                          gptfdisk \
                          logmgr \
                          parted \
			  phosphor-sel-logger \
                          tcu-reset \
                         "
