# Copyright (C) 2015 Assured Information Security, Inc.
# Author: Kyle J. Temkin <temkink@ainfosec.com>
#
# Released under the MIT license (see COPYING.MIT for the terms)
#
# Root filesystem for a simple dom0; including a kernel which can be used
# to boot the image. Xen is not included, but can easily be added by appending
# to IMAGE_INSTALL.
#

DESCRIPTION = "Root image for a simple Xen domain 0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp ;"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

CONMANPKGS ?= "connman connman-angstrom-settings connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi"
CONMANPKGS_libc-uclibc = ""

IMAGE_INSTALL += " \
	angstrom-packagegroup-boot \
	packagegroup-basic \
	${ROOTFS_PKGMANAGE_PKGS} \
  update-alternatives-cworth \
  packagegroup-xen-tools \
	systemd-analyze \
	cpufreq-tweaks \
  kernel-modules \
	${CONMANPKGS} \
	fixmac \
"

TARGET_HOSTNAME = "mobilext-dom0"

# Systemd journal is preferred.
BAD_RECOMMENDATIONS += "busybox-syslog"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "xen-base-dom0"

inherit override-hostname
inherit image