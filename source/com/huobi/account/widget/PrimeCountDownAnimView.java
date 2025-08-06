package com.huobi.account.widget;

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
import pro.huobi.R;
import wg.y;
import wg.z;

public class PrimeCountDownAnimView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f41983b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f41984c;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f41985d;

    /* renamed from: e  reason: collision with root package name */
    public int f41986e;

    /* renamed from: f  reason: collision with root package name */
    public int f41987f;

    /* renamed from: g  reason: collision with root package name */
    public int f41988g;

    /* renamed from: h  reason: collision with root package name */
    public float f41989h;

    /* renamed from: i  reason: collision with root package name */
    public float f41990i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41991j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f41992k;

    /* renamed from: l  reason: collision with root package name */
    public int f41993l;

    /* renamed from: m  reason: collision with root package name */
    public int f41994m;

    /* renamed from: n  reason: collision with root package name */
    public int f41995n;

    /* renamed from: o  reason: collision with root package name */
    public int f41996o;

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator f41997p;

    /* renamed from: q  reason: collision with root package name */
    public ValueAnimator f41998q;

    /* renamed from: r  reason: collision with root package name */
    public int f41999r;

    /* renamed from: s  reason: collision with root package name */
    public int f42000s;

    /* renamed from: t  reason: collision with root package name */
    public Typeface f42001t;

    /* renamed from: u  reason: collision with root package name */
    public int f42002u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f42003v;

    /* renamed from: w  reason: collision with root package name */
    public int f42004w;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        public void onAnimationEnd(Animator animator) {
            PrimeCountDownAnimView primeCountDownAnimView = PrimeCountDownAnimView.this;
            int unused = primeCountDownAnimView.f41993l = primeCountDownAnimView.f41995n;
            boolean unused2 = PrimeCountDownAnimView.this.f41991j = false;
            PrimeCountDownAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = PrimeCountDownAnimView.this.f41991j = true;
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
            int unused = primeCountDownAnimView.f41994m = primeCountDownAnimView.f41996o;
            boolean unused2 = PrimeCountDownAnimView.this.f41992k = false;
            PrimeCountDownAnimView.this.invalidate();
        }

        public void onAnimationStart(Animator animator) {
            boolean unused = PrimeCountDownAnimView.this.f41992k = true;
            PrimeCountDownAnimView.this.invalidate();
        }
    }

    public PrimeCountDownAnimView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.f41989h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.f41990i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public int getType() {
        return this.f42004w;
    }

    public final void i() {
        if (this.f41997p == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f41997p = duration;
            duration.addUpdateListener(new z(this));
            this.f41997p.setInterpolator(new DecelerateInterpolator());
            this.f41997p.addListener(new a());
        }
        this.f41997p.start();
    }

    public final void j() {
        if (this.f41998q == null) {
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(270);
            this.f41998q = duration;
            duration.addUpdateListener(new y(this));
            this.f41998q.setInterpolator(new DecelerateInterpolator());
            this.f41998q.addListener(new b());
        }
        this.f41998q.start();
    }

    public final int k(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void l() {
        this.f41986e = k(24.0f);
        this.f42002u = k(1.0f);
        this.f41983b.setAntiAlias(true);
        this.f41983b.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        this.f41983b.setColor(this.f42000s);
        this.f41983b.setTextSize((float) this.f41986e);
        this.f41984c.setColor(-65536);
    }

    public boolean m() {
        return this.f42003v;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f41987f == 0 || this.f41988g == 0) {
            this.f41983b.getTextBounds("0", 0, 1, this.f41985d);
            this.f41987f = this.f41985d.width();
            this.f41988g = this.f41985d.height();
        }
        int width = (getWidth() / 2) - this.f42002u;
        int width2 = (getWidth() / 2) + this.f42002u;
        int height = (getHeight() / 2) + (this.f41988g / 2);
        if (!m()) {
            this.f41983b.setAlpha(255);
            this.f41983b.setTextSize((float) this.f41986e);
            this.f41983b.setTextAlign(Paint.Align.RIGHT);
            float f11 = (float) height;
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) (width - (this.f42002u * 2)), f11, this.f41983b);
            this.f41983b.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(Constants.ACCEPT_TIME_SEPARATOR_SERVER, (float) (width2 + (this.f42002u * 2)), f11, this.f41983b);
            return;
        }
        this.f41983b.setTextAlign(Paint.Align.RIGHT);
        if (this.f41991j) {
            this.f41983b.setAlpha((int) (this.f41989h * 255.0f));
            this.f41983b.setTextSize(((float) this.f41986e) * ((this.f41989h * 0.19999999f) + 0.8f));
            float f12 = (float) width;
            float f13 = (float) height;
            canvas.drawText(this.f41995n + "", f12, f13 - (((float) ((getWidth() / 2) + (this.f41988g / 2))) * (1.0f - this.f41989h)), this.f41983b);
            this.f41983b.setAlpha((int) ((1.0f - this.f41989h) * 255.0f));
            this.f41983b.setTextSize(((float) this.f41986e) * (((1.0f - this.f41989h) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f41993l + "", f12, f13 + (((float) ((getWidth() / 2) + (this.f41988g / 2))) * this.f41989h), this.f41983b);
        } else {
            this.f41983b.setAlpha(255);
            this.f41983b.setTextSize((float) this.f41986e);
            canvas.drawText(this.f41993l + "", (float) width, (float) height, this.f41983b);
        }
        this.f41983b.setTextAlign(Paint.Align.LEFT);
        if (this.f41992k) {
            this.f41983b.setAlpha((int) (this.f41990i * 255.0f));
            this.f41983b.setTextSize(((float) this.f41986e) * ((this.f41990i * 0.19999999f) + 0.8f));
            float f14 = (float) width2;
            float f15 = (float) height;
            canvas.drawText(this.f41996o + "", f14, f15 - ((1.0f - this.f41990i) * f15), this.f41983b);
            this.f41983b.setAlpha((int) ((1.0f - this.f41990i) * 255.0f));
            this.f41983b.setTextSize(((float) this.f41986e) * (((1.0f - this.f41990i) * 0.19999999f) + 0.8f));
            canvas.drawText(this.f41994m + "", f14, f15 + (((float) ((getWidth() / 2) + (this.f41988g / 2))) * this.f41990i), this.f41983b);
        } else {
            this.f41983b.setAlpha(255);
            this.f41983b.setTextSize((float) this.f41986e);
            canvas.drawText(this.f41994m + "", (float) width2, (float) height, this.f41983b);
        }
        if (this.f41991j || this.f41992k) {
            invalidate();
        }
    }

    public void p(int i11, boolean z11) {
        if (getVisibility() == 0) {
            int i12 = this.f41999r;
            if (i12 > 0) {
                i11 = Math.min(i11, i12);
            }
            int max = Math.max(i11, 0);
            int i13 = max / 10;
            this.f41995n = i13;
            int i14 = max % 10;
            this.f41996o = i14;
            if (z11) {
                if (this.f41993l != i13) {
                    i();
                }
                if (this.f41994m != this.f41996o) {
                    j();
                    return;
                }
                return;
            }
            this.f41993l = i13;
            this.f41994m = i14;
            invalidate();
        }
    }

    public void setMax(int i11) {
        this.f41999r = Math.max(i11, 0);
    }

    public void setPadding(int i11) {
        this.f42002u = i11;
    }

    public void setTextColor(int i11) {
        this.f42000s = i11;
        this.f41983b.setColor(i11);
        invalidate();
    }

    public void setTextSize(int i11) {
        this.f41986e = i11;
        this.f41983b.setTextSize((float) i11);
        invalidate();
    }

    public void setTextStyle(Typeface typeface) {
        this.f42001t = typeface;
        this.f41983b.setTypeface(typeface);
        invalidate();
    }

    public void setType(int i11) {
        this.f42004w = i11;
    }

    public void setValid(boolean z11) {
        this.f42003v = z11;
        invalidate();
    }

    public PrimeCountDownAnimView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrimeCountDownAnimView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41983b = new Paint();
        this.f41984c = new Paint();
        this.f41985d = new Rect();
        this.f41989h = 1.0f;
        this.f41990i = 1.0f;
        this.f42000s = -1;
        this.f42001t = null;
        l();
    }
}
