package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class o extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34385b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34386c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34387a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return o.f34386c;
        }

        public a() {
        }
    }

    public o(String str) {
        super((r) null);
        this.f34387a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34386c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("default_input_method", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34387a;
    }
}
