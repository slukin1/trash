package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class v0 extends v<Long> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34428b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34429c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final long f34430a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return v0.f34429c;
        }

        public a() {
        }
    }

    public v0(long j11) {
        super((r) null);
        this.f34430a = j11;
    }

    public String a() {
        return String.valueOf(c().longValue());
    }

    public v.a b() {
        return f34429c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("total_internal_storage", String.valueOf(c().longValue())));
    }

    /* renamed from: f */
    public Long c() {
        return Long.valueOf(this.f34430a);
    }
}
