package ke;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.hbg.module.libkt.base.ext.c;

public final class b extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public float f25284b;

    public b(float f11) {
        this.f25284b = f11;
    }

    public final TextPaint a(Paint paint) {
        TextPaint textPaint = new TextPaint(paint);
        textPaint.setTextSize((float) c.d(Float.valueOf(this.f25284b)));
        return textPaint;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        CharSequence subSequence = charSequence != null ? charSequence.subSequence(i11, i12) : null;
        TextPaint a11 = a(paint);
        Paint.FontMetricsInt fontMetricsInt = a11.getFontMetricsInt();
        canvas.drawText(String.valueOf(subSequence), f11, ((float) i14) - ((((float) (((fontMetricsInt.descent + i14) + i14) + fontMetricsInt.ascent)) / 2.0f) - (((float) (i15 + i13)) / 2.0f)), a11);
    }

    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        return (int) a(paint).measureText(String.valueOf(charSequence != null ? charSequence.subSequence(i11, i12) : null));
    }
}
