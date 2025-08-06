package p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import androidx.camera.core.DynamicRange;
import androidx.core.util.h;
import java.util.Set;
import o.y;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f16253a;

    public interface a {
        DynamicRangeProfiles a();

        Set<DynamicRange> b(DynamicRange dynamicRange);

        Set<DynamicRange> getSupportedDynamicRanges();
    }

    public b(a aVar) {
        this.f16253a = aVar;
    }

    public static b a(y yVar) {
        b e11 = Build.VERSION.SDK_INT >= 33 ? e((DynamicRangeProfiles) yVar.a(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES)) : null;
        return e11 == null ? d.f16255a : e11;
    }

    public static b e(DynamicRangeProfiles dynamicRangeProfiles) {
        if (dynamicRangeProfiles == null) {
            return null;
        }
        h.j(Build.VERSION.SDK_INT >= 33, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new b(new c(dynamicRangeProfiles));
    }

    public Set<DynamicRange> b(DynamicRange dynamicRange) {
        return this.f16253a.b(dynamicRange);
    }

    public Set<DynamicRange> c() {
        return this.f16253a.getSupportedDynamicRanges();
    }

    public DynamicRangeProfiles d() {
        h.j(Build.VERSION.SDK_INT >= 33, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.f16253a.a();
    }
}
