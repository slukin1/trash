package tz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import sz.a;

public class c extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: b  reason: collision with root package name */
    public final a f60179b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f60180c = f.b();

    /* renamed from: d  reason: collision with root package name */
    public final Paint f60181d = f.a();

    public c(a aVar) {
        this.f60179b = aVar;
    }

    public final void a(TextPaint textPaint) {
        this.f60179b.b(textPaint);
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
        int i18;
        this.f60181d.setStyle(Paint.Style.FILL);
        this.f60181d.setColor(this.f60179b.o(paint));
        if (i12 > 0) {
            i18 = canvas.getWidth();
        } else {
            int i19 = i11;
            i11 -= canvas.getWidth();
            i18 = i19;
        }
        this.f60180c.set(i11, i13, i18, i15);
        canvas.drawRect(this.f60180c, this.f60181d);
    }

    public int getLeadingMargin(boolean z11) {
        return this.f60179b.p();
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
