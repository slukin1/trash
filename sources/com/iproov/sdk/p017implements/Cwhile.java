package com.iproov.sdk.p017implements;

import android.graphics.RectF;

/* renamed from: com.iproov.sdk.implements.while  reason: invalid class name and invalid package */
public final class Cwhile {
    /* renamed from: do  reason: not valid java name */
    public static RectF m1047do(int i11, int i12) {
        float f11 = (float) i11;
        float f12 = (float) i12;
        float[] fArr = m1049do(f11, f12);
        float f13 = (f11 - fArr[0]) / 2.0f;
        float f14 = (f12 - fArr[1]) / 2.0f;
        return new RectF(f13, f14, fArr[0] + f13, fArr[1] + f14);
    }

    /* renamed from: for  reason: not valid java name */
    private static float[] m1050for(float f11, float f12) {
        float f13 = f11 * f12;
        return new float[]{f13, f13 / 0.75f};
    }

    /* renamed from: if  reason: not valid java name */
    private static float[] m1051if(float f11, float f12) {
        float f13 = f11 * f12;
        return new float[]{0.75f * f13, f13};
    }

    /* renamed from: do  reason: not valid java name */
    public static RectF m1048do(RectF rectF, float f11) {
        float height = rectF.height();
        float width = (rectF.width() - (rectF.width() * ((height - (f11 * 2.0f)) / height))) / 2.0f;
        return new RectF(rectF.left + width, rectF.top + f11, rectF.right - width, rectF.bottom - f11);
    }

    /* renamed from: do  reason: not valid java name */
    private static float[] m1049do(float f11, float f12) {
        if (0.75f > f11 / f12) {
            return m1050for(f11, 0.9f);
        }
        return m1051if(f12, 0.9f);
    }
}
