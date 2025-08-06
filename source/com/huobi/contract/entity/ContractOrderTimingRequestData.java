package com.huobi.contract.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractOrderTimingRequestData implements Serializable {
    public static final String DIRECTION_BUY = "buy";
    public static final String DIRECTION_SELL = "sell";
    @Expose
    public boolean canTrade;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("direction")
    private String direction;
    @Expose
    private String displayTotalVolume;
    @Expose
    private String displayUnitName;
    @Expose
    private String displayUnitVolume;
    @SerializedName("lever_rate")
    private int levelRate;
    @SerializedName("margin_mode")
    private String marginMode;
    @SerializedName("offset")
    private String offset;
    @SerializedName("price_interval")
    private double priceInterval;
    @SerializedName("price_interval_mode")
    private int priceIntervalMode;
    @SerializedName("price_limit")
    private double priceLimit;
    private String quoteCurrency;
    private String symbol;
    @SerializedName("time_interval")
    private int timeInterval;
    @SerializedName("unit_volume")
    private int unitVolume;
    @SerializedName("volume")
    private int volume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractOrderTimingRequestData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractOrderTimingRequestData)) {
            return false;
        }
        ContractOrderTimingRequestData contractOrderTimingRequestData = (ContractOrderTimingRequestData) obj;
        if (!contractOrderTimingRequestData.canEqual(this) || isCanTrade() != contractOrderTimingRequestData.isCanTrade()) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractOrderTimingRequestData.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractOrderTimingRequestData.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = contractOrderTimingRequestData.getMarginMode();
        if (marginMode2 != null ? !marginMode2.equals(marginMode3) : marginMode3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractOrderTimingRequestData.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = contractOrderTimingRequestData.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        if (getLevelRate() != contractOrderTimingRequestData.getLevelRate() || Double.compare(getPriceInterval(), contractOrderTimingRequestData.getPriceInterval()) != 0 || getPriceIntervalMode() != contractOrderTimingRequestData.getPriceIntervalMode() || Double.compare(getPriceLimit(), contractOrderTimingRequestData.getPriceLimit()) != 0 || getTimeInterval() != contractOrderTimingRequestData.getTimeInterval() || getUnitVolume() != contractOrderTimingRequestData.getUnitVolume() || getVolume() != contractOrderTimingRequestData.getVolume()) {
            return false;
        }
        String displayUnitName2 = getDisplayUnitName();
        String displayUnitName3 = contractOrderTimingRequestData.getDisplayUnitName();
        if (displayUnitName2 != null ? !displayUnitName2.equals(displayUnitName3) : displayUnitName3 != null) {
            return false;
        }
        String displayUnitVolume2 = getDisplayUnitVolume();
        String displayUnitVolume3 = contractOrderTimingRequestData.getDisplayUnitVolume();
        if (displayUnitVolume2 != null ? !displayUnitVolume2.equals(displayUnitVolume3) : displayUnitVolume3 != null) {
            return false;
        }
        String displayTotalVolume2 = getDisplayTotalVolume();
        String displayTotalVolume3 = contractOrderTimingRequestData.getDisplayTotalVolume();
        if (displayTotalVolume2 != null ? !displayTotalVolume2.equals(displayTotalVolume3) : displayTotalVolume3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractOrderTimingRequestData.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = contractOrderTimingRequestData.getQuoteCurrency();
        return quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getDisplayTotalVolume() {
        return this.displayTotalVolume;
    }

    public String getDisplayUnitName() {
        return this.displayUnitName;
    }

    public String getDisplayUnitVolume() {
        return this.displayUnitVolume;
    }

    public int getLevelRate() {
        return this.levelRate;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getOffset() {
        return this.offset;
    }

    public double getPriceInterval() {
        return this.priceInterval;
    }

    public int getPriceIntervalMode() {
        return this.priceIntervalMode;
    }

    public double getPriceLimit() {
        return this.priceLimit;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getTimeInterval() {
        return this.timeInterval;
    }

    public int getUnitVolume() {
        return this.unitVolume;
    }

    public int getVolume() {
        return this.volume;
    }

    public int hashCode() {
        int i11 = isCanTrade() ? 79 : 97;
        String contractType2 = getContractType();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode2 = (hashCode * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String marginMode2 = getMarginMode();
        int hashCode3 = (hashCode2 * 59) + (marginMode2 == null ? 43 : marginMode2.hashCode());
        String direction2 = getDirection();
        int hashCode4 = (hashCode3 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int i13 = hashCode4 * 59;
        int hashCode5 = offset2 == null ? 43 : offset2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(getPriceInterval());
        int levelRate2 = ((((((i13 + hashCode5) * 59) + getLevelRate()) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + getPriceIntervalMode();
        long doubleToLongBits2 = Double.doubleToLongBits(getPriceLimit());
        int timeInterval2 = (((((((levelRate2 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + getTimeInterval()) * 59) + getUnitVolume()) * 59) + getVolume();
        String displayUnitName2 = getDisplayUnitName();
        int hashCode6 = (timeInterval2 * 59) + (displayUnitName2 == null ? 43 : displayUnitName2.hashCode());
        String displayUnitVolume2 = getDisplayUnitVolume();
        int hashCode7 = (hashCode6 * 59) + (displayUnitVolume2 == null ? 43 : displayUnitVolume2.hashCode());
        String displayTotalVolume2 = getDisplayTotalVolume();
        int hashCode8 = (hashCode7 * 59) + (displayTotalVolume2 == null ? 43 : displayTotalVolume2.hashCode());
        String symbol2 = getSymbol();
        int hashCode9 = (hashCode8 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int i14 = hashCode9 * 59;
        if (quoteCurrency2 != null) {
            i12 = quoteCurrency2.hashCode();
        }
        return i14 + i12;
    }

    public boolean isCanTrade() {
        return this.canTrade;
    }

    public void setCanTrade(boolean z11) {
        this.canTrade = z11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setDisplayTotalVolume(String str) {
        this.displayTotalVolume = str;
    }

    public void setDisplayUnitName(String str) {
        this.displayUnitName = str;
    }

    public void setDisplayUnitVolume(String str) {
        this.displayUnitVolume = str;
    }

    public void setLevelRate(int i11) {
        this.levelRate = i11;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setPriceInterval(double d11) {
        this.priceInterval = d11;
    }

    public void setPriceIntervalMode(int i11) {
        this.priceIntervalMode = i11;
    }

    public void setPriceLimit(double d11) {
        this.priceLimit = d11;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTimeInterval(int i11) {
        this.timeInterval = i11;
    }

    public void setUnitVolume(int i11) {
        this.unitVolume = i11;
    }

    public void setVolume(int i11) {
        this.volume = i11;
    }

    public String toString() {
        return "ContractOrderTimingRequestData(canTrade=" + isCanTrade() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", marginMode=" + getMarginMode() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", levelRate=" + getLevelRate() + ", priceInterval=" + getPriceInterval() + ", priceIntervalMode=" + getPriceIntervalMode() + ", priceLimit=" + getPriceLimit() + ", timeInterval=" + getTimeInterval() + ", unitVolume=" + getUnitVolume() + ", volume=" + getVolume() + ", displayUnitName=" + getDisplayUnitName() + ", displayUnitVolume=" + getDisplayUnitVolume() + ", displayTotalVolume=" + getDisplayTotalVolume() + ", symbol=" + getSymbol() + ", quoteCurrency=" + getQuoteCurrency() + ")";
    }
}
