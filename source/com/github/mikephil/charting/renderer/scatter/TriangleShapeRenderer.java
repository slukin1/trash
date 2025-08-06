package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import g5.k;
import j5.a;

public class TriangleShapeRenderer implements a {

    /* renamed from: a  reason: collision with root package name */
    public Path f65534a = new Path();

    public void a(Canvas canvas, k kVar, ViewPortHandler viewPortHandler, float f11, float f12, Paint paint) {
        float g11 = kVar.g();
        float f13 = g11 / 2.0f;
        float e11 = (g11 - (Utils.e(kVar.b0()) * 2.0f)) / 2.0f;
        int H = kVar.H();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.f65534a;
        path.reset();
        float f14 = f12 - f13;
        path.moveTo(f11, f14);
        float f15 = f11 + f13;
        float f16 = f12 + f13;
        path.lineTo(f15, f16);
        float f17 = f11 - f13;
        path.lineTo(f17, f16);
        int i11 = (((double) g11) > 0.0d ? 1 : (((double) g11) == 0.0d ? 0 : -1));
        if (i11 > 0) {
            path.lineTo(f11, f14);
            float f18 = f17 + e11;
            float f19 = f16 - e11;
            path.moveTo(f18, f19);
            path.lineTo(f15 - e11, f19);
            path.lineTo(f11, f14 + e11);
            path.lineTo(f18, f19);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (i11 > 0 && H != 1122867) {
            paint.setColor(H);
            path.moveTo(f11, f14 + e11);
            float f21 = f16 - e11;
            path.lineTo(f15 - e11, f21);
            path.lineTo(f17 + e11, f21);
            path.close();
            canvas.drawPath(path, paint);
            path.reset();
        }
    }
}
