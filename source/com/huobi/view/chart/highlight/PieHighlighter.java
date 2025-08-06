package com.huobi.view.chart.highlight;

import com.huobi.view.chart.PieChart;
import com.huobi.view.chart.data.PieData;
import com.huobi.view.chart.interfaces.datasets.IPieDataSet;

public class PieHighlighter extends PieRadarHighlighter<PieChart> {
    public PieHighlighter(PieChart pieChart) {
        super(pieChart);
    }

    public Highlight getClosestHighlight(int i11, float f11, float f12) {
        IPieDataSet dataSet = ((PieData) ((PieChart) this.mChart).getData()).getDataSet();
        return new Highlight((float) i11, dataSet.getEntryForIndex(i11).getY(), f11, f12, 0, dataSet.getAxisDependency());
    }
}
