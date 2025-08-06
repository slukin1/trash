package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class h0 extends v<Map<String, ? extends String>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34343b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34344c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, String> f34345a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return h0.f34344c;
        }

        public a() {
        }
    }

    public h0(Map<String, String> map) {
        super((r) null);
        this.f34345a = map;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : c().entrySet()) {
            sb2.append((String) entry.getKey());
            sb2.append((String) entry.getValue());
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34344c;
    }

    public Map<String, String> d() {
        Map<String, String> f11 = c();
        ArrayList arrayList = new ArrayList(f11.size());
        for (Map.Entry next : f11.entrySet()) {
            arrayList.add(l.a("proc_info." + w.b((String) next.getKey()), next.getValue()));
        }
        return MapsKt__MapsKt.s(arrayList);
    }

    /* renamed from: f */
    public Map<String, String> c() {
        return this.f34345a;
    }
}
