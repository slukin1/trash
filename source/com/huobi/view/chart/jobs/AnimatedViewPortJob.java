package com.huobi.view.chart.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.huobi.view.chart.utils.Transformer;
import com.huobi.view.chart.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public abstract class AnimatedViewPortJob extends ViewPortJob implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public ObjectAnimator animator;
    public float phase;
    public float xOrigin;
    public float yOrigin;

    public AnimatedViewPortJob(ViewPortHandler viewPortHandler, float f11, float f12, Transformer transformer, View view, float f13, float f14, long j11) {
        super(viewPortHandler, f11, f12, transformer, view);
        this.xOrigin = f13;
        this.yOrigin = f14;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phase", new float[]{0.0f, 1.0f});
        this.animator = ofFloat;
        ofFloat.setDuration(j11);
        this.animator.addUpdateListener(this);
        this.animator.addListener(this);
    }

    public float getPhase() {
        return this.phase;
    }

    public float getXOrigin() {
        return this.xOrigin;
    }

    public float getYOrigin() {
        return this.yOrigin;
    }

    public void onAnimationCancel(Animator animator2) {
        try {
            recycleSelf();
        } catch (IllegalArgumentException unused) {
        }
    }

    public void onAnimationEnd(Animator animator2) {
        try {
            recycleSelf();
        } catch (IllegalArgumentException unused) {
        }
    }

    public void onAnimationRepeat(Animator animator2) {
    }

    public void onAnimationStart(Animator animator2) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }

    public abstract void recycleSelf();

    public void resetAnimator() {
        this.animator.removeAllListeners();
        this.animator.removeAllUpdateListeners();
        this.animator.reverse();
        this.animator.addUpdateListener(this);
        this.animator.addListener(this);
    }

    @SuppressLint({"NewApi"})
    public void run() {
        this.animator.start();
    }

    public void setPhase(float f11) {
        this.phase = f11;
    }
}
