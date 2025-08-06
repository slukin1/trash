package tz;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import sz.a;

public class d extends MetricAffectingSpan {

    /* renamed from: b  reason: collision with root package name */
    public final a f60182b;

    public d(a aVar) {
        this.f60182b = aVar;
    }

    public final void a(TextPaint textPaint) {
        this.f60182b.c(textPaint);
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
        textPaint.bgColor = this.f60182b.n(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
