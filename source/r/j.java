package r;

import androidx.camera.camera2.internal.compat.quirk.AutoFlashUnderExposedQuirk;
import androidx.camera.core.impl.Quirks;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16428a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16429b = false;

    public j(Quirks quirks) {
        boolean z11 = false;
        this.f16428a = quirks.get(AutoFlashUnderExposedQuirk.class) != null ? true : z11;
    }

    public void a() {
        this.f16429b = false;
    }

    public void b() {
        this.f16429b = true;
    }

    public boolean c(int i11) {
        return this.f16429b && i11 == 0 && this.f16428a;
    }
}
