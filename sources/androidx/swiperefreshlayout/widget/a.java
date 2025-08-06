package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.h;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

public class a extends Drawable implements Animatable {

    /* renamed from: h  reason: collision with root package name */
    public static final Interpolator f11033h = new LinearInterpolator();

    /* renamed from: i  reason: collision with root package name */
    public static final Interpolator f11034i = new FastOutSlowInInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f11035j = {-16777216};

    /* renamed from: b  reason: collision with root package name */
    public final c f11036b;

    /* renamed from: c  reason: collision with root package name */
    public float f11037c;

    /* renamed from: d  reason: collision with root package name */
    public Resources f11038d;

    /* renamed from: e  reason: collision with root package name */
    public Animator f11039e;

    /* renamed from: f  reason: collision with root package name */
    public float f11040f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11041g;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    public class C0057a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11042b;

        public C0057a(c cVar) {
            this.f11042b = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.n(floatValue, this.f11042b);
            a.this.b(floatValue, this.f11042b, false);
            a.this.invalidateSelf();
        }
    }

    public class b implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f11044b;

        public b(c cVar) {
            this.f11044b = cVar;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            a.this.b(1.0f, this.f11044b, true);
            this.f11044b.A();
            this.f11044b.l();
            a aVar = a.this;
            if (aVar.f11041g) {
                aVar.f11041g = false;
                animator.cancel();
                animator.setDuration(1332);
                animator.start();
                this.f11044b.x(false);
                return;
            }
            aVar.f11040f += 1.0f;
        }

        public void onAnimationStart(Animator animator) {
            a.this.f11040f = 0.0f;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final RectF f11046a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public final Paint f11047b;

        /* renamed from: c  reason: collision with root package name */
        public final Paint f11048c;

        /* renamed from: d  reason: collision with root package name */
        public final Paint f11049d;

        /* renamed from: e  reason: collision with root package name */
        public float f11050e;

        /* renamed from: f  reason: collision with root package name */
        public float f11051f;

        /* renamed from: g  reason: collision with root package name */
        public float f11052g;

        /* renamed from: h  reason: collision with root package name */
        public float f11053h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f11054i;

        /* renamed from: j  reason: collision with root package name */
        public int f11055j;

        /* renamed from: k  reason: collision with root package name */
        public float f11056k;

        /* renamed from: l  reason: collision with root package name */
        public float f11057l;

        /* renamed from: m  reason: collision with root package name */
        public float f11058m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f11059n;

        /* renamed from: o  reason: collision with root package name */
        public Path f11060o;

        /* renamed from: p  reason: collision with root package name */
        public float f11061p;

        /* renamed from: q  reason: collision with root package name */
        public float f11062q;

        /* renamed from: r  reason: collision with root package name */
        public int f11063r;

        /* renamed from: s  reason: collision with root package name */
        public int f11064s;

        /* renamed from: t  reason: collision with root package name */
        public int f11065t;

        /* renamed from: u  reason: collision with root package name */
        public int f11066u;

        public c() {
            Paint paint = new Paint();
            this.f11047b = paint;
            Paint paint2 = new Paint();
            this.f11048c = paint2;
            Paint paint3 = new Paint();
            this.f11049d = paint3;
            this.f11050e = 0.0f;
            this.f11051f = 0.0f;
            this.f11052g = 0.0f;
            this.f11053h = 5.0f;
            this.f11061p = 1.0f;
            this.f11065t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.f11056k = this.f11050e;
            this.f11057l = this.f11051f;
            this.f11058m = this.f11052g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f11046a;
            float f11 = this.f11062q;
            float f12 = (this.f11053h / 2.0f) + f11;
            if (f11 <= 0.0f) {
                f12 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f11063r) * this.f11061p) / 2.0f, this.f11053h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f12, ((float) rect.centerY()) - f12, ((float) rect.centerX()) + f12, ((float) rect.centerY()) + f12);
            float f13 = this.f11050e;
            float f14 = this.f11052g;
            float f15 = (f13 + f14) * 360.0f;
            float f16 = ((this.f11051f + f14) * 360.0f) - f15;
            this.f11047b.setColor(this.f11066u);
            this.f11047b.setAlpha(this.f11065t);
            float f17 = this.f11053h / 2.0f;
            rectF.inset(f17, f17);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f11049d);
            float f18 = -f17;
            rectF.inset(f18, f18);
            canvas.drawArc(rectF, f15, f16, false, this.f11047b);
            b(canvas, f15, f16, rectF);
        }

        public void b(Canvas canvas, float f11, float f12, RectF rectF) {
            if (this.f11059n) {
                Path path = this.f11060o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f11060o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f11060o.moveTo(0.0f, 0.0f);
                this.f11060o.lineTo(((float) this.f11063r) * this.f11061p, 0.0f);
                Path path3 = this.f11060o;
                float f13 = this.f11061p;
                path3.lineTo((((float) this.f11063r) * f13) / 2.0f, ((float) this.f11064s) * f13);
                this.f11060o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f11063r) * this.f11061p) / 2.0f), rectF.centerY() + (this.f11053h / 2.0f));
                this.f11060o.close();
                this.f11048c.setColor(this.f11066u);
                this.f11048c.setAlpha(this.f11065t);
                canvas.save();
                canvas.rotate(f11 + f12, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f11060o, this.f11048c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f11065t;
        }

        public float d() {
            return this.f11051f;
        }

        public int e() {
            return this.f11054i[f()];
        }

        public int f() {
            return (this.f11055j + 1) % this.f11054i.length;
        }

        public float g() {
            return this.f11050e;
        }

        public int h() {
            return this.f11054i[this.f11055j];
        }

        public float i() {
            return this.f11057l;
        }

        public float j() {
            return this.f11058m;
        }

        public float k() {
            return this.f11056k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f11056k = 0.0f;
            this.f11057l = 0.0f;
            this.f11058m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i11) {
            this.f11065t = i11;
        }

        public void o(float f11, float f12) {
            this.f11063r = (int) f11;
            this.f11064s = (int) f12;
        }

        public void p(float f11) {
            if (f11 != this.f11061p) {
                this.f11061p = f11;
            }
        }

        public void q(float f11) {
            this.f11062q = f11;
        }

        public void r(int i11) {
            this.f11066u = i11;
        }

        public void s(ColorFilter colorFilter) {
            this.f11047b.setColorFilter(colorFilter);
        }

        public void t(int i11) {
            this.f11055j = i11;
            this.f11066u = this.f11054i[i11];
        }

        public void u(int[] iArr) {
            this.f11054i = iArr;
            t(0);
        }

        public void v(float f11) {
            this.f11051f = f11;
        }

        public void w(float f11) {
            this.f11052g = f11;
        }

        public void x(boolean z11) {
            if (this.f11059n != z11) {
                this.f11059n = z11;
            }
        }

        public void y(float f11) {
            this.f11050e = f11;
        }

        public void z(float f11) {
            this.f11053h = f11;
            this.f11047b.setStrokeWidth(f11);
        }
    }

    public a(Context context) {
        this.f11038d = ((Context) h.g(context)).getResources();
        c cVar = new c();
        this.f11036b = cVar;
        cVar.u(f11035j);
        k(2.5f);
        m();
    }

    public final void a(float f11, c cVar) {
        n(f11, cVar);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f11));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((((float) (Math.floor((double) (cVar.j() / 0.8f)) + 1.0d)) - cVar.j()) * f11));
    }

    public void b(float f11, c cVar, boolean z11) {
        float f12;
        float f13;
        if (this.f11041g) {
            a(f11, cVar);
        } else if (f11 != 1.0f || z11) {
            float j11 = cVar.j();
            if (f11 < 0.5f) {
                f12 = cVar.k();
                f13 = (f11034i.getInterpolation(f11 / 0.5f) * 0.79f) + 0.01f + f12;
            } else {
                float k11 = cVar.k() + 0.79f;
                float f14 = k11;
                f12 = k11 - (((1.0f - f11034i.getInterpolation((f11 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f13 = f14;
            }
            cVar.y(f12);
            cVar.v(f13);
            cVar.w(j11 + (0.20999998f * f11));
            h((f11 + this.f11040f) * 216.0f);
        }
    }

    public final int c(float f11, int i11, int i12) {
        int i13 = (i11 >> 24) & 255;
        int i14 = (i11 >> 16) & 255;
        int i15 = (i11 >> 8) & 255;
        int i16 = i11 & 255;
        return ((i13 + ((int) (((float) (((i12 >> 24) & 255) - i13)) * f11))) << 24) | ((i14 + ((int) (((float) (((i12 >> 16) & 255) - i14)) * f11))) << 16) | ((i15 + ((int) (((float) (((i12 >> 8) & 255) - i15)) * f11))) << 8) | (i16 + ((int) (f11 * ((float) ((i12 & 255) - i16)))));
    }

    public void d(boolean z11) {
        this.f11036b.x(z11);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f11037c, bounds.exactCenterX(), bounds.exactCenterY());
        this.f11036b.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f11) {
        this.f11036b.p(f11);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f11036b.u(iArr);
        this.f11036b.t(0);
        invalidateSelf();
    }

    public void g(float f11) {
        this.f11036b.w(f11);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f11036b.c();
    }

    public int getOpacity() {
        return -3;
    }

    public final void h(float f11) {
        this.f11037c = f11;
    }

    public final void i(float f11, float f12, float f13, float f14) {
        c cVar = this.f11036b;
        float f15 = this.f11038d.getDisplayMetrics().density;
        cVar.z(f12 * f15);
        cVar.q(f11 * f15);
        cVar.t(0);
        cVar.o(f13 * f15, f14 * f15);
    }

    public boolean isRunning() {
        return this.f11039e.isRunning();
    }

    public void j(float f11, float f12) {
        this.f11036b.y(f11);
        this.f11036b.v(f12);
        invalidateSelf();
    }

    public void k(float f11) {
        this.f11036b.z(f11);
        invalidateSelf();
    }

    public void l(int i11) {
        if (i11 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        c cVar = this.f11036b;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new C0057a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f11033h);
        ofFloat.addListener(new b(cVar));
        this.f11039e = ofFloat;
    }

    public void n(float f11, c cVar) {
        if (f11 > 0.75f) {
            cVar.r(c((f11 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    public void setAlpha(int i11) {
        this.f11036b.n(i11);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11036b.s(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.f11039e.cancel();
        this.f11036b.A();
        if (this.f11036b.d() != this.f11036b.g()) {
            this.f11041g = true;
            this.f11039e.setDuration(666);
            this.f11039e.start();
            return;
        }
        this.f11036b.t(0);
        this.f11036b.m();
        this.f11039e.setDuration(1332);
        this.f11039e.start();
    }

    public void stop() {
        this.f11039e.cancel();
        h(0.0f);
        this.f11036b.x(false);
        this.f11036b.t(0);
        this.f11036b.m();
        invalidateSelf();
    }
}
