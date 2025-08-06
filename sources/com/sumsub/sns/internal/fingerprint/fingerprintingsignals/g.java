package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import d10.l;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class g extends v<List<? extends String>> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34333b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34334c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f34335a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return g.f34334c;
        }

        public a() {
        }
    }

    public static final class b extends Lambda implements l<String, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f34336a = new b();

        public b() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(String str) {
            return str;
        }
    }

    public g(List<String> list) {
        super((r) null);
        this.f34335a = list;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        for (String append : c()) {
            sb2.append(append);
        }
        return sb2.toString();
    }

    public v.a b() {
        return f34334c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(kotlin.l.a("available_locales", CollectionsKt___CollectionsKt.k0(c(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.f34336a, 31, (Object) null)));
    }

    /* renamed from: f */
    public List<String> c() {
        return this.f34335a;
    }
}
