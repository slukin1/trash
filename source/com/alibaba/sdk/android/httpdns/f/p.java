package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.i.b;
import java.net.SocketTimeoutException;
import q2.a;
import t2.c;
import t2.f;

public class p implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public a f14648a;

    /* renamed from: b  reason: collision with root package name */
    public u2.a f14649b;

    /* renamed from: c  reason: collision with root package name */
    public s f14650c;

    /* renamed from: d  reason: collision with root package name */
    public long f14651d;

    public p(a aVar, u2.a aVar2, s sVar) {
        this.f14648a = aVar;
        this.f14649b = aVar2;
        this.f14650c = sVar;
    }

    public void a(c cVar, Throwable th2) {
        u2.a aVar;
        long currentTimeMillis = System.currentTimeMillis() - this.f14651d;
        if (d(th2) || currentTimeMillis > ((long) cVar.c())) {
            boolean h11 = this.f14648a.e().h(cVar.d(), cVar.b());
            cVar.f(this.f14648a.e().i());
            cVar.g(this.f14648a.e().m());
            if (h11 && (aVar = this.f14649b) != null) {
                aVar.f();
            }
            s sVar = this.f14650c;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public void b(c cVar) {
        this.f14651d = System.currentTimeMillis();
    }

    public void c(c cVar, Object obj) {
        s sVar;
        if (this.f14648a.e().k(cVar.d(), cVar.b()) && (sVar = this.f14650c) != null) {
            sVar.d();
        }
    }

    public final boolean d(Throwable th2) {
        if (th2 instanceof SocketTimeoutException) {
            return true;
        }
        if (th2 instanceof b) {
            return ((b) th2).g();
        }
        return false;
    }
}
