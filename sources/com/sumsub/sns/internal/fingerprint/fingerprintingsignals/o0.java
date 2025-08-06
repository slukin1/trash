package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.r;

public final class o0 extends v<List<? extends Pair<? extends String, ? extends String>>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34388b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34389c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final List<Pair<String, String>> f34390a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return o0.f34389c;
        }

        public a() {
        }
    }

    public o0(List<Pair<String, String>> list) {
        super((r) null);
        this.f34390a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (Pair pair : c()) {
            sb2.append((String) pair.getFirst());
            sb2.append((String) pair.getSecond());
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34389c;
    }

    public Map<String, String> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        for (T next : c()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            Pair pair = (Pair) next;
            linkedHashMap.put("security_provider." + i11 + '.' + ((String) pair.getFirst()), pair.getSecond());
            i11 = i12;
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public List<Pair<String, String>> c() {
        return this.f34390a;
    }
}
