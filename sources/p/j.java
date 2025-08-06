package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.h;

public class j extends i {
    public j(int i11, Surface surface) {
        this(new OutputConfiguration(i11, surface));
    }

    public static j l(OutputConfiguration outputConfiguration) {
        return new j(outputConfiguration);
    }

    public /* bridge */ /* synthetic */ void a(Surface surface) {
        super.a(surface);
    }

    public /* bridge */ /* synthetic */ String b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public void d(long j11) {
        if (j11 != -1) {
            ((OutputConfiguration) g()).setStreamUseCase(j11);
        }
    }

    public void e(long j11) {
        ((OutputConfiguration) g()).setDynamicRangeProfile(j11);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ void f(String str) {
        super.f(str);
    }

    public Object g() {
        h.a(this.f16269a instanceof OutputConfiguration);
        return this.f16269a;
    }

    public /* bridge */ /* synthetic */ Surface getSurface() {
        return super.getSurface();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public j(Object obj) {
        super(obj);
    }
}
