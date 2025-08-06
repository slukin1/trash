package p;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import androidx.core.util.h;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p.b;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final DynamicRangeProfiles f16254a;

    public c(Object obj) {
        this.f16254a = (DynamicRangeProfiles) obj;
    }

    public static Set<DynamicRange> d(Set<Long> set) {
        if (set.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(set.size());
        for (Long longValue : set) {
            hashSet.add(e(longValue.longValue()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static DynamicRange e(long j11) {
        DynamicRange b11 = a.b(j11);
        return (DynamicRange) h.h(b11, "Dynamic range profile cannot be converted to a DynamicRange object: " + j11);
    }

    public DynamicRangeProfiles a() {
        return this.f16254a;
    }

    public Set<DynamicRange> b(DynamicRange dynamicRange) {
        Long c11 = c(dynamicRange);
        boolean z11 = c11 != null;
        h.b(z11, "DynamicRange is not supported: " + dynamicRange);
        return d(this.f16254a.getProfileCaptureRequestConstraints(c11.longValue()));
    }

    public final Long c(DynamicRange dynamicRange) {
        return a.a(dynamicRange, this.f16254a);
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return d(this.f16254a.getSupportedProfiles());
    }
}
