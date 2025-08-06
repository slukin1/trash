package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.k;
import j5.a;

public class ChevronUpShapeRenderer implements a {
    public void a(Canvas canvas, k kVar, ViewPortHandler viewPortHandler, float f11, float f12, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        float g11 = (kVar.g() / 2.0f) * 2.0f;
        Canvas canvas2 = canvas;
        float f13 = f11;
        float f14 = f12 - g11;
        float f15 = f12;
        Paint paint2 = paint;
        canvas2.drawLine(f13, f14, f11 + g11, f15, paint2);
        canvas2.drawLine(f13, f14, f11 - g11, f15, paint2);
    }
}
