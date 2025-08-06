package com.jumio.commons.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import java.util.List;

public final class DrawingUtil {
    public static final DrawingUtil INSTANCE = new DrawingUtil();

    public final List<Path> createCroppedEdgePathListFromRect(Rect rect, boolean z11) {
        int i11 = rect.left;
        int i12 = rect.right;
        int i13 = rect.top;
        int i14 = rect.bottom;
        Path path = new Path();
        Path path2 = new Path();
        if (z11) {
            float f11 = (float) i12;
            float f12 = (float) i13;
            path.moveTo(f11, f12);
            float f13 = (float) i14;
            path.lineTo(f11, f13);
            float f14 = (float) i11;
            path2.moveTo(f14, f13);
            path2.lineTo(f14, f12);
        } else {
            float f15 = (float) i11;
            float f16 = (float) i13;
            path.moveTo(f15, f16);
            float f17 = (float) i12;
            path.lineTo(f17, f16);
            float f18 = (float) i14;
            path2.moveTo(f17, f18);
            path2.lineTo(f15, f18);
        }
        return CollectionsKt__CollectionsKt.n(path, path2);
    }

    public final Path createRectWithRoundedCornersAsPath(Rect rect, int i11, int i12, int i13, int i14) {
        int i15 = rect.left;
        int i16 = rect.right;
        int i17 = rect.top;
        int i18 = rect.bottom;
        Path path = new Path();
        path.moveTo(i11 <= 0 ? (float) i15 : (float) (i15 + i11), (float) i17);
        if (i12 <= 0) {
            path.lineTo((float) i16, (float) i17);
        } else {
            float f11 = (float) i17;
            path.lineTo((float) (i16 - i11), f11);
            float f12 = (float) i16;
            path.quadTo(f12, f11, f12, (float) (i12 + i17));
        }
        if (i13 <= 0) {
            path.lineTo((float) i16, (float) i18);
        } else {
            float f13 = (float) i16;
            path.lineTo(f13, (float) (i18 - i13));
            float f14 = (float) i18;
            path.quadTo(f13, f14, (float) (i16 - i13), f14);
        }
        if (i14 <= 0) {
            path.lineTo((float) i15, (float) i18);
        } else {
            float f15 = (float) i18;
            path.lineTo((float) (i15 + i14), f15);
            float f16 = (float) i15;
            path.quadTo(f16, f15, f16, (float) (i18 - i14));
        }
        if (i11 <= 0) {
            path.lineTo((float) i15, (float) i17);
        } else {
            float f17 = (float) i15;
            path.lineTo(f17, (float) (i17 + i11));
            float f18 = (float) i17;
            path.quadTo(f17, f18, (float) (i15 + i11), f18);
        }
        path.close();
        return path;
    }

    public final void drawPath(Canvas canvas, Paint paint, PointF... pointFArr) {
        Path path = new Path();
        int length = pointFArr.length;
        for (int i11 = 1; i11 < length; i11++) {
            int i12 = i11 - 1;
            if (Math.abs(pointFArr[i12].x - pointFArr[i11].x) < Math.abs(pointFArr[i12].y - pointFArr[i11].y)) {
                PointF pointF = pointFArr[i12];
                float f11 = pointF.y;
                if (f11 > pointFArr[i11].y) {
                    float f12 = (float) 2;
                    path.moveTo(pointF.x, (paint.getStrokeWidth() / f12) + f11);
                    PointF pointF2 = pointFArr[i11];
                    path.lineTo(pointF2.x, pointF2.y - (paint.getStrokeWidth() / f12));
                } else {
                    float f13 = (float) 2;
                    path.moveTo(pointF.x, f11 - (paint.getStrokeWidth() / f13));
                    PointF pointF3 = pointFArr[i11];
                    path.lineTo(pointF3.x, (paint.getStrokeWidth() / f13) + pointF3.y);
                }
            } else {
                float f14 = pointFArr[i12].x;
                if (f14 > pointFArr[i11].x) {
                    float f15 = (float) 2;
                    path.moveTo((paint.getStrokeWidth() / f15) + f14, pointFArr[i12].y);
                    path.lineTo(pointFArr[i11].x - (paint.getStrokeWidth() / f15), pointFArr[i11].y);
                } else {
                    float f16 = (float) 2;
                    path.moveTo(f14 - (paint.getStrokeWidth() / f16), pointFArr[i12].y);
                    path.lineTo((paint.getStrokeWidth() / f16) + pointFArr[i11].x, pointFArr[i11].y);
                }
            }
        }
        canvas.drawPath(path, paint);
    }
}
