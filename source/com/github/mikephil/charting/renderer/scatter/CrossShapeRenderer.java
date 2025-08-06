package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.k;
import j5.a;

public class CrossShapeRenderer implements a {
    public void a(Canvas canvas, k kVar, ViewPortHandler viewPortHandler, float f11, float f12, Paint paint) {
        float g11 = kVar.g() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        canvas2.drawLine(f11 - g11, f12, f11 + g11, f12, paint2);
        canvas2.drawLine(f11, f12 - g11, f11, f12 + g11, paint2);
    }
}
