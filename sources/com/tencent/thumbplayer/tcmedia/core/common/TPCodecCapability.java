package com.tencent.thumbplayer.tcmedia.core.common;

import java.io.Serializable;

public interface TPCodecCapability {
    public static final int DEFAULT_FRAMERATE = 30;
    public static final int DEFAULT_INVALID_PARAMETER = -1;

    public static class TPACodecPropertyRange implements Serializable {
        public int level;
        public int lowerboundBitRate;
        public int lowerboundChannels;
        public int lowerboundSampleRate;
        public int profile;
        public int upperboundBitRate;
        public int upperboundChannels;
        public int upperboundSampleRate;

        public void set(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.upperboundSampleRate = i11;
            this.upperboundChannels = i12;
            this.upperboundBitRate = i13;
            this.lowerboundSampleRate = i14;
            this.lowerboundChannels = i15;
            this.lowerboundBitRate = i16;
            this.profile = i17;
            this.level = i18;
        }
    }

    public static class TPCodecMaxCapability implements Serializable {
        public int maxBitRate;
        public int maxChannels;
        public int maxFramerateFormaxLumaSamples;
        public int maxLevel;
        public int maxLumaSamples;
        public int maxProfile;
        public int maxSampleRate;

        @Deprecated
        public TPCodecMaxCapability(int i11, int i12, int i13) {
            this.maxLumaSamples = i11;
            this.maxProfile = i12;
            this.maxLevel = i13;
            this.maxFramerateFormaxLumaSamples = 30;
            this.maxBitRate = -1;
            this.maxSampleRate = -1;
            this.maxChannels = -1;
        }

        public TPCodecMaxCapability(int i11, int i12, int i13, int i14) {
            this.maxLumaSamples = i11;
            this.maxProfile = i12;
            this.maxLevel = i13;
            this.maxFramerateFormaxLumaSamples = i14;
            this.maxBitRate = -1;
            this.maxSampleRate = -1;
            this.maxChannels = -1;
        }

        public TPCodecMaxCapability(int i11, int i12, int i13, int i14, int i15) {
            this.maxProfile = i11;
            this.maxLevel = i12;
            this.maxBitRate = i14;
            this.maxSampleRate = i13;
            this.maxChannels = i15;
            this.maxLumaSamples = -1;
            this.maxFramerateFormaxLumaSamples = -1;
        }
    }

    public static class TPHdrSupportVersionRange implements Serializable {
        public int lowerboundAndroidAPILevel;
        public int lowerboundPatchVersion;
        public int lowerboundSystemVersion;
        public int upperboundAndroidAPILevel;
        public int upperboundPatchVersion;
        public int upperboundSystemVersion;

        public TPHdrSupportVersionRange(int i11, int i12) {
            this.upperboundAndroidAPILevel = i11;
            this.lowerboundAndroidAPILevel = i12;
        }

        public TPHdrSupportVersionRange(int i11, int i12, int i13, int i14) {
            this.upperboundSystemVersion = i11;
            this.lowerboundSystemVersion = i12;
            this.upperboundPatchVersion = i13;
            this.lowerboundPatchVersion = i14;
        }
    }

    public static class TPVCodecPropertyRange implements Serializable {
        public int level;
        public int lowerboundHeight;
        public int lowerboundWidth;
        public int profile;
        public int upperboundHeight;
        public int upperboundWidth;

        public void set(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.upperboundWidth = i11;
            this.upperboundHeight = i12;
            this.lowerboundWidth = i13;
            this.lowerboundHeight = i14;
            this.profile = i15;
            this.level = i16;
        }
    }
}
