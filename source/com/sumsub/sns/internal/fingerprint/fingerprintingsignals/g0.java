package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class g0 extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34337b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34338c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final String f34339a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return g0.f34338c;
        }

        public a() {
        }
    }

    public g0(String str) {
        super((r) null);
        this.f34339a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34338c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("model_name", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34339a;
    }
}
