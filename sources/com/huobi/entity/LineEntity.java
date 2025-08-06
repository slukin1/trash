package com.huobi.entity;

import java.util.ArrayList;
import java.util.List;

public class LineEntity {
    private boolean display = true;
    private int divider;
    private int lineColor;
    private List<Double> lineData;
    private String title;

    public LineEntity() {
    }

    public int getDivider() {
        return this.divider;
    }

    public int getLineColor() {
        return this.lineColor;
    }

    public List<Double> getLineData() {
        return this.lineData;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isDisplay() {
        return this.display;
    }

    public void put(Double d11) {
        if (this.lineData == null) {
            this.lineData = new ArrayList();
        }
        this.lineData.add(d11);
    }

    public void setDisplay(boolean z11) {
        this.display = z11;
    }

    public void setDivider(int i11) {
        this.divider = i11;
    }

    public void setLineColor(int i11) {
        this.lineColor = i11;
    }

    public void setLineData(List<Double> list) {
        this.lineData = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public LineEntity(List<Double> list, String str, int i11) {
        this.lineData = list;
        this.title = str;
        this.lineColor = i11;
    }
}
