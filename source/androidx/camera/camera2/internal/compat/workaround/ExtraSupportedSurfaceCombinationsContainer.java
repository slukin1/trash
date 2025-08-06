package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.core.impl.SurfaceCombination;
import java.util.ArrayList;
import java.util.List;
import q.d;

public class ExtraSupportedSurfaceCombinationsContainer {

    /* renamed from: a  reason: collision with root package name */
    public final ExtraSupportedSurfaceCombinationsQuirk f5067a = ((ExtraSupportedSurfaceCombinationsQuirk) d.a(ExtraSupportedSurfaceCombinationsQuirk.class));

    public List<SurfaceCombination> a(String str, int i11) {
        ExtraSupportedSurfaceCombinationsQuirk extraSupportedSurfaceCombinationsQuirk = this.f5067a;
        if (extraSupportedSurfaceCombinationsQuirk == null) {
            return new ArrayList();
        }
        return extraSupportedSurfaceCombinationsQuirk.f(str, i11);
    }
}
