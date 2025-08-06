package b0;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.a;
import androidx.core.util.j;

public final class c implements j<a> {

    /* renamed from: a  reason: collision with root package name */
    public final String f12261a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12262b;

    /* renamed from: c  reason: collision with root package name */
    public final androidx.camera.video.a f12263c;

    /* renamed from: d  reason: collision with root package name */
    public final androidx.camera.video.internal.audio.a f12264d;

    /* renamed from: e  reason: collision with root package name */
    public final Timebase f12265e;

    public c(String str, int i11, Timebase timebase, androidx.camera.video.a aVar, androidx.camera.video.internal.audio.a aVar2) {
        this.f12261a = str;
        this.f12262b = i11;
        this.f12265e = timebase;
        this.f12263c = aVar;
        this.f12264d = aVar2;
    }

    /* renamed from: a */
    public a get() {
        Range<Integer> b11 = this.f12263c.b();
        Logger.d("AudioEncCfgDefaultRslvr", "Using fallback AUDIO bitrate");
        return a.c().f(this.f12261a).g(this.f12262b).e(this.f12265e).d(this.f12264d.e()).h(this.f12264d.f()).c(androidx.camera.video.internal.config.a.h(156000, this.f12264d.e(), 2, this.f12264d.f(), 48000, b11)).b();
    }
}
