package com.huobi.view.chart.highlight;

import com.huobi.view.chart.PieChart;
import com.huobi.view.chart.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {
    public T mChart;
    public List<Highlight> mHighlightBuffer = new ArrayList();

    public PieRadarHighlighter(T t11) {
        this.mChart = t11;
    }

    public abstract Highlight getClosestHighlight(int i11, float f11, float f12);

    public Highlight getHighlight(float f11, float f12) {
        if (this.mChart.distanceToCenter(f11, f12) > this.mChart.getRadius()) {
            return null;
        }
        float angleForPoint = this.mChart.getAngleForPoint(f11, f12);
        T t11 = this.mChart;
        if (t11 instanceof PieChart) {
            angleForPoint /= t11.getAnimator().getPhaseY();
        }
        int indexForAngle = this.mChart.getIndexForAngle(angleForPoint);
        if (indexForAngle < 0 || indexForAngle >= this.mChart.getData().getMaxEntryCountSet().getEntryCount()) {
            return null;
        }
        return getClosestHighlight(indexForAngle, f11, f12);
    }
}
