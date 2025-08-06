package r;

import android.graphics.PointF;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.Quirks;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final Quirks f16424a;

    public h(Quirks quirks) {
        this.f16424a = quirks;
    }

    public PointF a(MeteringPoint meteringPoint, int i11) {
        if (i11 != 1 || !this.f16424a.contains(AfRegionFlipHorizontallyQuirk.class)) {
            return new PointF(meteringPoint.getX(), meteringPoint.getY());
        }
        return new PointF(1.0f - meteringPoint.getX(), meteringPoint.getY());
    }
}
