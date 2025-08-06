package com.iproov.sdk.face;

import android.content.Context;
import androidx.annotation.Keep;
import com.iproov.sdk.core.exception.FaceDetectorException;

@Keep
public interface FaceDetectorFactory {
    FaceDetector getFaceDetector(Context context) throws FaceDetectorException;
}
