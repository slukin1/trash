package tz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

public class a implements LeadingMarginSpan {

    /* renamed from: b  reason: collision with root package name */
    public final sz.a f60170b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f60171c = f.b();

    /* renamed from: d  reason: collision with root package name */
    public final Paint f60172d = f.a();

    public a(sz.a aVar) {
        this.f60170b = aVar;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
        int l11 = this.f60170b.l();
        this.f60172d.set(paint);
        this.f60170b.a(this.f60172d);
        int i18 = i12 * l11;
        int i19 = i11 + i18;
        int i21 = i18 + i19;
        this.f60171c.set(Math.min(i19, i21), i13, Math.max(i19, i21), i15);
        canvas.drawRect(this.f60171c, this.f60172d);
    }

    public int getLeadingMargin(boolean z11) {
        return this.f60170b.k();
    }
}
