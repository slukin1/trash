package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.infoproviders.y;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import d10.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class k extends v<List<? extends y>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34360b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34361c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final List<y> f34362a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return k.f34361c;
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements l<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f34363a = new b();

        public b() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(String str) {
            return str;
        }
    }

    public k(List<y> list) {
        super((r) null);
        this.f34362a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (y yVar : c()) {
            sb2.append(yVar.d());
            for (String append : yVar.c()) {
                sb2.append(append);
            }
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34361c;
    }

    public Map<String, String> d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        for (T next : c()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            y yVar = (y) next;
            linkedHashMap.put("codec_info." + i11 + ".name", yVar.d());
            linkedHashMap.put("codec_info." + i11 + ".capabilities", CollectionsKt___CollectionsKt.k0(yVar.c(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.f34363a, 31, (Object) null));
            i11 = i12;
        }
        return linkedHashMap;
    }

    /* renamed from: f */
    public List<y> c() {
        return this.f34362a;
    }
}
