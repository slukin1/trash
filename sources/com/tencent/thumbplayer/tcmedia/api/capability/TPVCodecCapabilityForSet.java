package com.tencent.thumbplayer.tcmedia.api.capability;

public class TPVCodecCapabilityForSet {
    private int level;
    private int lowerboundHeight;
    private int lowerboundWidth;
    private int profile;
    private int upperboundHeight;
    private int upperboundWidth;

    public TPVCodecCapabilityForSet(int i11, int i12) {
        this.upperboundWidth = i11;
        this.upperboundHeight = i12;
        this.lowerboundWidth = 0;
        this.lowerboundHeight = 0;
        this.profile = -1;
        this.level = -1;
    }

    public TPVCodecCapabilityForSet(int i11, int i12, int i13) {
        this.upperboundWidth = i11;
        this.upperboundHeight = i12;
        this.profile = i13;
        this.lowerboundWidth = 0;
        this.lowerboundHeight = 0;
        this.level = -1;
    }

    public TPVCodecCapabilityForSet(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.upperboundWidth = i11;
        this.upperboundHeight = i12;
        this.lowerboundWidth = i13;
        this.lowerboundHeight = i14;
        this.profile = i15;
        this.level = i16;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLowerboundHeight() {
        return this.lowerboundHeight;
    }

    public int getLowerboundWidth() {
        return this.lowerboundWidth;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getUpperboundHeight() {
        return this.upperboundHeight;
    }

    public int getUpperboundWidth() {
        return this.upperboundWidth;
    }
}
