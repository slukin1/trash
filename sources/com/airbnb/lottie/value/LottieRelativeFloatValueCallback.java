package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    public LottieRelativeFloatValueCallback() {
    }

    public Float getOffset(LottieFrameInfo<Float> lottieFrameInfo) {
        T t11 = this.value;
        if (t11 != null) {
            return (Float) t11;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    public LottieRelativeFloatValueCallback(Float f11) {
        super(f11);
    }

    public Float getValue(LottieFrameInfo<Float> lottieFrameInfo) {
        return Float.valueOf(MiscUtils.lerp(lottieFrameInfo.getStartValue().floatValue(), lottieFrameInfo.getEndValue().floatValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(lottieFrameInfo).floatValue());
    }
}
