package com.github.mikephil.charting.data;

import g5.b;

public abstract class BarLineScatterCandleBubbleData<T extends b<? extends Entry>> extends ChartData<T> {
    public BarLineScatterCandleBubbleData() {
    }

    public BarLineScatterCandleBubbleData(T... tArr) {
        super(tArr);
    }
}
