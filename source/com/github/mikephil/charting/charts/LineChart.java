package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import f5.g;
import i5.j;

public class LineChart extends BarLineChartBase<LineData> implements g {
    public LineChart(Context context) {
        super(context);
    }

    public LineData getLineData() {
        return (LineData) this.f65358c;
    }

    public void n() {
        super.n();
        this.f65374s = new j(this, this.f65377v, this.f65376u);
    }

    public void onDetachedFromWindow() {
        i5.g gVar = this.f65374s;
        if (gVar != null && (gVar instanceof j)) {
            ((j) gVar).w();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
