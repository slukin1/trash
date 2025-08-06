package yi;

import android.os.Message;
import com.hbg.lib.network.pro.core.util.Period;
import i6.b;
import i6.d;
import i6.i;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f48109a;

    /* renamed from: b  reason: collision with root package name */
    public long f48110b;

    /* renamed from: c  reason: collision with root package name */
    public long f48111c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48112d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<it.a> f48113e;

    /* renamed from: f  reason: collision with root package name */
    public final List<SoftReference<it.a>> f48114f;

    /* renamed from: g  reason: collision with root package name */
    public final i6.b f48115g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f48116h;

    public class a implements b.a {
        public a() {
        }

        public void handleMessage(Message message) {
            e.f(e.this, 1000);
            e.this.p();
            if (e.this.f48112d && e.this.f48111c > 0) {
                e.this.f48115g.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static e f48118a = new e((a) null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static /* synthetic */ long f(e eVar, long j11) {
        long j12 = eVar.f48111c - j11;
        eVar.f48111c = j12;
        return j12;
    }

    public static e k() {
        return b.f48118a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        int i11 = this.f48109a;
        long j11 = this.f48111c;
        r(i11, j11, s(j11));
        if (this.f48111c <= 0) {
            this.f48112d = false;
            q(this.f48109a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i11) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f48114f) {
            SoftReference<it.a> softReference = this.f48113e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.c(i11);
            }
            for (int i12 = 0; i12 < this.f48114f.size(); i12++) {
                SoftReference softReference2 = this.f48114f.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.c(i11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(it.a aVar) {
        synchronized (this.f48114f) {
            if (aVar != null) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f48114f.size()) {
                        SoftReference softReference = this.f48114f.get(i11);
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
                    this.f48114f.add(new SoftReference(aVar));
                }
                aVar.b(this.f48109a, this.f48111c, s(this.f48111c));
            }
            d.b("registerCountDownCallback-->size:" + this.f48114f.size() + " callback:" + aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(it.a aVar) {
        synchronized (this.f48114f) {
            if (aVar != null) {
                SoftReference softReference = null;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f48114f.size()) {
                        SoftReference softReference2 = this.f48114f.get(i11);
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
                    this.f48114f.remove(softReference);
                }
            }
            d.b("unregisterCountDownCallback-->size:" + this.f48114f.size() + " callback:" + aVar);
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
        return this.f48110b;
    }

    public final void p() {
        i.b().f(new a(this));
    }

    public final void q(int i11) {
        i.b().g(new b(this, i11), 270);
    }

    public final void r(int i11, long j11, long[] jArr) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f48114f) {
            SoftReference<it.a> softReference = this.f48113e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.b(i11, j11, jArr);
            }
            for (int i12 = 0; i12 < this.f48114f.size(); i12++) {
                SoftReference softReference2 = this.f48114f.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.b(i11, j11, jArr);
                }
            }
        }
    }

    public void t(it.a aVar) {
        i.b().f(new d(this, aVar));
    }

    public void u(int i11, long j11) {
        this.f48109a = i11;
        this.f48112d = true;
        long max = Math.max(j11, 0);
        this.f48110b = max;
        this.f48111c = max;
        long j12 = this.f48111c - s(max)[4];
        this.f48111c = j12;
        this.f48111c = Math.max(j12, 0);
        p();
        this.f48115g.removeMessages(0);
        if (this.f48111c != 0) {
            this.f48115g.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public void v(it.a aVar) {
        i.b().f(new c(this, aVar));
    }

    public e() {
        this.f48114f = new ArrayList();
        this.f48116h = new a();
        this.f48115g = new i6.b(this.f48116h);
    }
}
