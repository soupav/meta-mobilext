# Copyright (C) 2015 Assured Information Security, Inc.
# Author: Kyle J. Temkin <temkink@ainfosec.com>
#
# Released under the MIT license (see COPYING.MIT for the terms)
#

SUMMARY = "Image for a more full-featured Xen control domain, intended to demo the platform."
DESCRIPTION = " \
    This image contains a GUI-based Xen control domain, with all of the software necessary \
    to get a graphical view of each guest domain. This is not intended as a basis for a \
    secure platform-- it currently runs a full X server in the control domain. \
    \
    To make demonstrations and modification easier, this image contains a development environment \
    which can be used to create simple demo applets, where necessary. If you create something neat, \
    consider creating a BitBake recipe for it!. \
"
AUTHOR = "Kyle J. Temkin <temkink@ainfosec.com>"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

require xen-dom0-image.inc

#Group together the packages Angstrom includes in its XFCE development image.
ANGSTROM_XFCE_DEV_PACKAGES += " \
	xinput-calibrator \
	systemd-analyze \
	\
	packagegroup-xfce-base \
	packagegroup-gnome-xserver-base \
	packagegroup-core-x11-xserver \
	packagegroup-gnome-fonts \
	angstrom-gnome-icon-theme-enable gtk-engine-clearlooks gtk-theme-clearlooks angstrom-clearlooks-theme-enable \
	\
	angstrom-gdm-autologin-hack angstrom-gdm-xfce-hack gdm \
	\
	packagegroup-sdk-target \
	\
	bash \
  pciutils \
	usbutils \
	i2c-tools \
	parse-edid \
	memtester \
	alsa-utils \
	devmem2 \
	iw \
	bonnie++ \
	hdparm \
	iozone3 \
	iperf \
	lmbench \
	rt-tests \
	evtest \
	bc \
	fb-test \
	tcpdump \
	procps \
	util-linux \
	coreutils \
	ethtool \
	bridge-utils \
	wget \
	screen \
	minicom \
	rsync \
	vim vim-vimrc \
	\
	git \
	\
	e2fsprogs-mke2fs \
	dosfstools \
	parted \
	xfsprogs \
	btrfs-tools \
	\
	python-core python-modules \
"

#TODO: Include all of the packages necessary to view guest VMs.
GUEST_VM_DEMO_PACKAGES = ""



IMAGE_INSTALL += "\
    ${ANGSTROM_XFCE_DEV_PACKAGES} \
    ${GUEST_VM_DEMO_PACKAGES} \
"

export IMAGE_BASENAME = "xen-demo-dom0"

IMAGE_PREPROCESS_COMMAND += "do_delete_gnome_session ; "

do_delete_gnome_session () {
	rm -f ${IMAGE_ROOTFS}${datadir}/xsessions/gnome.desktop
}
