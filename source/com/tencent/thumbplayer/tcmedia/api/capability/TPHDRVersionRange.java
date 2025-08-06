package com.tencent.thumbplayer.tcmedia.api.capability;

public class TPHDRVersionRange {
    public int lowerboundAndroidAPILevel;
    public int lowerboundPatchVersion;
    public int lowerboundSystemVersion;
    public int upperboundAndroidAPILevel;
    public int upperboundPatchVersion;
    public int upperboundSystemVersion;

    public TPHDRVersionRange(int i11, int i12) {
        this.upperboundAndroidAPILevel = i11;
        this.lowerboundAndroidAPILevel = i12;
    }

    public TPHDRVersionRange(int i11, int i12, int i13, int i14) {
        this.upperboundSystemVersion = i11;
        this.lowerboundSystemVersion = i12;
        this.upperboundPatchVersion = i13;
        this.lowerboundPatchVersion = i14;
    }
}
