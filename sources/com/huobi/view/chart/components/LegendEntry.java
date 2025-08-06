package com.huobi.view.chart.components;

import android.graphics.DashPathEffect;
import com.huobi.view.chart.components.Legend;
import com.huobi.view.chart.utils.ColorTemplate;

public class LegendEntry {
    public Legend.LegendForm form = Legend.LegendForm.DEFAULT;
    public int formColor = ColorTemplate.COLOR_NONE;
    public DashPathEffect formLineDashEffect = null;
    public float formLineWidth = Float.NaN;
    public float formSize = Float.NaN;
    public String label;

    public LegendEntry() {
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f11, float f12, DashPathEffect dashPathEffect, int i11) {
        this.label = str;
        this.form = legendForm;
        this.formSize = f11;
        this.formLineWidth = f12;
        this.formLineDashEffect = dashPathEffect;
        this.formColor = i11;
    }
}
