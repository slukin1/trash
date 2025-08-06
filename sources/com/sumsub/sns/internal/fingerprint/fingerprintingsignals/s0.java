package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.fingerprintingsignals.v;
import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.l;

public final class s0 extends v<String> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34412b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final v.a f34413c = new v.a(StabilityLevel.OPTIMAL);

    /* renamed from: a  reason: collision with root package name */
    public final String f34414a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final v.a a() {
            return s0.f34413c;
        }

        public a() {
        }
    }

    public s0(String str) {
        super((r) null);
        this.f34414a = str;
    }

    public String a() {
        return c();
    }

    public v.a b() {
        return f34413c;
    }

    public Map<String, String> d() {
        return MapsKt__MapsJVMKt.e(l.a("text_auto_replace_enabled", c()));
    }

    /* renamed from: f */
    public String c() {
        return this.f34414a;
    }
}
