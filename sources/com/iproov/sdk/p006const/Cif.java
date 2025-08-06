package com.iproov.sdk.p006const;

import android.content.Context;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.FaceDetectorFactory;

/* renamed from: com.iproov.sdk.const.if  reason: invalid class name and invalid package */
public class Cif implements FaceDetectorFactory {
    public FaceDetector getFaceDetector(Context context) {
        return new Cdo();
    }
}
