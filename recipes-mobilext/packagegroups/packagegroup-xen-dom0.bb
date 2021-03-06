# Copyright (C) 2015 Assured Information Security, Inc.
# Author: Kyle J. Temkin <temkink@ainfosec.com>
#
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Xen Hypervisor packaged for inclusion in a dom0 image"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    packagegroup-xen-hypervisor \
    packagegroup-xen-tools \
"

RDEPENDS_packagegroup-xen-hypervisor = " \
    xen-hypervisor \
    "

#
# A package group that includes the main Xen tools.
#
RDEPENDS_packagegroup-xen-tools = " \
    xen-base \
    xen-blktap \
    xen-console \
    xen-fsimage \
    xen-misc \
    xen-qemu \
    xen-fsimage \
    xen-scripts-block \
    xen-scripts-common \
    xen-scripts-network \
    xen-udev \
    xen-volatiles \
    xen-xencommons \
    xen-xendomains\
    xen-xenmon \
    xen-xenpmd \
    xen-xenstore \
    xen-xenstored \
    xen-xentrace \
    xen-xen-watchdog \
    xen-xl \
    "

#Packages not yet created (?):
# xen-flask 
# xen-gdbsx 
# xen-hvmloader 
# xen-kdd 
# xen-libblktap 
# xen-libblktapctl 
# xen-libblktapctl-dev 
# xen-libblktap-dev 
# xen-libfsimage 
# xen-libfsimage-dev 
# xen-libvhd 
# xen-libvhd-dev 
# xen-libxenctrl 
# xen-libxenctrl-dev 
# xen-libxenguest 
# xen-libxenguest-dev 
# xen-libxenlight 
# xen-libxenlight-dev 
# xen-libxenstat 
# xen-libxenstat-dev 
# xen-libxenstore 
# xen-libxenstore-dev 
# xen-libxenvchan 
# xen-libxenvchan-dev 
# xen-libxlutil 
# xen-libxlutil-dev 
# xen-pygrub 
# xen-python 
# xen-xcutils 
# xen-xenpaging 
# xen-xenstat 

