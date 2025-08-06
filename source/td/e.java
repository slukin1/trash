package td;

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
    public int f26201a;

    /* renamed from: b  reason: collision with root package name */
    public long f26202b;

    /* renamed from: c  reason: collision with root package name */
    public long f26203c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26204d;

    /* renamed from: e  reason: collision with root package name */
    public SoftReference<vd.a> f26205e;

    /* renamed from: f  reason: collision with root package name */
    public final List<SoftReference<vd.a>> f26206f;

    /* renamed from: g  reason: collision with root package name */
    public final i6.b f26207g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f26208h;

    public class a implements b.a {
        public a() {
        }

        public void handleMessage(Message message) {
            e.f(e.this, 1000);
            e.this.p();
            if (e.this.f26204d && e.this.f26203c > 0) {
                e.this.f26207g.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static e f26210a = new e((a) null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static /* synthetic */ long f(e eVar, long j11) {
        long j12 = eVar.f26203c - j11;
        eVar.f26203c = j12;
        return j12;
    }

    public static e k() {
        return b.f26210a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        int i11 = this.f26201a;
        long j11 = this.f26203c;
        r(i11, j11, s(j11));
        if (this.f26203c <= 0) {
            this.f26204d = false;
            q(this.f26201a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(int i11) {
        vd.a aVar;
        vd.a aVar2;
        synchronized (this.f26206f) {
            SoftReference<vd.a> softReference = this.f26205e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.c(i11);
            }
            for (int i12 = 0; i12 < this.f26206f.size(); i12++) {
                SoftReference softReference2 = this.f26206f.get(i12);
                if (!(softReference2 == null || (aVar = (vd.a) softReference2.get()) == null)) {
                    aVar.c(i11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(vd.a aVar) {
        synchronized (this.f26206f) {
            if (aVar != null) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f26206f.size()) {
                        SoftReference softReference = this.f26206f.get(i11);
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
                    this.f26206f.add(new SoftReference(aVar));
                }
                aVar.b(this.f26201a, this.f26203c, s(this.f26203c));
            }
            d.b("registerCountDownCallback-->size:" + this.f26206f.size() + " callback:" + aVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(vd.a aVar) {
        synchronized (this.f26206f) {
            if (aVar != null) {
                SoftReference softReference = null;
                int i11 = 0;
                while (true) {
                    if (i11 < this.f26206f.size()) {
                        SoftReference softReference2 = this.f26206f.get(i11);
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
                    this.f26206f.remove(softReference);
                }
            }
            d.b("unregisterCountDownCallback-->size:" + this.f26206f.size() + " callback:" + aVar);
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
        return this.f26202b;
    }

    public final void p() {
        i.b().f(new a(this));
    }

    public final void q(int i11) {
        i.b().g(new b(this, i11), 270);
    }

    public final void r(int i11, long j11, long[] jArr) {
        vd.a aVar;
        vd.a aVar2;
        synchronized (this.f26206f) {
            SoftReference<vd.a> softReference = this.f26205e;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.b(i11, j11, jArr);
            }
            for (int i12 = 0; i12 < this.f26206f.size(); i12++) {
                SoftReference softReference2 = this.f26206f.get(i12);
                if (!(softReference2 == null || (aVar = (vd.a) softReference2.get()) == null)) {
                    aVar.b(i11, j11, jArr);
                }
            }
        }
    }

    public void t(vd.a aVar) {
        i.b().f(new c(this, aVar));
    }

    public void u() {
        this.f26204d = false;
        this.f26203c = 0;
        this.f26207g.removeCallbacksAndMessages((Object) null);
    }

    public void v(int i11, long j11) {
        this.f26201a = i11;
        this.f26204d = true;
        long max = Math.max(j11, 0);
        this.f26202b = max;
        this.f26203c = max;
        long j12 = this.f26203c - s(max)[4];
        this.f26203c = j12;
        this.f26203c = Math.max(j12, 0);
        p();
        this.f26207g.removeMessages(0);
        if (this.f26203c != 0) {
            this.f26207g.sendEmptyMessageDelayed(0, 1000);
        }
    }

    public void w(vd.a aVar) {
        i.b().f(new d(this, aVar));
    }

    public e() {
        this.f26206f = new ArrayList();
        this.f26208h = new a();
        this.f26207g = new i6.b(this.f26208h);
    }
}
