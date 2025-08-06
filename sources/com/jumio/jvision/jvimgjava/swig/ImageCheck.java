package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class ImageCheck {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21267a;
    public transient boolean swigCMemOwn;

    public ImageCheck(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21267a = j11;
    }

    public static float computeFlashConfidence(ImageSource imageSource) {
        return JVImgJavaJNI.ImageCheck_computeFlashConfidence(ImageSource.getCPtr(imageSource), imageSource);
    }

    public static long getCPtr(ImageCheck imageCheck) {
        if (imageCheck == null) {
            return 0;
        }
        return imageCheck.f21267a;
    }

    public static boolean isFlashNeeded(ImageSource imageSource, int i11) {
        return JVImgJavaJNI.ImageCheck_isFlashNeeded(ImageSource.getCPtr(imageSource), imageSource, i11);
    }

    public static boolean isRefocusNeeded(ImageSource imageSource, int i11) {
        return JVImgJavaJNI.ImageCheck_isRefocusNeeded(ImageSource.getCPtr(imageSource), imageSource, i11);
    }

    public synchronized void delete() {
        long j11 = this.f21267a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVImgJavaJNI.delete_ImageCheck(j11);
            }
            this.f21267a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public ImageCheck() {
        this(JVImgJavaJNI.new_ImageCheck(), true);
    }
}
