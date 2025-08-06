package com.sumsub.sns.core.presentation.base.text.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class a extends ClickableSpan {
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
