SRC_URI:remove:evk-ax3005-fvp = "file://0002-Increase-MAXIMUM_TRANSFER_SIZE-of-PLDM.patch"
SRC_URI:remove:evk-ax3005-fvp-github = "file://0002-Increase-MAXIMUM_TRANSFER_SIZE-of-PLDM.patch"

EXTRA_OEMESON:append:evk-ax3005-fvp = " -Dmaximum-transfer-size=1048567"
EXTRA_OEMESON:append:evk-ax3005-fvp-github = " -Dmaximum-transfer-size=1048567"
