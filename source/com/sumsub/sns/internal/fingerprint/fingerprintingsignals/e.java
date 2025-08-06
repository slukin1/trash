package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class e extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34321b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34322c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34323a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return e.f34322c;
        }

        public a() {
        }
    }

    public e(String str) {
        super((r) null);
        this.f34323a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34322c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("android_version", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34323a;
    }
}
