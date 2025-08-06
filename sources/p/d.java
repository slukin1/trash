package p;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import androidx.core.util.h;
import java.util.Collections;
import java.util.Set;
import p.b;

public class d implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f16255a = new b(new d());

    /* renamed from: b  reason: collision with root package name */
    public static final Set<DynamicRange> f16256b = Collections.singleton(DynamicRange.SDR);

    public DynamicRangeProfiles a() {
        return null;
    }

    public Set<DynamicRange> b(DynamicRange dynamicRange) {
        boolean equals = DynamicRange.SDR.equals(dynamicRange);
        h.b(equals, "DynamicRange is not supported: " + dynamicRange);
        return f16256b;
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return f16256b;
    }
}
