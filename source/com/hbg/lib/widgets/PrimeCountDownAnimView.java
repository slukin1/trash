package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.ResourcesCompat;
import com.xiaomi.mipush.sdk.Constants;

public class PrimeCountDownAnimView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71571b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f71572c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f71573d;

    /* renamed from: e  reason: collision with root package name */
    public int f71574e;

    /* renamed from: f  reason: collision with root package name */
    public int f71575f;

    /* renamed from: g  reason: collision with root package name */
    public int f71576g;

    /* renamed from: h  reason: collision with root package name */
    public float f71577h;

    /* renamed from: i  reason: collision with root package name */
    public float f71578i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71579j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71580k;

    /* renamed from: l  reason: collision with root package name */
    public int f71581l;

    /* renamed from: m  reason: collision with root package name */
    public int f71582m;

    /* renamed from: n  reason: collision with root package name */
    public int f71583n;

    /* renamed from: o  reason: collision with root package name */
    public int f71584o;

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator f71585p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f71586q;

    /* renamed from: r  reason: collision with root package name */
    public int f71587r;

    /* renamed from: s  reason: collision with root package name */
    public int f71588s;

    /* renamed from: t  reason: collision with root package name */
    public Typeface f71589t;

    /* renamed from: u  reason: collision with root package name */
    public int f71590u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f71591v;

    /* renamed from: w  reason: collision with root package name */
    public int f71592w;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            PrimeCountDownAnimView primeCountDownAnimView = PrimeCountDownAnimView.this;
            int unused = primeCountDownAnimView.f71581l = primeCountDownAnimView.f71583n;
            boolean unused2 = PrimeCountDownAnimView.this.f71579j = false;
            PrimeCountDownAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = PrimeCountDownAnimView.this.f71579j = true;
            PrimeCountDownAnimView.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            PrimeCountDownAnimView primeCountDownAnimView = PrimeCountDownAnimView.this;
            int unused = primeCountDownAnimView.f71582m = primeCountDownAnimView.f71584o;
            boolean unused2 = PrimeCountDownAnimView.this.f71580k = false;
            PrimeCountDownAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = PrimeCountDownAnimView.this.f71580k = true;
            PrimeCountDownAnimView.this.invalidate();
        }
    }

    public PrimeCountDownAnimView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.f71577h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.f71578i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public int getType() {
        return this.f71592w;
    }

    public final void i() {
        if (this.f71585p == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f71585p = duration;
            duration.addUpdateListener(new k1(this));
            this.f71585p.setInterpolator(new DecelerateInterpolator());
            this.f71585p.addListener(new a());
        }
        this.f71585p.start();
    }

    public final void j() {
        if (this.f71586q == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f71586q = duration;
            duration.addUpdateListener(new j1(this));
            this.f71586q.setInterpolator(new DecelerateInterpolator());
            this.f71586q.addListener(new b());
        }
        this.f71586q.start();
    }

    public final int k(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void l() {
        this.f71574e = k(24.0f);
        this.f71590u = k(1.0f);
        this.f71571b.setAntiAlias(true);
        this.f71571b.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f71571b.setColor(this.f71588s);
        this.f71571b.setTextSize((float) this.f71574e);
        this.f71572c.setColor(-65536);
    }

    public boolean m() {
        return this.f71591v;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f71575f == 0 || this.f71576g == 0) {
            this.f71571b.getTextBounds("0", 0, 1, this.f71573d);
            this.f71575f = this.f71573d.width();
            this.f71576g = this.f71573d.height();
        }
        int width = (getWidth() / 2) - this.f71590u;
        int width2 = (getWidth() / 2) + this.f71590u;
        int height = (getHeight() / 2) + (this.f71576g / 2);
        if (!m()) {
            this.f71571b.setAlpha(255);
            this.f71571b.setTextSize((float) this.f71574e);
            this.f71571b.setTextAlign(Paint.Align.RIGHT);
            float f11 = (float) height;
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) (width - (this.f71590u * 2)), f11, this.f71571b);
            this.f71571b.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) (width2 + (this.f71590u * 2)), f11, this.f71571b);
            return;
        }
        this.f71571b.setTextAlign(Paint.Align.RIGHT);
        if (this.f71579j) {
            this.f71571b.setAlpha((int) (this.f71577h * 255.0f));
            this.f71571b.setTextSize(((float) this.f71574e) * ((this.f71577h * 0.19999999f) + 0.8f));
            float f12 = (float) width;
            float f13 = (float) height;
            canvas.drawText(this.f71583n + "", f12, f13 - (((float) ((getWidth() / 2) + (this.f71576g / 2))) * (1.0f - this.f71577h)), this.f71571b);
            this.f71571b.setAlpha((int) ((1.0f - this.f71577h) * 255.0f));
            this.f71571b.setTextSize(((float) this.f71574e) * (((1.0f - this.f71577h) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f71581l + "", f12, f13 + (((float) ((getWidth() / 2) + (this.f71576g / 2))) * this.f71577h), this.f71571b);
        } else {
            this.f71571b.setAlpha(255);
            this.f71571b.setTextSize((float) this.f71574e);
            canvas.drawText(this.f71581l + "", (float) width, (float) height, this.f71571b);
        }
        this.f71571b.setTextAlign(Paint.Align.LEFT);
        if (this.f71580k) {
            this.f71571b.setAlpha((int) (this.f71578i * 255.0f));
            this.f71571b.setTextSize(((float) this.f71574e) * ((this.f71578i * 0.19999999f) + 0.8f));
            float f14 = (float) width2;
            float f15 = (float) height;
            canvas.drawText(this.f71584o + "", f14, f15 - ((1.0f - this.f71578i) * f15), this.f71571b);
            this.f71571b.setAlpha((int) ((1.0f - this.f71578i) * 255.0f));
            this.f71571b.setTextSize(((float) this.f71574e) * (((1.0f - this.f71578i) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f71582m + "", f14, f15 + (((float) ((getWidth() / 2) + (this.f71576g / 2))) * this.f71578i), this.f71571b);
        } else {
            this.f71571b.setAlpha(255);
            this.f71571b.setTextSize((float) this.f71574e);
            canvas.drawText(this.f71582m + "", (float) width2, (float) height, this.f71571b);
        }
        if (this.f71579j || this.f71580k) {
            invalidate();
        }
    }

    public void p(int i11, boolean z11) {
        if (getVisibility() == 0) {
            int i12 = this.f71587r;
            if (i12 > 0) {
                i11 = Math.min(i11, i12);
            }
            int max = Math.max(i11, 0);
            int i13 = max / 10;
            this.f71583n = i13;
            int i14 = max % 10;
            this.f71584o = i14;
            if (z11) {
                if (this.f71581l != i13) {
                    i();
                }
                if (this.f71582m != this.f71584o) {
                    j();
                    return;
                }
                return;
            }
            this.f71581l = i13;
            this.f71582m = i14;
            invalidate();
        }
    }

    public void setMax(int i11) {
        this.f71587r = Math.max(i11, 0);
    }

    public void setPadding(int i11) {
        this.f71590u = i11;
    }

    public void setTextColor(int i11) {
        this.f71588s = i11;
        this.f71571b.setColor(i11);
        invalidate();
    }

    public void setTextSize(int i11) {
        this.f71574e = i11;
        this.f71571b.setTextSize((float) i11);
        invalidate();
    }

    public void setTextStyle(Typeface typeface) {
        this.f71589t = typeface;
        this.f71571b.setTypeface(typeface);
        invalidate();
    }

    public void setType(int i11) {
        this.f71592w = i11;
    }

    public void setValid(boolean z11) {
        this.f71591v = z11;
        invalidate();
    }

    public PrimeCountDownAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrimeCountDownAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71571b = new Paint();
        this.f71572c = new Paint();
        this.f71573d = new Rect();
        this.f71577h = 1.0f;
        this.f71578i = 1.0f;
        this.f71588s = -1;
        this.f71589t = null;
        l();
    }
}
