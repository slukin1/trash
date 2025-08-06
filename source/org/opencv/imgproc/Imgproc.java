package org.opencv.imgproc;

import org.opencv.core.Mat;
import org.opencv.core.Size;

public class Imgproc {
    public static final int COLOR_BGR2RGB = 4;

    public static void cvtColor(Mat mat, Mat mat2, int i11) {
        cvtColor_1(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void cvtColor_1(long j11, long j12, int i11);

    public static void resize(Mat mat, Mat mat2, Size size) {
        resize_3(mat.nativeObj, mat2.nativeObj, size.width, size.height);
    }

    private static native void resize_3(long j11, long j12, double d11, double d12);
}
