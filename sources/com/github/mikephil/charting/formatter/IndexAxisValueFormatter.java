package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import d5.c;

public class IndexAxisValueFormatter implements c {

    /* renamed from: a  reason: collision with root package name */
    public String[] f65494a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public int f65495b = 0;

    public String a(float f11, AxisBase axisBase) {
        int round = Math.round(f11);
        return (round < 0 || round >= this.f65495b || round != ((int) f11)) ? "" : this.f65494a[round];
    }
}
