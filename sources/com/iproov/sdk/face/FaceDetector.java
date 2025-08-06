package com.iproov.sdk.face;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.iproov.sdk.face.model.FaceFeature;

@Keep
public interface FaceDetector {
    public static final double FACE_TO_EYE_MULTIPLIER = 2.4d;

    FaceFeature detectFace(Bitmap bitmap);

    String getName();

    void release();

    void setOmega(double d11);
}
