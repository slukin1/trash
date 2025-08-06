package com.hbg.module.libkt.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public final class s extends ImageSpan {
    public s(Drawable drawable) {
        super(drawable);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f12 = (float) i14;
        canvas.save();
        canvas.translate(f11, (float) ((int) (((((fontMetrics.ascent + f12) + f12) + fontMetrics.descent) / ((float) 2)) - ((float) ((drawable.getBounds().bottom + drawable.getBounds().top) / 2)))));
        drawable.draw(canvas);
        canvas.restore();
    }
}
