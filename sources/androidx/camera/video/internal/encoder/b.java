package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import java.util.Objects;

public class b extends c1 {

    /* renamed from: c  reason: collision with root package name */
    public final MediaCodecInfo.AudioCapabilities f6160c;

    public b(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.f6176b.getAudioCapabilities();
        Objects.requireNonNull(audioCapabilities);
        MediaCodecInfo.AudioCapabilities audioCapabilities2 = audioCapabilities;
        this.f6160c = audioCapabilities;
    }
}
