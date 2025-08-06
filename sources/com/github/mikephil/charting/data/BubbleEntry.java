package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
public class BubbleEntry extends Entry {
    private float mSize = 0.0f;

    public BubbleEntry(float f11, float f12, float f13) {
        super(f11, f12);
        this.mSize = f13;
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float f11) {
        this.mSize = f11;
    }

    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.mSize, getData());
    }

    public BubbleEntry(float f11, float f12, float f13, Object obj) {
        super(f11, f12, obj);
        this.mSize = f13;
    }

    public BubbleEntry(float f11, float f12, float f13, Drawable drawable) {
        super(f11, f12, drawable);
        this.mSize = f13;
    }

    public BubbleEntry(float f11, float f12, float f13, Drawable drawable, Object obj) {
        super(f11, f12, drawable, obj);
        this.mSize = f13;
    }
}
