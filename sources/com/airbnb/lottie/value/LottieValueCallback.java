package com.airbnb.lottie.value;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

public class LottieValueCallback<T> {
    private BaseKeyframeAnimation<?, ?> animation;
    private final LottieFrameInfo<T> frameInfo = new LottieFrameInfo<>();
    public T value = null;

    public LottieValueCallback() {
    }

    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return this.value;
    }

    public final T getValueInternal(float f11, float f12, T t11, T t12, float f13, float f14, float f15) {
        return getValue(this.frameInfo.set(f11, f12, t11, t12, f13, f14, f15));
    }

    public final void setAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }

    public final void setValue(T t11) {
        this.value = t11;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.animation;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }

    public LottieValueCallback(T t11) {
        this.value = t11;
    }
}
