package tz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import d00.c;
import sz.a;

public class e extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: b  reason: collision with root package name */
    public final a f60183b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f60184c = f.b();

    /* renamed from: d  reason: collision with root package name */
    public final Paint f60185d = f.a();

    /* renamed from: e  reason: collision with root package name */
    public final int f60186e;

    public e(a aVar, int i11) {
        this.f60183b = aVar;
        this.f60186e = i11;
    }

    public final void a(TextPaint textPaint) {
        this.f60183b.e(textPaint, this.f60186e);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
        int i18;
        int i19 = this.f60186e;
        if ((i19 == 1 || i19 == 2) && c.a(i17, charSequence, this)) {
            this.f60185d.set(paint);
            this.f60183b.d(this.f60185d);
            float strokeWidth = this.f60185d.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i21 = (int) ((((float) i15) - strokeWidth) + 0.5f);
                if (i12 > 0) {
                    i18 = canvas.getWidth();
                } else {
                    i18 = i11;
                    i11 -= canvas.getWidth();
                }
                this.f60184c.set(i11, i21, i18, i15);
                canvas.drawRect(this.f60184c, this.f60185d);
            }
        }
    }

    public int getLeadingMargin(boolean z11) {
        return 0;
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
