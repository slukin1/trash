package com.huobi.staring.bean;

import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import java.io.Serializable;

public class CustomPriceResp implements Serializable {
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_UP = 1;
    private RemindBusinessType businessType;
    private RemindContractType contractType;
    private int direction;
    private String price;
    private long priceId;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof CustomPriceResp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPriceResp)) {
            return false;
        }
        CustomPriceResp customPriceResp = (CustomPriceResp) obj;
        if (!customPriceResp.canEqual(this) || getPriceId() != customPriceResp.getPriceId()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = customPriceResp.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        if (getDirection() != customPriceResp.getDirection()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = customPriceResp.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        RemindContractType contractType2 = getContractType();
        RemindContractType contractType3 = customPriceResp.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        RemindBusinessType businessType2 = getBusinessType();
        RemindBusinessType businessType3 = customPriceResp.getBusinessType();
        return businessType2 != null ? businessType2.equals(businessType3) : businessType3 == null;
    }

    public RemindBusinessType getBusinessType() {
        return this.businessType;
    }

    public RemindContractType getContractType() {
        return this.contractType;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getPrice() {
        return this.price;
    }

    public long getPriceId() {
        return this.priceId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        long priceId2 = getPriceId();
        String price2 = getPrice();
        int i11 = 43;
        int hashCode = ((((((int) (priceId2 ^ (priceId2 >>> 32))) + 59) * 59) + (price2 == null ? 43 : price2.hashCode())) * 59) + getDirection();
        String symbol2 = getSymbol();
        int hashCode2 = (hashCode * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        RemindContractType contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        RemindBusinessType businessType2 = getBusinessType();
        int i12 = hashCode3 * 59;
        if (businessType2 != null) {
            i11 = businessType2.hashCode();
        }
        return i12 + i11;
    }

    public void setBusinessType(RemindBusinessType remindBusinessType) {
        this.businessType = remindBusinessType;
    }

    public void setContractType(RemindContractType remindContractType) {
        this.contractType = remindContractType;
    }

    public void setDirection(int i11) {
        this.direction = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceId(long j11) {
        this.priceId = j11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "CustomPriceResp(priceId=" + getPriceId() + ", price=" + getPrice() + ", direction=" + getDirection() + ", symbol=" + getSymbol() + ", contractType=" + getContractType() + ", businessType=" + getBusinessType() + ")";
    }
}
