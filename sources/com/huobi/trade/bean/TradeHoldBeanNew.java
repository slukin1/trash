package com.huobi.trade.bean;

import com.huobi.trade.handler.TradeHoldNewViewHandler;

public class TradeHoldBeanNew extends TradeHoldBean {
    private String cost;
    private String debts;
    private String hold;
    private String price;
    private String profit;
    private double profitRatio;
    private int showTitle;
    private String spotBalance;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeHoldBeanNew;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeHoldBeanNew)) {
            return false;
        }
        TradeHoldBeanNew tradeHoldBeanNew = (TradeHoldBeanNew) obj;
        if (!tradeHoldBeanNew.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String hold2 = getHold();
        String hold3 = tradeHoldBeanNew.getHold();
        if (hold2 != null ? !hold2.equals(hold3) : hold3 != null) {
            return false;
        }
        String debts2 = getDebts();
        String debts3 = tradeHoldBeanNew.getDebts();
        if (debts2 != null ? !debts2.equals(debts3) : debts3 != null) {
            return false;
        }
        String spotBalance2 = getSpotBalance();
        String spotBalance3 = tradeHoldBeanNew.getSpotBalance();
        if (spotBalance2 != null ? !spotBalance2.equals(spotBalance3) : spotBalance3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = tradeHoldBeanNew.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String cost2 = getCost();
        String cost3 = tradeHoldBeanNew.getCost();
        if (cost2 != null ? !cost2.equals(cost3) : cost3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = tradeHoldBeanNew.getProfit();
        if (profit2 != null ? profit2.equals(profit3) : profit3 == null) {
            return Double.compare(getProfitRatio(), tradeHoldBeanNew.getProfitRatio()) == 0 && getShowTitle() == tradeHoldBeanNew.getShowTitle();
        }
        return false;
    }

    public String getCost() {
        return this.cost;
    }

    public String getDebts() {
        return this.debts;
    }

    public String getHold() {
        return this.hold;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProfit() {
        return this.profit;
    }

    public double getProfitRatio() {
        return this.profitRatio;
    }

    public int getShowTitle() {
        return this.showTitle;
    }

    public String getSpotBalance() {
        return this.spotBalance;
    }

    public String getViewHandlerName() {
        return TradeHoldNewViewHandler.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String hold2 = getHold();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (hold2 == null ? 43 : hold2.hashCode());
        String debts2 = getDebts();
        int hashCode3 = (hashCode2 * 59) + (debts2 == null ? 43 : debts2.hashCode());
        String spotBalance2 = getSpotBalance();
        int hashCode4 = (hashCode3 * 59) + (spotBalance2 == null ? 43 : spotBalance2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String cost2 = getCost();
        int hashCode6 = (hashCode5 * 59) + (cost2 == null ? 43 : cost2.hashCode());
        String profit2 = getProfit();
        int i12 = hashCode6 * 59;
        if (profit2 != null) {
            i11 = profit2.hashCode();
        }
        long doubleToLongBits = Double.doubleToLongBits(getProfitRatio());
        return ((((i12 + i11) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + getShowTitle();
    }

    public void setCost(String str) {
        this.cost = str;
    }

    public void setDebts(String str) {
        this.debts = str;
    }

    public void setHold(String str) {
        this.hold = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setProfitRatio(double d11) {
        this.profitRatio = d11;
    }

    public void setShowTitle(int i11) {
        this.showTitle = i11;
    }

    public void setSpotBalance(String str) {
        this.spotBalance = str;
    }

    public String toString() {
        return "TradeHoldBeanNew(hold=" + getHold() + ", debts=" + getDebts() + ", spotBalance=" + getSpotBalance() + ", price=" + getPrice() + ", cost=" + getCost() + ", profit=" + getProfit() + ", profitRatio=" + getProfitRatio() + ", showTitle=" + getShowTitle() + ")";
    }
}
