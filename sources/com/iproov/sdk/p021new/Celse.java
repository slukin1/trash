package com.iproov.sdk.p021new;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import com.iproov.sdk.p033throws.Ccatch;

/* renamed from: com.iproov.sdk.new.else  reason: invalid class name and invalid package */
public class Celse {
    /* renamed from: do  reason: not valid java name */
    public static Float m1193do(CameraCharacteristics cameraCharacteristics) {
        float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        if (fArr == null) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    /* renamed from: do  reason: not valid java name */
    public static Double m1192do(String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("/")) {
            return Double.valueOf(new Ccatch().m1926do(str));
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Double m1191do(Integer num) {
        if (num == null) {
            return null;
        }
        try {
            return Double.valueOf((double) num.intValue());
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Double m1190do(Float f11) {
        if (f11 == null) {
            return null;
        }
        try {
            return Double.valueOf((double) f11.floatValue());
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Rect m1189do(Rect rect, Double d11) {
        int width = rect.width();
        int doubleValue = (int) (((double) width) / d11.doubleValue());
        int height = rect.height();
        int doubleValue2 = (int) (((double) height) / d11.doubleValue());
        int i11 = rect.left + ((width - doubleValue) / 2);
        int i12 = rect.top + ((height - doubleValue2) / 2);
        return new Rect(i11, i12, doubleValue + i11, doubleValue2 + i12);
    }
}
