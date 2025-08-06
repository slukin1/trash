package r;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f16419a;

    public d(String str) {
        this.f16419a = str;
    }

    public List<Size> a(int i11) {
        ExcludedSupportedSizesQuirk excludedSupportedSizesQuirk = (ExcludedSupportedSizesQuirk) q.d.a(ExcludedSupportedSizesQuirk.class);
        if (excludedSupportedSizesQuirk == null) {
            return new ArrayList();
        }
        return excludedSupportedSizesQuirk.c(this.f16419a, i11);
    }
}
