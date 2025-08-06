package z;

import android.media.MediaCodecInfo;
import android.util.Range;

public final class d {
    public static Range<Integer> a(MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        return encoderCapabilities.getQualityRange();
    }
}
