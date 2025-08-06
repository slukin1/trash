package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class u extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34421b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34422c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34423a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return u.f34422c;
        }

        public a() {
        }
    }

    public u(String str) {
        super((r) null);
        this.f34423a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34422c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34423a;
    }
}
