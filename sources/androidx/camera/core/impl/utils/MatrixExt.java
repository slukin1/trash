package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import java.util.Locale;

public final class MatrixExt {
    private static final float[] sTemp = new float[16];

    private MatrixExt() {
    }

    private static void denormalize(float[] fArr, float f11, float f12) {
        Matrix.translateM(fArr, 0, -f11, -f12, 0.0f);
    }

    private static void normalize(float[] fArr, float f11, float f12) {
        Matrix.translateM(fArr, 0, f11, f12, 0.0f);
    }

    public static void postRotate(float[] fArr, float f11, float f12, float f13) {
        float[] fArr2 = sTemp;
        synchronized (fArr2) {
            Matrix.setIdentityM(fArr2, 0);
            normalize(fArr2, f12, f13);
            Matrix.rotateM(fArr2, 0, f11, 0.0f, 0.0f, 1.0f);
            denormalize(fArr2, f12, f13);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
        }
    }

    public static void preRotate(float[] fArr, float f11, float f12, float f13) {
        normalize(fArr, f12, f13);
        Matrix.rotateM(fArr, 0, f11, 0.0f, 0.0f, 1.0f);
        denormalize(fArr, f12, f13);
    }

    public static void preVerticalFlip(float[] fArr, float f11) {
        normalize(fArr, 0.0f, f11);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        denormalize(fArr, 0.0f, f11);
    }

    public static void setRotate(float[] fArr, float f11, float f12, float f13) {
        Matrix.setIdentityM(fArr, 0);
        preRotate(fArr, f11, f12, f13);
    }

    public static String toString(float[] fArr, int i11) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", new Object[]{Float.valueOf(fArr[i11]), Float.valueOf(fArr[i11 + 4]), Float.valueOf(fArr[i11 + 8]), Float.valueOf(fArr[i11 + 12]), Float.valueOf(fArr[i11 + 1]), Float.valueOf(fArr[i11 + 5]), Float.valueOf(fArr[i11 + 9]), Float.valueOf(fArr[i11 + 13]), Float.valueOf(fArr[i11 + 2]), Float.valueOf(fArr[i11 + 6]), Float.valueOf(fArr[i11 + 10]), Float.valueOf(fArr[i11 + 14]), Float.valueOf(fArr[i11 + 3]), Float.valueOf(fArr[i11 + 7]), Float.valueOf(fArr[i11 + 11]), Float.valueOf(fArr[i11 + 15])});
    }
}
