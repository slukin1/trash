package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;

@SuppressLint({"ParcelCreator"})
public class PieEntry extends Entry {
    private String label;

    public PieEntry(float f11) {
        super(0.0f, f11);
    }

    public String getLabel() {
        return this.label;
    }

    public float getValue() {
        return getY();
    }

    @Deprecated
    public float getX() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.getX();
    }

    public void setLabel(String str) {
        this.label = str;
    }

    @Deprecated
    public void setX(float f11) {
        super.setX(f11);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    public PieEntry(float f11, Object obj) {
        super(0.0f, f11, obj);
    }

    public PieEntry copy() {
        return new PieEntry(getY(), this.label, getData());
    }

    public PieEntry(float f11, Drawable drawable) {
        super(0.0f, f11, drawable);
    }

    public PieEntry(float f11, Drawable drawable, Object obj) {
        super(0.0f, f11, drawable, obj);
    }

    public PieEntry(float f11, String str) {
        super(0.0f, f11);
        this.label = str;
    }

    public PieEntry(float f11, String str, Object obj) {
        super(0.0f, f11, obj);
        this.label = str;
    }

    public PieEntry(float f11, String str, Drawable drawable) {
        super(0.0f, f11, drawable);
        this.label = str;
    }

    public PieEntry(float f11, String str, Drawable drawable, Object obj) {
        super(0.0f, f11, drawable, obj);
        this.label = str;
    }
}
