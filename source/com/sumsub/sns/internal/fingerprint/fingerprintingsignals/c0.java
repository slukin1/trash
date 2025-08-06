package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class c0 extends v<List<? extends v>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34312b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34313c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final List<com.sumsub.sns.internal.fingerprint.infoproviders.v> f34314a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return c0.f34313c;
        }

        public a() {
        }
    }

    public static final class b<T> implements Comparator {
        public final int compare(T t11, T t12) {
            return ComparisonsKt__ComparisonsKt.a((String) t11, (String) t12);
        }
    }

    public c0(List<com.sumsub.sns.internal.fingerprint.infoproviders.v> list) {
        super((r) null);
        this.f34314a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        List<com.sumsub.sns.internal.fingerprint.infoproviders.v> f11 = c();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(f11, 10));
        for (com.sumsub.sns.internal.fingerprint.infoproviders.v vVar : f11) {
            arrayList.add(vVar.c() + vVar.d());
        }
        for (String append : CollectionsKt___CollectionsKt.z0(arrayList, new b())) {
            sb2.append(append);
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34313c;
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
            arrayList.add(l.a("input_device_v2." + i11 + '.' + w.b(vVar.c()), vVar.d()));
            i11 = i12;
        }
        return MapsKt__MapsKt.s(arrayList);
    }

    /* renamed from: f */
    public List<com.sumsub.sns.internal.fingerprint.infoproviders.v> c() {
        return this.f34314a;
    }
}
