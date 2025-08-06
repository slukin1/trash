package com.tencent.thumbplayer.tcmedia.api.capability;

public class TPVCodecCapabilityForGet {
    private static final int MAX_FRAME_RATE_FOR_LUMA_SAMPLES_DEFAULT = -1;
    private static final int MAX_LEVEL_DEFAULT = -1;
    private static final int MAX_LUMA_SAMPLES_DEFAULT = -1;
    private static final int MAX_PROFILE_DEFAULT = -1;
    public static final TPVCodecCapabilityForGet mDefaultVCodecCapability = new TPVCodecCapabilityForGet(-1, -1, -1, -1);
    private int maxFramerateFormaxLumaSamples;
    private int maxLevel;
    private int maxLumaSamples;
    private int maxProfile;

    public TPVCodecCapabilityForGet(int i11, int i12, int i13, int i14) {
        this.maxLumaSamples = i11;
        this.maxProfile = i12;
        this.maxLevel = i13;
        this.maxFramerateFormaxLumaSamples = i14;
    }

    public int getMaxFramerateFormaxLumaSamples() {
        return this.maxFramerateFormaxLumaSamples;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxLumaSamples() {
        return this.maxLumaSamples;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }
}
