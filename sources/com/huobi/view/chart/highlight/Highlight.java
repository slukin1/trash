package com.huobi.view.chart.highlight;

import com.huobi.view.chart.components.YAxis;

public class Highlight {
    private YAxis.AxisDependency axis;
    private int mDataIndex;
    private int mDataSetIndex;
    private float mDrawX;
    private float mDrawY;
    private int mStackIndex;
    private float mX;
    private float mXPx;
    private float mY;
    private float mYPx;

    public Highlight(float f11, float f12, int i11) {
        this.mX = Float.NaN;
        this.mY = Float.NaN;
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f11;
        this.mY = f12;
        this.mDataSetIndex = i11;
    }

    public boolean equalTo(Highlight highlight) {
        return highlight != null && this.mDataSetIndex == highlight.mDataSetIndex && this.mX == highlight.mX && this.mStackIndex == highlight.mStackIndex && this.mDataIndex == highlight.mDataIndex;
    }

    public YAxis.AxisDependency getAxis() {
        return this.axis;
    }

    public int getDataIndex() {
        return this.mDataIndex;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public float getDrawX() {
        return this.mDrawX;
    }

    public float getDrawY() {
        return this.mDrawY;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public float getX() {
        return this.mX;
    }

    public float getXPx() {
        return this.mXPx;
    }

    public float getY() {
        return this.mY;
    }

    public float getYPx() {
        return this.mYPx;
    }

    public boolean isStacked() {
        return this.mStackIndex >= 0;
    }

    public void setDataIndex(int i11) {
        this.mDataIndex = i11;
    }

    public void setDraw(float f11, float f12) {
        this.mDrawX = f11;
        this.mDrawY = f12;
    }

    public String toString() {
        return "Highlight, x: " + this.mX + ", y: " + this.mY + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }

    public Highlight(float f11, int i11, int i12) {
        this(f11, Float.NaN, i11);
        this.mStackIndex = i12;
    }

    public Highlight(float f11, float f12, float f13, float f14, int i11, YAxis.AxisDependency axisDependency) {
        this.mX = Float.NaN;
        this.mY = Float.NaN;
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = f11;
        this.mY = f12;
        this.mXPx = f13;
        this.mYPx = f14;
        this.mDataSetIndex = i11;
        this.axis = axisDependency;
    }

    public Highlight(float f11, float f12, float f13, float f14, int i11, int i12, YAxis.AxisDependency axisDependency) {
        this(f11, f12, f13, f14, i11, axisDependency);
        this.mStackIndex = i12;
    }
}
