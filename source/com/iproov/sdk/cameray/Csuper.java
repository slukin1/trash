package com.iproov.sdk.cameray;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Range;

/* renamed from: com.iproov.sdk.cameray.super  reason: invalid class name */
public class Csuper {
    /* renamed from: do  reason: not valid java name */
    private static int m195do(int i11, int i12) {
        return i11 > 1000 ? i12 * 1000 : i12;
    }

    /* renamed from: do  reason: not valid java name */
    public static Range<Integer> m196do(CameraCharacteristics cameraCharacteristics, int i11) {
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        return m197do((Range<Integer>[]) rangeArr, m195do(((Integer) rangeArr[0].getLower()).intValue(), i11));
    }

    /* renamed from: do  reason: not valid java name */
    private static Range<Integer> m197do(Range<Integer>[] rangeArr, int i11) {
        Range<Integer> range = null;
        for (Range<Integer> range2 : rangeArr) {
            if (range2.getUpper().intValue() == i11) {
                return range2;
            }
            if (range == null || ((range2.getUpper().intValue() <= i11 || range.getUpper().intValue() >= i11) && ((range2.getUpper().intValue() < i11 && range.getUpper().intValue() > i11) || Math.abs(i11 - range2.getUpper().intValue()) < Math.abs(i11 - range.getUpper().intValue())))) {
                range = range2;
            }
        }
        return range;
    }
}
