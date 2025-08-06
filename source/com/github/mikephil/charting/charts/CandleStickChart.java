package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.CandleData;
import f5.d;
import i5.e;

public class CandleStickChart extends BarLineChartBase<CandleData> implements d {
    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleData getCandleData() {
        return (CandleData) this.f65358c;
    }

    public void n() {
        super.n();
        this.f65374s = new e(this, this.f65377v, this.f65376u);
        getXAxis().M(0.5f);
        getXAxis().L(0.5f);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
