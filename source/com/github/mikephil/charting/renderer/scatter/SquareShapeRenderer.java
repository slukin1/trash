package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.k;
import j5.a;

public class SquareShapeRenderer implements a {
    public void a(Canvas canvas, k kVar, ViewPortHandler viewPortHandler, float f11, float f12, Paint paint) {
        Paint paint2 = paint;
        float g11 = kVar.g();
        float f13 = g11 / 2.0f;
        float e11 = Utils.e(kVar.b0());
        float f14 = (g11 - (e11 * 2.0f)) / 2.0f;
        float f15 = f14 / 2.0f;
        int H = kVar.H();
        if (((double) g11) > 0.0d) {
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f14);
            float f16 = f11 - e11;
            float f17 = f12 - e11;
            float f18 = f11 + e11;
            float f19 = f12 + e11;
            canvas.drawRect(f16 - f15, f17 - f15, f18 + f15, f19 + f15, paint);
            if (H != 1122867) {
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(H);
                canvas.drawRect(f16, f17, f18, f19, paint);
                return;
            }
            return;
        }
        paint2.setStyle(Paint.Style.FILL);
        Canvas canvas2 = canvas;
        canvas2.drawRect(f11 - f13, f12 - f13, f11 + f13, f12 + f13, paint);
    }
}
