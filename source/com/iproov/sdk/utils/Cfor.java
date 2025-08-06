package com.iproov.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.SensorManager;
import com.iproov.sdk.p017implements.Cnative;

/* renamed from: com.iproov.sdk.utils.for  reason: invalid class name */
public class Cfor {

    /* renamed from: com.iproov.sdk.utils.for$do  reason: invalid class name */
    public enum Cdo {
        FILL,
        FIT
    }

    /* renamed from: do  reason: not valid java name */
    public static double m2232do(Point point, Point point2) {
        return (Math.atan2((double) (point.y - point2.y), (double) (point.x - point2.x)) + 3.141592653589793d) % 6.283185307179586d;
    }

    /* renamed from: for  reason: not valid java name */
    public static Point m2241for(Rect rect) {
        return new Point(rect.centerX(), rect.centerY());
    }

    /* renamed from: if  reason: not valid java name */
    public static double m2242if(Point point, Point point2) {
        return Math.sqrt(Math.pow((double) (point2.y - point.y), 2.0d) + Math.pow((double) (point2.x - point.x), 2.0d));
    }

    /* renamed from: do  reason: not valid java name */
    public static Rect m2238do(RectF rectF) {
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    /* renamed from: if  reason: not valid java name */
    public static Cnative m2243if(Rect rect) {
        return new Cnative((double) rect.exactCenterX(), (double) rect.exactCenterY(), (double) rect.width());
    }

    /* renamed from: do  reason: not valid java name */
    public static RectF m2239do(Rect rect, Rect rect2) {
        return new RectF((((float) rect.left) * 1.0f) / ((float) rect2.width()), (((float) rect.top) * 1.0f) / ((float) rect2.height()), (((float) rect.right) * 1.0f) / ((float) rect2.width()), (((float) rect.bottom) * 1.0f) / ((float) rect2.height()));
    }

    /* renamed from: do  reason: not valid java name */
    public static Rect m2235do(Rect rect, float f11) {
        int min = (int) (((float) Math.min(rect.width(), rect.height())) * f11);
        int width = rect.left + ((int) (((float) (rect.width() - min)) / 2.0f));
        int height = rect.top + ((int) (((float) (rect.height() - min)) / 2.0f));
        return new Rect(width, height, width + min, min + height);
    }

    /* renamed from: do  reason: not valid java name */
    public static Rect m2237do(Rect rect, Rect rect2, Rect rect3, Cdo doVar) {
        if (rect == null) {
            return null;
        }
        float width = (((float) rect3.width()) * 1.0f) / ((float) rect2.width());
        float height = (((float) rect3.height()) * 1.0f) / ((float) rect2.height());
        float min = doVar == Cdo.FIT ? Math.min(width, height) : Math.max(width, height);
        int width2 = rect2.width() / 2;
        int height2 = rect2.height() / 2;
        float width3 = (float) (rect3.width() / 2);
        float height3 = (float) (rect3.height() / 2);
        return new Rect((int) ((((float) (rect.left - width2)) * min) + width3), (int) ((((float) (rect.top - height2)) * min) + height3), (int) ((((float) (rect.right - width2)) * min) + width3), (int) ((((float) (rect.bottom - height2)) * min) + height3));
    }

    /* renamed from: do  reason: not valid java name */
    public static double m2231do(float f11) {
        return Double.parseDouble(Float.toString(f11));
    }

    /* renamed from: do  reason: not valid java name */
    public static float m2233do(double d11) {
        return Float.parseFloat(Double.toString(d11));
    }

    /* renamed from: do  reason: not valid java name */
    public static Rect m2234do(Rect rect) {
        if (rect.bottom < 0) {
            return new Rect(rect.left, 0, rect.right, rect.bottom);
        }
        return null;
    }

    /* renamed from: do  reason: not valid java name */
    public static Rect m2236do(Rect rect, int i11) {
        if (rect.top > i11) {
            return new Rect(rect.left, rect.top, rect.right, i11);
        }
        return null;
    }

    /* renamed from: do  reason: not valid java name */
    public static float[] m2240do(float[] fArr) {
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        float[] fArr3 = new float[3];
        SensorManager.getOrientation(fArr2, fArr3);
        float f11 = fArr3[1];
        fArr3[1] = -fArr3[0];
        fArr3[0] = -f11;
        return fArr3;
    }
}
