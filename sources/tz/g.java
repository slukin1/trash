package tz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import d00.c;
import sz.a;

public class g implements LeadingMarginSpan {

    /* renamed from: b  reason: collision with root package name */
    public final a f60190b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60191c;

    /* renamed from: d  reason: collision with root package name */
    public final Paint f60192d = f.a();

    /* renamed from: e  reason: collision with root package name */
    public int f60193e;

    public g(a aVar, String str) {
        this.f60190b = aVar;
        this.f60191c = str;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            g[] gVarArr = (g[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), g.class);
            if (gVarArr != null) {
                TextPaint paint = textView.getPaint();
                for (g gVar : gVarArr) {
                    gVar.f60193e = (int) (paint.measureText(gVar.f60191c) + 0.5f);
                }
            }
        }
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
        if (z11 && c.b(i16, charSequence, this)) {
            this.f60192d.set(paint);
            this.f60190b.h(this.f60192d);
            int measureText = (int) (this.f60192d.measureText(this.f60191c) + 0.5f);
            int k11 = this.f60190b.k();
            if (measureText > k11) {
                this.f60193e = measureText;
                k11 = measureText;
            } else {
                this.f60193e = 0;
            }
            canvas.drawText(this.f60191c, (float) (i12 > 0 ? (i11 + (k11 * i12)) - measureText : i11 + (i12 * k11) + (k11 - measureText)), (float) i14, this.f60192d);
        }
    }

    public int getLeadingMargin(boolean z11) {
        return Math.max(this.f60193e, this.f60190b.k());
    }
}
