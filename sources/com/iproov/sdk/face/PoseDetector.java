package com.iproov.sdk.face;

import androidx.annotation.Keep;
import com.iproov.sdk.face.model.Pose;

@Keep
public interface PoseDetector<T> {
    Pose calculatePose(T t11);

    void setOmega(float f11);
}
