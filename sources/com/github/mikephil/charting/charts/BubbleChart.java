package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BubbleData;
import f5.c;
import i5.d;

public class BubbleChart extends BarLineChartBase<BubbleData> implements c {
    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleData getBubbleData() {
        return (BubbleData) this.f65358c;
    }

    public void n() {
        super.n();
        this.f65374s = new d(this, this.f65377v, this.f65376u);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
