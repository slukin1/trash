package io.noties.markwon.html.span;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class SubScriptSpan extends MetricAffectingSpan {
    public final void a(TextPaint textPaint) {
        textPaint.setTextSize(textPaint.getTextSize() * 0.75f);
        textPaint.baselineShift -= (int) (textPaint.ascent() / 2.0f);
    }

    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
