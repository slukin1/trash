package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class h extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34340b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34341c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final String f34342a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return h.f34341c;
        }

        public a() {
        }
    }

    public h(String str) {
        super((r) null);
        this.f34342a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34341c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("battery_full_capacity", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34342a;
    }
}
