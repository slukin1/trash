package com.huobi.index.countdown;

import android.os.Message;
import com.hbg.lib.network.pro.core.util.Period;
import i6.b;
import i6.d;
import i6.i;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import xl.c;

public final class IndexCountDownManager {

    /* renamed from: a  reason: collision with root package name */
    public int f73255a;

    /* renamed from: b  reason: collision with root package name */
    public long f73256b;

    /* renamed from: c  reason: collision with root package name */
    public long f73257c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73258d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73259e;

    /* renamed from: f  reason: collision with root package name */
    public SoftReference<it.a> f73260f;

    /* renamed from: g  reason: collision with root package name */
    public final List<SoftReference<it.a>> f73261g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final b f73262h = new b(this.f73263i);

    /* renamed from: i  reason: collision with root package name */
    public b.a f73263i = new a();

    public class a implements b.a {
        public a() {
        }

        public void handleMessage(Message message) {
            IndexCountDownManager.f(IndexCountDownManager.this, 1000);
            IndexCountDownManager.this.o();
            if (IndexCountDownManager.this.f73258d && IndexCountDownManager.this.f73257c > 0) {
                IndexCountDownManager.this.f73262h.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    public static /* synthetic */ long f(IndexCountDownManager indexCountDownManager, long j11) {
        long j12 = indexCountDownManager.f73257c - j11;
        indexCountDownManager.f73257c = j12;
        return j12;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        int i11 = this.f73255a;
        long j11 = this.f73257c;
        q(i11, j11, r(j11));
        if (this.f73257c <= 0) {
            this.f73258d = false;
            p(this.f73255a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(int i11) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f73261g) {
            SoftReference<it.a> softReference = this.f73260f;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.c(i11);
            }
            for (int i12 = 0; i12 < this.f73261g.size(); i12++) {
                SoftReference softReference2 = this.f73261g.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.c(i11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(it.a aVar) {
        synchronized (this.f73261g) {
            if (aVar != null) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f73261g.size()) {
                        SoftReference softReference = this.f73261g.get(i11);
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
                    this.f73261g.add(new SoftReference(aVar));
                }
                aVar.b(this.f73255a, this.f73257c, r(this.f73257c));
            }
            d.b("registerCountDownCallback-->size:" + this.f73261g.size() + " callback:" + aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(it.a aVar) {
        synchronized (this.f73261g) {
            if (aVar != null) {
                SoftReference softReference = null;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f73261g.size()) {
                        SoftReference softReference2 = this.f73261g.get(i11);
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
                    this.f73261g.remove(softReference);
                }
            }
            d.b("unregisterCountDownCallback-->size:" + this.f73261g.size() + " callback:" + aVar);
        }
    }

    public long j() {
        return this.f73256b;
    }

    public final void o() {
        i.b().f(new xl.a(this));
    }

    public final void p(int i11) {
        i.b().g(new xl.b(this, i11), 270);
    }

    public final void q(int i11, long j11, long[] jArr) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f73261g) {
            SoftReference<it.a> softReference = this.f73260f;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.b(i11, j11, jArr);
            }
            for (int i12 = 0; i12 < this.f73261g.size(); i12++) {
                SoftReference softReference2 = this.f73261g.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.b(i11, j11, jArr);
                }
            }
        }
    }

    public final long[] r(long j11) {
        boolean z11 = this.f73259e;
        long j12 = 0;
        long j13 = z11 ? j11 / Period.DAY_MILLS : 0;
        if (z11) {
            j12 = j13 * Period.DAY_MILLS;
        }
        long j14 = j11 - j12;
        long j15 = j14 / Period.MIN60_MILLS;
        long j16 = j14 - (Period.MIN60_MILLS * j15);
        long j17 = j16 / 60000;
        long j18 = j16 - (60000 * j17);
        long j19 = j18 / 1000;
        return new long[]{j13, j15, j17, j19, j18 - (1000 * j19)};
    }

    public void s(it.a aVar) {
        i.b().f(new xl.d(this, aVar));
    }

    public void t() {
        this.f73258d = false;
        this.f73257c = 0;
        this.f73262h.removeCallbacksAndMessages((Object) null);
    }

    public void u(int i11, long j11, boolean z11) {
        this.f73255a = i11;
        this.f73259e = z11;
        this.f73258d = true;
        long max = Math.max(j11, 0);
        this.f73256b = max;
        this.f73257c = max;
        long j12 = this.f73257c - r(max)[4];
        this.f73257c = j12;
        this.f73257c = Math.max(j12, 0);
        o();
        this.f73262h.removeMessages(0);
        if (this.f73257c != 0) {
            this.f73262h.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public void v(it.a aVar) {
        i.b().f(new c(this, aVar));
    }
}
