package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

public class LimitLine extends ComponentBase {

    /* renamed from: g  reason: collision with root package name */
    public float f65449g;

    /* renamed from: h  reason: collision with root package name */
    public float f65450h;

    /* renamed from: i  reason: collision with root package name */
    public int f65451i;

    /* renamed from: j  reason: collision with root package name */
    public Paint.Style f65452j;

    /* renamed from: k  reason: collision with root package name */
    public String f65453k;

    /* renamed from: l  reason: collision with root package name */
    public DashPathEffect f65454l;

    /* renamed from: m  reason: collision with root package name */
    public LimitLabelPosition f65455m;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public DashPathEffect j() {
        return this.f65454l;
    }

    public String k() {
        return this.f65453k;
    }

    public LimitLabelPosition l() {
        return this.f65455m;
    }

    public float m() {
        return this.f65449g;
    }

    public int n() {
        return this.f65451i;
    }

    public float o() {
        return this.f65450h;
    }

    public Paint.Style p() {
        return this.f65452j;
    }
}
