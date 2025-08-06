package com.hbg.module.kline.view.histogram;

import ge.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HistogramChartBean implements Serializable {
    private String coinType = "";
    private List<a> datas = new ArrayList();
    private double totalAmount;

    public String getCoinType() {
        return this.coinType;
    }

    public List<a> getDatas() {
        return this.datas;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setCoinType(String str) {
        this.coinType = str;
    }

    public void setDatas(List<a> list) {
        this.datas = list;
    }

    public void setTotalAmount(double d11) {
        this.totalAmount = d11;
    }
}
