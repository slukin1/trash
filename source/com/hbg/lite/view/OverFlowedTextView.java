package com.hbg.lite.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class OverFlowedTextView extends AppCompatTextView {
    public OverFlowedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean d() {
        return getPaint().measureText(getText().toString()) > ((float) getAvailableWidth());
    }

    public int getAvailableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public float getPaintMeasureWith() {
        return getPaint().measureText(getText().toString());
    }

    public OverFlowedTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
