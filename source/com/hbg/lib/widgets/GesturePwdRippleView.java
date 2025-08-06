package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.content.ContextCompat;

public class GesturePwdRippleView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71362b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public final Paint f71363c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    public final Paint f71364d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    public int f71365e;

    /* renamed from: f  reason: collision with root package name */
    public int f71366f;

    /* renamed from: g  reason: collision with root package name */
    public float f71367g;

    /* renamed from: h  reason: collision with root package name */
    public float f71368h;

    /* renamed from: i  reason: collision with root package name */
    public float f71369i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f71370j;

    /* renamed from: k  reason: collision with root package name */
    public float f71371k;

    /* renamed from: l  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f71372l = new j0(this);

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f71373m = new m0(this);

    /* renamed from: n  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f71374n = new l0(this);

    /* renamed from: o  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f71375o = new k0(this);

    /* renamed from: p  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f71376p = new i0(this);

    /* renamed from: q  reason: collision with root package name */
    public AnimatorSet f71377q;

    /* renamed from: r  reason: collision with root package name */
    public Interpolator f71378r = new DecelerateInterpolator();

    /* renamed from: s  reason: collision with root package name */
    public int f71379s;

    /* renamed from: t  reason: collision with root package name */
    public int f71380t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f71381u;

    /* renamed from: v  reason: collision with root package name */
    public int f71382v;

    /* renamed from: w  reason: collision with root package name */
    public int f71383w;

    /* renamed from: x  reason: collision with root package name */
    public int f71384x;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            GesturePwdRippleView.this.invalidate();
        }
    }

    public GesturePwdRippleView(Context context) {
        super(context);
        h(context);
    }

    public static int g(Context context, float f11) {
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(ValueAnimator valueAnimator) {
        this.f71367g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(ValueAnimator valueAnimator) {
        this.f71368h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.f71370j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        this.f71371k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.f71369i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public void f() {
        AnimatorSet animatorSet = this.f71377q;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f71377q.cancel();
        }
    }

    public int getColumns() {
        return this.f71380t;
    }

    public int getMaxSize() {
        if (this.f71384x == 0) {
            this.f71384x = Math.min(getWidth(), getHeight()) / 2;
        }
        return this.f71384x;
    }

    public int getPosition() {
        return this.f71383w;
    }

    public int getRows() {
        return this.f71379s;
    }

    public final void h(Context context) {
        this.f71366f = ContextCompat.getColor(context, R$color.baseColorThreeLevelText);
        this.f71362b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f71362b.setAntiAlias(true);
        this.f71362b.setColor(this.f71366f);
        this.f71363c.setStyle(Paint.Style.STROKE);
        this.f71363c.setAntiAlias(true);
        this.f71363c.setColor(this.f71365e);
        this.f71363c.setStrokeWidth((float) g(context, 1.0f));
        this.f71364d.setStyle(Paint.Style.STROKE);
        this.f71364d.setAntiAlias(true);
        this.f71364d.setColor(this.f71365e);
        this.f71364d.setStrokeWidth((float) g(context, 1.0f));
        this.f71382v = g(context, 5.0f);
    }

    public boolean i() {
        AnimatorSet animatorSet = this.f71377q;
        return animatorSet != null && animatorSet.isRunning();
    }

    public void o() {
        setChecked(false);
        f();
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int maxSize = getMaxSize();
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        if (this.f71367g > 0.1f) {
            this.f71363c.setAlpha((int) (this.f71370j * 255.0f));
            canvas.drawCircle((float) width, (float) height, ((float) maxSize) * this.f71367g, this.f71363c);
        }
        if (this.f71368h > 0.1f) {
            this.f71364d.setAlpha((int) (this.f71371k * 255.0f));
            canvas.drawCircle((float) width, (float) height, ((float) maxSize) * this.f71368h, this.f71364d);
        }
        this.f71362b.setAlpha((int) (this.f71369i * 255.0f));
        canvas.drawCircle((float) width, (float) height, (float) this.f71382v, this.f71362b);
        if (i()) {
            invalidate();
        }
    }

    public void p() {
        if (!this.f71381u) {
            o();
            this.f71362b.setColor(this.f71365e);
            this.f71381u = true;
            f();
            if (this.f71377q == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.1f, 0.75f});
                ofFloat.setDuration(400);
                ofFloat.addUpdateListener(this.f71372l);
                ofFloat.setInterpolator(this.f71378r);
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.1f, 0.55f});
                ofFloat2.setDuration(200);
                ofFloat2.addUpdateListener(this.f71373m);
                ofFloat2.setStartDelay(200);
                ofFloat2.setInterpolator(this.f71378r);
                ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.1f, 0.2f, 0.5f, 0.2f, 0.0f});
                ofFloat3.setDuration(400);
                ofFloat3.addUpdateListener(this.f71374n);
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{0.1f, 0.3f, 1.0f});
                ofFloat4.setDuration(200);
                ofFloat4.addUpdateListener(this.f71375o);
                ofFloat4.setStartDelay(200);
                ofFloat4.setInterpolator(this.f71378r);
                ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 1.0f, 1.0f});
                ofFloat5.setDuration(400);
                ofFloat5.addUpdateListener(this.f71376p);
                AnimatorSet animatorSet = new AnimatorSet();
                this.f71377q = animatorSet;
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5});
                this.f71377q.addListener(new a());
            }
            this.f71377q.start();
        }
    }

    public void setCenterPointColor(int i11) {
        this.f71362b.setColor(i11);
        invalidate();
    }

    public void setChecked(boolean z11) {
        this.f71381u = z11;
        if (z11) {
            this.f71367g = 1.0f;
            this.f71368h = 1.0f;
            this.f71369i = 1.0f;
            this.f71370j = 1.0f;
            this.f71371k = 1.0f;
            this.f71362b.setColor(this.f71365e);
            return;
        }
        this.f71367g = 0.0f;
        this.f71368h = 0.0f;
        this.f71369i = 1.0f;
        this.f71370j = 0.0f;
        this.f71371k = 0.0f;
        this.f71362b.setColor(this.f71366f);
    }

    public void setColumns(int i11) {
        this.f71380t = i11;
    }

    public void setPosition(int i11) {
        this.f71383w = i11;
    }

    public void setRows(int i11) {
        this.f71379s = i11;
    }

    public void setSelectColor(int i11) {
        this.f71365e = i11;
        this.f71363c.setColor(i11);
        this.f71364d.setColor(this.f71365e);
        invalidate();
    }

    public GesturePwdRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context);
    }

    public GesturePwdRippleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h(context);
    }
}
