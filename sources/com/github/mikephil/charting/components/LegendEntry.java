package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;
import com.huobi.view.chart.utils.ColorTemplate;

public class LegendEntry {

    /* renamed from: a  reason: collision with root package name */
    public String f65443a;

    /* renamed from: b  reason: collision with root package name */
    public Legend.LegendForm f65444b = Legend.LegendForm.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    public float f65445c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    public float f65446d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    public DashPathEffect f65447e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f65448f = ColorTemplate.COLOR_NONE;

    public LegendEntry() {
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f11, float f12, DashPathEffect dashPathEffect, int i11) {
        this.f65443a = str;
        this.f65444b = legendForm;
        this.f65445c = f11;
        this.f65446d = f12;
        this.f65447e = dashPathEffect;
        this.f65448f = i11;
    }
}
