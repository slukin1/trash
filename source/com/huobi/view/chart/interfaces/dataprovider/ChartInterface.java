package com.huobi.view.chart.interfaces.dataprovider;

import android.graphics.RectF;
import com.huobi.view.chart.data.ChartData;
import com.huobi.view.chart.formatter.ValueFormatter;
import com.huobi.view.chart.utils.MPPointF;

public interface ChartInterface {
    MPPointF getCenterOfView();

    MPPointF getCenterOffsets();

    RectF getContentRect();

    ChartData getData();

    ValueFormatter getDefaultValueFormatter();

    int getHeight();

    float getMaxHighlightDistance();

    int getMaxVisibleCount();

    int getWidth();

    float getXChartMax();

    float getXChartMin();

    float getXRange();

    float getYChartMax();

    float getYChartMin();
}
