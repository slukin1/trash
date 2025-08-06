package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: v  reason: collision with root package name */
    public static final float[][] f29698v = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};

    /* renamed from: w  reason: collision with root package name */
    public static final float[][] f29699w = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};

    /* renamed from: x  reason: collision with root package name */
    public static final float[][] f29700x = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    /* renamed from: b  reason: collision with root package name */
    public float f29701b = 100.0f;

    /* renamed from: c  reason: collision with root package name */
    public Paint f29702c;

    /* renamed from: d  reason: collision with root package name */
    public Path f29703d;

    /* renamed from: e  reason: collision with root package name */
    public Path f29704e;

    /* renamed from: f  reason: collision with root package name */
    public Path f29705f;

    /* renamed from: g  reason: collision with root package name */
    public Path f29706g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f29707h;

    /* renamed from: i  reason: collision with root package name */
    public int f29708i;

    /* renamed from: j  reason: collision with root package name */
    public float f29709j;

    /* renamed from: k  reason: collision with root package name */
    public int f29710k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f29711l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f29712m = false;

    /* renamed from: n  reason: collision with root package name */
    public int f29713n;

    /* renamed from: o  reason: collision with root package name */
    public ValueAnimator f29714o;

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator f29715p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f29716q;

    /* renamed from: r  reason: collision with root package name */
    public ValueAnimator f29717r;

    /* renamed from: s  reason: collision with root package name */
    public ValueAnimator f29718s;

    /* renamed from: t  reason: collision with root package name */
    public ValueAnimator f29719t;

    /* renamed from: u  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f29720u = new a();

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = WaveView.this.f29709j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.postInvalidateOnAnimation();
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            WaveView.this.m();
            boolean unused = WaveView.this.f29711l = false;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.f29703d.moveTo(0.0f, 0.0f);
            float f11 = floatValue * 0.5f;
            WaveView.this.f29703d.quadTo(((float) WaveView.this.f29708i) * 0.25f, 0.0f, ((float) WaveView.this.f29708i) * 0.333f, f11);
            WaveView.this.f29703d.quadTo(((float) WaveView.this.f29708i) * 0.5f, floatValue * 1.4f, ((float) WaveView.this.f29708i) * 0.666f, f11);
            WaveView.this.f29703d.quadTo(((float) WaveView.this.f29708i) * 0.75f, 0.0f, (float) WaveView.this.f29708i, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    public WaveView(Context context) {
        super(context);
        getViewTreeObserver().addOnPreDrawListener(this);
        j();
    }

    public void f() {
        if (!this.f29718s.isRunning()) {
            r();
            s(0.1f);
        }
    }

    public void g(float f11, float f12) {
        l();
        this.f29703d.moveTo(0.0f, 0.0f);
        Path path = this.f29703d;
        int i11 = this.f29708i;
        float[][] fArr = f29699w;
        float[][] fArr2 = f29698v;
        path.cubicTo(fArr[0][0] * ((float) i11), fArr[0][1] * ((float) i11), Math.min(fArr2[1][0] + f12, fArr[1][0]) * ((float) i11), Math.max((fArr2[1][1] + f11) - f12, fArr[1][1]) * ((float) this.f29708i), Math.max(fArr2[2][0] - f12, fArr[2][0]) * ((float) this.f29708i), Math.max((fArr2[2][1] + f11) - f12, fArr[2][1]) * ((float) this.f29708i));
        Path path2 = this.f29703d;
        float max = ((float) this.f29708i) * Math.max(fArr2[3][0] - f12, fArr[3][0]);
        float min = ((float) this.f29708i) * Math.min(fArr2[3][1] + f11 + f12, fArr[3][1]);
        float max2 = ((float) this.f29708i) * Math.max(fArr2[4][0] - f12, fArr[4][0]);
        float min2 = ((float) this.f29708i) * Math.min(fArr2[4][1] + f11 + f12, fArr[4][1]);
        int i12 = this.f29708i;
        path2.cubicTo(max, min, max2, min2, ((float) i12) * fArr[5][0], ((float) i12) * Math.min(fArr2[0][1] + f11 + f12, fArr[5][1]));
        Path path3 = this.f29703d;
        int i13 = this.f29708i;
        float max3 = ((float) i13) - (((float) i13) * Math.max(fArr2[4][0] - f12, fArr[4][0]));
        float min3 = ((float) this.f29708i) * Math.min(fArr2[4][1] + f11 + f12, fArr[4][1]);
        int i14 = this.f29708i;
        float max4 = ((float) i14) - (((float) i14) * Math.max(fArr2[3][0] - f12, fArr[3][0]));
        float min4 = ((float) this.f29708i) * Math.min(fArr2[3][1] + f11 + f12, fArr[3][1]);
        int i15 = this.f29708i;
        path3.cubicTo(max3, min3, max4, min4, ((float) i15) - (((float) i15) * Math.max(fArr2[2][0] - f12, fArr[2][0])), ((float) this.f29708i) * Math.max((fArr2[2][1] + f11) - f12, fArr[2][1]));
        Path path4 = this.f29703d;
        int i16 = this.f29708i;
        float min5 = ((float) i16) - (((float) i16) * Math.min(fArr2[1][0] + f12, fArr[1][0]));
        float max5 = ((float) this.f29708i) * Math.max((fArr2[1][1] + f11) - f12, fArr[1][1]);
        int i17 = this.f29708i;
        path4.cubicTo(min5, max5, ((float) i17) - (((float) i17) * fArr[0][0]), ((float) i17) * fArr[0][1], (float) i17, 0.0f);
        this.f29709j = (((float) this.f29708i) * Math.min(fArr2[3][1] + f11 + f12, fArr[3][1])) + this.f29701b;
        postInvalidateOnAnimation();
    }

    public float getCurrentCircleCenterY() {
        return this.f29709j;
    }

    public void h(float f11) {
        l();
        this.f29703d.moveTo(0.0f, 0.0f);
        Path path = this.f29703d;
        int i11 = this.f29708i;
        float[][] fArr = f29698v;
        path.cubicTo(fArr[0][0] * ((float) i11), fArr[0][1], fArr[1][0] * ((float) i11), (fArr[1][1] + f11) * ((float) i11), fArr[2][0] * ((float) i11), ((float) i11) * (fArr[2][1] + f11));
        Path path2 = this.f29703d;
        int i12 = this.f29708i;
        path2.cubicTo(((float) i12) * fArr[3][0], ((float) i12) * (fArr[3][1] + f11), ((float) i12) * fArr[4][0], ((float) i12) * (fArr[4][1] + f11), ((float) i12) * fArr[5][0], ((float) i12) * (fArr[5][1] + f11));
        Path path3 = this.f29703d;
        int i13 = this.f29708i;
        path3.cubicTo(((float) i13) - (((float) i13) * fArr[4][0]), ((float) i13) * (fArr[4][1] + f11), ((float) i13) - (((float) i13) * fArr[3][0]), ((float) i13) * (fArr[3][1] + f11), ((float) i13) - (((float) i13) * fArr[2][0]), ((float) i13) * (fArr[2][1] + f11));
        Path path4 = this.f29703d;
        int i14 = this.f29708i;
        path4.cubicTo(((float) i14) - (((float) i14) * fArr[1][0]), ((float) i14) * (fArr[1][1] + f11), ((float) i14) - (((float) i14) * fArr[0][0]), fArr[0][1], (float) i14, 0.0f);
        postInvalidateOnAnimation();
    }

    public void i(float f11, float f12, float f13) {
        l();
        this.f29703d.moveTo(0.0f, 0.0f);
        Path path = this.f29703d;
        int i11 = this.f29708i;
        float[][] fArr = f29700x;
        float[][] fArr2 = f29698v;
        float[][] fArr3 = f29699w;
        path.cubicTo(fArr[0][0] * ((float) i11), fArr[0][1] * ((float) i11), Math.min(Math.min(fArr2[1][0] + f12, fArr3[1][0]) + f13, fArr[1][0]) * ((float) i11), Math.max(Math.max((fArr2[1][1] + f11) - f12, fArr3[1][1]) - f13, fArr[1][1]) * ((float) this.f29708i), Math.max(fArr2[2][0] - f12, fArr[2][0]) * ((float) this.f29708i), Math.min(Math.max((fArr2[2][1] + f11) - f12, fArr3[2][1]) + f13, fArr[2][1]) * ((float) this.f29708i));
        Path path2 = this.f29703d;
        float min = ((float) this.f29708i) * Math.min(Math.max(fArr2[3][0] - f12, fArr3[3][0]) + f13, fArr[3][0]);
        float min2 = ((float) this.f29708i) * Math.min(Math.min(fArr2[3][1] + f11 + f12, fArr3[3][1]) + f13, fArr[3][1]);
        float max = ((float) this.f29708i) * Math.max(fArr2[4][0] - f12, fArr[4][0]);
        float min3 = ((float) this.f29708i) * Math.min(Math.min(fArr2[4][1] + f11 + f12, fArr3[4][1]) + f13, fArr[4][1]);
        int i12 = this.f29708i;
        path2.cubicTo(min, min2, max, min3, ((float) i12) * fArr[5][0], ((float) i12) * Math.min(Math.min(fArr2[0][1] + f11 + f12, fArr3[5][1]) + f13, fArr[5][1]));
        Path path3 = this.f29703d;
        int i13 = this.f29708i;
        float max2 = ((float) i13) - (((float) i13) * Math.max(fArr2[4][0] - f12, fArr[4][0]));
        float min4 = ((float) this.f29708i) * Math.min(Math.min(fArr2[4][1] + f11 + f12, fArr3[4][1]) + f13, fArr[4][1]);
        int i14 = this.f29708i;
        float min5 = ((float) i14) - (((float) i14) * Math.min(Math.max(fArr2[3][0] - f12, fArr3[3][0]) + f13, fArr[3][0]));
        float min6 = ((float) this.f29708i) * Math.min(Math.min(fArr2[3][1] + f11 + f12, fArr3[3][1]) + f13, fArr[3][1]);
        int i15 = this.f29708i;
        path3.cubicTo(max2, min4, min5, min6, ((float) i15) - (((float) i15) * Math.max(fArr2[2][0] - f12, fArr[2][0])), ((float) this.f29708i) * Math.min(Math.max((fArr2[2][1] + f11) - f12, fArr3[2][1]) + f13, fArr[2][1]));
        Path path4 = this.f29703d;
        int i16 = this.f29708i;
        float min7 = ((float) i16) - (((float) i16) * Math.min(Math.min(fArr2[1][0] + f12, fArr3[1][0]) + f13, fArr[1][0]));
        float max3 = ((float) this.f29708i) * Math.max(Math.max((fArr2[1][1] + f11) - f12, fArr3[1][1]) - f13, fArr[1][1]);
        int i17 = this.f29708i;
        path4.cubicTo(min7, max3, ((float) i17) - (((float) i17) * fArr[0][0]), ((float) i17) * fArr[0][1], (float) i17, 0.0f);
        this.f29709j = (((float) this.f29708i) * Math.min(Math.min(fArr2[3][1] + f11 + f12, fArr3[3][1]) + f13, fArr[3][1])) + this.f29701b;
        postInvalidateOnAnimation();
    }

    public final void j() {
        o();
        p();
        m();
        this.f29707h = new RectF();
        setLayerType(1, (Paint) null);
    }

    public void k() {
        if (!this.f29711l) {
            this.f29711l = true;
            int i11 = this.f29710k;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i11, (float) i11});
            this.f29717r = ofFloat;
            ofFloat.start();
            int i12 = this.f29710k;
            float f11 = this.f29701b;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{((float) i12) - f11, ((float) i12) - f11});
            this.f29714o = ofFloat2;
            ofFloat2.start();
            this.f29709j = (float) this.f29710k;
            postInvalidate();
        }
    }

    public final void l() {
        ValueAnimator valueAnimator = this.f29719t;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f29719t.cancel();
        }
    }

    public final void m() {
        this.f29714o = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        this.f29715p = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        this.f29716q = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{-1000.0f, -1000.0f});
        this.f29717r = ofFloat;
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 1.0f});
        this.f29718s = ofFloat2;
        ofFloat2.setDuration(1);
        this.f29718s.start();
    }

    public void n(int i11, int i12) {
        this.f29702c.setShadowLayer((float) i11, 0.0f, 0.0f, i12);
    }

    public final void o() {
        float f11 = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f29702c = paint;
        paint.setColor(-14575885);
        this.f29702c.setAntiAlias(true);
        this.f29702c.setStyle(Paint.Style.FILL);
        this.f29702c.setShadowLayer((float) ((int) ((f11 * 2.0f) + 0.5f)), 0.0f, 0.0f, -1728053248);
    }

    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f29718s;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f29718s.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f29717r;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.f29717r.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f29714o;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.f29714o.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.f29719t;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.f29719t.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.f29716q;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.f29716q.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.f29715p;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.f29715p.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f29703d, this.f29702c);
        if (!isInEditMode()) {
            this.f29703d.rewind();
            this.f29704e.rewind();
            this.f29705f.rewind();
        }
        float floatValue = ((Float) this.f29717r.getAnimatedValue()).floatValue();
        float f11 = ((float) this.f29708i) / 2.0f;
        this.f29707h.setEmpty();
        float floatValue2 = ((Float) this.f29718s.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.f29715p.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.f29716q.getAnimatedValue()).floatValue();
        RectF rectF = this.f29707h;
        float f12 = this.f29701b;
        float f13 = floatValue3 + 1.0f;
        float f14 = 1.0f + floatValue4;
        rectF.set((f11 - ((f12 * f13) * floatValue2)) + ((f12 * floatValue4) / 2.0f), (((f12 * f14) * floatValue2) + floatValue) - ((f12 * floatValue3) / 2.0f), (((f13 * f12) * floatValue2) + f11) - ((floatValue4 * f12) / 2.0f), (floatValue - ((f14 * f12) * floatValue2)) + ((f12 * floatValue3) / 2.0f));
        float floatValue5 = ((Float) this.f29714o.getAnimatedValue()).floatValue();
        this.f29704e.moveTo(f11, floatValue5);
        double d11 = (double) floatValue;
        double pow = ((Math.pow((double) this.f29701b, 2.0d) + ((double) (floatValue * floatValue5))) - Math.pow(d11, 2.0d)) / ((double) (floatValue5 - floatValue));
        double d12 = (((double) this.f29708i) * -2.0d) / 2.0d;
        double d13 = -d12;
        double pow2 = (d12 * d12) - (((Math.pow(pow - d11, 2.0d) + Math.pow((double) f11, 2.0d)) - Math.pow((double) this.f29701b, 2.0d)) * 4.0d);
        float f15 = (float) pow;
        this.f29704e.lineTo((float) ((Math.sqrt(pow2) + d13) / 2.0d), f15);
        this.f29704e.lineTo((float) ((d13 - Math.sqrt(pow2)) / 2.0d), f15);
        this.f29704e.close();
        this.f29706g.set(this.f29704e);
        this.f29706g.addOval(this.f29707h, Path.Direction.CCW);
        this.f29705f.addOval(this.f29707h, Path.Direction.CCW);
        this.f29714o.isRunning();
        canvas.drawPath(this.f29704e, this.f29702c);
        canvas.drawPath(this.f29705f, this.f29702c);
    }

    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (!this.f29712m) {
            return false;
        }
        t(this.f29713n);
        return false;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f29708i = i11;
        this.f29701b = ((float) i11) / 14.4f;
        t((int) Math.min((float) Math.min(i11, i12), ((float) getHeight()) - this.f29701b));
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public final void p() {
        this.f29703d = new Path();
        this.f29704e = new Path();
        this.f29705f = new Path();
        this.f29706g = new Path();
    }

    public void postInvalidateOnAnimation() {
        if (Build.VERSION.SDK_INT >= 16) {
            super.postInvalidateOnAnimation();
        } else {
            super.invalidate();
        }
    }

    public void q() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f29718s = ofFloat;
        ofFloat.addUpdateListener(this.f29720u);
        this.f29718s.setDuration(200);
        this.f29718s.addListener(new c());
        this.f29718s.start();
    }

    public void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 1.0f});
        this.f29718s = ofFloat;
        ofFloat.setDuration(1);
        this.f29718s.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(((float) this.f29708i) / 1440.0f) * 500.0f, (float) this.f29710k});
        this.f29717r = ofFloat2;
        ofFloat2.setDuration(500);
        this.f29717r.addUpdateListener(new b());
        this.f29717r.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f29717r.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, ((float) this.f29710k) - this.f29701b});
        this.f29714o = ofFloat3;
        ofFloat3.setDuration(500);
        this.f29714o.addUpdateListener(this.f29720u);
        this.f29714o.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f29715p = ofFloat4;
        ofFloat4.setDuration(500);
        this.f29715p.addUpdateListener(this.f29720u);
        this.f29715p.setInterpolator(new DropBounceInterpolator());
        this.f29715p.setStartDelay(500);
        this.f29715p.start();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f29716q = ofFloat5;
        ofFloat5.setDuration(500);
        this.f29716q.addUpdateListener(this.f29720u);
        this.f29716q.setInterpolator(new DropBounceInterpolator());
        this.f29716q.setStartDelay(625);
        this.f29716q.start();
    }

    public void s(float f11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{Math.min(f11, 0.2f) * ((float) this.f29708i), 0.0f});
        this.f29719t = ofFloat;
        ofFloat.setDuration(1000);
        this.f29719t.addUpdateListener(new d());
        this.f29719t.setInterpolator(new BounceInterpolator());
        this.f29719t.start();
    }

    public void setMaxDropHeight(int i11) {
        if (this.f29712m) {
            t(i11);
            return;
        }
        this.f29713n = i11;
        this.f29712m = true;
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void setShadowRadius(int i11) {
        this.f29702c.setShadowLayer((float) i11, 0.0f, 0.0f, -1728053248);
    }

    public void setWaveColor(int i11) {
        this.f29702c.setColor(i11);
        invalidate();
    }

    public final void t(int i11) {
        float f11 = (float) i11;
        if ((((float) this.f29708i) / 1440.0f) * 500.0f > f11) {
            Log.w("WaveView", "DropHeight is more than " + ((((float) this.f29708i) / 1440.0f) * 500.0f));
            return;
        }
        this.f29710k = (int) Math.min(f11, ((float) getHeight()) - this.f29701b);
        if (this.f29711l) {
            this.f29711l = false;
            k();
        }
    }
}
