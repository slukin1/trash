package com.huobi.view.chart.interfaces.datasets;

import com.huobi.view.chart.data.Entry;

public interface IBarLineScatterCandleBubbleDataSet<T extends Entry> extends IDataSet<T> {
    int getHighLightColor();
}
