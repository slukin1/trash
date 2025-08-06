package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import java.io.Serializable;

public class LinearSwapTimeOrderInfo implements Serializable {
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private long createdAt;
    private String direction;
    @SerializedName("filled_volume")
    private String filledVolume;
    @SerializedName("lever_rate")
    private int leverRate;
    @SerializedName("margin_mode")
    private String marginMode;
    private String offset;
    @SerializedName("order_id")
    private String orderId;
    private String price;
    @SerializedName("price_interval")
    private String priceInterval;
    @SerializedName("price_interval_mode")
    private int priceIntervalMode;
    @SerializedName("price_limit")
    private String priceLimit;
    private String symbol;
    @SerializedName("time_interval")
    private long timeInterval;
    @SerializedName("trade_type")
    private int tradeType;
    @SerializedName("unit_volume")
    private String unitVolume;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapTimeOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapTimeOrderInfo)) {
            return false;
        }
        LinearSwapTimeOrderInfo linearSwapTimeOrderInfo = (LinearSwapTimeOrderInfo) obj;
        if (!linearSwapTimeOrderInfo.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = linearSwapTimeOrderInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        if (getTradeType() != linearSwapTimeOrderInfo.getTradeType()) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = linearSwapTimeOrderInfo.getMarginMode();
        if (marginMode2 != null ? !marginMode2.equals(marginMode3) : marginMode3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = linearSwapTimeOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = linearSwapTimeOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapTimeOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = linearSwapTimeOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = linearSwapTimeOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        if (getLeverRate() != linearSwapTimeOrderInfo.getLeverRate() || getCreatedAt() != linearSwapTimeOrderInfo.getCreatedAt()) {
            return false;
        }
        String unitVolume2 = getUnitVolume();
        String unitVolume3 = linearSwapTimeOrderInfo.getUnitVolume();
        if (unitVolume2 != null ? !unitVolume2.equals(unitVolume3) : unitVolume3 != null) {
            return false;
        }
        String filledVolume2 = getFilledVolume();
        String filledVolume3 = linearSwapTimeOrderInfo.getFilledVolume();
        if (filledVolume2 != null ? !filledVolume2.equals(filledVolume3) : filledVolume3 != null) {
            return false;
        }
        String priceInterval2 = getPriceInterval();
        String priceInterval3 = linearSwapTimeOrderInfo.getPriceInterval();
        if (priceInterval2 != null ? !priceInterval2.equals(priceInterval3) : priceInterval3 != null) {
            return false;
        }
        if (getPriceIntervalMode() != linearSwapTimeOrderInfo.getPriceIntervalMode()) {
            return false;
        }
        String priceLimit2 = getPriceLimit();
        String priceLimit3 = linearSwapTimeOrderInfo.getPriceLimit();
        if (priceLimit2 != null ? !priceLimit2.equals(priceLimit3) : priceLimit3 != null) {
            return false;
        }
        if (getTimeInterval() != linearSwapTimeOrderInfo.getTimeInterval()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapTimeOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = linearSwapTimeOrderInfo.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFilledVolume() {
        return this.filledVolume;
    }

    public int getLeverRate() {
        return this.leverRate;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getOffset() {
        return this.offset;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPriceInterval() {
        return this.priceInterval;
    }

    public int getPriceIntervalMode() {
        return this.priceIntervalMode;
    }

    public String getPriceLimit() {
        return this.priceLimit;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public String getUnitVolume() {
        return this.unitVolume;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = (((orderId2 == null ? 43 : orderId2.hashCode()) + 59) * 59) + getTradeType();
        String marginMode2 = getMarginMode();
        int hashCode2 = (hashCode * 59) + (marginMode2 == null ? 43 : marginMode2.hashCode());
        String direction2 = getDirection();
        int hashCode3 = (hashCode2 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode4 = (hashCode3 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode5 = (hashCode4 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractType2 = getContractType();
        int hashCode6 = (hashCode5 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String volume2 = getVolume();
        int hashCode7 = (((hashCode6 * 59) + (volume2 == null ? 43 : volume2.hashCode())) * 59) + getLeverRate();
        long createdAt2 = getCreatedAt();
        int i12 = (hashCode7 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String unitVolume2 = getUnitVolume();
        int hashCode8 = (i12 * 59) + (unitVolume2 == null ? 43 : unitVolume2.hashCode());
        String filledVolume2 = getFilledVolume();
        int hashCode9 = (hashCode8 * 59) + (filledVolume2 == null ? 43 : filledVolume2.hashCode());
        String priceInterval2 = getPriceInterval();
        int hashCode10 = (((hashCode9 * 59) + (priceInterval2 == null ? 43 : priceInterval2.hashCode())) * 59) + getPriceIntervalMode();
        String priceLimit2 = getPriceLimit();
        int hashCode11 = (hashCode10 * 59) + (priceLimit2 == null ? 43 : priceLimit2.hashCode());
        long timeInterval2 = getTimeInterval();
        int i13 = (hashCode11 * 59) + ((int) (timeInterval2 ^ (timeInterval2 >>> 32)));
        String symbol2 = getSymbol();
        int hashCode12 = (i13 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String price2 = getPrice();
        int i14 = hashCode12 * 59;
        if (price2 != null) {
            i11 = price2.hashCode();
        }
        return i14 + i11;
    }

    public boolean isBuy() {
        return this.direction.equals("buy");
    }

    public boolean isCross() {
        return this.marginMode.equals(FutureContractInfo.MARGIN_CROSS);
    }

    public boolean isOpen() {
        return this.offset.equals("open");
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFilledVolume(String str) {
        this.filledVolume = str;
    }

    public void setLeverRate(int i11) {
        this.leverRate = i11;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceInterval(String str) {
        this.priceInterval = str;
    }

    public void setPriceIntervalMode(int i11) {
        this.priceIntervalMode = i11;
    }

    public void setPriceLimit(String str) {
        this.priceLimit = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTimeInterval(long j11) {
        this.timeInterval = j11;
    }

    public void setTradeType(int i11) {
        this.tradeType = i11;
    }

    public void setUnitVolume(String str) {
        this.unitVolume = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "LinearSwapTimeOrderInfo(orderId=" + getOrderId() + ", tradeType=" + getTradeType() + ", marginMode=" + getMarginMode() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", volume=" + getVolume() + ", leverRate=" + getLeverRate() + ", createdAt=" + getCreatedAt() + ", unitVolume=" + getUnitVolume() + ", filledVolume=" + getFilledVolume() + ", priceInterval=" + getPriceInterval() + ", priceIntervalMode=" + getPriceIntervalMode() + ", priceLimit=" + getPriceLimit() + ", timeInterval=" + getTimeInterval() + ", symbol=" + getSymbol() + ", price=" + getPrice() + ")";
    }
}
