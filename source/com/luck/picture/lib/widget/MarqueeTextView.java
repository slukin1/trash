package com.luck.picture.lib.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

public class MarqueeTextView extends MediumBoldTextView {
    public MarqueeTextView(Context context) {
        super(context);
    }

    public boolean isFocused() {
        return true;
    }

    public boolean isSelected() {
        return true;
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        if (z11) {
            super.onFocusChanged(true, i11, rect);
        }
    }

    public void onWindowFocusChanged(boolean z11) {
        if (z11) {
            super.onWindowFocusChanged(true);
        }
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
