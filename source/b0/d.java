package b0;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.audio.a;
import androidx.core.util.j;

public final class d implements j<a> {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.camera.video.a f12266a;

    /* renamed from: b  reason: collision with root package name */
    public final EncoderProfilesProxy.AudioProfileProxy f12267b;

    public d(androidx.camera.video.a aVar, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.f12266a = aVar;
        this.f12267b = audioProfileProxy;
    }

    /* renamed from: a */
    public a get() {
        int f11 = androidx.camera.video.internal.config.a.f(this.f12266a);
        int g11 = androidx.camera.video.internal.config.a.g(this.f12266a);
        int c11 = this.f12266a.c();
        Range<Integer> d11 = this.f12266a.d();
        int channels = this.f12267b.getChannels();
        if (c11 == -1) {
            Logger.d("AudioSrcAdPrflRslvr", "Resolved AUDIO channel count from AudioProfile: " + channels);
            c11 = channels;
        } else {
            Logger.d("AudioSrcAdPrflRslvr", "Media spec AUDIO channel count overrides AudioProfile [AudioProfile channel count: " + channels + ", Resolved Channel Count: " + c11 + "]");
        }
        int sampleRate = this.f12267b.getSampleRate();
        int i11 = androidx.camera.video.internal.config.a.i(d11, c11, g11, sampleRate);
        Logger.d("AudioSrcAdPrflRslvr", "Using resolved AUDIO sample rate or nearest supported from AudioProfile: " + i11 + "Hz. [AudioProfile sample rate: " + sampleRate + "Hz]");
        return a.a().d(f11).c(g11).e(c11).f(i11).b();
    }
}
