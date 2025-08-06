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

public class KlineCountDownAnimView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71440b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f71441c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f71442d;

    /* renamed from: e  reason: collision with root package name */
    public int f71443e;

    /* renamed from: f  reason: collision with root package name */
    public int f71444f;

    /* renamed from: g  reason: collision with root package name */
    public int f71445g;

    /* renamed from: h  reason: collision with root package name */
    public float f71446h;

    /* renamed from: i  reason: collision with root package name */
    public float f71447i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71448j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71449k;

    /* renamed from: l  reason: collision with root package name */
    public int f71450l;

    /* renamed from: m  reason: collision with root package name */
    public int f71451m;

    /* renamed from: n  reason: collision with root package name */
    public int f71452n;

    /* renamed from: o  reason: collision with root package name */
    public int f71453o;

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator f71454p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f71455q;

    /* renamed from: r  reason: collision with root package name */
    public int f71456r;

    /* renamed from: s  reason: collision with root package name */
    public int f71457s;

    /* renamed from: t  reason: collision with root package name */
    public int f71458t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f71459u;

    /* renamed from: v  reason: collision with root package name */
    public int f71460v;

    /* renamed from: w  reason: collision with root package name */
    public Paint.Align f71461w;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            KlineCountDownAnimView klineCountDownAnimView = KlineCountDownAnimView.this;
            int unused = klineCountDownAnimView.f71450l = klineCountDownAnimView.f71452n;
            boolean unused2 = KlineCountDownAnimView.this.f71448j = false;
            KlineCountDownAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = KlineCountDownAnimView.this.f71448j = true;
            KlineCountDownAnimView.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            KlineCountDownAnimView klineCountDownAnimView = KlineCountDownAnimView.this;
            int unused = klineCountDownAnimView.f71451m = klineCountDownAnimView.f71453o;
            boolean unused2 = KlineCountDownAnimView.this.f71449k = false;
            KlineCountDownAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = KlineCountDownAnimView.this.f71449k = true;
            KlineCountDownAnimView.this.invalidate();
        }
    }

    public KlineCountDownAnimView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.f71446h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.f71447i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public int getType() {
        return this.f71460v;
    }

    public final void i() {
        if (this.f71454p == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f71454p = duration;
            duration.addUpdateListener(new w0(this));
            this.f71454p.setInterpolator(new DecelerateInterpolator());
            this.f71454p.addListener(new a());
        }
        this.f71454p.start();
    }

    public final void j() {
        if (this.f71455q == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f71455q = duration;
            duration.addUpdateListener(new v0(this));
            this.f71455q.setInterpolator(new DecelerateInterpolator());
            this.f71455q.addListener(new b());
        }
        this.f71455q.start();
    }

    public final int k(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void l() {
        this.f71443e = k(24.0f);
        this.f71458t = k(1.0f);
        this.f71440b.setAntiAlias(true);
        this.f71440b.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f71440b.setColor(this.f71457s);
        this.f71440b.setTextSize((float) this.f71443e);
        this.f71441c.setColor(-65536);
    }

    public boolean m() {
        return this.f71459u;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f71444f == 0 || this.f71445g == 0) {
            this.f71440b.getTextBounds("0", 0, 1, this.f71442d);
            this.f71444f = this.f71442d.width();
            this.f71445g = this.f71442d.height();
        }
        int width = (getWidth() / 2) - this.f71458t;
        int width2 = (getWidth() / 2) + this.f71458t;
        if (this.f71461w == Paint.Align.RIGHT) {
            int k11 = k(4.0f);
            int width3 = ((getWidth() - k11) - this.f71444f) - (this.f71458t * 2);
            width2 = ((getWidth() - k11) - this.f71444f) - this.f71458t;
            width = width3;
        }
        int height = (getHeight() / 2) + (this.f71445g / 2);
        if (!m()) {
            this.f71440b.setAlpha(255);
            this.f71440b.setTextSize((float) this.f71443e);
            this.f71440b.setTextAlign(Paint.Align.RIGHT);
            float f11 = (float) height;
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) width, f11, this.f71440b);
            this.f71440b.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) width2, f11, this.f71440b);
            return;
        }
        this.f71440b.setTextAlign(Paint.Align.RIGHT);
        if (this.f71448j) {
            this.f71440b.setAlpha((int) (this.f71446h * 255.0f));
            this.f71440b.setTextSize(((float) this.f71443e) * ((this.f71446h * 0.19999999f) + 0.8f));
            float f12 = (float) width;
            float f13 = (float) height;
            canvas.drawText(this.f71452n + "", f12, f13 - (((float) ((getWidth() / 2) + (this.f71445g / 2))) * (1.0f - this.f71446h)), this.f71440b);
            this.f71440b.setAlpha((int) ((1.0f - this.f71446h) * 255.0f));
            this.f71440b.setTextSize(((float) this.f71443e) * (((1.0f - this.f71446h) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f71450l + "", f12, f13 + (((float) ((getWidth() / 2) + (this.f71445g / 2))) * this.f71446h), this.f71440b);
        } else {
            this.f71440b.setAlpha(255);
            this.f71440b.setTextSize((float) this.f71443e);
            canvas.drawText(this.f71450l + "", (float) width, (float) height, this.f71440b);
        }
        this.f71440b.setTextAlign(Paint.Align.LEFT);
        if (this.f71449k) {
            this.f71440b.setAlpha((int) (this.f71447i * 255.0f));
            this.f71440b.setTextSize(((float) this.f71443e) * ((this.f71447i * 0.19999999f) + 0.8f));
            float f14 = (float) width2;
            float f15 = (float) height;
            canvas.drawText(this.f71453o + "", f14, f15 - ((1.0f - this.f71447i) * f15), this.f71440b);
            this.f71440b.setAlpha((int) ((1.0f - this.f71447i) * 255.0f));
            this.f71440b.setTextSize(((float) this.f71443e) * (((1.0f - this.f71447i) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f71451m + "", f14, f15 + (((float) ((getWidth() / 2) + (this.f71445g / 2))) * this.f71447i), this.f71440b);
        } else {
            this.f71440b.setAlpha(255);
            this.f71440b.setTextSize((float) this.f71443e);
            canvas.drawText(this.f71451m + "", (float) width2, (float) height, this.f71440b);
        }
        if (this.f71448j || this.f71449k) {
            invalidate();
        }
    }

    public void p(int i11, boolean z11) {
        if (getVisibility() == 0) {
            int i12 = this.f71456r;
            if (i12 > 0) {
                i11 = Math.min(i11, i12);
            }
            int max = Math.max(i11, 0);
            int i13 = max / 10;
            this.f71452n = i13;
            int i14 = max % 10;
            this.f71453o = i14;
            if (z11) {
                if (this.f71450l != i13) {
                    i();
                }
                if (this.f71451m != this.f71453o) {
                    j();
                    return;
                }
                return;
            }
            this.f71450l = i13;
            this.f71451m = i14;
            invalidate();
        }
    }

    public void setMax(int i11) {
        this.f71456r = Math.max(i11, 0);
    }

    public void setPadding(int i11) {
        this.f71458t = i11;
    }

    public void setTextAlign(Paint.Align align) {
        this.f71461w = align;
    }

    public void setTextColor(int i11) {
        this.f71457s = i11;
        this.f71440b.setColor(i11);
        invalidate();
    }

    public void setTextSize(int i11) {
        this.f71443e = i11;
        this.f71440b.setTextSize((float) i11);
        invalidate();
    }

    public void setTextStyle(Typeface typeface) {
        this.f71440b.setTypeface(typeface);
        invalidate();
    }

    public void setType(int i11) {
        this.f71460v = i11;
    }

    public void setValid(boolean z11) {
        this.f71459u = z11;
        invalidate();
    }

    public KlineCountDownAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KlineCountDownAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71440b = new Paint();
        this.f71441c = new Paint();
        this.f71442d = new Rect();
        this.f71446h = 1.0f;
        this.f71447i = 1.0f;
        this.f71457s = -1;
        this.f71461w = Paint.Align.CENTER;
        l();
    }
}
