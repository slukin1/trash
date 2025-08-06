package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

public class MiscUtils {
    private static final PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int clamp(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i13, i11));
    }

    public static boolean contains(float f11, float f12, float f13) {
        return f11 >= f12 && f11 <= f13;
    }

    private static int floorDiv(int i11, int i12) {
        int i13 = i11 / i12;
        return (((i11 ^ i12) >= 0) || i11 % i12 == 0) ? i13 : i13 - 1;
    }

    public static int floorMod(float f11, float f12) {
        return floorMod((int) f11, (int) f12);
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        path.reset();
        PointF initialPoint = shapeData.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        pathFromDataCurrentPoint.set(initialPoint.x, initialPoint.y);
        for (int i11 = 0; i11 < shapeData.getCurves().size(); i11++) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(i11);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF pointF = pathFromDataCurrentPoint;
            if (!controlPoint1.equals(pointF) || !controlPoint2.equals(vertex)) {
                path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            } else {
                path.lineTo(vertex.x, vertex.y);
            }
            pointF.set(vertex.x, vertex.y);
        }
        if (shapeData.isClosed()) {
            path.close();
        }
    }

    public static double lerp(double d11, double d12, double d13) {
        return d11 + (d13 * (d12 - d11));
    }

    public static float lerp(float f11, float f12, float f13) {
        return f11 + (f13 * (f12 - f11));
    }

    public static int lerp(int i11, int i12, float f11) {
        return (int) (((float) i11) + (f11 * ((float) (i12 - i11))));
    }

    public static void resolveKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), i11)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f13, f11));
    }

    private static int floorMod(int i11, int i12) {
        return i11 - (i12 * floorDiv(i11, i12));
    }

    public static double clamp(double d11, double d12, double d13) {
        return Math.max(d12, Math.min(d13, d11));
    }
}
