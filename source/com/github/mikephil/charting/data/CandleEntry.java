package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
public class CandleEntry extends Entry {
    private float mClose = 0.0f;
    private float mOpen = 0.0f;
    private float mShadowHigh = 0.0f;
    private float mShadowLow = 0.0f;

    public CandleEntry(float f11, float f12, float f13, float f14, float f15) {
        super(f11, (f12 + f13) / 2.0f);
        this.mShadowHigh = f12;
        this.mShadowLow = f13;
        this.mOpen = f14;
        this.mClose = f15;
    }

    public float getBodyRange() {
        return Math.abs(this.mOpen - this.mClose);
    }

    public float getClose() {
        return this.mClose;
    }

    public float getHigh() {
        return this.mShadowHigh;
    }

    public float getLow() {
        return this.mShadowLow;
    }

    public float getOpen() {
        return this.mOpen;
    }

    public float getShadowRange() {
        return Math.abs(this.mShadowHigh - this.mShadowLow);
    }

    public float getY() {
        return super.getY();
    }

    public void setClose(float f11) {
        this.mClose = f11;
    }

    public void setHigh(float f11) {
        this.mShadowHigh = f11;
    }

    public void setLow(float f11) {
        this.mShadowLow = f11;
    }

    public void setOpen(float f11) {
        this.mOpen = f11;
    }

    public CandleEntry copy() {
        return new CandleEntry(getX(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
    }

    public CandleEntry(float f11, float f12, float f13, float f14, float f15, Object obj) {
        super(f11, (f12 + f13) / 2.0f, obj);
        this.mShadowHigh = f12;
        this.mShadowLow = f13;
        this.mOpen = f14;
        this.mClose = f15;
    }

    public CandleEntry(float f11, float f12, float f13, float f14, float f15, Drawable drawable) {
        super(f11, (f12 + f13) / 2.0f, drawable);
        this.mShadowHigh = f12;
        this.mShadowLow = f13;
        this.mOpen = f14;
        this.mClose = f15;
    }

    public CandleEntry(float f11, float f12, float f13, float f14, float f15, Drawable drawable, Object obj) {
        super(f11, (f12 + f13) / 2.0f, drawable, obj);
        this.mShadowHigh = f12;
        this.mShadowLow = f13;
        this.mOpen = f14;
        this.mClose = f15;
    }
}
