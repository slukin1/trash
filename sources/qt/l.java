package qt;

import android.os.Message;
import com.hbg.lib.network.pro.core.util.Period;
import i6.b;
import i6.i;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public int f84705a;

    /* renamed from: b  reason: collision with root package name */
    public long f84706b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84707c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<it.a> f84708d;

    /* renamed from: e  reason: collision with root package name */
    public final List<SoftReference<it.a>> f84709e;

    /* renamed from: f  reason: collision with root package name */
    public final i6.b f84710f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f84711g;

    public class a implements b.a {
        public a() {
        }

        public void handleMessage(Message message) {
            l.d(l.this, 1000);
            l.this.k();
            if (l.this.f84707c && l.this.f84706b > 0) {
                l.this.f84710f.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static l f84713a = new l((a) null);
    }

    public /* synthetic */ l(a aVar) {
        this();
    }

    public static /* synthetic */ long d(l lVar, long j11) {
        long j12 = lVar.f84706b - j11;
        lVar.f84706b = j12;
        return j12;
    }

    public static l h() {
        return b.f84713a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        int i11 = this.f84705a;
        long j11 = this.f84706b;
        m(i11, j11, n(j11));
        if (this.f84706b <= 0) {
            this.f84707c = false;
            l(this.f84705a);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(int i11) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f84709e) {
            SoftReference<it.a> softReference = this.f84708d;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.c(i11);
            }
            for (int i12 = 0; i12 < this.f84709e.size(); i12++) {
                SoftReference softReference2 = this.f84709e.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.c(i11);
                }
            }
        }
    }

    public static long[] n(long j11) {
        long j12 = j11 / Period.DAY_MILLS;
        long j13 = j11 - (Period.DAY_MILLS * j12);
        long j14 = j13 / Period.MIN60_MILLS;
        long j15 = j13 - (Period.MIN60_MILLS * j14);
        long j16 = j15 / 60000;
        long j17 = j15 - (60000 * j16);
        long j18 = j17 / 1000;
        return new long[]{j12, j14, j16, j18, j17 - (1000 * j18)};
    }

    public final void k() {
        i.b().f(new j(this));
    }

    public final void l(int i11) {
        i.b().g(new k(this, i11), 270);
    }

    public final void m(int i11, long j11, long[] jArr) {
        it.a aVar;
        it.a aVar2;
        synchronized (this.f84709e) {
            SoftReference<it.a> softReference = this.f84708d;
            if (!(softReference == null || (aVar2 = softReference.get()) == null)) {
                aVar2.b(i11, j11, jArr);
            }
            for (int i12 = 0; i12 < this.f84709e.size(); i12++) {
                SoftReference softReference2 = this.f84709e.get(i12);
                if (!(softReference2 == null || (aVar = (it.a) softReference2.get()) == null)) {
                    aVar.b(i11, j11, jArr);
                }
            }
        }
    }

    public void o() {
        this.f84707c = false;
        this.f84706b = 0;
        this.f84710f.removeCallbacksAndMessages((Object) null);
    }

    public l() {
        this.f84709e = new ArrayList();
        this.f84711g = new a();
        this.f84710f = new i6.b(this.f84711g);
    }
}
