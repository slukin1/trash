package com.rodolfonavalon.shaperipplelibrary.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends BaseShape {
    public void a(Canvas canvas, int i11, int i12, float f11, int i13, int i14, Paint paint) {
        paint.setColor(i13);
        canvas.drawCircle((float) i11, (float) i12, f11, paint);
    }

    public void b(Context context, Paint paint) {
    }
}
