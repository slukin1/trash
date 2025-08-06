package com.huobi.view.chart.formatter;

import com.huobi.view.chart.PieChart;
import com.huobi.view.chart.data.PieEntry;
import java.text.DecimalFormat;

public class PercentFormatter extends ValueFormatter {
    public DecimalFormat mFormat;
    private PieChart pieChart;

    public PercentFormatter() {
        this.mFormat = new DecimalFormat("###,###,##0.0");
    }

    public String getFormattedValue(float f11) {
        return this.mFormat.format((double) f11) + " %";
    }

    public String getPieLabel(float f11, PieEntry pieEntry) {
        PieChart pieChart2 = this.pieChart;
        if (pieChart2 == null || !pieChart2.isUsePercentValuesEnabled()) {
            return this.mFormat.format((double) f11);
        }
        return getFormattedValue(f11);
    }

    public PercentFormatter(PieChart pieChart2) {
        this();
        this.pieChart = pieChart2;
    }
}
