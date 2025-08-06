package com.hbg.lib.network.hbg.core.bean;

public class AssertsTradeData {
    private String balance;
    private String convertBalance;
    private String cost;
    private String currency;
    private String debts;
    private String holdBalance;
    private String marketBuy;
    private String profit;
    private double profitRate;
    private double proportion;
    private String spotBalance;
    private String total;

    public boolean canEqual(Object obj) {
        return obj instanceof AssertsTradeData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssertsTradeData)) {
            return false;
        }
        AssertsTradeData assertsTradeData = (AssertsTradeData) obj;
        if (!assertsTradeData.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = assertsTradeData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String balance2 = getBalance();
        String balance3 = assertsTradeData.getBalance();
        if (balance2 != null ? !balance2.equals(balance3) : balance3 != null) {
            return false;
        }
        String total2 = getTotal();
        String total3 = assertsTradeData.getTotal();
        if (total2 != null ? !total2.equals(total3) : total3 != null) {
            return false;
        }
        if (Double.compare(getProportion(), assertsTradeData.getProportion()) != 0) {
            return false;
        }
        String convertBalance2 = getConvertBalance();
        String convertBalance3 = assertsTradeData.getConvertBalance();
        if (convertBalance2 != null ? !convertBalance2.equals(convertBalance3) : convertBalance3 != null) {
            return false;
        }
        String holdBalance2 = getHoldBalance();
        String holdBalance3 = assertsTradeData.getHoldBalance();
        if (holdBalance2 != null ? !holdBalance2.equals(holdBalance3) : holdBalance3 != null) {
            return false;
        }
        String spotBalance2 = getSpotBalance();
        String spotBalance3 = assertsTradeData.getSpotBalance();
        if (spotBalance2 != null ? !spotBalance2.equals(spotBalance3) : spotBalance3 != null) {
            return false;
        }
        String debts2 = getDebts();
        String debts3 = assertsTradeData.getDebts();
        if (debts2 != null ? !debts2.equals(debts3) : debts3 != null) {
            return false;
        }
        String marketBuy2 = getMarketBuy();
        String marketBuy3 = assertsTradeData.getMarketBuy();
        if (marketBuy2 != null ? !marketBuy2.equals(marketBuy3) : marketBuy3 != null) {
            return false;
        }
        String cost2 = getCost();
        String cost3 = assertsTradeData.getCost();
        if (cost2 != null ? !cost2.equals(cost3) : cost3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = assertsTradeData.getProfit();
        if (profit2 != null ? profit2.equals(profit3) : profit3 == null) {
            return Double.compare(getProfitRate(), assertsTradeData.getProfitRate()) == 0;
        }
        return false;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getConvertBalance() {
        return this.convertBalance;
    }

    public String getCost() {
        return this.cost;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDebts() {
        return this.debts;
    }

    public String getHoldBalance() {
        return this.holdBalance;
    }

    public String getMarketBuy() {
        return this.marketBuy;
    }

    public String getProfit() {
        return this.profit;
    }

    public double getProfitRate() {
        return this.profitRate;
    }

    public double getProportion() {
        return this.proportion;
    }

    public String getSpotBalance() {
        return this.spotBalance;
    }

    public String getTotal() {
        return this.total;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String balance2 = getBalance();
        int hashCode2 = ((hashCode + 59) * 59) + (balance2 == null ? 43 : balance2.hashCode());
        String total2 = getTotal();
        int hashCode3 = (hashCode2 * 59) + (total2 == null ? 43 : total2.hashCode());
        long doubleToLongBits = Double.doubleToLongBits(getProportion());
        int i12 = (hashCode3 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        String convertBalance2 = getConvertBalance();
        int hashCode4 = (i12 * 59) + (convertBalance2 == null ? 43 : convertBalance2.hashCode());
        String holdBalance2 = getHoldBalance();
        int hashCode5 = (hashCode4 * 59) + (holdBalance2 == null ? 43 : holdBalance2.hashCode());
        String spotBalance2 = getSpotBalance();
        int hashCode6 = (hashCode5 * 59) + (spotBalance2 == null ? 43 : spotBalance2.hashCode());
        String debts2 = getDebts();
        int hashCode7 = (hashCode6 * 59) + (debts2 == null ? 43 : debts2.hashCode());
        String marketBuy2 = getMarketBuy();
        int hashCode8 = (hashCode7 * 59) + (marketBuy2 == null ? 43 : marketBuy2.hashCode());
        String cost2 = getCost();
        int hashCode9 = (hashCode8 * 59) + (cost2 == null ? 43 : cost2.hashCode());
        String profit2 = getProfit();
        int i13 = hashCode9 * 59;
        if (profit2 != null) {
            i11 = profit2.hashCode();
        }
        long doubleToLongBits2 = Double.doubleToLongBits(getProfitRate());
        return ((i13 + i11) * 59) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setConvertBalance(String str) {
        this.convertBalance = str;
    }

    public void setCost(String str) {
        this.cost = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDebts(String str) {
        this.debts = str;
    }

    public void setHoldBalance(String str) {
        this.holdBalance = str;
    }

    public void setMarketBuy(String str) {
        this.marketBuy = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setProfitRate(double d11) {
        this.profitRate = d11;
    }

    public void setProportion(double d11) {
        this.proportion = d11;
    }

    public void setSpotBalance(String str) {
        this.spotBalance = str;
    }

    public void setTotal(String str) {
        this.total = str;
    }

    public String toString() {
        return "AssertsTradeData(currency=" + getCurrency() + ", balance=" + getBalance() + ", total=" + getTotal() + ", proportion=" + getProportion() + ", convertBalance=" + getConvertBalance() + ", holdBalance=" + getHoldBalance() + ", spotBalance=" + getSpotBalance() + ", debts=" + getDebts() + ", marketBuy=" + getMarketBuy() + ", cost=" + getCost() + ", profit=" + getProfit() + ", profitRate=" + getProfitRate() + ")";
    }
}
