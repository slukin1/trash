package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.core.util.h;
import o.l0;
import o.y;

public class y2 {
    public static int a(float f11, float f12) {
        boolean z11 = true;
        h.b(f11 > 0.0f, "Focal length should be positive.");
        if (f12 <= 0.0f) {
            z11 = false;
        }
        h.b(z11, "Sensor length should be positive.");
        int degrees = (int) Math.toDegrees(Math.atan((double) (f12 / (f11 * 2.0f))) * 2.0d);
        h.c(degrees, 0, 360, "The provided focal length and sensor length result in an invalid view angle degrees.");
        return degrees;
    }

    public static float b(y yVar) {
        float[] fArr = (float[]) yVar.a(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        h.h(fArr, "The focal lengths can not be empty.");
        return fArr[0];
    }

    public static int c(l0 l0Var, int i11) {
        try {
            for (String c11 : l0Var.d()) {
                y c12 = l0Var.c(c11);
                Integer num = (Integer) c12.a(CameraCharacteristics.LENS_FACING);
                h.h(num, "Lens facing can not be null");
                if (num.intValue() == b3.b(i11)) {
                    return a(b(c12), d(c12));
                }
            }
            throw new IllegalArgumentException("Unable to get the default focal length with the specified lens facing.");
        } catch (CameraAccessExceptionCompat unused) {
            throw new IllegalArgumentException("Unable to get the default focal length.");
        }
    }

    public static float d(y yVar) {
        SizeF sizeF = (SizeF) yVar.a(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        Rect rect = (Rect) yVar.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        Size size = (Size) yVar.a(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        Integer num = (Integer) yVar.a(CameraCharacteristics.SENSOR_ORIENTATION);
        h.h(sizeF, "The sensor size can't be null.");
        h.h(num, "The sensor orientation can't be null.");
        h.h(rect, "The active array size can't be null.");
        h.h(size, "The pixel array size can't be null.");
        Size rectToSize = TransformUtils.rectToSize(rect);
        if (TransformUtils.is90or270(num.intValue())) {
            sizeF = TransformUtils.reverseSizeF(sizeF);
            rectToSize = TransformUtils.reverseSize(rectToSize);
            size = TransformUtils.reverseSize(size);
        }
        return (sizeF.getWidth() * ((float) rectToSize.getWidth())) / ((float) size.getWidth());
    }
}
