package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;
import q.d;

public class ResolutionCorrector {

    /* renamed from: a  reason: collision with root package name */
    public final ExtraCroppingQuirk f5069a;

    public ResolutionCorrector() {
        this((ExtraCroppingQuirk) d.a(ExtraCroppingQuirk.class));
    }

    public List<Size> a(SurfaceConfig.ConfigType configType, List<Size> list) {
        Size c11;
        ExtraCroppingQuirk extraCroppingQuirk = this.f5069a;
        if (extraCroppingQuirk == null || (c11 = extraCroppingQuirk.c(configType)) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c11);
        for (Size next : list) {
            if (!next.equals(c11)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ResolutionCorrector(ExtraCroppingQuirk extraCroppingQuirk) {
        this.f5069a = extraCroppingQuirk;
    }
}
