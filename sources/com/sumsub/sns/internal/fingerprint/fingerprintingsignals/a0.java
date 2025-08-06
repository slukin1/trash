package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class a0 extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34300b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34301c = new v.a(StabilityLevel.UNIQUE);

    /* renamed from: a  reason: collision with root package name */
    public final String f34302a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return a0.f34301c;
        }

        public a() {
        }
    }

    public a0(String str) {
        super((r) null);
        this.f34302a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34301c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("http_proxy", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34302a;
    }
}
