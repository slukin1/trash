package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.d0;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class f extends v<List<? extends d0>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34327b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34328c = new v.a(StabilityLevel.UNIQUE);

    /* renamed from: a  reason: collision with root package name */
    public final List<d0> f34329a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return f.f34328c;
        }

        public a() {
        }
    }

    public static final class b<T> implements Comparator {
        public final int compare(T t11, T t12) {
            return ComparisonsKt__ComparisonsKt.a(((d0) t11).b(), ((d0) t12).b());
        }
    }

    public f(List<d0> list) {
        super((r) null);
        this.f34329a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (d0 b11 : CollectionsKt___CollectionsKt.z0(c(), new b())) {
            sb2.append(b11.b());
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34328c;
    }

    public Map<String, String> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        for (T next : c()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            linkedHashMap.put("application." + i11, ((d0) next).b());
            i11 = i12;
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public List<d0> c() {
        return this.f34329a;
    }
}
