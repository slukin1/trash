package com.huobi.future.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserOrderLimitType;
import java.io.Serializable;

public class FutureUserOrderLimitType implements Serializable {
    private static final long serialVersionUID = -1915427849338128660L;
    private String closeLimit;
    private String contractCode;
    private String contractType;
    private String openLimit;
    private String openOrdersLong;
    private String openOrdersShort;
    private String positionLimitLong;
    private String positionLimitShort;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof FutureUserOrderLimitType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureUserOrderLimitType)) {
            return false;
        }
        FutureUserOrderLimitType futureUserOrderLimitType = (FutureUserOrderLimitType) obj;
        if (!futureUserOrderLimitType.canEqual(this)) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = futureUserOrderLimitType.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = futureUserOrderLimitType.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = futureUserOrderLimitType.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String openLimit2 = getOpenLimit();
        String openLimit3 = futureUserOrderLimitType.getOpenLimit();
        if (openLimit2 != null ? !openLimit2.equals(openLimit3) : openLimit3 != null) {
            return false;
        }
        String closeLimit2 = getCloseLimit();
        String closeLimit3 = futureUserOrderLimitType.getCloseLimit();
        if (closeLimit2 != null ? !closeLimit2.equals(closeLimit3) : closeLimit3 != null) {
            return false;
        }
        String positionLimitLong2 = getPositionLimitLong();
        String positionLimitLong3 = futureUserOrderLimitType.getPositionLimitLong();
        if (positionLimitLong2 != null ? !positionLimitLong2.equals(positionLimitLong3) : positionLimitLong3 != null) {
            return false;
        }
        String positionLimitShort2 = getPositionLimitShort();
        String positionLimitShort3 = futureUserOrderLimitType.getPositionLimitShort();
        if (positionLimitShort2 != null ? !positionLimitShort2.equals(positionLimitShort3) : positionLimitShort3 != null) {
            return false;
        }
        String openOrdersLong2 = getOpenOrdersLong();
        String openOrdersLong3 = futureUserOrderLimitType.getOpenOrdersLong();
        if (openOrdersLong2 != null ? !openOrdersLong2.equals(openOrdersLong3) : openOrdersLong3 != null) {
            return false;
        }
        String openOrdersShort2 = getOpenOrdersShort();
        String openOrdersShort3 = futureUserOrderLimitType.getOpenOrdersShort();
        return openOrdersShort2 != null ? openOrdersShort2.equals(openOrdersShort3) : openOrdersShort3 == null;
    }

    public String getCloseLimit() {
        return this.closeLimit;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getOpenLimit() {
        return this.openLimit;
    }

    public String getOpenOrdersLong() {
        return this.openOrdersLong;
    }

    public String getOpenOrdersShort() {
        return this.openOrdersShort;
    }

    public String getPositionLimitLong() {
        return this.positionLimitLong;
    }

    public String getPositionLimitShort() {
        return this.positionLimitShort;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String contractType2 = getContractType();
        int i11 = 43;
        int hashCode = contractType2 == null ? 43 : contractType2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String openLimit2 = getOpenLimit();
        int hashCode4 = (hashCode3 * 59) + (openLimit2 == null ? 43 : openLimit2.hashCode());
        String closeLimit2 = getCloseLimit();
        int hashCode5 = (hashCode4 * 59) + (closeLimit2 == null ? 43 : closeLimit2.hashCode());
        String positionLimitLong2 = getPositionLimitLong();
        int hashCode6 = (hashCode5 * 59) + (positionLimitLong2 == null ? 43 : positionLimitLong2.hashCode());
        String positionLimitShort2 = getPositionLimitShort();
        int hashCode7 = (hashCode6 * 59) + (positionLimitShort2 == null ? 43 : positionLimitShort2.hashCode());
        String openOrdersLong2 = getOpenOrdersLong();
        int hashCode8 = (hashCode7 * 59) + (openOrdersLong2 == null ? 43 : openOrdersLong2.hashCode());
        String openOrdersShort2 = getOpenOrdersShort();
        int i12 = hashCode8 * 59;
        if (openOrdersShort2 != null) {
            i11 = openOrdersShort2.hashCode();
        }
        return i12 + i11;
    }

    public FutureUserOrderLimitType linearSwapConvert(FutureUserOrderLimitType futureUserOrderLimitType, LinearSwapUserOrderLimitType linearSwapUserOrderLimitType) {
        futureUserOrderLimitType.setSymbol(linearSwapUserOrderLimitType.getSymbol());
        futureUserOrderLimitType.setContractCode(linearSwapUserOrderLimitType.getContractCode());
        futureUserOrderLimitType.setOpenLimit(linearSwapUserOrderLimitType.getOpenLimit());
        futureUserOrderLimitType.setCloseLimit(linearSwapUserOrderLimitType.getCloseLimit());
        futureUserOrderLimitType.setPositionLimitLong(linearSwapUserOrderLimitType.getPositionLimitLong());
        futureUserOrderLimitType.setPositionLimitShort(linearSwapUserOrderLimitType.getPositionLimitShort());
        futureUserOrderLimitType.setOpenOrdersLong(linearSwapUserOrderLimitType.getOpenOrdersLong());
        futureUserOrderLimitType.setOpenOrdersShort(linearSwapUserOrderLimitType.getOpenOrdersShort());
        return futureUserOrderLimitType;
    }

    public void setCloseLimit(String str) {
        this.closeLimit = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setOpenLimit(String str) {
        this.openLimit = str;
    }

    public void setOpenOrdersLong(String str) {
        this.openOrdersLong = str;
    }

    public void setOpenOrdersShort(String str) {
        this.openOrdersShort = str;
    }

    public void setPositionLimitLong(String str) {
        this.positionLimitLong = str;
    }

    public void setPositionLimitShort(String str) {
        this.positionLimitShort = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "FutureUserOrderLimitType(contractType=" + getContractType() + ", symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", openLimit=" + getOpenLimit() + ", closeLimit=" + getCloseLimit() + ", positionLimitLong=" + getPositionLimitLong() + ", positionLimitShort=" + getPositionLimitShort() + ", openOrdersLong=" + getOpenOrdersLong() + ", openOrdersShort=" + getOpenOrdersShort() + ")";
    }
}
