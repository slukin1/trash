package com.tencent.ugc.videobase.utils;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class FloatUtils {
    private static final float THRESHOLD = 1.0E-6f;

    public static List<PointF> convertFloatArrayToPointFList(float[] fArr) {
        if (fArr == null || (fArr.length & 1) == 1) {
            return null;
        }
        int i11 = 0;
        ArrayList arrayList = new ArrayList();
        while (i11 < fArr.length) {
            int i12 = i11 + 1;
            arrayList.add(new PointF(fArr[i11], fArr[i12]));
            i11 = i12 + 1;
        }
        return arrayList;
    }

    public static float[] convertPointFListToFloatArray(List<PointF> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        float[] fArr = new float[(size * 2)];
        for (int i11 = 0; i11 < size; i11++) {
            PointF pointF = list.get(i11);
            int i12 = i11 * 2;
            fArr[i12] = pointF.x;
            fArr[i12 + 1] = pointF.y;
        }
        return fArr;
    }

    public static boolean isEqual(float f11, float f12) {
        return Math.abs(f11 - f12) < THRESHOLD;
    }

    public static boolean isEqual(double d11, double d12) {
        return Math.abs(d11 - d12) < 9.999999974752427E-7d;
    }
}
