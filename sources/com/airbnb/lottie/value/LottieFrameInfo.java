package com.airbnb.lottie.value;

public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    public LottieFrameInfo<T> set(float f11, float f12, T t11, T t12, float f13, float f14, float f15) {
        this.startFrame = f11;
        this.endFrame = f12;
        this.startValue = t11;
        this.endValue = t12;
        this.linearKeyframeProgress = f13;
        this.interpolatedKeyframeProgress = f14;
        this.overallProgress = f15;
        return this;
    }
}
