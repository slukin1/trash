package com.sumsub.sns.internal.core.data.model.remote;

import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.internal.core.data.model.a;
import com.sumsub.sns.internal.core.data.model.remote.f;
import java.util.ArrayList;
import java.util.List;

public final class g {
    public static final a.C0336a a(f.c.C0347c cVar) {
        return new a.C0336a(cVar.c(), cVar.e());
    }

    public static final a.b a(f.d dVar) {
        return new a.b(dVar.l(), dVar.j(), dVar.n(), dVar.f(), dVar.h());
    }

    public static final a a(f fVar) {
        String n11 = fVar.n();
        String h11 = fVar.h();
        FlowActionType t11 = fVar.t();
        String j11 = fVar.j();
        String l11 = fVar.l();
        List<f.c.C0347c> b11 = fVar.p().b();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(b11, 10));
        for (f.c.C0347c a11 : b11) {
            arrayList.add(a(a11));
        }
        return new a(n11, h11, t11, j11, l11, arrayList, a(fVar.r()));
    }
}
