package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class JVImgJavaJNI {
    public static final native float ImageCheck_computeFlashConfidence(long j11, ImageSource imageSource);

    public static final native boolean ImageCheck_isFlashNeeded(long j11, ImageSource imageSource, int i11);

    public static final native boolean ImageCheck_isRefocusNeeded(long j11, ImageSource imageSource, int i11);

    public static final native float ImageQualityAcquisition_Evaluate(long j11, ImageSource imageSource);

    public static final native void delete_ImageCheck(long j11);

    public static final native long new_ImageCheck();
}
