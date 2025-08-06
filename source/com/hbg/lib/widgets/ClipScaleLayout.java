package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

public class ClipScaleLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Path f71038b;

    /* renamed from: c  reason: collision with root package name */
    public float f71039c;

    /* renamed from: d  reason: collision with root package name */
    public a f71040d;

    public interface a {
        void a(float f11);
    }

    public ClipScaleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(ValueAnimator valueAnimator) {
        setRate(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void c(Animator.AnimatorListener animatorListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.1f});
        ofFloat.setDuration(600);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new f(this));
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f71039c < 0.0f) {
            this.f71039c = 0.0f;
        }
        this.f71038b.reset();
        this.f71038b.moveTo(0.0f, (float) getHeight());
        float height = ((float) (getHeight() + getWidth())) * this.f71039c;
        this.f71038b.addCircle(0.0f, (float) getHeight(), height, Path.Direction.CCW);
        try {
            canvas.clipPath(this.f71038b);
        } catch (Exception unused) {
        }
        super.dispatchDraw(canvas);
        a aVar = this.f71040d;
        if (aVar != null) {
            aVar.a(this.f71039c);
        }
    }

    public void setCallback(a aVar) {
        this.f71040d = aVar;
    }

    public void setRate(float f11) {
        this.f71039c = f11;
        invalidate();
    }

    public ClipScaleLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71038b = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClipScaleLayout, i11, 0);
        this.f71039c = obtainStyledAttributes.getFloat(R$styleable.ClipScaleLayout_clip_rate, 0.0f);
        obtainStyledAttributes.recycle();
    }
}
