package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import q2.a;
import q2.e;
import t2.c;
import t2.d;
import t2.f;
import t2.h;
import t2.i;
import t2.k;
import w2.b;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public a f14590a;

    /* renamed from: b  reason: collision with root package name */
    public u2.a f14591b;

    /* renamed from: c  reason: collision with root package name */
    public a f14592c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f14593d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public e f14594e;

    public g(a aVar, u2.a aVar2, e eVar) {
        this.f14590a = aVar;
        this.f14591b = aVar2;
        this.f14592c = new a(aVar2);
        this.f14594e = eVar;
    }

    public void a(String str, RequestIpType requestIpType, Map<String, String> map, String str2, i<h> iVar) {
        if (!this.f14590a.o()) {
            if (HttpDnsLog.f()) {
                HttpDnsLog.i("requestInterpretHost region miss match [" + this.f14590a.u() + "] [" + this.f14590a.e().g() + "]");
            }
            iVar.a((Throwable) b.f16745f);
            this.f14591b.f();
            return;
        }
        c e11 = f.e(this.f14590a, str, requestIpType, map, str2, this.f14593d, this.f14594e);
        if (HttpDnsLog.f()) {
            HttpDnsLog.b("start async ip request for " + str + " " + requestIpType);
        }
        this.f14592c.a().a(this.f14590a, e11, iVar);
    }

    public void b(ArrayList<String> arrayList, RequestIpType requestIpType, i<m> iVar) {
        if (!this.f14590a.o()) {
            if (HttpDnsLog.f()) {
                HttpDnsLog.i("requestResolveHost region miss match [" + this.f14590a.u() + "] [" + this.f14590a.e().g() + "]");
            }
            iVar.a((Throwable) b.f16745f);
            this.f14591b.f();
            return;
        }
        c f11 = f.f(this.f14590a, arrayList, requestIpType, this.f14594e);
        if (HttpDnsLog.f()) {
            HttpDnsLog.b("start resolve hosts async for " + arrayList.toString() + " " + requestIpType);
        }
        try {
            this.f14590a.c().execute(new t2.e(new k(new f(new f(new f(new t2.b(f11, new n()), new d(s2.b.b(this.f14590a.s()))), new h(this.f14590a.l())), new p(this.f14590a, this.f14591b, this.f14592c)), 1), iVar));
        } catch (Throwable th2) {
            iVar.a(th2);
        }
    }

    public void c() {
        this.f14592c.b();
    }
}
