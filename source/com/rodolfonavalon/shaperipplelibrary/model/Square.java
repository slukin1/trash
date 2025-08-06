package com.rodolfonavalon.shaperipplelibrary.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Square extends BaseShape {

    /* renamed from: c  reason: collision with root package name */
    public Rect f28863c;

    public void a(Canvas canvas, int i11, int i12, float f11, int i13, int i14, Paint paint) {
        Rect rect = this.f28863c;
        float f12 = (float) i11;
        rect.left = (int) (f12 - f11);
        rect.right = (int) (f12 + f11);
        float f13 = (float) i12;
        rect.top = (int) (f13 - f11);
        rect.bottom = (int) (f13 + f11);
        paint.setColor(i13);
        canvas.drawRect(this.f28863c, paint);
    }

    public void b(Context context, Paint paint) {
        this.f28863c = new Rect();
    }
}
