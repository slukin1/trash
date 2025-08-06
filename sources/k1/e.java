package k1;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.h;

public abstract class e extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    public final Paint.FontMetricsInt f16021b = new Paint.FontMetricsInt();

    /* renamed from: c  reason: collision with root package name */
    public final d f16022c;

    /* renamed from: d  reason: collision with root package name */
    public short f16023d = -1;

    /* renamed from: e  reason: collision with root package name */
    public short f16024e = -1;

    /* renamed from: f  reason: collision with root package name */
    public float f16025f = 1.0f;

    public e(d dVar) {
        h.h(dVar, "metadata cannot be null");
        this.f16022c = dVar;
    }

    public final d a() {
        return this.f16022c;
    }

    public final int b() {
        return this.f16023d;
    }

    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f16021b);
        Paint.FontMetricsInt fontMetricsInt2 = this.f16021b;
        this.f16025f = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.f16022c.e());
        this.f16024e = (short) ((int) (((float) this.f16022c.e()) * this.f16025f));
        short i13 = (short) ((int) (((float) this.f16022c.i()) * this.f16025f));
        this.f16023d = i13;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f16021b;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i13;
    }
}
