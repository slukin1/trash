package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import com.hbg.lib.common.utils.PixelUtils;

public class l1 extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public Paint f72059a;

    /* renamed from: b  reason: collision with root package name */
    public float f72060b;

    /* renamed from: c  reason: collision with root package name */
    public int f72061c = 0;

    /* renamed from: d  reason: collision with root package name */
    public RectF f72062d;

    /* renamed from: e  reason: collision with root package name */
    public float f72063e;

    /* renamed from: f  reason: collision with root package name */
    public float f72064f;

    /* renamed from: g  reason: collision with root package name */
    public float f72065g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f72066h;

    /* renamed from: i  reason: collision with root package name */
    public Path f72067i;

    /* renamed from: j  reason: collision with root package name */
    public Path f72068j;

    /* renamed from: k  reason: collision with root package name */
    public Path f72069k;

    /* renamed from: l  reason: collision with root package name */
    public float f72070l;

    /* renamed from: m  reason: collision with root package name */
    public float f72071m;

    /* renamed from: n  reason: collision with root package name */
    public float f72072n;

    /* renamed from: o  reason: collision with root package name */
    public int f72073o = -1;

    /* renamed from: p  reason: collision with root package name */
    public int f72074p = -65536;

    /* renamed from: q  reason: collision with root package name */
    public Button f72075q;

    /* renamed from: r  reason: collision with root package name */
    public Animatable f72076r;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l1.a(l1.this, 5.0f);
            l1.this.invalidateSelf();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            l1.this.f72075q.setClickable(true);
            if (l1.this.f72076r != null) {
                l1.this.f72076r.stop();
            }
        }
    }

    public l1(float f11, Button button) {
        this.f72060b = f11;
        this.f72075q = button;
        Paint paint = new Paint(1);
        this.f72059a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f72059a.setStrokeWidth((float) PixelUtils.a(2.5f));
        float f12 = this.f72060b;
        this.f72062d = new RectF(0.0f, 0.0f, f12, f12);
        float f13 = this.f72060b;
        this.f72063e = f13 / 2.0f;
        this.f72064f = f13 / 2.0f;
        e();
    }

    public static /* synthetic */ float a(l1 l1Var, float f11) {
        float f12 = l1Var.f72065g + f11;
        l1Var.f72065g = f12;
        return f12;
    }

    public void d() {
        this.f72061c = 0;
        this.f72072n = this.f72070l;
        this.f72059a.setColor(this.f72073o);
        h();
    }

    public void draw(Canvas canvas) {
        int i11 = this.f72061c;
        if (i11 != 0) {
            if (i11 == 1) {
                canvas.save();
                canvas.rotate(this.f72065g, this.f72063e, this.f72064f);
                canvas.drawArc(this.f72062d, -90.0f, 240.0f, false, this.f72059a);
                canvas.restore();
            } else if (i11 == 2) {
                canvas.drawPath(this.f72067i, this.f72059a);
                this.f72059a.setPathEffect((PathEffect) null);
            } else if (i11 == 3) {
                canvas.drawPath(this.f72068j, this.f72059a);
                canvas.drawPath(this.f72069k, this.f72059a);
                this.f72059a.setPathEffect((PathEffect) null);
            }
        }
    }

    public final void e() {
        Path path = new Path();
        this.f72067i = path;
        float f11 = this.f72060b;
        path.moveTo(1.0f * f11, f11 * 0.2f);
        Path path2 = this.f72067i;
        float f12 = this.f72060b;
        path2.lineTo(f12 * 0.4f, f12 * 0.8f);
        this.f72067i.lineTo(0.0f, this.f72060b * 0.4f);
        PathMeasure pathMeasure = new PathMeasure(this.f72067i, false);
        this.f72070l = pathMeasure.getLength();
        Path path3 = new Path();
        this.f72068j = path3;
        float f13 = this.f72060b;
        path3.moveTo(f13 * 0.9f, f13 * 0.9f);
        Path path4 = this.f72068j;
        float f14 = this.f72060b;
        path4.lineTo(f14 * 0.1f, f14 * 0.1f);
        pathMeasure.setPath(this.f72068j, false);
        this.f72071m = pathMeasure.getLength();
        Path path5 = new Path();
        this.f72069k = path5;
        float f15 = this.f72060b;
        path5.moveTo(f15 * 0.9f, f15 * 0.1f);
        Path path6 = this.f72069k;
        float f16 = this.f72060b;
        path6.lineTo(0.1f * f16, f16 * 0.9f);
    }

    public void f(Animatable animatable) {
        this.f72076r = animatable;
    }

    public void g(int i11) {
        this.f72073o = i11;
    }

    public int getIntrinsicHeight() {
        return (int) this.f72060b;
    }

    public int getIntrinsicWidth() {
        return (int) this.f72060b;
    }

    public int getOpacity() {
        return -3;
    }

    public final void h() {
        j();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "Phase", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.addListener(new b());
        ofFloat.start();
    }

    public void i() {
        this.f72061c = 1;
        this.f72059a.setColor(this.f72073o);
        this.f72075q.setClickable(false);
        if (this.f72066h == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f72066h = ofFloat;
            ofFloat.setDuration(2000);
            this.f72066h.setRepeatCount(-1);
            this.f72066h.setRepeatMode(1);
            this.f72066h.addUpdateListener(new a());
        }
        this.f72066h.start();
    }

    public void j() {
        ValueAnimator valueAnimator = this.f72066h;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f72066h.end();
        }
    }

    public void setAlpha(int i11) {
        this.f72059a.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f72059a.setColorFilter(colorFilter);
    }
}
