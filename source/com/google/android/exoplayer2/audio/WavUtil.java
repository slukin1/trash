package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

public final class WavUtil {
    public static final int DATA_FOURCC = 1684108385;
    public static final int FMT_FOURCC = 1718449184;
    public static final int RIFF_FOURCC = 1380533830;
    public static final int TYPE_ALAW = 6;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_IMA_ADPCM = 17;
    public static final int TYPE_MLAW = 7;
    public static final int TYPE_PCM = 1;
    public static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;
    public static final int WAVE_FOURCC = 1463899717;

    private WavUtil() {
    }

    public static int getPcmEncodingForType(int i11, int i12) {
        if (i11 != 1) {
            if (i11 == 3) {
                return i12 == 32 ? 4 : 0;
            }
            if (i11 != 65534) {
                return 0;
            }
        }
        return Util.getPcmEncoding(i12);
    }

    public static int getTypeForPcmEncoding(int i11) {
        if (i11 == 2 || i11 == 3) {
            return 1;
        }
        if (i11 == 4) {
            return 3;
        }
        if (i11 == 536870912 || i11 == 805306368) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}
