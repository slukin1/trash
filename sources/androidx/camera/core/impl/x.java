package androidx.camera.core.impl;

import androidx.camera.core.impl.EncoderProfilesProxy;
import com.google.android.exoplayer2.util.MimeTypes;

public final /* synthetic */ class x {
    public static String a(int i11) {
        switch (i11) {
            case 1:
                return MimeTypes.AUDIO_AMR_NB;
            case 2:
                return MimeTypes.AUDIO_AMR_WB;
            case 3:
            case 4:
            case 5:
                return MimeTypes.AUDIO_AAC;
            case 6:
                return MimeTypes.AUDIO_VORBIS;
            case 7:
                return MimeTypes.AUDIO_OPUS;
            default:
                return EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE;
        }
    }

    public static int b(int i11) {
        if (i11 == 3) {
            return 2;
        }
        if (i11 != 4) {
            return i11 != 5 ? -1 : 39;
        }
        return 5;
    }

    public static String c(int i11) {
        switch (i11) {
            case 1:
                return MimeTypes.VIDEO_H263;
            case 2:
                return "video/avc";
            case 3:
                return MimeTypes.VIDEO_MP4V;
            case 4:
                return "video/x-vnd.on2.vp8";
            case 5:
                return "video/hevc";
            case 6:
                return "video/x-vnd.on2.vp9";
            case 7:
                return "video/dolby-vision";
            case 8:
                return "video/av01";
            default:
                return EncoderProfilesProxy.VideoProfileProxy.MEDIA_TYPE_NONE;
        }
    }
}
