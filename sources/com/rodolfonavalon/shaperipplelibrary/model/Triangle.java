package com.rodolfonavalon.shaperipplelibrary.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Triangle extends BaseShape {

    /* renamed from: c  reason: collision with root package name */
    public Path f28865c;

    public void a(Canvas canvas, int i11, int i12, float f11, int i13, int i14, Paint paint) {
        int i15 = (int) f11;
        int i16 = i12 - i15;
        this.f28865c.moveTo((float) i11, (float) i16);
        float f12 = (float) (i12 + i15);
        this.f28865c.lineTo((float) (i11 - i15), f12);
        this.f28865c.lineTo((float) (i11 + i15), f12);
        this.f28865c.close();
        paint.setColor(i13);
        canvas.drawPath(this.f28865c, paint);
        this.f28865c.reset();
    }

    public void b(Context context, Paint paint) {
        this.f28865c = new Path();
    }
}
