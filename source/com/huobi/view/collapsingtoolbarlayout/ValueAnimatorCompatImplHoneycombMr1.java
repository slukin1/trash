package com.huobi.view.collapsingtoolbarlayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import com.huobi.view.collapsingtoolbarlayout.ValueAnimatorCompat;

class ValueAnimatorCompatImplHoneycombMr1 extends ValueAnimatorCompat.Impl {
    private final ValueAnimator mValueAnimator = new ValueAnimator();

    public void addListener(final ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy) {
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animatorListenerProxy.onAnimationCancel();
            }

            public void onAnimationEnd(Animator animator) {
                animatorListenerProxy.onAnimationEnd();
            }

            public void onAnimationStart(Animator animator) {
                animatorListenerProxy.onAnimationStart();
            }
        });
    }

    public void addUpdateListener(final ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatorUpdateListenerProxy.onAnimationUpdate();
            }
        });
    }

    public void cancel() {
        this.mValueAnimator.cancel();
    }

    public void end() {
        this.mValueAnimator.end();
    }

    public float getAnimatedFloatValue() {
        return ((Float) this.mValueAnimator.getAnimatedValue()).floatValue();
    }

    public float getAnimatedFraction() {
        return this.mValueAnimator.getAnimatedFraction();
    }

    public int getAnimatedIntValue() {
        return ((Integer) this.mValueAnimator.getAnimatedValue()).intValue();
    }

    public long getDuration() {
        return this.mValueAnimator.getDuration();
    }

    public boolean isRunning() {
        return this.mValueAnimator.isRunning();
    }

    public void setDuration(long j11) {
        this.mValueAnimator.setDuration(j11);
    }

    public void setFloatValues(float f11, float f12) {
        this.mValueAnimator.setFloatValues(new float[]{f11, f12});
    }

    public void setIntValues(int i11, int i12) {
        this.mValueAnimator.setIntValues(new int[]{i11, i12});
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mValueAnimator.setInterpolator(interpolator);
    }

    public void start() {
        this.mValueAnimator.start();
    }
}
