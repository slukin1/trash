package com.twitter.sdk.android.tweetui.internal;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class ClickableLinkSpan extends ClickableSpan implements HighlightedClickableSpan {
    private final boolean colored;
    public final int linkColor;
    private boolean selected;
    private final int selectedColor;
    private final boolean underlined;

    public ClickableLinkSpan(int i11, int i12, boolean z11) {
        this(i11, i12, true, z11);
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void select(boolean z11) {
        this.selected = z11;
    }

    public void updateDrawState(TextPaint textPaint) {
        if (this.colored) {
            textPaint.setColor(this.linkColor);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
        if (this.selected) {
            textPaint.bgColor = this.selectedColor;
        } else {
            textPaint.bgColor = 0;
        }
        if (this.underlined) {
            textPaint.setUnderlineText(true);
        }
    }

    public ClickableLinkSpan(int i11, int i12, boolean z11, boolean z12) {
        this.selectedColor = i11;
        this.linkColor = i12;
        this.colored = z11;
        this.underlined = z12;
    }
}
