package io.noties.markwon.utils;

import android.graphics.Canvas;
import android.text.Layout;
import android.text.Spanned;
import android.widget.TextView;
import tz.h;
import tz.i;

public abstract class SpanUtils {
    public static int a(Canvas canvas, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Layout b11 = h.b(spanned);
            if (b11 != null) {
                return b11.getWidth();
            }
            TextView c11 = i.c(spanned);
            if (c11 != null) {
                return (c11.getWidth() - c11.getPaddingLeft()) - c11.getPaddingRight();
            }
        }
        return canvas.getWidth();
    }
}
