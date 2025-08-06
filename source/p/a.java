package p;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.camera.core.DynamicRange;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Long, DynamicRange> f16251a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<DynamicRange, List<Long>> f16252b;

    static {
        HashMap hashMap = new HashMap();
        f16251a = hashMap;
        HashMap hashMap2 = new HashMap();
        f16252b = hashMap2;
        DynamicRange dynamicRange = DynamicRange.SDR;
        hashMap.put(1L, dynamicRange);
        hashMap2.put(dynamicRange, Collections.singletonList(1L));
        hashMap.put(2L, DynamicRange.HLG_10_BIT);
        hashMap2.put((DynamicRange) hashMap.get(2L), Collections.singletonList(2L));
        DynamicRange dynamicRange2 = DynamicRange.HDR10_10_BIT;
        hashMap.put(4L, dynamicRange2);
        hashMap2.put(dynamicRange2, Collections.singletonList(4L));
        DynamicRange dynamicRange3 = DynamicRange.HDR10_PLUS_10_BIT;
        hashMap.put(8L, dynamicRange3);
        hashMap2.put(dynamicRange3, Collections.singletonList(8L));
        List<Long> asList = Arrays.asList(new Long[]{64L, 128L, 16L, 32L});
        for (Long put : asList) {
            f16251a.put(put, DynamicRange.DOLBY_VISION_10_BIT);
        }
        f16252b.put(DynamicRange.DOLBY_VISION_10_BIT, asList);
        List<Long> asList2 = Arrays.asList(new Long[]{1024L, 2048L, 256L, 512L});
        for (Long put2 : asList2) {
            f16251a.put(put2, DynamicRange.DOLBY_VISION_8_BIT);
        }
        f16252b.put(DynamicRange.DOLBY_VISION_8_BIT, asList2);
    }

    public static Long a(DynamicRange dynamicRange, DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = f16252b.get(dynamicRange);
        if (list == null) {
            return null;
        }
        Set supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l11 : list) {
            if (supportedProfiles.contains(l11)) {
                return l11;
            }
        }
        return null;
    }

    public static DynamicRange b(long j11) {
        return f16251a.get(Long.valueOf(j11));
    }
}
