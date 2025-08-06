package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    public void setStringValueCallback(final LottieValueCallback<String> lottieValueCallback) {
        final LottieFrameInfo lottieFrameInfo = new LottieFrameInfo();
        final DocumentData documentData = new DocumentData();
        super.setValueCallback(new LottieValueCallback<DocumentData>() {
            /* JADX WARNING: type inference failed for: r14v0, types: [com.airbnb.lottie.value.LottieFrameInfo, com.airbnb.lottie.value.LottieFrameInfo<com.airbnb.lottie.model.DocumentData>] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.airbnb.lottie.model.DocumentData getValue(com.airbnb.lottie.value.LottieFrameInfo<com.airbnb.lottie.model.DocumentData> r14) {
                /*
                    r13 = this;
                    com.airbnb.lottie.value.LottieFrameInfo r0 = r0
                    float r1 = r14.getStartFrame()
                    float r2 = r14.getEndFrame()
                    java.lang.Object r3 = r14.getStartValue()
                    com.airbnb.lottie.model.DocumentData r3 = (com.airbnb.lottie.model.DocumentData) r3
                    java.lang.String r3 = r3.text
                    java.lang.Object r4 = r14.getEndValue()
                    com.airbnb.lottie.model.DocumentData r4 = (com.airbnb.lottie.model.DocumentData) r4
                    java.lang.String r4 = r4.text
                    float r5 = r14.getLinearKeyframeProgress()
                    float r6 = r14.getInterpolatedKeyframeProgress()
                    float r7 = r14.getOverallProgress()
                    r0.set(r1, r2, r3, r4, r5, r6, r7)
                    com.airbnb.lottie.value.LottieValueCallback r0 = r4
                    com.airbnb.lottie.value.LottieFrameInfo r1 = r0
                    java.lang.Object r0 = r0.getValue(r1)
                    r2 = r0
                    java.lang.String r2 = (java.lang.String) r2
                    float r0 = r14.getInterpolatedKeyframeProgress()
                    r1 = 1065353216(0x3f800000, float:1.0)
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 != 0) goto L_0x0043
                    java.lang.Object r14 = r14.getEndValue()
                    goto L_0x0047
                L_0x0043:
                    java.lang.Object r14 = r14.getStartValue()
                L_0x0047:
                    com.airbnb.lottie.model.DocumentData r14 = (com.airbnb.lottie.model.DocumentData) r14
                    com.airbnb.lottie.model.DocumentData r1 = r1
                    java.lang.String r3 = r14.fontName
                    float r4 = r14.size
                    com.airbnb.lottie.model.DocumentData$Justification r5 = r14.justification
                    int r6 = r14.tracking
                    float r7 = r14.lineHeight
                    float r8 = r14.baselineShift
                    int r9 = r14.color
                    int r10 = r14.strokeColor
                    float r11 = r14.strokeWidth
                    boolean r12 = r14.strokeOverFill
                    r1.set(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                    com.airbnb.lottie.model.DocumentData r14 = r1
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.AnonymousClass1.getValue(com.airbnb.lottie.value.LottieFrameInfo):com.airbnb.lottie.model.DocumentData");
            }
        });
    }

    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f11) {
        T t11;
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback != null) {
            float f12 = keyframe.startFrame;
            Float f13 = keyframe.endFrame;
            float floatValue = f13 == null ? Float.MAX_VALUE : f13.floatValue();
            T t12 = keyframe.startValue;
            DocumentData documentData = (DocumentData) t12;
            T t13 = keyframe.endValue;
            return (DocumentData) lottieValueCallback.getValueInternal(f12, floatValue, documentData, t13 == null ? (DocumentData) t12 : (DocumentData) t13, f11, getInterpolatedCurrentKeyframeProgress(), getProgress());
        } else if (f11 != 1.0f || (t11 = keyframe.endValue) == null) {
            return (DocumentData) keyframe.startValue;
        } else {
            return (DocumentData) t11;
        }
    }
}
