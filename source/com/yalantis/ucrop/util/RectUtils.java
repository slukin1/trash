package com.yalantis.ucrop.util;

import android.graphics.RectF;

public class RectUtils {
    public static float[] getCenterFromRect(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] getCornersFromRect(RectF rectF) {
        float f11 = rectF.left;
        float f12 = rectF.top;
        float f13 = rectF.right;
        float f14 = rectF.bottom;
        return new float[]{f11, f12, f13, f12, f13, f14, f11, f14};
    }

    public static float[] getRectSidesFromCorners(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow((double) (fArr[0] - fArr[2]), 2.0d) + Math.pow((double) (fArr[1] - fArr[3]), 2.0d)), (float) Math.sqrt(Math.pow((double) (fArr[2] - fArr[4]), 2.0d) + Math.pow((double) (fArr[3] - fArr[5]), 2.0d))};
    }

    public static RectF trapToRect(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i11 = 1; i11 < fArr.length; i11 += 2) {
            float round = ((float) Math.round(fArr[i11 - 1] * 10.0f)) / 10.0f;
            float round2 = ((float) Math.round(fArr[i11] * 10.0f)) / 10.0f;
            float f11 = rectF.left;
            if (round < f11) {
                f11 = round;
            }
            rectF.left = f11;
            float f12 = rectF.top;
            if (round2 < f12) {
                f12 = round2;
            }
            rectF.top = f12;
            float f13 = rectF.right;
            if (round <= f13) {
                round = f13;
            }
            rectF.right = round;
            float f14 = rectF.bottom;
            if (round2 <= f14) {
                round2 = f14;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }
}
