package com.huobi.edgeengine.template.widget.chart;

import com.github.mikephil.charting.components.AxisBase;
import d5.c;
import java.text.DecimalFormat;

public class FloatValueFormatter implements c {

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f44219a = new DecimalFormat("###,###,###,##0.0");

    public String a(float f11, AxisBase axisBase) {
        return this.f44219a.format((double) f11);
    }
}
