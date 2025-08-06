package com.huobi.login.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class AutoMarqueeTextView extends AppCompatTextView {
    public AutoMarqueeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
    }

    public boolean isFocused() {
        return true;
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
    }

    public AutoMarqueeTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setFocusable(true);
    }
}
