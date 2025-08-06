package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.d;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class j extends v<List<? extends d>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34354b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34355c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f34356a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return j.f34355c;
        }

        public a() {
        }
    }

    public j(List<d> list) {
        super((r) null);
        this.f34356a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (d dVar : c()) {
            sb2.append(dVar.d());
            sb2.append(dVar.f());
            sb2.append(dVar.e());
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34355c;
    }

    public Map<String, String> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        for (T next : c()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            d dVar = (d) next;
            linkedHashMap.put("camera_name." + i11, dVar.d());
            linkedHashMap.put("camera_type." + i11, dVar.f());
            linkedHashMap.put("camera_orientation." + i11, dVar.e());
            i11 = i12;
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public List<d> c() {
        return this.f34356a;
    }
}
