package com.huobi.trade.helper;

import android.os.Message;
import com.hbg.lib.network.pro.core.util.Period;
import i6.b;
import i6.d;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public int f82045a;

    /* renamed from: b  reason: collision with root package name */
    public long f82046b;

    /* renamed from: c  reason: collision with root package name */
    public long f82047c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f82048d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<it.a> f82049e;

    /* renamed from: f  reason: collision with root package name */
    public final List<SoftReference<it.a>> f82050f;

    /* renamed from: g  reason: collision with root package name */
    public final i6.b f82051g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f82052h;

    public class a implements b.a {
        public a() {
        }

        public void handleMessage(Message message) {
            i.f(i.this, 1000);
            i.this.p();
            if (i.this.f82048d && i.this.f82047c > 0) {
                i.this.f82051g.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static i f82054a = new i((a) null);
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static /* synthetic */ long f(i iVar, long j11) {
        long j12 = iVar.f82047c - j11;
        iVar.f82047c = j12;
        return j12;
    }

    public static i k() {
        return b.f82054a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        int i11 = this.f82045a;
        long j11 = this.f82047c;
        r(i11, j11, s(j11));
        if (this.f82047c <= 0) {
            this.f82048d = false;
            q(this.f82045a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i11) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f82050f) {
            SoftReference<it.a> softReference = this.f82049e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.c(i11);
            }
            for (int i12 = 0; i12 < this.f82050f.size(); i12++) {
                SoftReference softReference2 = this.f82050f.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.c(i11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(it.a aVar) {
        synchronized (this.f82050f) {
            if (aVar != null) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f82050f.size()) {
                        SoftReference softReference = this.f82050f.get(i11);
                        if (softReference != null && softReference.get() == aVar) {
                            z11 = true;
                            break;
                        }
                        i11++;
                    } else {
                        break;
                    }
                }
                if (!z11) {
                    this.f82050f.add(new SoftReference(aVar));
                }
                aVar.b(this.f82045a, this.f82047c, s(this.f82047c));
            }
            d.b("registerCountDownCallback-->size:" + this.f82050f.size() + " callback:" + aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(it.a aVar) {
        synchronized (this.f82050f) {
            if (aVar != null) {
                SoftReference softReference = null;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f82050f.size()) {
                        SoftReference softReference2 = this.f82050f.get(i11);
                        if (softReference2 != null && softReference2.get() == aVar) {
                            softReference = softReference2;
                            break;
                        }
                        i11++;
                    } else {
                        break;
                    }
                }
                if (softReference != null) {
                    this.f82050f.remove(softReference);
                }
            }
            d.b("unregisterCountDownCallback-->size:" + this.f82050f.size() + " callback:" + aVar);
        }
    }

    public static long[] s(long j11) {
        long j12 = j11 / Period.DAY_MILLS;
        long j13 = j11 - (Period.DAY_MILLS * j12);
        long j14 = j13 / Period.MIN60_MILLS;
        long j15 = j13 - (Period.MIN60_MILLS * j14);
        long j16 = j15 / 60000;
        long j17 = j15 - (60000 * j16);
        long j18 = j17 / 1000;
        return new long[]{j12, j14, j16, j18, j17 - (1000 * j18)};
    }

    public long j() {
        return this.f82046b;
    }

    public final void p() {
        i6.i.b().f(new e(this));
    }

    public final void q(int i11) {
        i6.i.b().g(new f(this, i11), 270);
    }

    public final void r(int i11, long j11, long[] jArr) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f82050f) {
            SoftReference<it.a> softReference = this.f82049e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.b(i11, j11, jArr);
            }
            for (int i12 = 0; i12 < this.f82050f.size(); i12++) {
                SoftReference softReference2 = this.f82050f.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.b(i11, j11, jArr);
                }
            }
        }
    }

    public void t(it.a aVar) {
        i6.i.b().f(new h(this, aVar));
    }

    public void u() {
        this.f82048d = false;
        this.f82047c = 0;
        this.f82051g.removeCallbacksAndMessages((Object) null);
    }

    public void v(int i11, long j11) {
        this.f82045a = i11;
        this.f82048d = true;
        long max = Math.max(j11, 0);
        this.f82046b = max;
        this.f82047c = max;
        long j12 = this.f82047c - s(max)[4];
        this.f82047c = j12;
        this.f82047c = Math.max(j12, 0);
        p();
        this.f82051g.removeMessages(0);
        if (this.f82047c != 0) {
            this.f82051g.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public void w(it.a aVar) {
        i6.i.b().f(new g(this, aVar));
    }

    public i() {
        this.f82050f = new ArrayList();
        this.f82052h = new a();
        this.f82051g = new i6.b(this.f82052h);
    }
}
