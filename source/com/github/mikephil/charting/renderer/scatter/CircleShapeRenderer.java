package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.k;
import j5.a;

public class CircleShapeRenderer implements a {
    public void a(Canvas canvas, k kVar, ViewPortHandler viewPortHandler, float f11, float f12, Paint paint) {
        float g11 = kVar.g();
        float f13 = g11 / 2.0f;
        float e11 = Utils.e(kVar.b0());
        float f14 = (g11 - (e11 * 2.0f)) / 2.0f;
        float f15 = f14 / 2.0f;
        int H = kVar.H();
        if (((double) g11) > 0.0d) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f14);
            canvas.drawCircle(f11, f12, f15 + e11, paint);
            if (H != 1122867) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(H);
                canvas.drawCircle(f11, f12, e11, paint);
                return;
            }
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f11, f12, f13, paint);
    }
}
