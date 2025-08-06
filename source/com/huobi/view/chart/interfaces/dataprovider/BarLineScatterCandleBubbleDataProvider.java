package com.huobi.view.chart.interfaces.dataprovider;

import com.huobi.view.chart.components.YAxis;
import com.huobi.view.chart.data.BarLineScatterCandleBubbleData;
import com.huobi.view.chart.data.ChartData;
import com.huobi.view.chart.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {
    BarLineScatterCandleBubbleData getData();

    /* bridge */ /* synthetic */ ChartData getData();

    float getHighestVisibleX();

    float getLowestVisibleX();

    Transformer getTransformer(YAxis.AxisDependency axisDependency);

    boolean isInverted(YAxis.AxisDependency axisDependency);
}
