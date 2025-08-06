package tz;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import d00.c;
import sz.a;

public class b implements LeadingMarginSpan {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f60173g;

    /* renamed from: b  reason: collision with root package name */
    public a f60174b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f60175c = f.a();

    /* renamed from: d  reason: collision with root package name */
    public final RectF f60176d = f.c();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f60177e = f.b();

    /* renamed from: f  reason: collision with root package name */
    public final int f60178f;

    static {
        int i11 = Build.VERSION.SDK_INT;
        f60173g = 24 == i11 || 25 == i11;
    }

    public b(a aVar, int i11) {
        this.f60174b = aVar;
        this.f60178f = i11;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i11, int i12, int i13, int i14, int i15, CharSequence charSequence, int i16, int i17, boolean z11, Layout layout) {
        int i18;
        int i19;
        Paint.Style style;
        int i21;
        if (z11 && c.b(i16, charSequence, this)) {
            this.f60175c.set(paint);
            this.f60174b.h(this.f60175c);
            int save = canvas.save();
            try {
                int k11 = this.f60174b.k();
                int m11 = this.f60174b.m((int) ((this.f60175c.descent() - this.f60175c.ascent()) + 0.5f));
                int i22 = (k11 - m11) / 2;
                if (f60173g) {
                    if (i12 < 0) {
                        i21 = i11 - (layout.getWidth() - (k11 * this.f60178f));
                    } else {
                        i21 = (k11 * this.f60178f) - i11;
                    }
                    int i23 = i11 + (i22 * i12);
                    int i24 = (i12 * m11) + i23;
                    int i25 = i12 * i21;
                    i18 = Math.min(i23, i24) + i25;
                    i19 = Math.max(i23, i24) + i25;
                } else {
                    if (i12 <= 0) {
                        i11 -= k11;
                    }
                    i18 = i11 + i22;
                    i19 = i18 + m11;
                }
                int descent = (i14 + ((int) (((this.f60175c.descent() + this.f60175c.ascent()) / 2.0f) + 0.5f))) - (m11 / 2);
                int i26 = m11 + descent;
                int i27 = this.f60178f;
                if (i27 != 0) {
                    if (i27 != 1) {
                        this.f60177e.set(i18, descent, i19, i26);
                        this.f60175c.setStyle(Paint.Style.FILL);
                        canvas.drawRect(this.f60177e, this.f60175c);
                    }
                }
                this.f60176d.set((float) i18, (float) descent, (float) i19, (float) i26);
                if (this.f60178f == 0) {
                    style = Paint.Style.FILL;
                } else {
                    style = Paint.Style.STROKE;
                }
                this.f60175c.setStyle(style);
                canvas.drawOval(this.f60176d, this.f60175c);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    public int getLeadingMargin(boolean z11) {
        return this.f60174b.k();
    }
}
