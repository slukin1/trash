package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF point = new PointF();

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f11) {
        return getValue(keyframe, f11, f11, f11);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f11, float f12, float f13) {
        T t11;
        T t12 = keyframe.startValue;
        if (t12 == null || (t11 = keyframe.endValue) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) t12;
        PointF pointF2 = (PointF) t11;
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null) {
            PointF pointF3 = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF, pointF2, f11, getLinearCurrentKeyframeProgress(), getProgress());
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.point;
        float f14 = pointF.x;
        float f15 = f14 + (f12 * (pointF2.x - f14));
        float f16 = pointF.y;
        pointF4.set(f15, f16 + (f13 * (pointF2.y - f16)));
        return this.point;
    }
}
