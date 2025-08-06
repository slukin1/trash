package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionPlatformPositionInfo implements Serializable {
    @SerializedName("amount_type")
    private int amountType;
    @SerializedName("contract_type")
    private int contractType;
    @SerializedName("instrument_right_type")
    private String instrumentRightType;
    @SerializedName("position_volume")
    private String positionVolume;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("times")
    private long times;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionPlatformPositionInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionPlatformPositionInfo)) {
            return false;
        }
        OptionPlatformPositionInfo optionPlatformPositionInfo = (OptionPlatformPositionInfo) obj;
        if (!optionPlatformPositionInfo.canEqual(this) || getAmountType() != optionPlatformPositionInfo.getAmountType() || getContractType() != optionPlatformPositionInfo.getContractType()) {
            return false;
        }
        String instrumentRightType2 = getInstrumentRightType();
        String instrumentRightType3 = optionPlatformPositionInfo.getInstrumentRightType();
        if (instrumentRightType2 != null ? !instrumentRightType2.equals(instrumentRightType3) : instrumentRightType3 != null) {
            return false;
        }
        String positionVolume2 = getPositionVolume();
        String positionVolume3 = optionPlatformPositionInfo.getPositionVolume();
        if (positionVolume2 != null ? !positionVolume2.equals(positionVolume3) : positionVolume3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionPlatformPositionInfo.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return getTimes() == optionPlatformPositionInfo.getTimes();
        }
        return false;
    }

    public int getAmountType() {
        return this.amountType;
    }

    public int getContractType() {
        return this.contractType;
    }

    public String getInstrumentRightType() {
        return this.instrumentRightType;
    }

    public String getPositionVolume() {
        return this.positionVolume;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getTimes() {
        return this.times;
    }

    public int hashCode() {
        int amountType2 = ((getAmountType() + 59) * 59) + getContractType();
        String instrumentRightType2 = getInstrumentRightType();
        int i11 = 43;
        int hashCode = (amountType2 * 59) + (instrumentRightType2 == null ? 43 : instrumentRightType2.hashCode());
        String positionVolume2 = getPositionVolume();
        int hashCode2 = (hashCode * 59) + (positionVolume2 == null ? 43 : positionVolume2.hashCode());
        String symbol2 = getSymbol();
        int i12 = hashCode2 * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
        }
        long times2 = getTimes();
        return ((i12 + i11) * 59) + ((int) ((times2 >>> 32) ^ times2));
    }

    public void setAmountType(int i11) {
        this.amountType = i11;
    }

    public void setContractType(int i11) {
        this.contractType = i11;
    }

    public void setInstrumentRightType(String str) {
        this.instrumentRightType = str;
    }

    public void setPositionVolume(String str) {
        this.positionVolume = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTimes(long j11) {
        this.times = j11;
    }

    public String toString() {
        return "OptionPlatformPositionInfo(amountType=" + getAmountType() + ", contractType=" + getContractType() + ", instrumentRightType=" + getInstrumentRightType() + ", positionVolume=" + getPositionVolume() + ", symbol=" + getSymbol() + ", times=" + getTimes() + ")";
    }
}
