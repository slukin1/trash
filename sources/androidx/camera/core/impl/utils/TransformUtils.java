package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.core.util.h;
import java.util.Locale;

public class TransformUtils {
    public static final RectF NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    private TransformUtils() {
    }

    public static Matrix getExifTransform(int i11, int i12, int i13) {
        Matrix matrix = new Matrix();
        float f11 = (float) i12;
        float f12 = (float) i13;
        RectF rectF = new RectF(0.0f, 0.0f, f11, f12);
        RectF rectF2 = NORMALIZED_RECT;
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
        boolean z11 = true;
        switch (i11) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(270.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(90.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
        }
        z11 = false;
        if (z11) {
            rectF = new RectF(0.0f, 0.0f, f12, f11);
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public static Matrix getNormalizedToBuffer(Rect rect) {
        return getNormalizedToBuffer(new RectF(rect));
    }

    public static Matrix getRectToRect(RectF rectF, RectF rectF2, int i11) {
        return getRectToRect(rectF, rectF2, i11, false);
    }

    public static Size getRotatedSize(Rect rect, int i11) {
        return rotateSize(rectToSize(rect), i11);
    }

    public static boolean hasCropping(Rect rect, Size size) {
        return (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) ? false : true;
    }

    public static boolean is90or270(int i11) {
        if (i11 == 90 || i11 == 270) {
            return true;
        }
        if (i11 == 0 || i11 == 180) {
            return false;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + i11);
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size size, Size size2) {
        return isAspectRatioMatchingWithRoundingError(size, false, size2, false);
    }

    public static float max(float f11, float f12, float f13, float f14) {
        return Math.max(Math.max(f11, f12), Math.max(f13, f14));
    }

    public static float min(float f11, float f12, float f13, float f14) {
        return Math.min(Math.min(f11, f12), Math.min(f13, f14));
    }

    public static Size rectToSize(Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    public static String rectToString(Rect rect) {
        return String.format(Locale.US, "%s(%dx%d)", new Object[]{rect, Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
    }

    public static float[] rectToVertices(RectF rectF) {
        float f11 = rectF.left;
        float f12 = rectF.top;
        float f13 = rectF.right;
        float f14 = rectF.bottom;
        return new float[]{f11, f12, f13, f12, f13, f14, f11, f14};
    }

    public static Size reverseSize(Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    public static SizeF reverseSizeF(SizeF sizeF) {
        return new SizeF(sizeF.getHeight(), sizeF.getWidth());
    }

    public static RectF rotateRect(RectF rectF, int i11) {
        boolean z11 = i11 % 90 == 0;
        h.b(z11, "Invalid rotation degrees: " + i11);
        return is90or270(within360(i11)) ? new RectF(0.0f, 0.0f, rectF.height(), rectF.width()) : rectF;
    }

    public static Size rotateSize(Size size, int i11) {
        boolean z11 = i11 % 90 == 0;
        h.b(z11, "Invalid rotation degrees: " + i11);
        return is90or270(within360(i11)) ? reverseSize(size) : size;
    }

    public static Rect sizeToRect(Size size) {
        return sizeToRect(size, 0, 0);
    }

    public static RectF sizeToRectF(Size size) {
        return sizeToRectF(size, 0, 0);
    }

    public static float[] sizeToVertices(Size size) {
        return new float[]{0.0f, 0.0f, (float) size.getWidth(), 0.0f, (float) size.getWidth(), (float) size.getHeight(), 0.0f, (float) size.getHeight()};
    }

    public static Matrix updateSensorToBufferTransform(Matrix matrix, Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate((float) (-rect.left), (float) (-rect.top));
        return matrix2;
    }

    public static RectF verticesToRect(float[] fArr) {
        return new RectF(min(fArr[0], fArr[2], fArr[4], fArr[6]), min(fArr[1], fArr[3], fArr[5], fArr[7]), max(fArr[0], fArr[2], fArr[4], fArr[6]), max(fArr[1], fArr[3], fArr[5], fArr[7]));
    }

    public static int within360(int i11) {
        return ((i11 % 360) + 360) % 360;
    }

    public static Matrix getNormalizedToBuffer(RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(NORMALIZED_RECT, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    public static Matrix getRectToRect(RectF rectF, RectF rectF2, int i11, boolean z11) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        matrix.postRotate((float) i11);
        if (z11) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(getNormalizedToBuffer(rectF2));
        return matrix;
    }

    public static boolean isAspectRatioMatchingWithRoundingError(Size size, boolean z11, Size size2, boolean z12) {
        float f11;
        float f12;
        float f13;
        float f14;
        if (z11) {
            f11 = ((float) size.getWidth()) / ((float) size.getHeight());
            f12 = f11;
        } else {
            f11 = (((float) size.getWidth()) + 1.0f) / (((float) size.getHeight()) - 1.0f);
            f12 = (((float) size.getWidth()) - 1.0f) / (((float) size.getHeight()) + 1.0f);
        }
        if (z12) {
            f13 = ((float) size2.getWidth()) / ((float) size2.getHeight());
            f14 = f13;
        } else {
            float width = (((float) size2.getWidth()) + 1.0f) / (((float) size2.getHeight()) - 1.0f);
            f13 = (((float) size2.getWidth()) - 1.0f) / (((float) size2.getHeight()) + 1.0f);
            f14 = width;
        }
        return f11 >= f13 && f14 >= f12;
    }

    public static Rect sizeToRect(Size size, int i11, int i12) {
        return new Rect(i11, i12, size.getWidth() + i11, size.getHeight() + i12);
    }

    public static RectF sizeToRectF(Size size, int i11, int i12) {
        return new RectF((float) i11, (float) i12, (float) (i11 + size.getWidth()), (float) (i12 + size.getHeight()));
    }
}
