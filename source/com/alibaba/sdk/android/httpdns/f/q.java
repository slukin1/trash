package com.alibaba.sdk.android.httpdns.f;

import com.jumio.core.cdn.CDNDownload;
import t2.c;
import t2.d;
import t2.e;
import t2.f;
import t2.h;
import t2.i;
import u2.a;
import w2.b;

public class q implements e {

    /* renamed from: a  reason: collision with root package name */
    public a f14652a;

    /* renamed from: b  reason: collision with root package name */
    public s f14653b;

    /* renamed from: c  reason: collision with root package name */
    public int f14654c = CDNDownload.DEFAULT_TIMEOUT;

    /* renamed from: d  reason: collision with root package name */
    public long f14655d = 0;

    public q(a aVar, s sVar) {
        this.f14652a = aVar;
        this.f14653b = sVar;
    }

    public void a(q2.a aVar, c cVar, i<h> iVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f14655d < ((long) this.f14654c)) {
            iVar.a((Throwable) b.f16744e);
            return;
        }
        this.f14655d = currentTimeMillis;
        try {
            aVar.c().execute(new e(new f(new f(new f(new t2.b(cVar, new i()), new d(s2.b.b(aVar.s()))), new h(aVar.l())), new p(aVar, this.f14652a, this.f14653b)), iVar));
        } catch (Throwable th2) {
            iVar.a(th2);
        }
    }

    public void b() {
        this.f14655d = 0;
    }
}
