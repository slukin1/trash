package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class l0 extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34370b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34371c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34372a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return l0.f34371c;
        }

        public a() {
        }
    }

    public l0(String str) {
        super((r) null);
        this.f34372a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34371c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("rtt_calling_mode", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34372a;
    }
}
