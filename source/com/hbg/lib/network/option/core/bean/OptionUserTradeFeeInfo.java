package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionUserTradeFeeInfo implements Serializable {
    private static final long serialVersionUID = -8881304006191159951L;
    @SerializedName("call_delivery_fee")
    private String callDeliveryFee;
    @SerializedName("fee_rate_type")
    private int feeRatType;
    @SerializedName("maker_offset_fee_rate")
    private String makerOffsetFeeRate;
    @SerializedName("maker_open_fee_rate")
    private String makerOpenFeeRate;
    @SerializedName("max_delivery_fee_rate")
    private String maxDeliveryFeeRate;
    @SerializedName("max_trade_in_fee_rate")
    private String maxTradeInFeeRate;
    @SerializedName("max_trade_out_fee_rate")
    private String maxTradeOutFeeRate;
    @SerializedName("put_delivery_fee")
    private String putDeliveryFee;
    private String symbol;
    @SerializedName("taker_offset_fee_rate")
    private String takerOffsetFeeRate;
    @SerializedName("taker_open_fee_rate")
    private String takerOpenFeeRate;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionUserTradeFeeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionUserTradeFeeInfo)) {
            return false;
        }
        OptionUserTradeFeeInfo optionUserTradeFeeInfo = (OptionUserTradeFeeInfo) obj;
        if (!optionUserTradeFeeInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionUserTradeFeeInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String makerOpenFeeRate2 = getMakerOpenFeeRate();
        String makerOpenFeeRate3 = optionUserTradeFeeInfo.getMakerOpenFeeRate();
        if (makerOpenFeeRate2 != null ? !makerOpenFeeRate2.equals(makerOpenFeeRate3) : makerOpenFeeRate3 != null) {
            return false;
        }
        String makerOffsetFeeRate2 = getMakerOffsetFeeRate();
        String makerOffsetFeeRate3 = optionUserTradeFeeInfo.getMakerOffsetFeeRate();
        if (makerOffsetFeeRate2 != null ? !makerOffsetFeeRate2.equals(makerOffsetFeeRate3) : makerOffsetFeeRate3 != null) {
            return false;
        }
        String takerOpenFeeRate2 = getTakerOpenFeeRate();
        String takerOpenFeeRate3 = optionUserTradeFeeInfo.getTakerOpenFeeRate();
        if (takerOpenFeeRate2 != null ? !takerOpenFeeRate2.equals(takerOpenFeeRate3) : takerOpenFeeRate3 != null) {
            return false;
        }
        String takerOffsetFeeRate2 = getTakerOffsetFeeRate();
        String takerOffsetFeeRate3 = optionUserTradeFeeInfo.getTakerOffsetFeeRate();
        if (takerOffsetFeeRate2 != null ? !takerOffsetFeeRate2.equals(takerOffsetFeeRate3) : takerOffsetFeeRate3 != null) {
            return false;
        }
        if (getFeeRatType() != optionUserTradeFeeInfo.getFeeRatType()) {
            return false;
        }
        String maxTradeInFeeRate2 = getMaxTradeInFeeRate();
        String maxTradeInFeeRate3 = optionUserTradeFeeInfo.getMaxTradeInFeeRate();
        if (maxTradeInFeeRate2 != null ? !maxTradeInFeeRate2.equals(maxTradeInFeeRate3) : maxTradeInFeeRate3 != null) {
            return false;
        }
        String maxTradeOutFeeRate2 = getMaxTradeOutFeeRate();
        String maxTradeOutFeeRate3 = optionUserTradeFeeInfo.getMaxTradeOutFeeRate();
        if (maxTradeOutFeeRate2 != null ? !maxTradeOutFeeRate2.equals(maxTradeOutFeeRate3) : maxTradeOutFeeRate3 != null) {
            return false;
        }
        String callDeliveryFee2 = getCallDeliveryFee();
        String callDeliveryFee3 = optionUserTradeFeeInfo.getCallDeliveryFee();
        if (callDeliveryFee2 != null ? !callDeliveryFee2.equals(callDeliveryFee3) : callDeliveryFee3 != null) {
            return false;
        }
        String putDeliveryFee2 = getPutDeliveryFee();
        String putDeliveryFee3 = optionUserTradeFeeInfo.getPutDeliveryFee();
        if (putDeliveryFee2 != null ? !putDeliveryFee2.equals(putDeliveryFee3) : putDeliveryFee3 != null) {
            return false;
        }
        String maxDeliveryFeeRate2 = getMaxDeliveryFeeRate();
        String maxDeliveryFeeRate3 = optionUserTradeFeeInfo.getMaxDeliveryFeeRate();
        return maxDeliveryFeeRate2 != null ? maxDeliveryFeeRate2.equals(maxDeliveryFeeRate3) : maxDeliveryFeeRate3 == null;
    }

    public String getCallDeliveryFee() {
        return this.callDeliveryFee;
    }

    public int getFeeRatType() {
        return this.feeRatType;
    }

    public String getMakerOffsetFeeRate() {
        return this.makerOffsetFeeRate;
    }

    public String getMakerOpenFeeRate() {
        return this.makerOpenFeeRate;
    }

    public String getMaxDeliveryFeeRate() {
        return this.maxDeliveryFeeRate;
    }

    public String getMaxTradeInFeeRate() {
        return this.maxTradeInFeeRate;
    }

    public String getMaxTradeOutFeeRate() {
        return this.maxTradeOutFeeRate;
    }

    public String getPutDeliveryFee() {
        return this.putDeliveryFee;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTakerOffsetFeeRate() {
        return this.takerOffsetFeeRate;
    }

    public String getTakerOpenFeeRate() {
        return this.takerOpenFeeRate;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String makerOpenFeeRate2 = getMakerOpenFeeRate();
        int hashCode2 = ((hashCode + 59) * 59) + (makerOpenFeeRate2 == null ? 43 : makerOpenFeeRate2.hashCode());
        String makerOffsetFeeRate2 = getMakerOffsetFeeRate();
        int hashCode3 = (hashCode2 * 59) + (makerOffsetFeeRate2 == null ? 43 : makerOffsetFeeRate2.hashCode());
        String takerOpenFeeRate2 = getTakerOpenFeeRate();
        int hashCode4 = (hashCode3 * 59) + (takerOpenFeeRate2 == null ? 43 : takerOpenFeeRate2.hashCode());
        String takerOffsetFeeRate2 = getTakerOffsetFeeRate();
        int hashCode5 = (((hashCode4 * 59) + (takerOffsetFeeRate2 == null ? 43 : takerOffsetFeeRate2.hashCode())) * 59) + getFeeRatType();
        String maxTradeInFeeRate2 = getMaxTradeInFeeRate();
        int hashCode6 = (hashCode5 * 59) + (maxTradeInFeeRate2 == null ? 43 : maxTradeInFeeRate2.hashCode());
        String maxTradeOutFeeRate2 = getMaxTradeOutFeeRate();
        int hashCode7 = (hashCode6 * 59) + (maxTradeOutFeeRate2 == null ? 43 : maxTradeOutFeeRate2.hashCode());
        String callDeliveryFee2 = getCallDeliveryFee();
        int hashCode8 = (hashCode7 * 59) + (callDeliveryFee2 == null ? 43 : callDeliveryFee2.hashCode());
        String putDeliveryFee2 = getPutDeliveryFee();
        int hashCode9 = (hashCode8 * 59) + (putDeliveryFee2 == null ? 43 : putDeliveryFee2.hashCode());
        String maxDeliveryFeeRate2 = getMaxDeliveryFeeRate();
        int i12 = hashCode9 * 59;
        if (maxDeliveryFeeRate2 != null) {
            i11 = maxDeliveryFeeRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setCallDeliveryFee(String str) {
        this.callDeliveryFee = str;
    }

    public void setFeeRatType(int i11) {
        this.feeRatType = i11;
    }

    public void setMakerOffsetFeeRate(String str) {
        this.makerOffsetFeeRate = str;
    }

    public void setMakerOpenFeeRate(String str) {
        this.makerOpenFeeRate = str;
    }

    public void setMaxDeliveryFeeRate(String str) {
        this.maxDeliveryFeeRate = str;
    }

    public void setMaxTradeInFeeRate(String str) {
        this.maxTradeInFeeRate = str;
    }

    public void setMaxTradeOutFeeRate(String str) {
        this.maxTradeOutFeeRate = str;
    }

    public void setPutDeliveryFee(String str) {
        this.putDeliveryFee = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTakerOffsetFeeRate(String str) {
        this.takerOffsetFeeRate = str;
    }

    public void setTakerOpenFeeRate(String str) {
        this.takerOpenFeeRate = str;
    }

    public String toString() {
        return "OptionUserTradeFeeInfo(symbol=" + getSymbol() + ", makerOpenFeeRate=" + getMakerOpenFeeRate() + ", makerOffsetFeeRate=" + getMakerOffsetFeeRate() + ", takerOpenFeeRate=" + getTakerOpenFeeRate() + ", takerOffsetFeeRate=" + getTakerOffsetFeeRate() + ", feeRatType=" + getFeeRatType() + ", maxTradeInFeeRate=" + getMaxTradeInFeeRate() + ", maxTradeOutFeeRate=" + getMaxTradeOutFeeRate() + ", callDeliveryFee=" + getCallDeliveryFee() + ", putDeliveryFee=" + getPutDeliveryFee() + ", maxDeliveryFeeRate=" + getMaxDeliveryFeeRate() + ")";
    }
}
