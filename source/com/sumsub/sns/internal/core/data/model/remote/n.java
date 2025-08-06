package com.sumsub.sns.internal.core.data.model.remote;

import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.remote.m;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class n {
    public static final Document.b.C0329b a(m.c cVar) {
        return new Document.b.C0329b(cVar.e(), cVar.i(), cVar.g(), cVar.k());
    }

    public static final Document.b a(m mVar) {
        m.c n11 = mVar.n();
        LinkedHashMap linkedHashMap = null;
        Document.b.C0329b a11 = n11 != null ? a(n11) : null;
        String f11 = mVar.f();
        String h11 = mVar.h();
        List<Integer> j11 = mVar.j();
        Map<Integer, m.c> l11 = mVar.l();
        if (l11 != null) {
            linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(l11.size()));
            for (Map.Entry entry : l11.entrySet()) {
                linkedHashMap.put(entry.getKey(), a((m.c) entry.getValue()));
            }
        }
        return new Document.b(a11, f11, h11, j11, linkedHashMap);
    }
}
