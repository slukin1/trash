package com.hbg.module.content.utls;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public final class f extends ImageSpan {

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Drawable> f18912b;

    public f(Drawable drawable, int i11) {
        super(drawable, i11);
    }

    public final Drawable a() {
        WeakReference<Drawable> weakReference = this.f18912b;
        Drawable drawable = weakReference != null ? (Drawable) weakReference.get() : null;
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getDrawable();
        this.f18912b = new WeakReference<>(drawable2);
        return drawable2;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        int i16;
        Drawable a11 = a();
        if (a11 != null) {
            Drawable a12 = a();
            canvas.save();
            int i17 = i15 - a12.getBounds().bottom;
            int i18 = this.mVerticalAlignment;
            if (i18 == 1) {
                i16 = paint.getFontMetricsInt().descent;
            } else {
                if (i18 == 2) {
                    Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                    i17 = (((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent) / 2;
                    i16 = a11.getBounds().bottom / 2;
                }
                canvas.translate(f11, (float) i17);
                a12.draw(canvas);
                canvas.restore();
            }
            i17 -= i16;
            canvas.translate(f11, (float) i17);
            a12.draw(canvas);
            canvas.restore();
        }
    }
}
