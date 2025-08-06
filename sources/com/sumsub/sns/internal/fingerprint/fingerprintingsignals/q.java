package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class q extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34397b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34398c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34399a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return q.f34398c;
        }

        public a() {
        }
    }

    public q(String str) {
        super((r) null);
        this.f34399a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34398c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("development_settings_enabled", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34399a;
    }
}
