package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.g0;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class p0 extends v<List<? extends g0>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34394b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34395c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final List<g0> f34396a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return p0.f34395c;
        }

        public a() {
        }
    }

    public p0(List<g0> list) {
        super((r) null);
        this.f34396a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (g0 g0Var : c()) {
            sb2.append(g0Var.a());
            sb2.append(g0Var.b());
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34395c;
    }

    public Map<String, String> d() {
        List<g0> f11 = c();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(f11, 10));
        int i11 = 0;
        for (T next : f11) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            g0 g0Var = (g0) next;
            arrayList.add(l.a("sensor." + i11 + '.' + w.b(g0Var.a()), g0Var.b()));
            i11 = i12;
        }
        return MapsKt__MapsKt.s(arrayList);
    }

    /* renamed from: f */
    public List<g0> c() {
        return this.f34396a;
    }
}
