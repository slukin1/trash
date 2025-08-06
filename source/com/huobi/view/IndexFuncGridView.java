package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class IndexFuncGridView extends GridView {
    public IndexFuncGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public IndexFuncGridView(Context context) {
        super(context);
    }

    public IndexFuncGridView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
