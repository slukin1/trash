package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class StopCurrencyCostBean implements Serializable {
    private String avgCost;
    private String currency;
    private String profit;
    private String profitRate;
    private String todayProfit;
    private String todayProfitRate;

    public boolean canEqual(Object obj) {
        return obj instanceof StopCurrencyCostBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StopCurrencyCostBean)) {
            return false;
        }
        StopCurrencyCostBean stopCurrencyCostBean = (StopCurrencyCostBean) obj;
        if (!stopCurrencyCostBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = stopCurrencyCostBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String avgCost2 = getAvgCost();
        String avgCost3 = stopCurrencyCostBean.getAvgCost();
        if (avgCost2 != null ? !avgCost2.equals(avgCost3) : avgCost3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = stopCurrencyCostBean.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        String profitRate2 = getProfitRate();
        String profitRate3 = stopCurrencyCostBean.getProfitRate();
        if (profitRate2 != null ? !profitRate2.equals(profitRate3) : profitRate3 != null) {
            return false;
        }
        String todayProfit2 = getTodayProfit();
        String todayProfit3 = stopCurrencyCostBean.getTodayProfit();
        if (todayProfit2 != null ? !todayProfit2.equals(todayProfit3) : todayProfit3 != null) {
            return false;
        }
        String todayProfitRate2 = getTodayProfitRate();
        String todayProfitRate3 = stopCurrencyCostBean.getTodayProfitRate();
        return todayProfitRate2 != null ? todayProfitRate2.equals(todayProfitRate3) : todayProfitRate3 == null;
    }

    public String getAvgCost() {
        return this.avgCost;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getProfit() {
        return this.profit;
    }

    public String getProfitRate() {
        return this.profitRate;
    }

    public String getTodayProfit() {
        return this.todayProfit;
    }

    public String getTodayProfitRate() {
        return this.todayProfitRate;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String avgCost2 = getAvgCost();
        int hashCode2 = ((hashCode + 59) * 59) + (avgCost2 == null ? 43 : avgCost2.hashCode());
        String profit2 = getProfit();
        int hashCode3 = (hashCode2 * 59) + (profit2 == null ? 43 : profit2.hashCode());
        String profitRate2 = getProfitRate();
        int hashCode4 = (hashCode3 * 59) + (profitRate2 == null ? 43 : profitRate2.hashCode());
        String todayProfit2 = getTodayProfit();
        int hashCode5 = (hashCode4 * 59) + (todayProfit2 == null ? 43 : todayProfit2.hashCode());
        String todayProfitRate2 = getTodayProfitRate();
        int i12 = hashCode5 * 59;
        if (todayProfitRate2 != null) {
            i11 = todayProfitRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvgCost(String str) {
        this.avgCost = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setProfitRate(String str) {
        this.profitRate = str;
    }

    public void setTodayProfit(String str) {
        this.todayProfit = str;
    }

    public void setTodayProfitRate(String str) {
        this.todayProfitRate = str;
    }

    public String toString() {
        return "StopCurrencyCostBean(currency=" + getCurrency() + ", avgCost=" + getAvgCost() + ", profit=" + getProfit() + ", profitRate=" + getProfitRate() + ", todayProfit=" + getTodayProfit() + ", todayProfitRate=" + getTodayProfitRate() + ")";
    }
}
