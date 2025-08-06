package com.tencent.thumbplayer.tcmedia.api.capability;

public class TPACodecCapabilityForGet {
    private int maxBitrate;
    private int maxChannels;
    private int maxLevel;
    private int maxProfile;
    private int maxSamplerate;

    public TPACodecCapabilityForGet(int i11, int i12, int i13, int i14, int i15) {
        this.maxSamplerate = i11;
        this.maxChannels = i12;
        this.maxBitrate = i13;
        this.maxProfile = i14;
        this.maxLevel = i15;
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getMaxChannels() {
        return this.maxChannels;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }

    public int getMaxSamplerate() {
        return this.maxSamplerate;
    }
}
