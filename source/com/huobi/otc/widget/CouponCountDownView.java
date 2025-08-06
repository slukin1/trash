package com.huobi.otc.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.module.otc.R$font;
import com.xiaomi.mipush.sdk.Constants;
import vp.c;

public class CouponCountDownView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f79683b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f79684c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f79685d;

    /* renamed from: e  reason: collision with root package name */
    public int f79686e;

    /* renamed from: f  reason: collision with root package name */
    public int f79687f;

    /* renamed from: g  reason: collision with root package name */
    public int f79688g;

    /* renamed from: h  reason: collision with root package name */
    public float f79689h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f79690i;

    /* renamed from: j  reason: collision with root package name */
    public int f79691j;

    /* renamed from: k  reason: collision with root package name */
    public int f79692k;

    /* renamed from: l  reason: collision with root package name */
    public ValueAnimator f79693l;

    /* renamed from: m  reason: collision with root package name */
    public int f79694m;

    /* renamed from: n  reason: collision with root package name */
    public int f79695n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f79696o;

    /* renamed from: p  reason: collision with root package name */
    public int f79697p;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            CouponCountDownView couponCountDownView = CouponCountDownView.this;
            int unused = couponCountDownView.f79691j = couponCountDownView.f79692k;
            boolean unused2 = CouponCountDownView.this.f79690i = false;
            CouponCountDownView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = CouponCountDownView.this.f79690i = true;
            CouponCountDownView.this.invalidate();
        }
    }

    public CouponCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        this.f79689h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public final void e(int i11) {
        if (this.f79693l == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f79693l = duration;
            duration.addUpdateListener(new c(this));
            this.f79693l.setInterpolator(new DecelerateInterpolator());
            this.f79693l.addListener(new a());
        }
        this.f79693l.start();
    }

    public final int f(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void g() {
        this.f79686e = f(24.0f);
        this.f79683b.setAntiAlias(true);
        this.f79683b.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f79683b.setColor(this.f79695n);
        this.f79683b.setTextSize((float) this.f79686e);
        this.f79684c.setColor(-65536);
    }

    public int getType() {
        return this.f79697p;
    }

    public boolean h() {
        return this.f79696o;
    }

    public void j(int i11, boolean z11) {
        if (getVisibility() == 0) {
            int i12 = this.f79694m;
            if (i12 > 0) {
                i11 = Math.min(i11, i12);
            }
            int max = Math.max(i11, 0);
            this.f79692k = max;
            if (!z11) {
                this.f79691j = max;
                invalidate();
            } else if (this.f79691j != max) {
                e(max);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f79687f == 0 || this.f79688g == 0) {
            this.f79683b.getTextBounds("0", 0, 1, this.f79685d);
            this.f79687f = this.f79685d.width();
            this.f79688g = this.f79685d.height();
        }
        int width = getWidth() / 2;
        int height = (getHeight() / 2) + (this.f79688g / 2);
        if (!h()) {
            this.f79683b.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) width, (float) height, this.f79683b);
            return;
        }
        this.f79683b.setTextAlign(Paint.Align.CENTER);
        if (this.f79690i) {
            this.f79683b.setAlpha((int) (this.f79689h * 255.0f));
            this.f79683b.setTextSize(((float) this.f79686e) * ((this.f79689h * 0.19999999f) + 0.8f));
            float f11 = (float) width;
            float f12 = (float) height;
            canvas.drawText(this.f79692k + "", f11, f12 - ((1.0f - this.f79689h) * f12), this.f79683b);
            this.f79683b.setAlpha((int) ((1.0f - this.f79689h) * 255.0f));
            this.f79683b.setTextSize(((float) this.f79686e) * (((1.0f - this.f79689h) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f79691j + "", f11, f12 + (((float) ((getWidth() / 2) + (this.f79688g / 2))) * this.f79689h), this.f79683b);
        } else {
            this.f79683b.setAlpha(255);
            this.f79683b.setTextSize((float) this.f79686e);
            canvas.drawText(this.f79691j + "", (float) width, (float) height, this.f79683b);
        }
        if (this.f79690i) {
            invalidate();
        }
    }

    public void setMax(int i11) {
        this.f79694m = Math.max(i11, 0);
    }

    public void setTextColor(int i11) {
        this.f79695n = i11;
        this.f79683b.setColor(i11);
        invalidate();
    }

    public void setTextSize(int i11) {
        this.f79686e = i11;
        this.f79683b.setTextSize((float) i11);
        invalidate();
    }

    public void setType(int i11) {
        this.f79697p = i11;
    }

    public void setValid(boolean z11) {
        this.f79696o = z11;
        invalidate();
    }

    public CouponCountDownView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f79683b = new Paint();
        this.f79684c = new Paint();
        this.f79685d = new Rect();
        this.f79689h = 1.0f;
        this.f79695n = -1;
        g();
    }
}
