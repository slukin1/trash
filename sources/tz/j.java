package tz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import sz.a;

public class j implements LeadingMarginSpan {

    /* renamed from: b  reason: collision with root package name */
    public final a f60196b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f60197c = f.b();

    /* renamed from: d  reason: collision with root package name */
    public final Paint f60198d = f.a();

    public j(a aVar) {
        this.f60196b = aVar;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
        int i18;
        int i19 = i13 + ((i15 - i13) / 2);
        this.f60198d.set(paint);
        this.f60196b.i(this.f60198d);
        int strokeWidth = (int) ((((float) ((int) (this.f60198d.getStrokeWidth() + 0.5f))) / 2.0f) + 0.5f);
        if (i12 > 0) {
            i18 = canvas.getWidth();
        } else {
            i18 = i11;
            i11 -= canvas.getWidth();
        }
        this.f60197c.set(i11, i19 - strokeWidth, i18, i19 + strokeWidth);
        canvas.drawRect(this.f60197c, this.f60198d);
    }

    public int getLeadingMargin(boolean z11) {
        return 0;
    }
}
