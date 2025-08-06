package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.h0;

public abstract class a implements View.OnTouchListener {

    /* renamed from: s  reason: collision with root package name */
    public static final int f8694s = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    public final C0028a f8695b = new C0028a();

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f8696c = new AccelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public final View f8697d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f8698e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f8699f = {0.0f, 0.0f};

    /* renamed from: g  reason: collision with root package name */
    public float[] f8700g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: h  reason: collision with root package name */
    public int f8701h;

    /* renamed from: i  reason: collision with root package name */
    public int f8702i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f8703j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    public float[] f8704k = {0.0f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    public float[] f8705l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: m  reason: collision with root package name */
    public boolean f8706m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f8707n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f8708o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f8709p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f8710q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f8711r;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    public static class C0028a {

        /* renamed from: a  reason: collision with root package name */
        public int f8712a;

        /* renamed from: b  reason: collision with root package name */
        public int f8713b;

        /* renamed from: c  reason: collision with root package name */
        public float f8714c;

        /* renamed from: d  reason: collision with root package name */
        public float f8715d;

        /* renamed from: e  reason: collision with root package name */
        public long f8716e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public long f8717f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f8718g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f8719h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f8720i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f8721j;

        /* renamed from: k  reason: collision with root package name */
        public int f8722k;

        public void a() {
            if (this.f8717f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g11 = g(e(currentAnimationTimeMillis));
                this.f8717f = currentAnimationTimeMillis;
                float f11 = ((float) (currentAnimationTimeMillis - this.f8717f)) * g11;
                this.f8718g = (int) (this.f8714c * f11);
                this.f8719h = (int) (f11 * this.f8715d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f8718g;
        }

        public int c() {
            return this.f8719h;
        }

        public int d() {
            float f11 = this.f8714c;
            return (int) (f11 / Math.abs(f11));
        }

        public final float e(long j11) {
            long j12 = this.f8716e;
            if (j11 < j12) {
                return 0.0f;
            }
            long j13 = this.f8720i;
            if (j13 < 0 || j11 < j13) {
                return a.e(((float) (j11 - j12)) / ((float) this.f8712a), 0.0f, 1.0f) * 0.5f;
            }
            float f11 = this.f8721j;
            return (1.0f - f11) + (f11 * a.e(((float) (j11 - j13)) / ((float) this.f8722k), 0.0f, 1.0f));
        }

        public int f() {
            float f11 = this.f8715d;
            return (int) (f11 / Math.abs(f11));
        }

        public final float g(float f11) {
            return (-4.0f * f11 * f11) + (f11 * 4.0f);
        }

        public boolean h() {
            return this.f8720i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f8720i + ((long) this.f8722k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f8722k = a.f((int) (currentAnimationTimeMillis - this.f8716e), 0, this.f8713b);
            this.f8721j = e(currentAnimationTimeMillis);
            this.f8720i = currentAnimationTimeMillis;
        }

        public void j(int i11) {
            this.f8713b = i11;
        }

        public void k(int i11) {
            this.f8712a = i11;
        }

        public void l(float f11, float f12) {
            this.f8714c = f11;
            this.f8715d = f12;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f8716e = currentAnimationTimeMillis;
            this.f8720i = -1;
            this.f8717f = currentAnimationTimeMillis;
            this.f8721j = 0.5f;
            this.f8718g = 0;
            this.f8719h = 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f8709p) {
                if (aVar.f8707n) {
                    aVar.f8707n = false;
                    aVar.f8695b.m();
                }
                C0028a aVar2 = a.this.f8695b;
                if (aVar2.h() || !a.this.u()) {
                    a.this.f8709p = false;
                    return;
                }
                a aVar3 = a.this;
                if (aVar3.f8708o) {
                    aVar3.f8708o = false;
                    aVar3.c();
                }
                aVar2.a();
                a.this.j(aVar2.b(), aVar2.c());
                h0.p0(a.this.f8697d, this);
            }
        }
    }

    public a(View view) {
        this.f8697d = view;
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        float f12 = (float) ((int) ((1575.0f * f11) + 0.5f));
        o(f12, f12);
        float f13 = (float) ((int) ((f11 * 315.0f) + 0.5f));
        p(f13, f13);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f8694s);
        r(500);
        q(500);
    }

    public static float e(float f11, float f12, float f13) {
        return f11 > f13 ? f13 : f11 < f12 ? f12 : f11;
    }

    public static int f(int i11, int i12, int i13) {
        return i11 > i13 ? i13 : i11 < i12 ? i12 : i11;
    }

    public abstract boolean a(int i11);

    public abstract boolean b(int i11);

    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f8697d.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final float d(int i11, float f11, float f12, float f13) {
        float h11 = h(this.f8699f[i11], f12, this.f8700g[i11], f11);
        int i12 = (h11 > 0.0f ? 1 : (h11 == 0.0f ? 0 : -1));
        if (i12 == 0) {
            return 0.0f;
        }
        float f14 = this.f8703j[i11];
        float f15 = this.f8704k[i11];
        float f16 = this.f8705l[i11];
        float f17 = f14 * f13;
        if (i12 > 0) {
            return e(h11 * f17, f15, f16);
        }
        return -e((-h11) * f17, f15, f16);
    }

    public final float g(float f11, float f12) {
        if (f12 == 0.0f) {
            return 0.0f;
        }
        int i11 = this.f8701h;
        if (i11 == 0 || i11 == 1) {
            if (f11 < f12) {
                if (f11 >= 0.0f) {
                    return 1.0f - (f11 / f12);
                }
                return (!this.f8709p || i11 != 1) ? 0.0f : 1.0f;
            }
        } else if (i11 == 2 && f11 < 0.0f) {
            return f11 / (-f12);
        }
    }

    public final float h(float f11, float f12, float f13, float f14) {
        float f15;
        float e11 = e(f11 * f12, 0.0f, f13);
        float g11 = g(f12 - f14, e11) - g(f14, e11);
        if (g11 < 0.0f) {
            f15 = -this.f8696c.getInterpolation(-g11);
        } else if (g11 <= 0.0f) {
            return 0.0f;
        } else {
            f15 = this.f8696c.getInterpolation(g11);
        }
        return e(f15, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f8707n) {
            this.f8709p = false;
        } else {
            this.f8695b.i();
        }
    }

    public abstract void j(int i11, int i12);

    public a k(int i11) {
        this.f8702i = i11;
        return this;
    }

    public a l(int i11) {
        this.f8701h = i11;
        return this;
    }

    public a m(boolean z11) {
        if (this.f8710q && !z11) {
            i();
        }
        this.f8710q = z11;
        return this;
    }

    public a n(float f11, float f12) {
        float[] fArr = this.f8700g;
        fArr[0] = f11;
        fArr[1] = f12;
        return this;
    }

    public a o(float f11, float f12) {
        float[] fArr = this.f8705l;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f8710q
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.f8708o = r2
            r5.f8706m = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f8697d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f8697d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f8695b
            r7.l(r0, r6)
            boolean r6 = r5.f8709p
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.f8711r
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f8709p
            if (r6 == 0) goto L_0x0061
            r1 = r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f11, float f12) {
        float[] fArr = this.f8704k;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    public a q(int i11) {
        this.f8695b.j(i11);
        return this;
    }

    public a r(int i11) {
        this.f8695b.k(i11);
        return this;
    }

    public a s(float f11, float f12) {
        float[] fArr = this.f8699f;
        fArr[0] = f11;
        fArr[1] = f12;
        return this;
    }

    public a t(float f11, float f12) {
        float[] fArr = this.f8703j;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0028a aVar = this.f8695b;
        int f11 = aVar.f();
        int d11 = aVar.d();
        return (f11 != 0 && b(f11)) || (d11 != 0 && a(d11));
    }

    public final void v() {
        int i11;
        if (this.f8698e == null) {
            this.f8698e = new b();
        }
        this.f8709p = true;
        this.f8707n = true;
        if (this.f8706m || (i11 = this.f8702i) <= 0) {
            this.f8698e.run();
        } else {
            h0.q0(this.f8697d, this.f8698e, (long) i11);
        }
        this.f8706m = true;
    }
}
