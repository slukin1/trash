package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import d5.d;
import f5.g;
import g5.f;

public class DefaultFillFormatter implements d {
    public float a(f fVar, g gVar) {
        float yChartMax = gVar.getYChartMax();
        float yChartMin = gVar.getYChartMin();
        LineData lineData = gVar.getLineData();
        if (fVar.getYMax() > 0.0f && fVar.getYMin() < 0.0f) {
            return 0.0f;
        }
        if (lineData.o() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.q() < 0.0f) {
            yChartMin = 0.0f;
        }
        return fVar.getYMin() >= 0.0f ? yChartMin : yChartMax;
    }
}
