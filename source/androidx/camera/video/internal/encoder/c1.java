package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import androidx.camera.video.internal.workaround.EncoderFinder;
import java.util.Objects;

public abstract class c1 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    public final MediaCodecInfo f6175a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f6176b;

    public c1(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        this.f6175a = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Objects.requireNonNull(capabilitiesForType);
            MediaCodecInfo.CodecCapabilities codecCapabilities = capabilitiesForType;
            this.f6176b = capabilitiesForType;
        } catch (RuntimeException e11) {
            throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + str, e11);
        }
    }

    public static MediaCodecInfo i(n nVar) throws InvalidConfigException {
        MediaCodec a11 = new EncoderFinder().a(nVar.b());
        MediaCodecInfo codecInfo = a11.getCodecInfo();
        a11.release();
        return codecInfo;
    }
}
