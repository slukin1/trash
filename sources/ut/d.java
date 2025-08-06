package ut;

import android.os.Message;
import com.hbg.lib.network.pro.core.util.Period;
import i6.b;
import i6.i;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f84952a;

    /* renamed from: b  reason: collision with root package name */
    public long f84953b;

    /* renamed from: c  reason: collision with root package name */
    public long f84954c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84955d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<it.a> f84956e;

    /* renamed from: f  reason: collision with root package name */
    public final List<SoftReference<it.a>> f84957f;

    /* renamed from: g  reason: collision with root package name */
    public final i6.b f84958g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f84959h;

    public class a implements b.a {
        public a() {
        }

        public void handleMessage(Message message) {
            d.e(d.this, 1000);
            d.this.m();
            if (d.this.f84955d && d.this.f84954c > 0) {
                d.this.f84958g.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static d f84961a = new d((a) null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static /* synthetic */ long e(d dVar, long j11) {
        long j12 = dVar.f84954c - j11;
        dVar.f84954c = j12;
        return j12;
    }

    public static d i() {
        return b.f84961a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j() {
        int i11 = this.f84952a;
        long j11 = this.f84954c;
        o(i11, j11, p(j11));
        if (this.f84954c <= 0) {
            this.f84955d = false;
            n(this.f84952a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(int i11) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f84957f) {
            SoftReference<it.a> softReference = this.f84956e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.c(i11);
            }
            for (int i12 = 0; i12 < this.f84957f.size(); i12++) {
                SoftReference softReference2 = this.f84957f.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.c(i11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(it.a aVar) {
        synchronized (this.f84957f) {
            if (aVar != null) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f84957f.size()) {
                        SoftReference softReference = this.f84957f.get(i11);
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
                    this.f84957f.add(new SoftReference(aVar));
                }
                aVar.b(this.f84952a, this.f84954c, p(this.f84954c));
            }
            i6.d.b("registerCountDownCallback-->size:" + this.f84957f.size() + " callback:" + aVar);
        }
    }

    public static long[] p(long j11) {
        long j12 = j11 / Period.DAY_MILLS;
        long j13 = j11 - (Period.DAY_MILLS * j12);
        long j14 = j13 / Period.MIN60_MILLS;
        long j15 = j13 - (Period.MIN60_MILLS * j14);
        long j16 = j15 / 60000;
        long j17 = j15 - (60000 * j16);
        long j18 = j17 / 1000;
        return new long[]{j12, j14, j16, j18, j17 - (1000 * j18)};
    }

    public final void m() {
        i.b().f(new a(this));
    }

    public final void n(int i11) {
        i.b().g(new b(this, i11), 270);
    }

    public final void o(int i11, long j11, long[] jArr) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f84957f) {
            SoftReference<it.a> softReference = this.f84956e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.b(i11, j11, jArr);
            }
            for (int i12 = 0; i12 < this.f84957f.size(); i12++) {
                SoftReference softReference2 = this.f84957f.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.b(i11, j11, jArr);
                }
            }
        }
    }

    public void q(it.a aVar) {
        i.b().f(new c(this, aVar));
    }

    public void r() {
        this.f84955d = false;
        this.f84954c = 0;
        this.f84958g.removeCallbacksAndMessages((Object) null);
    }

    public void s(it.a aVar) {
        this.f84956e = new SoftReference<>(aVar);
    }

    public void t(int i11, long j11) {
        this.f84952a = i11;
        this.f84955d = true;
        long max = Math.max(j11, 0);
        this.f84953b = max;
        this.f84954c = max;
        long j12 = this.f84954c - p(max)[4];
        this.f84954c = j12;
        this.f84954c = Math.max(j12, 0);
        m();
        this.f84958g.removeMessages(0);
        if (this.f84954c != 0) {
            this.f84958g.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public d() {
        this.f84957f = new ArrayList();
        this.f84959h = new a();
        this.f84958g = new i6.b(this.f84959h);
    }
}
