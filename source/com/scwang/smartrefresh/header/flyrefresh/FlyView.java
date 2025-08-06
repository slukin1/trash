package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.scwang.smartrefresh.layout.internal.pathview.PathsView;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class FlyView extends PathsView {
    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i11) {
        b(-1);
        c("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z");
        setMinimumWidth(DensityUtil.b(25.0f));
        setMinimumHeight(DensityUtil.b(25.0f));
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public FlyView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11);
    }
}
