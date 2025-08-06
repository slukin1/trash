package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class t0 extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34418b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34419c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34420a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return t0.f34419c;
        }

        public a() {
        }
    }

    public t0(String str) {
        super((r) null);
        this.f34420a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34419c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("time_12_or_24", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34420a;
    }
}
