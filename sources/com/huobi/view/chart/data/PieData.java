package com.huobi.view.chart.data;

import com.huobi.view.chart.highlight.Highlight;
import com.huobi.view.chart.interfaces.datasets.IPieDataSet;

public class PieData extends ChartData<IPieDataSet> {
    public PieData() {
    }

    public IPieDataSet getDataSet() {
        return (IPieDataSet) this.mDataSets.get(0);
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        return getDataSet().getEntryForIndex((int) highlight.getX());
    }

    public float getYValueSum() {
        float f11 = 0.0f;
        for (int i11 = 0; i11 < getDataSet().getEntryCount(); i11++) {
            f11 += ((PieEntry) getDataSet().getEntryForIndex(i11)).getY();
        }
        return f11;
    }

    public void setDataSet(IPieDataSet iPieDataSet) {
        this.mDataSets.clear();
        this.mDataSets.add(iPieDataSet);
        notifyDataChanged();
    }

    public PieData(IPieDataSet iPieDataSet) {
        super((T[]) new IPieDataSet[]{iPieDataSet});
    }

    public IPieDataSet getDataSetByIndex(int i11) {
        if (i11 == 0) {
            return getDataSet();
        }
        return null;
    }

    public IPieDataSet getDataSetByLabel(String str, boolean z11) {
        if (z11) {
            if (str.equalsIgnoreCase(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
                return (IPieDataSet) this.mDataSets.get(0);
            }
            return null;
        } else if (str.equals(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
            return (IPieDataSet) this.mDataSets.get(0);
        } else {
            return null;
        }
    }
}
