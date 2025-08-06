package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class b0 extends v<List<? extends v>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34306b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34307c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final List<com.sumsub.sns.internal.fingerprint.infoproviders.v> f34308a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return b0.f34307c;
        }

        public a() {
        }
    }

    public b0(List<com.sumsub.sns.internal.fingerprint.infoproviders.v> list) {
        super((r) null);
        this.f34308a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (com.sumsub.sns.internal.fingerprint.infoproviders.v vVar : c()) {
            sb2.append(vVar.c());
            sb2.append(vVar.d());
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34307c;
    }

    public Map<String, String> d() {
        List<com.sumsub.sns.internal.fingerprint.infoproviders.v> f11 = c();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(f11, 10));
        int i11 = 0;
        for (T next : f11) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            com.sumsub.sns.internal.fingerprint.infoproviders.v vVar = (com.sumsub.sns.internal.fingerprint.infoproviders.v) next;
            arrayList.add(l.a("input_device." + i11 + '.' + w.b(vVar.c()), vVar.d()));
            i11 = i12;
        }
        return MapsKt__MapsKt.s(arrayList);
    }

    /* renamed from: f */
    public List<com.sumsub.sns.internal.fingerprint.infoproviders.v> c() {
        return this.f34308a;
    }
}
