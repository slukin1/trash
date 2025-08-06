package com.huobi.view.barchart;

import java.io.Serializable;
import java.util.List;

public class BarChartBean implements Serializable {
    private List<BarChartItem> amounts;
    private double totalAmount;

    public static class BarChartItem implements Serializable {
        private double amount;
        private String label;

        public double getAmount() {
            return this.amount;
        }

        public String getLabel() {
            return this.label;
        }

        public void setAmount(double d11) {
            this.amount = d11;
        }

        public void setLabel(String str) {
            this.label = str;
        }
    }

    public List<BarChartItem> getAmounts() {
        return this.amounts;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setAmounts(List<BarChartItem> list) {
        this.amounts = list;
    }

    public void setTotalAmount(double d11) {
        this.totalAmount = d11;
    }
}
