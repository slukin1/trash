package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import o.y;

public final class t4 {
    public static boolean a(y yVar, int i11) {
        int[] iArr = (int[]) yVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i12 : iArr) {
                if (i12 == i11) {
                    return true;
                }
            }
        }
        return false;
    }
}
