package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import d5.c;
import d5.e;
import java.text.DecimalFormat;

public class PercentFormatter implements e, c {

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f65499a = new DecimalFormat("###,###,##0.0");

    public String a(float f11, AxisBase axisBase) {
        return this.f65499a.format((double) f11) + " %";
    }

    public String b(float f11, Entry entry, int i11, ViewPortHandler viewPortHandler) {
        return this.f65499a.format((double) f11) + " %";
    }
}
