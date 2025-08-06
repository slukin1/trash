package com.huobi.view.chart.formatter;

import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.utils.ViewPortHandler;

@Deprecated
public interface IValueFormatter {
    @Deprecated
    String getFormattedValue(float f11, Entry entry, int i11, ViewPortHandler viewPortHandler);
}
