package b0;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.a;
import androidx.core.util.j;

public final class b implements j<a> {

    /* renamed from: a  reason: collision with root package name */
    public final String f12255a;

    /* renamed from: b  reason: collision with root package name */
    public final Timebase f12256b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12257c;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.camera.video.a f12258d;

    /* renamed from: e  reason: collision with root package name */
    public final androidx.camera.video.internal.audio.a f12259e;

    /* renamed from: f  reason: collision with root package name */
    public final EncoderProfilesProxy.AudioProfileProxy f12260f;

    public b(String str, int i11, Timebase timebase, androidx.camera.video.a aVar, androidx.camera.video.internal.audio.a aVar2, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.f12255a = str;
        this.f12257c = i11;
        this.f12256b = timebase;
        this.f12258d = aVar;
        this.f12259e = aVar2;
        this.f12260f = audioProfileProxy;
    }

    /* renamed from: a */
    public a get() {
        Logger.d("AudioEncAdPrflRslvr", "Using resolved AUDIO bitrate from AudioProfile");
        return a.c().f(this.f12255a).g(this.f12257c).e(this.f12256b).d(this.f12259e.e()).h(this.f12259e.f()).c(androidx.camera.video.internal.config.a.h(this.f12260f.getBitrate(), this.f12259e.e(), this.f12260f.getChannels(), this.f12259e.f(), this.f12260f.getSampleRate(), this.f12258d.b())).b();
    }
}
