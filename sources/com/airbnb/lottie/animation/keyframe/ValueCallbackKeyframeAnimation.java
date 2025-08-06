package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final A valueCallbackValue;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, (Object) null);
    }

    public float getEndProgress() {
        return 1.0f;
    }

    public A getValue() {
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        A a11 = this.valueCallbackValue;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, a11, a11, getProgress(), getProgress(), getProgress());
    }

    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    public void setProgress(float f11) {
        this.progress = f11;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, A a11) {
        super(Collections.emptyList());
        setValueCallback(lottieValueCallback);
        this.valueCallbackValue = a11;
    }

    public A getValue(Keyframe<K> keyframe, float f11) {
        return getValue();
    }
}
