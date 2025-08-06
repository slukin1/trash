package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.MimeTypes;

public final class MpegAudioUtil {
    /* access modifiers changed from: private */
    public static final int[] BITRATE_V1_L1 = {32000, 64000, 96000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 288000, 320000, 352000, 384000, 416000, 448000};
    /* access modifiers changed from: private */
    public static final int[] BITRATE_V1_L2 = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000, 384000};
    /* access modifiers changed from: private */
    public static final int[] BITRATE_V1_L3 = {32000, MAX_RATE_BYTES_PER_SECOND, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND, 320000};
    /* access modifiers changed from: private */
    public static final int[] BITRATE_V2 = {8000, 16000, 24000, 32000, MAX_RATE_BYTES_PER_SECOND, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};
    /* access modifiers changed from: private */
    public static final int[] BITRATE_V2_L1 = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 224000, AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND};
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public static final int MAX_RATE_BYTES_PER_SECOND = 40000;
    /* access modifiers changed from: private */
    public static final String[] MIME_TYPE_BY_LAYER = {MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, "audio/mpeg"};
    private static final int SAMPLES_PER_FRAME_L1 = 384;
    private static final int SAMPLES_PER_FRAME_L2 = 1152;
    private static final int SAMPLES_PER_FRAME_L3_V1 = 1152;
    private static final int SAMPLES_PER_FRAME_L3_V2 = 576;
    /* access modifiers changed from: private */
    public static final int[] SAMPLING_RATE_V1 = {44100, 48000, 32000};

    public static final class Header {
        public int bitrate;
        public int channels;
        public int frameSize;
        public String mimeType;
        public int sampleRate;
        public int samplesPerFrame;
        public int version;

        public boolean setForHeaderData(int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            if (!MpegAudioUtil.isMagicPresent(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
                return false;
            }
            this.version = i12;
            this.mimeType = MpegAudioUtil.MIME_TYPE_BY_LAYER[3 - i13];
            int i16 = MpegAudioUtil.SAMPLING_RATE_V1[i15];
            this.sampleRate = i16;
            int i17 = 2;
            if (i12 == 2) {
                this.sampleRate = i16 / 2;
            } else if (i12 == 0) {
                this.sampleRate = i16 / 4;
            }
            int i18 = (i11 >>> 9) & 1;
            this.samplesPerFrame = MpegAudioUtil.getFrameSizeInSamples(i12, i13);
            if (i13 == 3) {
                int i19 = i12 == 3 ? MpegAudioUtil.BITRATE_V1_L1[i14 - 1] : MpegAudioUtil.BITRATE_V2_L1[i14 - 1];
                this.bitrate = i19;
                this.frameSize = (((i19 * 12) / this.sampleRate) + i18) * 4;
            } else {
                int i21 = 144;
                if (i12 == 3) {
                    int i22 = i13 == 2 ? MpegAudioUtil.BITRATE_V1_L2[i14 - 1] : MpegAudioUtil.BITRATE_V1_L3[i14 - 1];
                    this.bitrate = i22;
                    this.frameSize = ((i22 * 144) / this.sampleRate) + i18;
                } else {
                    int i23 = MpegAudioUtil.BITRATE_V2[i14 - 1];
                    this.bitrate = i23;
                    if (i13 == 1) {
                        i21 = 72;
                    }
                    this.frameSize = ((i21 * i23) / this.sampleRate) + i18;
                }
            }
            if (((i11 >> 6) & 3) == 3) {
                i17 = 1;
            }
            this.channels = i17;
            return true;
        }
    }

    private MpegAudioUtil() {
    }

    public static int getFrameSize(int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (!isMagicPresent(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0 || (i14 = (i11 >>> 12) & 15) == 0 || i14 == 15 || (i15 = (i11 >>> 10) & 3) == 3) {
            return -1;
        }
        int i17 = SAMPLING_RATE_V1[i15];
        if (i12 == 2) {
            i17 /= 2;
        } else if (i12 == 0) {
            i17 /= 4;
        }
        int i18 = (i11 >>> 9) & 1;
        if (i13 == 3) {
            return ((((i12 == 3 ? BITRATE_V1_L1[i14 - 1] : BITRATE_V2_L1[i14 - 1]) * 12) / i17) + i18) * 4;
        }
        if (i12 == 3) {
            i16 = i13 == 2 ? BITRATE_V1_L2[i14 - 1] : BITRATE_V1_L3[i14 - 1];
        } else {
            i16 = BITRATE_V2[i14 - 1];
        }
        int i19 = 144;
        if (i12 == 3) {
            return ((i16 * 144) / i17) + i18;
        }
        if (i13 == 1) {
            i19 = 72;
        }
        return ((i19 * i16) / i17) + i18;
    }

    /* access modifiers changed from: private */
    public static int getFrameSizeInSamples(int i11, int i12) {
        if (i12 != 1) {
            if (i12 == 2) {
                return 1152;
            }
            if (i12 == 3) {
                return 384;
            }
            throw new IllegalArgumentException();
        } else if (i11 == 3) {
            return 1152;
        } else {
            return SAMPLES_PER_FRAME_L3_V2;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isMagicPresent(int i11) {
        return (i11 & -2097152) == -2097152;
    }

    public static int parseMpegAudioFrameSampleCount(int i11) {
        int i12;
        int i13;
        if (!isMagicPresent(i11) || (i12 = (i11 >>> 19) & 3) == 1 || (i13 = (i11 >>> 17) & 3) == 0) {
            return -1;
        }
        int i14 = (i11 >>> 12) & 15;
        int i15 = (i11 >>> 10) & 3;
        if (i14 == 0 || i14 == 15 || i15 == 3) {
            return -1;
        }
        return getFrameSizeInSamples(i12, i13);
    }
}
