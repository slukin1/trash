package com.huobi.view.chart.highlight;

import com.huobi.view.chart.components.YAxis;
import com.huobi.view.chart.data.BarLineScatterCandleBubbleData;
import com.huobi.view.chart.data.DataSet;
import com.huobi.view.chart.data.Entry;
import com.huobi.view.chart.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.huobi.view.chart.interfaces.datasets.IDataSet;
import com.huobi.view.chart.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
    public T mChart;
    public List<Highlight> mHighlightBuffer = new ArrayList();

    public ChartHighlighter(T t11) {
        this.mChart = t11;
    }

    public List<Highlight> buildHighlights(IDataSet iDataSet, int i11, float f11, DataSet.Rounding rounding) {
        Entry entryForXValue;
        ArrayList arrayList = new ArrayList();
        List<Entry> entriesForXValue = iDataSet.getEntriesForXValue(f11);
        if (entriesForXValue.size() == 0 && (entryForXValue = iDataSet.getEntryForXValue(f11, Float.NaN, rounding)) != null) {
            entriesForXValue = iDataSet.getEntriesForXValue(entryForXValue.getX());
        }
        if (entriesForXValue.size() == 0) {
            return arrayList;
        }
        for (Entry entry : entriesForXValue) {
            MPPointD pixelForValues = this.mChart.getTransformer(iDataSet.getAxisDependency()).getPixelForValues(entry.getX(), entry.getY());
            arrayList.add(new Highlight(entry.getX(), entry.getY(), (float) pixelForValues.f19014x, (float) pixelForValues.f19015y, i11, iDataSet.getAxisDependency()));
        }
        return arrayList;
    }

    public Highlight getClosestHighlightByPixel(List<Highlight> list, float f11, float f12, YAxis.AxisDependency axisDependency, float f13) {
        Highlight highlight = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Highlight highlight2 = list.get(i11);
            if (axisDependency == null || highlight2.getAxis() == axisDependency) {
                float distance = getDistance(f11, f12, highlight2.getXPx(), highlight2.getYPx());
                if (distance < f13) {
                    highlight = highlight2;
                    f13 = distance;
                }
            }
        }
        return highlight;
    }

    public BarLineScatterCandleBubbleData getData() {
        return this.mChart.getData();
    }

    public float getDistance(float f11, float f12, float f13, float f14) {
        return (float) Math.hypot((double) (f11 - f13), (double) (f12 - f14));
    }

    public Highlight getHighlight(float f11, float f12) {
        MPPointD valsForTouch = getValsForTouch(f11, f12);
        MPPointD.recycleInstance(valsForTouch);
        return getHighlightForX((float) valsForTouch.f19014x, f11, f12);
    }

    public Highlight getHighlightForX(float f11, float f12, float f13) {
        List<Highlight> highlightsAtXValue = getHighlightsAtXValue(f11, f12, f13);
        if (highlightsAtXValue.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float minimumDistance = getMinimumDistance(highlightsAtXValue, f13, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return getClosestHighlightByPixel(highlightsAtXValue, f12, f13, minimumDistance < getMinimumDistance(highlightsAtXValue, f13, axisDependency2) ? axisDependency : axisDependency2, this.mChart.getMaxHighlightDistance());
    }

    public float getHighlightPos(Highlight highlight) {
        return highlight.getYPx();
    }

    public List<Highlight> getHighlightsAtXValue(float f11, float f12, float f13) {
        this.mHighlightBuffer.clear();
        BarLineScatterCandleBubbleData data = getData();
        if (data == null) {
            return this.mHighlightBuffer;
        }
        int dataSetCount = data.getDataSetCount();
        for (int i11 = 0; i11 < dataSetCount; i11++) {
            IDataSet dataSetByIndex = data.getDataSetByIndex(i11);
            if (dataSetByIndex.isHighlightEnabled()) {
                this.mHighlightBuffer.addAll(buildHighlights(dataSetByIndex, i11, f11, DataSet.Rounding.CLOSEST));
            }
        }
        return this.mHighlightBuffer;
    }

    public float getMinimumDistance(List<Highlight> list, float f11, YAxis.AxisDependency axisDependency) {
        float f12 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < list.size(); i11++) {
            Highlight highlight = list.get(i11);
            if (highlight.getAxis() == axisDependency) {
                float abs = Math.abs(getHighlightPos(highlight) - f11);
                if (abs < f12) {
                    f12 = abs;
                }
            }
        }
        return f12;
    }

    public MPPointD getValsForTouch(float f11, float f12) {
        return this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f11, f12);
    }
}
