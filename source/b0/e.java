package b0;

import android.util.Range;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.audio.a;
import androidx.core.util.j;

public final class e implements j<a> {

    /* renamed from: a  reason: collision with root package name */
    public final androidx.camera.video.a f12268a;

    public e(androidx.camera.video.a aVar) {
        this.f12268a = aVar;
    }

    /* renamed from: a */
    public a get() {
        int i11;
        int f11 = androidx.camera.video.internal.config.a.f(this.f12268a);
        int g11 = androidx.camera.video.internal.config.a.g(this.f12268a);
        int c11 = this.f12268a.c();
        if (c11 == -1) {
            c11 = 1;
            Logger.d("DefAudioResolver", "Using fallback AUDIO channel count: " + 1);
        } else {
            Logger.d("DefAudioResolver", "Using supplied AUDIO channel count: " + c11);
        }
        Range<Integer> d11 = this.f12268a.d();
        if (androidx.camera.video.a.f5903b.equals(d11)) {
            i11 = 44100;
            Logger.d("DefAudioResolver", "Using fallback AUDIO sample rate: " + 44100 + "Hz");
        } else {
            i11 = androidx.camera.video.internal.config.a.i(d11, c11, g11, d11.getUpper().intValue());
            Logger.d("DefAudioResolver", "Using AUDIO sample rate resolved from AudioSpec: " + i11 + "Hz");
        }
        return a.a().d(f11).c(g11).e(c11).f(i11).b();
    }
}
