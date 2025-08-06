package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class ImageQualityAcquisition {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21268a;
    public transient boolean swigCMemOwn;

    public ImageQualityAcquisition(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21268a = j11;
    }

    public static float Evaluate(ImageSource imageSource) {
        return JVImgJavaJNI.ImageQualityAcquisition_Evaluate(ImageSource.getCPtr(imageSource), imageSource);
    }

    public static long getCPtr(ImageQualityAcquisition imageQualityAcquisition) {
        if (imageQualityAcquisition == null) {
            return 0;
        }
        return imageQualityAcquisition.f21268a;
    }

    public synchronized void delete() {
        if (this.f21268a != 0) {
            if (!this.swigCMemOwn) {
                this.f21268a = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }
}
