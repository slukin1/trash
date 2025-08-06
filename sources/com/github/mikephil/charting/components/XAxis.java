package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

public class XAxis extends AxisBase {
    public int I = 1;
    public int J = 1;
    public int K = 1;
    public int L = 1;
    public float M = 0.0f;
    public boolean N = false;
    public XAxisPosition O = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.f65414c = Utils.e(4.0f);
    }

    public float O() {
        return this.M;
    }

    public XAxisPosition P() {
        return this.O;
    }

    public boolean Q() {
        return this.N;
    }

    public void R(XAxisPosition xAxisPosition) {
        this.O = xAxisPosition;
    }
}
