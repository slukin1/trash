package yz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import io.noties.markwon.utils.SpanUtils;
import sz.a;

public class c extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public final a f60229b;

    /* renamed from: c  reason: collision with root package name */
    public final a f60230c;

    /* renamed from: d  reason: collision with root package name */
    public final int f60231d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f60232e;

    public c(a aVar, a aVar2, int i11, boolean z11) {
        this.f60229b = aVar;
        this.f60230c = aVar2;
        this.f60231d = i11;
        this.f60232e = z11;
    }

    public static float a(int i11, int i12, Paint paint) {
        return (float) ((int) (((float) (i11 + ((i12 - i11) / 2))) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f)));
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i11, int i12, float f11, int i13, int i14, int i15, Paint paint) {
        int i16;
        Canvas canvas2 = canvas;
        int i17 = i13;
        int i18 = i15;
        Paint paint2 = paint;
        this.f60230c.g(SpanUtils.a(canvas, charSequence), paint.getTextSize());
        a aVar = this.f60230c;
        if (aVar.e()) {
            int i19 = i18 - aVar.getBounds().bottom;
            int save = canvas.save();
            try {
                int i21 = this.f60231d;
                if (2 == i21) {
                    i16 = ((i18 - i17) - aVar.getBounds().height()) / 2;
                } else {
                    if (1 == i21) {
                        i16 = paint.getFontMetricsInt().descent;
                    }
                    float f12 = f11;
                    canvas.translate(f11, (float) i19);
                    aVar.draw(canvas);
                }
                i19 -= i16;
                float f122 = f11;
                canvas.translate(f11, (float) i19);
                aVar.draw(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            float f13 = f11;
            float a11 = a(i17, i18, paint2);
            if (this.f60232e) {
                this.f60229b.f(paint2);
            }
            canvas.drawText(charSequence, i11, i12, f11, a11, paint);
        }
    }

    public int getSize(Paint paint, CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f60230c.e()) {
            Rect bounds = this.f60230c.getBounds();
            if (fontMetricsInt != null) {
                int i13 = -bounds.bottom;
                fontMetricsInt.ascent = i13;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = i13;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right;
        }
        if (this.f60232e) {
            this.f60229b.f(paint);
        }
        return (int) (paint.measureText(charSequence, i11, i12) + 0.5f);
    }
}
