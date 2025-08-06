package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.l;

public final class r extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34403b = new a((kotlin.jvm.internal.r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34404c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34405a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final v.a a() {
            return r.f34404c;
        }

        public a() {
        }
    }

    public r(String str) {
        super((kotlin.jvm.internal.r) null);
        this.f34405a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34404c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("encryption_status", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34405a;
    }
}
