package com.rodolfonavalon.shaperipplelibrary.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Star extends BaseShape {

    /* renamed from: c  reason: collision with root package name */
    public Path f28864c;

    public void a(Canvas canvas, int i11, int i12, float f11, int i13, int i14, Paint paint) {
        float f12 = ((float) i11) - f11;
        float f13 = ((float) i12) - f11;
        float f14 = 0.5f * f11;
        float f15 = f12 + f14;
        float f16 = (0.84f * f11) + f13;
        this.f28864c.moveTo(f15, f16);
        this.f28864c.lineTo((1.5f * f11) + f12, f16);
        float f17 = (1.45f * f11) + f13;
        this.f28864c.lineTo((0.68f * f11) + f12, f17);
        this.f28864c.lineTo((1.0f * f11) + f12, f13 + f14);
        this.f28864c.lineTo(f12 + (f11 * 1.32f), f17);
        this.f28864c.lineTo(f15, f16);
        this.f28864c.close();
        paint.setColor(i13);
        canvas.drawPath(this.f28864c, paint);
        this.f28864c.reset();
    }

    public void b(Context context, Paint paint) {
        this.f28864c = new Path();
    }
}
