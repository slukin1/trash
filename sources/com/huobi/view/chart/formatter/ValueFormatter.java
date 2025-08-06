package com.huobi.view.chart.formatter;

import com.huobi.view.chart.components.AxisBase;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.data.PieEntry;
import com.huobi.view.chart.utils.ViewPortHandler;

public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public String getAxisLabel(float f11, AxisBase axisBase) {
        return getFormattedValue(f11);
    }

    @Deprecated
    public String getFormattedValue(float f11, AxisBase axisBase) {
        return getFormattedValue(f11);
    }

    public String getPieLabel(float f11, PieEntry pieEntry) {
        return getFormattedValue(f11);
    }

    public String getPointLabel(Entry entry) {
        return getFormattedValue(entry.getY());
    }

    @Deprecated
    public String getFormattedValue(float f11, Entry entry, int i11, ViewPortHandler viewPortHandler) {
        return getFormattedValue(f11);
    }

    public String getFormattedValue(float f11) {
        return String.valueOf(f11);
    }
}
