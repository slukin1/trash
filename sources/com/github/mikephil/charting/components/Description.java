package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class Description extends ComponentBase {

    /* renamed from: g  reason: collision with root package name */
    public String f65418g = "Description Label";

    /* renamed from: h  reason: collision with root package name */
    public MPPointF f65419h;

    /* renamed from: i  reason: collision with root package name */
    public Paint.Align f65420i = Paint.Align.RIGHT;

    public Description() {
        this.f65416e = Utils.e(8.0f);
    }

    public MPPointF j() {
        return this.f65419h;
    }

    public String k() {
        return this.f65418g;
    }

    public Paint.Align l() {
        return this.f65420i;
    }
}
