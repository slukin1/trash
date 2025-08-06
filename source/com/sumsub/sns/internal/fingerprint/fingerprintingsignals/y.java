package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class y extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34569b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34570c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34571a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return y.f34570c;
        }

        public a() {
        }
    }

    public y(String str) {
        super((r) null);
        this.f34571a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34570c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("font_scale", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34571a;
    }
}
