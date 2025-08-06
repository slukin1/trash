package gy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.scwang.smartrefresh.header.internal.FastOutSlowInInterpolator;
import java.util.ArrayList;

public class b extends Drawable implements Animatable {

    /* renamed from: m  reason: collision with root package name */
    public static final Interpolator f37154m = new LinearInterpolator();

    /* renamed from: n  reason: collision with root package name */
    public static final Interpolator f37155n = new FastOutSlowInInterpolator();

    /* renamed from: o  reason: collision with root package name */
    public static final int[] f37156o = {-16777216};

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<Animation> f37157b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final d f37158c;

    /* renamed from: d  reason: collision with root package name */
    public float f37159d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f37160e;

    /* renamed from: f  reason: collision with root package name */
    public View f37161f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f37162g;

    /* renamed from: h  reason: collision with root package name */
    public float f37163h;

    /* renamed from: i  reason: collision with root package name */
    public double f37164i;

    /* renamed from: j  reason: collision with root package name */
    public double f37165j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f37166k;

    /* renamed from: l  reason: collision with root package name */
    public final Drawable.Callback f37167l;

    public class a extends Animation {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f37168b;

        public a(d dVar) {
            this.f37168b = dVar;
        }

        public void applyTransformation(float f11, Transformation transformation) {
            b bVar = b.this;
            if (bVar.f37166k) {
                bVar.a(f11, this.f37168b);
                return;
            }
            float c11 = bVar.c(this.f37168b);
            float j11 = this.f37168b.j();
            float l11 = this.f37168b.l();
            float k11 = this.f37168b.k();
            b.this.m(f11, this.f37168b);
            if (f11 <= 0.5f) {
                Interpolator interpolator = b.f37155n;
                this.f37168b.D(l11 + ((0.8f - c11) * interpolator.getInterpolation(f11 / 0.5f)));
            }
            if (f11 > 0.5f) {
                Interpolator interpolator2 = b.f37155n;
                this.f37168b.z(j11 + ((0.8f - c11) * interpolator2.getInterpolation((f11 - 0.5f) / 0.5f)));
            }
            this.f37168b.B(k11 + (0.25f * f11));
            b bVar2 = b.this;
            bVar2.h((f11 * 216.0f) + ((bVar2.f37163h / 5.0f) * 1080.0f));
        }
    }

    /* renamed from: gy.b$b  reason: collision with other inner class name */
    public class C0507b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f37170a;

        public C0507b(d dVar) {
            this.f37170a = dVar;
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
            this.f37170a.F();
            this.f37170a.n();
            d dVar = this.f37170a;
            dVar.D(dVar.e());
            b bVar = b.this;
            if (bVar.f37166k) {
                bVar.f37166k = false;
                animation.setDuration(1332);
                this.f37170a.C(false);
                return;
            }
            bVar.f37163h = (bVar.f37163h + 1.0f) % 5.0f;
        }

