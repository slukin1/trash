package com.huobi.view.chart.highlight;

public final class Range {
    public float from;

    /* renamed from: to  reason: collision with root package name */
    public float f19010to;

    public Range(float f11, float f12) {
        this.from = f11;
        this.f19010to = f12;
    }

    public boolean contains(float f11) {
        return f11 > this.from && f11 <= this.f19010to;
    }

    public boolean isLarger(float f11) {
        return f11 > this.f19010to;
    }

    public boolean isSmaller(float f11) {
        return f11 < this.from;
    }
}
