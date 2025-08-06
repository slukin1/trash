package org.opencv.imgcodecs;

import org.opencv.core.Mat;

public class Imgcodecs {
    public static boolean imwrite(String str, Mat mat) {
        return imwrite_1(str, mat.nativeObj);
    }

    private static native boolean imwrite_1(String str, long j11);
}
