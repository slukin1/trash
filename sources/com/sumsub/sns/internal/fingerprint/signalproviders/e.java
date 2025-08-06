package com.sumsub.sns.internal.fingerprint.signalproviders;

import com.sumsub.sns.internal.fingerprint.signalproviders.b;
import java.util.List;

public abstract class e<T extends b> {
    public static /* synthetic */ String a(e eVar, StabilityLevel stabilityLevel, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                stabilityLevel = StabilityLevel.OPTIMAL;
            }
            return eVar.a(stabilityLevel);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fingerprint");
    }

    public abstract T a();

    public abstract String a(StabilityLevel stabilityLevel);

    public final String a(List<? extends a<?>> list, StabilityLevel stabilityLevel) {
        StringBuilder sb2 = new StringBuilder();
        for (a aVar : c.a(list, stabilityLevel)) {
            sb2.append(aVar.toString());
        }
        return sb2.toString();
    }
}
