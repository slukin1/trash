package com.huobi.copytrading.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.widget.NestedScrollView;

public class HBNestedScrollView extends NestedScrollView {
    public HBNestedScrollView(Context context) {
        super(context);
    }

    public void measureChildWithMargins(View view, int i11, int i12, int i13, int i14) {
        view.measure(i11, i13);
    }

    public HBNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HBNestedScrollView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
