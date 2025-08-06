package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class a extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final C0390a f34297b = new C0390a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34298c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final String f34299a;

    /* renamed from: com.sumsub.sns.internal.fingerprint.fingerprintingsignals.a$a  reason: collision with other inner class name */
    public static final class C0390a {
        public /* synthetic */ C0390a(r rVar) {
            this();
        }

        public final v.a a() {
            return a.f34298c;
        }

        public C0390a() {
        }
    }

    public a(String str) {
        super((r) null);
        this.f34299a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34298c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("abi_type", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34299a;
    }
}