        public void onAnimationStart(Animation animation) {
            b.this.f37163h = 0.0f;
        }
    }

    public class c implements Drawable.Callback {
        public c() {
        }

        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            b.this.scheduleSelf(runnable, j11);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final RectF f37173a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public final Paint f37174b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f37175c;

        /* renamed from: d  reason: collision with root package name */
        public final Drawable.Callback f37176d;

        /* renamed from: e  reason: collision with root package name */
        public float f37177e;

        /* renamed from: f  reason: collision with root package name */
        public float f37178f;

        /* renamed from: g  reason: collision with root package name */
        public float f37179g;

        /* renamed from: h  reason: collision with root package name */
        public float f37180h;

        /* renamed from: i  reason: collision with root package name */
        public float f37181i;

        /* renamed from: j  reason: collision with root package name */
        public int[] f37182j;

        /* renamed from: k  reason: collision with root package name */
        public int f37183k;

        /* renamed from: l  reason: collision with root package name */
        public float f37184l;

        /* renamed from: m  reason: collision with root package name */
        public float f37185m;

        /* renamed from: n  reason: collision with root package name */
        public float f37186n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f37187o;

        /* renamed from: p  reason: collision with root package name */
        public Path f37188p;

        /* renamed from: q  reason: collision with root package name */
        public float f37189q;

        /* renamed from: r  reason: collision with root package name */
        public double f37190r;

        /* renamed from: s  reason: collision with root package name */
        public int f37191s;

        /* renamed from: t  reason: collision with root package name */
        public int f37192t;

        /* renamed from: u  reason: collision with root package name */
        public int f37193u;

        /* renamed from: v  reason: collision with root package name */
        public final Paint f37194v;

        /* renamed from: w  reason: collision with root package name */
        public int f37195w;

        /* renamed from: x  reason: collision with root package name */
        public int f37196x;

        public d(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.f37174b = paint;
            Paint paint2 = new Paint();
            this.f37175c = paint2;
            this.f37177e = 0.0f;
            this.f37178f = 0.0f;
            this.f37179g = 0.0f;
            this.f37180h = 5.0f;
            this.f37181i = 2.5f;
            this.f37194v = new Paint(1);
            this.f37176d = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        public void A(int i11, int i12) {
            double d11;
            float min = (float) Math.min(i11, i12);
            double d12 = this.f37190r;
            if (d12 <= 0.0d || min < 0.0f) {
                d11 = Math.ceil((double) (this.f37180h / 2.0f));
            } else {
                d11 = ((double) (min / 2.0f)) - d12;
            }
            this.f37181i = (float) d11;
        }

        public void B(float f11) {
            this.f37179g = f11;
            o();
        }

        public void C(boolean z11) {
            if (this.f37187o != z11) {
                this.f37187o = z11;
                o();
            }
        }

        public void D(float f11) {
            this.f37177e = f11;
            o();
        }

        public void E(float f11) {
            this.f37180h = f11;
            this.f37174b.setStrokeWidth(f11);
            o();
        }

        public void F() {
            this.f37184l = this.f37177e;
            this.f37185m = this.f37178f;
            this.f37186n = this.f37179g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f37173a;
            rectF.set(rect);
            float f11 = this.f37181i;
            rectF.inset(f11, f11);
            float f12 = this.f37177e;
            float f13 = this.f37179g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f37178f + f13) * 360.0f) - f14;
            if (f15 != 0.0f) {
                this.f37174b.setColor(this.f37196x);
                canvas.drawArc(rectF, f14, f15, false, this.f37174b);
            }
            b(canvas, f14, f15, rect);
            if (this.f37193u < 255) {
                this.f37194v.setColor(this.f37195w);
                this.f37194v.setAlpha(255 - this.f37193u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f37194v);
            }
        }

        public final void b(Canvas canvas, float f11, float f12, Rect rect) {
            if (this.f37187o) {
                Path path = this.f37188p;
                if (path == null) {
                    Path path2 = new Path();
                    this.f37188p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f13 = ((float) (((int) this.f37181i) / 2)) * this.f37189q;
                float sin = (float) ((this.f37190r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f37188p.moveTo(0.0f, 0.0f);
                this.f37188p.lineTo(((float) this.f37191s) * this.f37189q, 0.0f);
                Path path3 = this.f37188p;
                float f14 = this.f37189q;
                path3.lineTo((((float) this.f37191s) * f14) / 2.0f, ((float) this.f37192t) * f14);
                this.f37188p.offset(((float) ((this.f37190r * Math.cos(0.0d)) + ((double) rect.exactCenterX()))) - f13, sin);
                this.f37188p.close();
                this.f37175c.setColor(this.f37196x);
                canvas.rotate((f11 + f12) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f37188p, this.f37175c);
            }
        }

        public int c() {
            return this.f37193u;
        }

        public double d() {
            return this.f37190r;
        }

        public float e() {
            return this.f37178f;
        }

        public int f() {
            return this.f37182j[g()];
        }

        public final int g() {
            return (this.f37183k + 1) % this.f37182j.length;
        }

        public float h() {
            return this.f37177e;
        }

        public int i() {
            return this.f37182j[this.f37183k];
        }

        public float j() {
            return this.f37185m;
        }

        public float k() {
            return this.f37186n;
        }

        public float l() {
            return this.f37184l;
        }

        public float m() {
            return this.f37180h;
        }

        public void n() {
            x(g());
        }

        public final void o() {
            this.f37176d.invalidateDrawable((Drawable) null);
        }

        public void p() {
            this.f37184l = 0.0f;
            this.f37185m = 0.0f;
            this.f37186n = 0.0f;
            D(0.0f);
            z(0.0f);
            B(0.0f);
        }

        public void q(int i11) {
            this.f37193u = i11;
        }

        public void r(float f11, float f12) {
            this.f37191s = (int) f11;
            this.f37192t = (int) f12;
        }

        public void s(float f11) {
            if (f11 != this.f37189q) {
                this.f37189q = f11;
                o();
            }
        }

        public void t(int i11) {
            this.f37195w = i11;
        }

        public void u(double d11) {
            this.f37190r = d11;
        }

        public void v(int i11) {
            this.f37196x = i11;
        }

        public void w(ColorFilter colorFilter) {
            this.f37174b.setColorFilter(colorFilter);
            o();
        }

        public void x(int i11) {
            this.f37183k = i11;
            this.f37196x = this.f37182j[i11];
        }

        public void y(int[] iArr) {
            this.f37182j = iArr;
            x(0);
        }

        public void z(float f11) {
            this.f37178f = f11;
            o();
        }
    }

    public b(Context context, View view) {
        c cVar = new c();
        this.f37167l = cVar;
        this.f37161f = view;
        this.f37160e = context.getResources();
        d dVar = new d(cVar);
        this.f37158c = dVar;
        dVar.y(f37156o);
        n(1);
        k();
    }

    public void a(float f11, d dVar) {
        m(f11, dVar);
        dVar.D(dVar.l() + (((dVar.j() - c(dVar)) - dVar.l()) * f11));
        dVar.z(dVar.j());
        dVar.B(dVar.k() + ((((float) (Math.floor((double) (dVar.k() / 0.8f)) + 1.0d)) - dVar.k()) * f11));
    }

    public final int b(float f11, int i11, int i12) {
        int intValue = Integer.valueOf(i11).intValue();
        int i13 = (intValue >> 24) & 255;
        int i14 = (intValue >> 16) & 255;
        int i15 = (intValue >> 8) & 255;
        int i16 = intValue & 255;
        int intValue2 = Integer.valueOf(i12).intValue();
        return ((i13 + ((int) (((float) (((intValue2 >> 24) & 255) - i13)) * f11))) << 24) | ((i14 + ((int) (((float) (((intValue2 >> 16) & 255) - i14)) * f11))) << 16) | ((i15 + ((int) (((float) (((intValue2 >> 8) & 255) - i15)) * f11))) << 8) | (i16 + ((int) (f11 * ((float) ((intValue2 & 255) - i16)))));
    }

    public float c(d dVar) {
        return (float) Math.toRadians(((double) dVar.m()) / (dVar.d() * 6.283185307179586d));
    }

    public void d(float f11) {
        this.f37158c.s(f11);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f37159d, bounds.exactCenterX(), bounds.exactCenterY());
        this.f37158c.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void e(int i11) {
        this.f37158c.t(i11);
    }

    public void f(int... iArr) {
        this.f37158c.y(iArr);
        this.f37158c.x(0);
    }

    public void g(float f11) {
        this.f37158c.B(f11);
    }

    public int getAlpha() {
        return this.f37158c.c();
    }

    public int getIntrinsicHeight() {
        return (int) this.f37165j;
    }

    public int getIntrinsicWidth() {
        return (int) this.f37164i;
    }

    public int getOpacity() {
        return -3;
    }

    public void h(float f11) {
        this.f37159d = f11;
        invalidateSelf();
    }

    public final void i(double d11, double d12, double d13, double d14, float f11, float f12) {
        d dVar = this.f37158c;
        float f13 = this.f37160e.getDisplayMetrics().density;
        double d15 = (double) f13;
        this.f37164i = d11 * d15;
        this.f37165j = d12 * d15;
        dVar.E(((float) d14) * f13);
        dVar.u(d13 * d15);
        dVar.x(0);
        dVar.r(f11 * f13, f12 * f13);
        dVar.A((int) this.f37164i, (int) this.f37165j);
    }

    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f37157b;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            Animation animation = arrayList.get(i11);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void j(float f11, float f12) {
        this.f37158c.D(f11);
        this.f37158c.z(f12);
    }

    public final void k() {
        d dVar = this.f37158c;
        a aVar = new a(dVar);
        aVar.setRepeatCount(-1);
        aVar.setRepeatMode(1);
        aVar.setInterpolator(f37154m);
        aVar.setAnimationListener(new C0507b(dVar));
        this.f37162g = aVar;
    }

    public void l(boolean z11) {
        this.f37158c.C(z11);
    }

    public void m(float f11, d dVar) {
        if (f11 > 0.75f) {
            dVar.v(b((f11 - 0.75f) / 0.25f, dVar.i(), dVar.f()));
        }
    }

    public void n(int i11) {
        if (i11 == 0) {
            i(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            i(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void setAlpha(int i11) {
        this.f37158c.q(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f37158c.w(colorFilter);
    }

    public void start() {
        this.f37162g.reset();
        this.f37158c.F();
        if (this.f37158c.e() != this.f37158c.h()) {
            this.f37166k = true;
            this.f37162g.setDuration(666);
            this.f37161f.startAnimation(this.f37162g);
            return;
        }
        this.f37158c.x(0);
        this.f37158c.p();
        this.f37162g.setDuration(1332);
        this.f37161f.startAnimation(this.f37162g);
    }

    public void stop() {
        this.f37161f.clearAnimation();
        h(0.0f);
        this.f37158c.C(false);
        this.f37158c.x(0);
        this.f37158c.p();
    }
}
