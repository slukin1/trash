package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ExchangeSettings implements Serializable {
    private static final long serialVersionUID = -8097086112543128869L;
    @SerializedName("buy-limit-must-less-than")
    private String buyLimitMustLessThan;
    @SerializedName("market-buy-order-rate-must-less-than")
    private String buyMarketMustLessThan;
    @SerializedName("circuit-break-when-greater-than")
    private String circuitBreakWhenGreaterThan;
    @SerializedName("circuit-break-when-less-than")
    private String circuitBreakWhenLessThan;
    @SerializedName("limit-order-must-greater-than")
    private String limitOrderMustGreaterThan;
    @SerializedName("limit-order-must-less-than")
    private String limitOrderMustLessThan;
    @SerializedName("market-bs-calc-max-scale")
    private String marketBSCalcMaxScale;
    @SerializedName("market-buy-order-must-greater-than")
    private String marketBuyOrderMustGreaterThan;
    @SerializedName("market-buy-order-must-less-than")
    private String marketBuyOrderMustLessThan;
    @SerializedName("market-sell-order-must-greater-than")
    private String marketSellOrderMustGreaterThan;
    @SerializedName("market-sell-order-must-less-than")
    private String marketSellOrderMustLessThan;
    @SerializedName("sell-limit-must-greater-than")
    private String sellLimitMustGreaterThan;
    @SerializedName("market-sell-order-rate-must-less-than")
    private String sellMarketMustGreaterThan;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ExchangeSettings;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExchangeSettings)) {
            return false;
        }
        ExchangeSettings exchangeSettings = (ExchangeSettings) obj;
        if (!exchangeSettings.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = exchangeSettings.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String buyMarketMustLessThan2 = getBuyMarketMustLessThan();
        String buyMarketMustLessThan3 = exchangeSettings.getBuyMarketMustLessThan();
        if (buyMarketMustLessThan2 != null ? !buyMarketMustLessThan2.equals(buyMarketMustLessThan3) : buyMarketMustLessThan3 != null) {
            return false;
        }
        String sellMarketMustGreaterThan2 = getSellMarketMustGreaterThan();
        String sellMarketMustGreaterThan3 = exchangeSettings.getSellMarketMustGreaterThan();
        if (sellMarketMustGreaterThan2 != null ? !sellMarketMustGreaterThan2.equals(sellMarketMustGreaterThan3) : sellMarketMustGreaterThan3 != null) {
            return false;
        }
        String buyLimitMustLessThan2 = getBuyLimitMustLessThan();
        String buyLimitMustLessThan3 = exchangeSettings.getBuyLimitMustLessThan();
        if (buyLimitMustLessThan2 != null ? !buyLimitMustLessThan2.equals(buyLimitMustLessThan3) : buyLimitMustLessThan3 != null) {
            return false;
        }
        String sellLimitMustGreaterThan2 = getSellLimitMustGreaterThan();
        String sellLimitMustGreaterThan3 = exchangeSettings.getSellLimitMustGreaterThan();
        if (sellLimitMustGreaterThan2 != null ? !sellLimitMustGreaterThan2.equals(sellLimitMustGreaterThan3) : sellLimitMustGreaterThan3 != null) {
            return false;
        }
        String limitOrderMustGreaterThan2 = getLimitOrderMustGreaterThan();
        String limitOrderMustGreaterThan3 = exchangeSettings.getLimitOrderMustGreaterThan();
        if (limitOrderMustGreaterThan2 != null ? !limitOrderMustGreaterThan2.equals(limitOrderMustGreaterThan3) : limitOrderMustGreaterThan3 != null) {
            return false;
        }
        String limitOrderMustLessThan2 = getLimitOrderMustLessThan();
        String limitOrderMustLessThan3 = exchangeSettings.getLimitOrderMustLessThan();
        if (limitOrderMustLessThan2 != null ? !limitOrderMustLessThan2.equals(limitOrderMustLessThan3) : limitOrderMustLessThan3 != null) {
            return false;
        }
        String marketBuyOrderMustGreaterThan2 = getMarketBuyOrderMustGreaterThan();
        String marketBuyOrderMustGreaterThan3 = exchangeSettings.getMarketBuyOrderMustGreaterThan();
        if (marketBuyOrderMustGreaterThan2 != null ? !marketBuyOrderMustGreaterThan2.equals(marketBuyOrderMustGreaterThan3) : marketBuyOrderMustGreaterThan3 != null) {
            return false;
        }
        String marketBuyOrderMustLessThan2 = getMarketBuyOrderMustLessThan();
        String marketBuyOrderMustLessThan3 = exchangeSettings.getMarketBuyOrderMustLessThan();
        if (marketBuyOrderMustLessThan2 != null ? !marketBuyOrderMustLessThan2.equals(marketBuyOrderMustLessThan3) : marketBuyOrderMustLessThan3 != null) {
            return false;
        }
        String marketSellOrderMustGreaterThan2 = getMarketSellOrderMustGreaterThan();
        String marketSellOrderMustGreaterThan3 = exchangeSettings.getMarketSellOrderMustGreaterThan();
        if (marketSellOrderMustGreaterThan2 != null ? !marketSellOrderMustGreaterThan2.equals(marketSellOrderMustGreaterThan3) : marketSellOrderMustGreaterThan3 != null) {
            return false;
        }
        String marketSellOrderMustLessThan2 = getMarketSellOrderMustLessThan();
        String marketSellOrderMustLessThan3 = exchangeSettings.getMarketSellOrderMustLessThan();
        if (marketSellOrderMustLessThan2 != null ? !marketSellOrderMustLessThan2.equals(marketSellOrderMustLessThan3) : marketSellOrderMustLessThan3 != null) {
            return false;
        }
        String circuitBreakWhenGreaterThan2 = getCircuitBreakWhenGreaterThan();
        String circuitBreakWhenGreaterThan3 = exchangeSettings.getCircuitBreakWhenGreaterThan();
        if (circuitBreakWhenGreaterThan2 != null ? !circuitBreakWhenGreaterThan2.equals(circuitBreakWhenGreaterThan3) : circuitBreakWhenGreaterThan3 != null) {
            return false;
        }
        String circuitBreakWhenLessThan2 = getCircuitBreakWhenLessThan();
        String circuitBreakWhenLessThan3 = exchangeSettings.getCircuitBreakWhenLessThan();
        if (circuitBreakWhenLessThan2 != null ? !circuitBreakWhenLessThan2.equals(circuitBreakWhenLessThan3) : circuitBreakWhenLessThan3 != null) {
            return false;
        }
        String marketBSCalcMaxScale2 = getMarketBSCalcMaxScale();
        String marketBSCalcMaxScale3 = exchangeSettings.getMarketBSCalcMaxScale();
        return marketBSCalcMaxScale2 != null ? marketBSCalcMaxScale2.equals(marketBSCalcMaxScale3) : marketBSCalcMaxScale3 == null;
    }

    public String getBuyLimitMustLessThan() {
        return this.buyLimitMustLessThan;
    }

    public String getBuyMarketMustLessThan() {
        return this.buyMarketMustLessThan;
    }

    public String getCircuitBreakWhenGreaterThan() {
        return this.circuitBreakWhenGreaterThan;
    }

    public String getCircuitBreakWhenLessThan() {
        return this.circuitBreakWhenLessThan;
    }

    public String getLimitOrderMustGreaterThan() {
        return this.limitOrderMustGreaterThan;
    }

    public String getLimitOrderMustLessThan() {
        return this.limitOrderMustLessThan;
    }

    public String getMarketBSCalcMaxScale() {
        return this.marketBSCalcMaxScale;
    }

    public String getMarketBuyOrderMustGreaterThan() {
        return this.marketBuyOrderMustGreaterThan;
    }

    public String getMarketBuyOrderMustLessThan() {
        return this.marketBuyOrderMustLessThan;
    }

    public String getMarketSellOrderMustGreaterThan() {
        return this.marketSellOrderMustGreaterThan;
    }

    public String getMarketSellOrderMustLessThan() {
        return this.marketSellOrderMustLessThan;
    }

    public String getSellLimitMustGreaterThan() {
        return this.sellLimitMustGreaterThan;
    }

    public String getSellMarketMustGreaterThan() {
        return this.sellMarketMustGreaterThan;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String buyMarketMustLessThan2 = getBuyMarketMustLessThan();
        int hashCode2 = ((hashCode + 59) * 59) + (buyMarketMustLessThan2 == null ? 43 : buyMarketMustLessThan2.hashCode());
        String sellMarketMustGreaterThan2 = getSellMarketMustGreaterThan();
        int hashCode3 = (hashCode2 * 59) + (sellMarketMustGreaterThan2 == null ? 43 : sellMarketMustGreaterThan2.hashCode());
        String buyLimitMustLessThan2 = getBuyLimitMustLessThan();
        int hashCode4 = (hashCode3 * 59) + (buyLimitMustLessThan2 == null ? 43 : buyLimitMustLessThan2.hashCode());
        String sellLimitMustGreaterThan2 = getSellLimitMustGreaterThan();
        int hashCode5 = (hashCode4 * 59) + (sellLimitMustGreaterThan2 == null ? 43 : sellLimitMustGreaterThan2.hashCode());
        String limitOrderMustGreaterThan2 = getLimitOrderMustGreaterThan();
        int hashCode6 = (hashCode5 * 59) + (limitOrderMustGreaterThan2 == null ? 43 : limitOrderMustGreaterThan2.hashCode());
        String limitOrderMustLessThan2 = getLimitOrderMustLessThan();
        int hashCode7 = (hashCode6 * 59) + (limitOrderMustLessThan2 == null ? 43 : limitOrderMustLessThan2.hashCode());
        String marketBuyOrderMustGreaterThan2 = getMarketBuyOrderMustGreaterThan();
        int hashCode8 = (hashCode7 * 59) + (marketBuyOrderMustGreaterThan2 == null ? 43 : marketBuyOrderMustGreaterThan2.hashCode());
        String marketBuyOrderMustLessThan2 = getMarketBuyOrderMustLessThan();
        int hashCode9 = (hashCode8 * 59) + (marketBuyOrderMustLessThan2 == null ? 43 : marketBuyOrderMustLessThan2.hashCode());
        String marketSellOrderMustGreaterThan2 = getMarketSellOrderMustGreaterThan();
        int hashCode10 = (hashCode9 * 59) + (marketSellOrderMustGreaterThan2 == null ? 43 : marketSellOrderMustGreaterThan2.hashCode());
        String marketSellOrderMustLessThan2 = getMarketSellOrderMustLessThan();
        int hashCode11 = (hashCode10 * 59) + (marketSellOrderMustLessThan2 == null ? 43 : marketSellOrderMustLessThan2.hashCode());
        String circuitBreakWhenGreaterThan2 = getCircuitBreakWhenGreaterThan();
        int hashCode12 = (hashCode11 * 59) + (circuitBreakWhenGreaterThan2 == null ? 43 : circuitBreakWhenGreaterThan2.hashCode());
        String circuitBreakWhenLessThan2 = getCircuitBreakWhenLessThan();
        int hashCode13 = (hashCode12 * 59) + (circuitBreakWhenLessThan2 == null ? 43 : circuitBreakWhenLessThan2.hashCode());
        String marketBSCalcMaxScale2 = getMarketBSCalcMaxScale();
        int i12 = hashCode13 * 59;
        if (marketBSCalcMaxScale2 != null) {
            i11 = marketBSCalcMaxScale2.hashCode();
        }
        return i12 + i11;
    }

    public void setBuyLimitMustLessThan(String str) {
        this.buyLimitMustLessThan = str;
    }

    public void setBuyMarketMustLessThan(String str) {
        this.buyMarketMustLessThan = str;
    }

    public void setCircuitBreakWhenGreaterThan(String str) {
        this.circuitBreakWhenGreaterThan = str;
    }

    public void setCircuitBreakWhenLessThan(String str) {
        this.circuitBreakWhenLessThan = str;
    }

    public void setLimitOrderMustGreaterThan(String str) {
        this.limitOrderMustGreaterThan = str;
    }

    public void setLimitOrderMustLessThan(String str) {
        this.limitOrderMustLessThan = str;
    }

    public void setMarketBSCalcMaxScale(String str) {
        this.marketBSCalcMaxScale = str;
    }

    public void setMarketBuyOrderMustGreaterThan(String str) {
        this.marketBuyOrderMustGreaterThan = str;
    }

    public void setMarketBuyOrderMustLessThan(String str) {
        this.marketBuyOrderMustLessThan = str;
    }

    public void setMarketSellOrderMustGreaterThan(String str) {
        this.marketSellOrderMustGreaterThan = str;
    }

    public void setMarketSellOrderMustLessThan(String str) {
        this.marketSellOrderMustLessThan = str;
    }

    public void setSellLimitMustGreaterThan(String str) {
        this.sellLimitMustGreaterThan = str;
    }

    public void setSellMarketMustGreaterThan(String str) {
        this.sellMarketMustGreaterThan = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ExchangeSettings(symbol=" + getSymbol() + ", buyMarketMustLessThan=" + getBuyMarketMustLessThan() + ", sellMarketMustGreaterThan=" + getSellMarketMustGreaterThan() + ", buyLimitMustLessThan=" + getBuyLimitMustLessThan() + ", sellLimitMustGreaterThan=" + getSellLimitMustGreaterThan() + ", limitOrderMustGreaterThan=" + getLimitOrderMustGreaterThan() + ", limitOrderMustLessThan=" + getLimitOrderMustLessThan() + ", marketBuyOrderMustGreaterThan=" + getMarketBuyOrderMustGreaterThan() + ", marketBuyOrderMustLessThan=" + getMarketBuyOrderMustLessThan() + ", marketSellOrderMustGreaterThan=" + getMarketSellOrderMustGreaterThan() + ", marketSellOrderMustLessThan=" + getMarketSellOrderMustLessThan() + ", circuitBreakWhenGreaterThan=" + getCircuitBreakWhenGreaterThan() + ", circuitBreakWhenLessThan=" + getCircuitBreakWhenLessThan() + ", marketBSCalcMaxScale=" + getMarketBSCalcMaxScale() + ")";
    }
}
