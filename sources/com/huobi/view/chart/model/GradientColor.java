package com.huobi.view.chart.model;

public class GradientColor {
    private int endColor;
    private int startColor;

    public GradientColor(int i11, int i12) {
        this.startColor = i11;
        this.endColor = i12;
    }

    public int getEndColor() {
        return this.endColor;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public void setEndColor(int i11) {
        this.endColor = i11;
    }

    public void setStartColor(int i11) {
        this.startColor = i11;
    }
}
