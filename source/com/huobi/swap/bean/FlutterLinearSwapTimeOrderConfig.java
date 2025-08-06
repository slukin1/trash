package com.huobi.swap.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlutterLinearSwapTimeOrderConfig implements Serializable {
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    private int curShowMode;
    @SerializedName("is_red_rise_green_fall")
    private boolean isRedRiseGreenFall;
    @SerializedName("order_id")
    private String orderId;
    private String symbol;
    @SerializedName("unit_type")
    private int unit;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterLinearSwapTimeOrderConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterLinearSwapTimeOrderConfig)) {
            return false;
        }
        FlutterLinearSwapTimeOrderConfig flutterLinearSwapTimeOrderConfig = (FlutterLinearSwapTimeOrderConfig) obj;
        if (!flutterLinearSwapTimeOrderConfig.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = flutterLinearSwapTimeOrderConfig.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = flutterLinearSwapTimeOrderConfig.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = flutterLinearSwapTimeOrderConfig.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = flutterLinearSwapTimeOrderConfig.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return getCurShowMode() == flutterLinearSwapTimeOrderConfig.getCurShowMode() && getUnit() == flutterLinearSwapTimeOrderConfig.getUnit() && isRedRiseGreenFall() == flutterLinearSwapTimeOrderConfig.isRedRiseGreenFall();
        }
        return false;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public int getCurShowMode() {
        return this.curShowMode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getUnit() {
        return this.unit;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        String contractType2 = getContractType();
        int hashCode2 = ((hashCode + 59) * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String orderId2 = getOrderId();
        int hashCode3 = (hashCode2 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        String symbol2 = getSymbol();
        int i12 = hashCode3 * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
        }
        return ((((((i12 + i11) * 59) + getCurShowMode()) * 59) + getUnit()) * 59) + (isRedRiseGreenFall() ? 79 : 97);
    }

    public boolean isRedRiseGreenFall() {
        return this.isRedRiseGreenFall;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCurShowMode(int i11) {
        this.curShowMode = i11;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setRedRiseGreenFall(boolean z11) {
        this.isRedRiseGreenFall = z11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUnit(int i11) {
        this.unit = i11;
    }

    public String toString() {
        return "FlutterLinearSwapTimeOrderConfig(contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", orderId=" + getOrderId() + ", symbol=" + getSymbol() + ", curShowMode=" + getCurShowMode() + ", unit=" + getUnit() + ", isRedRiseGreenFall=" + isRedRiseGreenFall() + ")";
    }
}
