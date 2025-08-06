package com.huobi.view.chart.listener;

import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.highlight.Highlight;

public interface OnChartValueSelectedListener {
    void onNothingSelected();

    void onValueSelected(Entry entry, Highlight highlight);
}
