package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class StrongEmphasisSpan extends MetricAffectingSpan {
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setFakeBoldText(true);
    }

    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setFakeBoldText(true);
    }
}
