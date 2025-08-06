package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    public LottieInterpolatedValue(T t11, T t12) {
        this(t11, t12, new LinearInterpolator());
    }

    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }

    public abstract T interpolateValue(T t11, T t12, float f11);

    public LottieInterpolatedValue(T t11, T t12, Interpolator interpolator2) {
        this.startValue = t11;
        this.endValue = t12;
        this.interpolator = interpolator2;
    }
}
