package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

@SuppressLint({"ParcelCreator"})
public class RadarEntry extends Entry {
    public RadarEntry(float f11) {
        super(0.0f, f11);
    }

    public float getValue() {
        return getY();
    }

    @Deprecated
    public float getX() {
        return super.getX();
    }

    @Deprecated
    public void setX(float f11) {
        super.setX(f11);
    }

    public RadarEntry(float f11, Object obj) {
        super(0.0f, f11, obj);
    }

    public RadarEntry copy() {
        return new RadarEntry(getY(), getData());
    }
}
