package com.tencent.thumbplayer.tcmedia.api.capability;

public class TPACodecCapabilityForSet {
    private int level;
    private int lowerboundBitrate;
    private int lowerboundChannels;
    private int lowerboundSamplerate;
    private int profile;
    private int upperboundBitrate;
    private int upperboundChannels;
    private int upperboundSamplerate;

    public TPACodecCapabilityForSet(int i11, int i12, int i13) {
        this.upperboundSamplerate = i11;
        this.upperboundChannels = i12;
        this.upperboundBitrate = i13;
        this.lowerboundSamplerate = 0;
        this.lowerboundChannels = 0;
        this.lowerboundBitrate = 0;
        this.profile = 0;
        this.level = 0;
    }

    public TPACodecCapabilityForSet(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.upperboundSamplerate = i11;
        this.upperboundChannels = i12;
        this.upperboundBitrate = i13;
        this.lowerboundSamplerate = i14;
        this.lowerboundChannels = i15;
        this.lowerboundBitrate = i16;
        this.profile = i17;
        this.level = i18;
    }

    public int getLevelForSet() {
        return this.level;
    }

    public int getLowerboundBitrate() {
        return this.lowerboundBitrate;
    }

    public int getLowerboundChannels() {
        return this.lowerboundChannels;
    }

    public int getLowerboundSamplerate() {
        return this.lowerboundSamplerate;
    }

    public int getProfileForSet() {
        return this.profile;
    }

    public int getUpperboundBitrate() {
        return this.upperboundBitrate;
    }

    public int getUpperboundChannels() {
        return this.upperboundChannels;
    }

    public int getUpperboundSamplerate() {
        return this.upperboundSamplerate;
    }
}
