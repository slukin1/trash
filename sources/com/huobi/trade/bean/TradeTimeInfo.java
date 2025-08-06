package com.huobi.trade.bean;

import com.hbg.lib.data.symbol.TradeType;
import java.io.Serializable;

public class TradeTimeInfo implements Serializable {
    public static final String DEFAULT_VALUE = "--";
    private String accountId = "";
    private int amountPrecision;
    private String availableOfBuy = "";
    private String availableOfSell = "";
    private int direction = 0;
    private String greaterThan;
    private String lastPriceNew;
    private String lessThan;
    private String maxPriceIntervalRatio;
    private int maxTimeInterval;
    private String minPriceIntervalRatio;
    private int minTimeInterval;
    private int pricePrecision;
    private boolean rise;
    private String source = "android";
    private String symbol = "--";
    private TradeType tradeType;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeTimeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeTimeInfo)) {
            return false;
        }
        TradeTimeInfo tradeTimeInfo = (TradeTimeInfo) obj;
        if (!tradeTimeInfo.canEqual(this)) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = tradeTimeInfo.getTradeType();
        if (tradeType2 != null ? !tradeType2.equals(tradeType3) : tradeType3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = tradeTimeInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String lastPriceNew2 = getLastPriceNew();
        String lastPriceNew3 = tradeTimeInfo.getLastPriceNew();
        if (lastPriceNew2 != null ? !lastPriceNew2.equals(lastPriceNew3) : lastPriceNew3 != null) {
            return false;
        }
        if (isRise() != tradeTimeInfo.isRise()) {
            return false;
        }
        String availableOfBuy2 = getAvailableOfBuy();
        String availableOfBuy3 = tradeTimeInfo.getAvailableOfBuy();
        if (availableOfBuy2 != null ? !availableOfBuy2.equals(availableOfBuy3) : availableOfBuy3 != null) {
            return false;
        }
        String availableOfSell2 = getAvailableOfSell();
        String availableOfSell3 = tradeTimeInfo.getAvailableOfSell();
        if (availableOfSell2 != null ? !availableOfSell2.equals(availableOfSell3) : availableOfSell3 != null) {
            return false;
        }
        if (getMinTimeInterval() != tradeTimeInfo.getMinTimeInterval() || getMaxTimeInterval() != tradeTimeInfo.getMaxTimeInterval()) {
            return false;
        }
        String minPriceIntervalRatio2 = getMinPriceIntervalRatio();
        String minPriceIntervalRatio3 = tradeTimeInfo.getMinPriceIntervalRatio();
        if (minPriceIntervalRatio2 != null ? !minPriceIntervalRatio2.equals(minPriceIntervalRatio3) : minPriceIntervalRatio3 != null) {
            return false;
        }
        String maxPriceIntervalRatio2 = getMaxPriceIntervalRatio();
        String maxPriceIntervalRatio3 = tradeTimeInfo.getMaxPriceIntervalRatio();
        if (maxPriceIntervalRatio2 != null ? !maxPriceIntervalRatio2.equals(maxPriceIntervalRatio3) : maxPriceIntervalRatio3 != null) {
            return false;
        }
        if (getDirection() != tradeTimeInfo.getDirection()) {
            return false;
        }
        String accountId2 = getAccountId();
        String accountId3 = tradeTimeInfo.getAccountId();
        if (accountId2 != null ? !accountId2.equals(accountId3) : accountId3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = tradeTimeInfo.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String lessThan2 = getLessThan();
        String lessThan3 = tradeTimeInfo.getLessThan();
        if (lessThan2 != null ? !lessThan2.equals(lessThan3) : lessThan3 != null) {
            return false;
        }
        String greaterThan2 = getGreaterThan();
        String greaterThan3 = tradeTimeInfo.getGreaterThan();
        if (greaterThan2 != null ? greaterThan2.equals(greaterThan3) : greaterThan3 == null) {
            return getPricePrecision() == tradeTimeInfo.getPricePrecision() && getAmountPrecision() == tradeTimeInfo.getAmountPrecision();
        }
        return false;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public int getAmountPrecision() {
        return this.amountPrecision;
    }

    public String getAvailableOfBuy() {
        return this.availableOfBuy;
    }

    public String getAvailableOfSell() {
        return this.availableOfSell;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getGreaterThan() {
        return this.greaterThan;
    }

    public String getLastPriceNew() {
        return this.lastPriceNew;
    }

    public String getLessThan() {
        return this.lessThan;
    }

    public String getMaxPriceIntervalRatio() {
        return this.maxPriceIntervalRatio;
    }

    public int getMaxTimeInterval() {
        return this.maxTimeInterval;
    }

    public String getMinPriceIntervalRatio() {
        return this.minPriceIntervalRatio;
    }

    public int getMinTimeInterval() {
        return this.minTimeInterval;
    }

    public int getPricePrecision() {
        return this.pricePrecision;
    }

    public String getSource() {
        return this.source;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public int hashCode() {
        TradeType tradeType2 = getTradeType();
        int i11 = 43;
        int hashCode = tradeType2 == null ? 43 : tradeType2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String lastPriceNew2 = getLastPriceNew();
        int hashCode3 = (((hashCode2 * 59) + (lastPriceNew2 == null ? 43 : lastPriceNew2.hashCode())) * 59) + (isRise() ? 79 : 97);
        String availableOfBuy2 = getAvailableOfBuy();
        int hashCode4 = (hashCode3 * 59) + (availableOfBuy2 == null ? 43 : availableOfBuy2.hashCode());
        String availableOfSell2 = getAvailableOfSell();
        int hashCode5 = (((((hashCode4 * 59) + (availableOfSell2 == null ? 43 : availableOfSell2.hashCode())) * 59) + getMinTimeInterval()) * 59) + getMaxTimeInterval();
        String minPriceIntervalRatio2 = getMinPriceIntervalRatio();
        int hashCode6 = (hashCode5 * 59) + (minPriceIntervalRatio2 == null ? 43 : minPriceIntervalRatio2.hashCode());
        String maxPriceIntervalRatio2 = getMaxPriceIntervalRatio();
        int hashCode7 = (((hashCode6 * 59) + (maxPriceIntervalRatio2 == null ? 43 : maxPriceIntervalRatio2.hashCode())) * 59) + getDirection();
        String accountId2 = getAccountId();
        int hashCode8 = (hashCode7 * 59) + (accountId2 == null ? 43 : accountId2.hashCode());
        String source2 = getSource();
        int hashCode9 = (hashCode8 * 59) + (source2 == null ? 43 : source2.hashCode());
        String lessThan2 = getLessThan();
        int hashCode10 = (hashCode9 * 59) + (lessThan2 == null ? 43 : lessThan2.hashCode());
        String greaterThan2 = getGreaterThan();
        int i12 = hashCode10 * 59;
        if (greaterThan2 != null) {
            i11 = greaterThan2.hashCode();
        }
        return ((((i12 + i11) * 59) + getPricePrecision()) * 59) + getAmountPrecision();
    }

    public boolean isRise() {
        return this.rise;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setAmountPrecision(int i11) {
        this.amountPrecision = i11;
    }

    public void setAvailableOfBuy(String str) {
        this.availableOfBuy = str;
    }

    public void setAvailableOfSell(String str) {
        this.availableOfSell = str;
    }

    public void setDirection(int i11) {
        this.direction = i11;
    }

    public void setGreaterThan(String str) {
        this.greaterThan = str;
    }

    public void setLastPriceNew(String str) {
        this.lastPriceNew = str;
    }

    public void setLessThan(String str) {
        this.lessThan = str;
    }

    public void setMaxPriceIntervalRatio(String str) {
        this.maxPriceIntervalRatio = str;
    }

    public void setMaxTimeInterval(int i11) {
        this.maxTimeInterval = i11;
    }

    public void setMinPriceIntervalRatio(String str) {
        this.minPriceIntervalRatio = str;
    }

    public void setMinTimeInterval(int i11) {
        this.minTimeInterval = i11;
    }

    public void setPricePrecision(int i11) {
        this.pricePrecision = i11;
    }

    public void setRise(boolean z11) {
        this.rise = z11;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "TradeTimeInfo(tradeType=" + getTradeType() + ", symbol=" + getSymbol() + ", lastPriceNew=" + getLastPriceNew() + ", rise=" + isRise() + ", availableOfBuy=" + getAvailableOfBuy() + ", availableOfSell=" + getAvailableOfSell() + ", minTimeInterval=" + getMinTimeInterval() + ", maxTimeInterval=" + getMaxTimeInterval() + ", minPriceIntervalRatio=" + getMinPriceIntervalRatio() + ", maxPriceIntervalRatio=" + getMaxPriceIntervalRatio() + ", direction=" + getDirection() + ", accountId=" + getAccountId() + ", source=" + getSource() + ", lessThan=" + getLessThan() + ", greaterThan=" + getGreaterThan() + ", pricePrecision=" + getPricePrecision() + ", amountPrecision=" + getAmountPrecision() + ")";
    }
}
