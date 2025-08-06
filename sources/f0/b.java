package f0;

import androidx.camera.core.impl.Quirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import java.util.ArrayList;
import java.util.List;

public class b {
    public static List<Quirk> a() {
        ArrayList arrayList = new ArrayList();
        if (SurfaceViewStretchedQuirk.f()) {
            arrayList.add(new SurfaceViewStretchedQuirk());
        }
        if (SurfaceViewNotCroppedByParentQuirk.c()) {
            arrayList.add(new SurfaceViewNotCroppedByParentQuirk());
        }
        return arrayList;
    }
}
