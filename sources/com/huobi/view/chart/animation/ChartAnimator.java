package com.huobi.view.chart.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.huobi.view.chart.animation.Easing;

public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    public float mPhaseX = 1.0f;
    public float mPhaseY = 1.0f;

    public ChartAnimator() {
    }

    private ObjectAnimator xAnimator(int i11, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i11);
        return ofFloat;
    }

    private ObjectAnimator yAnimator(int i11, Easing.EasingFunction easingFunction) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration((long) i11);
        return ofFloat;
    }

    public void animateX(int i11) {
        animateX(i11, Easing.Linear);
    }

    public void animateXY(int i11, int i12) {
        Easing.EasingFunction easingFunction = Easing.Linear;
        animateXY(i11, i12, easingFunction, easingFunction);
    }

    public void animateY(int i11) {
        animateY(i11, Easing.Linear);
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseX(float f11) {
        if (f11 > 1.0f) {
            f11 = 1.0f;
        } else if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.mPhaseX = f11;
    }

    public void setPhaseY(float f11) {
        if (f11 > 1.0f) {
            f11 = 1.0f;
        } else if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        this.mPhaseY = f11;
    }

    public void animateX(int i11, Easing.EasingFunction easingFunction) {
        ObjectAnimator xAnimator = xAnimator(i11, easingFunction);
        xAnimator.addUpdateListener(this.mListener);
        xAnimator.start();
    }

    public void animateXY(int i11, int i12, Easing.EasingFunction easingFunction) {
        ObjectAnimator xAnimator = xAnimator(i11, easingFunction);
        ObjectAnimator yAnimator = yAnimator(i12, easingFunction);
        if (i11 > i12) {
            xAnimator.addUpdateListener(this.mListener);
        } else {
            yAnimator.addUpdateListener(this.mListener);
        }
        xAnimator.start();
        yAnimator.start();
    }

    public void animateY(int i11, Easing.EasingFunction easingFunction) {
        ObjectAnimator yAnimator = yAnimator(i11, easingFunction);
        yAnimator.addUpdateListener(this.mListener);
        yAnimator.start();
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    public void animateXY(int i11, int i12, Easing.EasingFunction easingFunction, Easing.EasingFunction easingFunction2) {
        ObjectAnimator xAnimator = xAnimator(i11, easingFunction);
        ObjectAnimator yAnimator = yAnimator(i12, easingFunction2);
        if (i11 > i12) {
            xAnimator.addUpdateListener(this.mListener);
        } else {
            yAnimator.addUpdateListener(this.mListener);
        }
        xAnimator.start();
        yAnimator.start();
    }
}
