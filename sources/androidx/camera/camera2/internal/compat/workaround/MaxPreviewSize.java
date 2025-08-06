package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import q.d;

public class MaxPreviewSize {

    /* renamed from: a  reason: collision with root package name */
    public final ExtraCroppingQuirk f5068a;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) d.a(ExtraCroppingQuirk.class));
    }

    public Size a(Size size) {
        Size c11;
        ExtraCroppingQuirk extraCroppingQuirk = this.f5068a;
        if (extraCroppingQuirk == null || (c11 = extraCroppingQuirk.c(SurfaceConfig.ConfigType.PRIV)) == null) {
            return size;
        }
        return c11.getWidth() * c11.getHeight() > size.getWidth() * size.getHeight() ? c11 : size;
    }

    public MaxPreviewSize(ExtraCroppingQuirk extraCroppingQuirk) {
        this.f5068a = extraCroppingQuirk;
    }
}
