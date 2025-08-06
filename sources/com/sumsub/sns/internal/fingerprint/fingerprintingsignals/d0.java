package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class d0 extends v<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34318b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34319c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f34320a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return d0.f34319c;
        }

        public a() {
        }
    }

    public d0(boolean z11) {
        super((r) null);
        this.f34320a = z11;
    }

    public String a() {
        return String.valueOf(c().booleanValue());
    }

    public v.a b() {
        return f34319c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("is_pin_security_enabled", String.valueOf(c().booleanValue())));
    }

    /* renamed from: f */
    public Boolean c() {
        return Boolean.valueOf(this.f34320a);
    }
}
