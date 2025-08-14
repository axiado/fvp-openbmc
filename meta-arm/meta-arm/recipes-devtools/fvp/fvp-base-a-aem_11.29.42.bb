require fvp-envelope.inc

LICENSE:append = " & Artistic-2.0 & BSL-1.0 & BSD-2-Clause & Unlicense"

SUMMARY = "Arm Fixed Virtual Platform - Armv-A Base RevC Architecture Envelope Model FVP"
LIC_FILES_CHKSUM = "file://license_terms/license_agreement.txt;md5=1a33828e132ba71861c11688dbb0bd16 \
                    file://license_terms/third_party_licenses/third_party_licenses.txt;md5=41f1533ebfbd4f1d32cfc82b55f6729a  \
                    file://license_terms/third_party_licenses/arm_license_management_utilities/third_party_licenses.txt;md5=abcaafefc7b7a0cdf6664c51f9075c5b"


SRC_URI = "https://developer.arm.com/-/cdn-downloads/permalink/FVPs-Architecture/FM-11.29-42/${MODEL_CODE}_${PV_URL}_${FVP_ARCH}.tgz;subdir=${BP};name=fvp-${HOST_ARCH}"
SRC_URI[fvp-aarch64.sha256sum] = "738f2270fbad6d9e10e675448fd7d30f20cc3d5bd087b8f9bc39c56ff1d89693"
SRC_URI[fvp-x86_64.sha256sum] = "a48468821fe4d1eb291a2822596bf6d7429195f72ac3abaa1957782fd9f0665b"

# The CSS used in the FVP homepage make it too difficult to query with the tooling currently in Yocto
UPSTREAM_VERSION_UNKNOWN = "1"

MODEL_CODE = "FVP_Base_RevC-2xAEMvA"

COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"
