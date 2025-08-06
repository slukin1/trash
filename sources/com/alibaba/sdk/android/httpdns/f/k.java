package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import com.alibaba.sdk.android.httpdns.e.b;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.Map;
import t2.i;
import x2.c;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public q2.a f14616a;

    /* renamed from: b  reason: collision with root package name */
    public j f14617b;

    /* renamed from: c  reason: collision with root package name */
    public g f14618c;

    /* renamed from: d  reason: collision with root package name */
    public c f14619d;

    /* renamed from: e  reason: collision with root package name */
    public b f14620e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14621f = true;

    /* renamed from: g  reason: collision with root package name */
    public com.alibaba.sdk.android.httpdns.e.c f14622g;

    /* renamed from: h  reason: collision with root package name */
    public b f14623h;

    public class a implements i<h> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f14624a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RequestIpType f14625b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14626c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f14627d;

        /* renamed from: com.alibaba.sdk.android.httpdns.f.k$a$a  reason: collision with other inner class name */
        public class C0071a implements x2.b {
            public C0071a() {
            }

            public void a(String str, String[] strArr) {
                if (HttpDnsLog.f()) {
                    HttpDnsLog.g("ip probe for " + str + " " + a.this.f14625b + " return " + w2.a.c(strArr));
                }
                k.this.f14617b.h(str, RequestIpType.v4, a.this.f14627d, strArr);
            }
        }

        public a(String str, RequestIpType requestIpType, String str2, String str3) {
            this.f14624a = str;
            this.f14625b = requestIpType;
            this.f14626c = str2;
            this.f14627d = str3;
        }

        public void a(Throwable th2) {
            HttpDnsLog.j("ip request for " + this.f14624a + " fail", th2);
            k.this.f14622g.c(this.f14624a, this.f14625b, this.f14627d);
        }

        /* renamed from: b */
        public void a(h hVar) {
            if (HttpDnsLog.f()) {
                HttpDnsLog.g("ip request for " + this.f14624a + " " + this.f14625b + " return " + hVar.toString());
            }
            k.this.f14617b.g(this.f14626c, this.f14624a, this.f14625b, hVar.d(), this.f14627d, hVar);
            RequestIpType requestIpType = this.f14625b;
            if (requestIpType == RequestIpType.v4 || requestIpType == RequestIpType.both) {
                k.this.f14619d.c(this.f14624a, hVar.e(), new C0071a());
            }
            k.this.f14622g.c(this.f14624a, this.f14625b, this.f14627d);
        }
    }

    public k(q2.a aVar, c cVar, g gVar, j jVar, b bVar, com.alibaba.sdk.android.httpdns.e.c cVar2) {
        this.f14616a = aVar;
        this.f14619d = cVar;
        this.f14618c = gVar;
        this.f14617b = jVar;
        this.f14620e = bVar;
        this.f14622g = cVar2;
        this.f14623h = new b();
    }

    public m2.b c(String str, RequestIpType requestIpType, Map<String, String> map, String str2) {
        String str3 = str;
        RequestIpType requestIpType2 = requestIpType;
        String str4 = str2;
        if (this.f14620e.a(str)) {
            if (HttpDnsLog.f()) {
                HttpDnsLog.b("request host " + str + ", which is filtered");
            }
            return w2.b.f16743d;
        }
        if (HttpDnsLog.f()) {
            HttpDnsLog.b("request host " + str + " with type " + requestIpType2 + " extras : " + w2.a.i(map) + " cacheKey " + str4);
        }
        m2.b b11 = this.f14617b.b(str, requestIpType2, str4);
        if (HttpDnsLog.f()) {
            HttpDnsLog.b("host " + str + " result is " + w2.a.r(b11));
        }
        if ((b11 == null || b11.b()) && this.f14622g.e(str, requestIpType2, str4)) {
            String u11 = this.f14616a.u();
            this.f14618c.a(str, requestIpType, map, str2, new a(str, requestIpType, u11, str2));
        }
        if (b11 == null || (b11.b() && !this.f14621f && !b11.c())) {
            if (HttpDnsLog.f()) {
                HttpDnsLog.g("request host " + str + " and return empty immediately");
            }
            return w2.b.f16743d;
        }
        if (HttpDnsLog.f()) {
            HttpDnsLog.g("request host " + str + " for " + requestIpType2 + " and return " + b11.toString() + " immediately");
        }
        return b11;
    }

    public void e(boolean z11) {
        this.f14621f = z11;
    }
}
