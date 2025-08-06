package com.huobi.edgeengine.template.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class NoUnderLineClickableSpan extends ClickableSpan {
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
