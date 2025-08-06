package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;

public final class l extends v<Integer> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34367b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34368c = new v.a(StabilityLevel.STABLE);

    /* renamed from: a  reason: collision with root package name */
    public final int f34369a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return l.f34368c;
        }

        public a() {
        }
    }

    public l(int i11) {
        super((r) null);
        this.f34369a = i11;
    }

    public String a() {
        return String.valueOf(c().intValue());
    }

    public v.a b() {
        return f34368c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(kotlin.l.a("cores_count", String.valueOf(c().intValue())));
    }

    /* renamed from: f */
    public Integer c() {
        return Integer.valueOf(this.f34369a);
    }
}
