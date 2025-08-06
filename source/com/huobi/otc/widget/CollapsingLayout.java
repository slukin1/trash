package com.huobi.otc.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import vp.a;

public class CollapsingLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public boolean f79667b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f79668c = true;

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f79669d;

    /* renamed from: e  reason: collision with root package name */
    public float f79670e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79671f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f79672g = new a(this);

    public CollapsingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(ValueAnimator valueAnimator) {
        getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        requestLayout();
    }

    public final void b() {
    }

    public boolean c() {
        return this.f79667b;
    }

    public float getFraction() {
        return this.f79670e;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f79671f = true;
    }

    public void onDetachedFromWindow() {
        this.f79671f = false;
        AnimatorSet animatorSet = this.f79669d;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f79669d.cancel();
            this.f79669d = null;
        }
        super.onDetachedFromWindow();
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        View childAt = getChildAt(0);
        if (childAt != null && c() && this.f79668c) {
            setMeasuredDimension(childAt.getMeasuredWidth(), (int) (((float) childAt.getMeasuredHeight()) * this.f79670e));
        }
    }

    public void setDefaultCollapse(boolean z11) {
        this.f79667b = z11;
        this.f79668c = true;
    }

    public void setFraction(float f11) {
        this.f79670e = f11;
    }

    public CollapsingLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }
}
