package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class j0 extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34357b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34358c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34359a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return j0.f34358c;
        }

        public a() {
        }
    }

    public j0(String str) {
        super((r) null);
        this.f34359a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34358c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("region_country", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34359a;
    }
}
