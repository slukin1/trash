package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractUserOrderLimitType implements Serializable {
    private static final long serialVersionUID = -1915427849338128660L;
    @SerializedName("close_limit")
    private String closeLimit;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("open_limit")
    private String openLimit;
    @SerializedName("open_orders_long")
    private String openOrdersLong;
    @SerializedName("open_orders_short")
    private String openOrdersShort;
    @SerializedName("position_limit_long")
    private String positionLimitLong;
    @SerializedName("position_limit_short")
    private String positionLimitShort;
    @SerializedName("position_long")
    private String positionLong;
    @SerializedName("position_short")
    private String positionShort;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractUserOrderLimitType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractUserOrderLimitType)) {
            return false;
        }
        ContractUserOrderLimitType contractUserOrderLimitType = (ContractUserOrderLimitType) obj;
        if (!contractUserOrderLimitType.canEqual(this)) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractUserOrderLimitType.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String openLimit2 = getOpenLimit();
        String openLimit3 = contractUserOrderLimitType.getOpenLimit();
        if (openLimit2 != null ? !openLimit2.equals(openLimit3) : openLimit3 != null) {
            return false;
        }
        String closeLimit2 = getCloseLimit();
        String closeLimit3 = contractUserOrderLimitType.getCloseLimit();
        if (closeLimit2 != null ? !closeLimit2.equals(closeLimit3) : closeLimit3 != null) {
            return false;
        }
        String positionLimitLong2 = getPositionLimitLong();
        String positionLimitLong3 = contractUserOrderLimitType.getPositionLimitLong();
        if (positionLimitLong2 != null ? !positionLimitLong2.equals(positionLimitLong3) : positionLimitLong3 != null) {
            return false;
        }
        String positionLimitShort2 = getPositionLimitShort();
        String positionLimitShort3 = contractUserOrderLimitType.getPositionLimitShort();
        if (positionLimitShort2 != null ? !positionLimitShort2.equals(positionLimitShort3) : positionLimitShort3 != null) {
            return false;
        }
        String openOrdersLong2 = getOpenOrdersLong();
        String openOrdersLong3 = contractUserOrderLimitType.getOpenOrdersLong();
        if (openOrdersLong2 != null ? !openOrdersLong2.equals(openOrdersLong3) : openOrdersLong3 != null) {
            return false;
        }
        String openOrdersShort2 = getOpenOrdersShort();
        String openOrdersShort3 = contractUserOrderLimitType.getOpenOrdersShort();
        if (openOrdersShort2 != null ? !openOrdersShort2.equals(openOrdersShort3) : openOrdersShort3 != null) {
            return false;
        }
        String positionLong2 = getPositionLong();
        String positionLong3 = contractUserOrderLimitType.getPositionLong();
        if (positionLong2 != null ? !positionLong2.equals(positionLong3) : positionLong3 != null) {
            return false;
        }
        String positionShort2 = getPositionShort();
        String positionShort3 = contractUserOrderLimitType.getPositionShort();
        return positionShort2 != null ? positionShort2.equals(positionShort3) : positionShort3 == null;
    }

    public String getCloseLimit() {
        return this.closeLimit;
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

    public String getPositionLong() {
        return this.positionLong;
    }

    public String getPositionShort() {
        return this.positionShort;
    }

    public int hashCode() {
        String contractType2 = getContractType();
        int i11 = 43;
        int hashCode = contractType2 == null ? 43 : contractType2.hashCode();
        String openLimit2 = getOpenLimit();
        int hashCode2 = ((hashCode + 59) * 59) + (openLimit2 == null ? 43 : openLimit2.hashCode());
        String closeLimit2 = getCloseLimit();
        int hashCode3 = (hashCode2 * 59) + (closeLimit2 == null ? 43 : closeLimit2.hashCode());
        String positionLimitLong2 = getPositionLimitLong();
        int hashCode4 = (hashCode3 * 59) + (positionLimitLong2 == null ? 43 : positionLimitLong2.hashCode());
        String positionLimitShort2 = getPositionLimitShort();
        int hashCode5 = (hashCode4 * 59) + (positionLimitShort2 == null ? 43 : positionLimitShort2.hashCode());
        String openOrdersLong2 = getOpenOrdersLong();
        int hashCode6 = (hashCode5 * 59) + (openOrdersLong2 == null ? 43 : openOrdersLong2.hashCode());
        String openOrdersShort2 = getOpenOrdersShort();
        int hashCode7 = (hashCode6 * 59) + (openOrdersShort2 == null ? 43 : openOrdersShort2.hashCode());
        String positionLong2 = getPositionLong();
        int hashCode8 = (hashCode7 * 59) + (positionLong2 == null ? 43 : positionLong2.hashCode());
        String positionShort2 = getPositionShort();
        int i12 = hashCode8 * 59;
        if (positionShort2 != null) {
            i11 = positionShort2.hashCode();
        }
        return i12 + i11;
    }

    public void setCloseLimit(String str) {
        this.closeLimit = str;
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

    public void setPositionLong(String str) {
        this.positionLong = str;
    }

    public void setPositionShort(String str) {
        this.positionShort = str;
    }

    public String toString() {
        return "ContractUserOrderLimitType(contractType=" + getContractType() + ", openLimit=" + getOpenLimit() + ", closeLimit=" + getCloseLimit() + ", positionLimitLong=" + getPositionLimitLong() + ", positionLimitShort=" + getPositionLimitShort() + ", openOrdersLong=" + getOpenOrdersLong() + ", openOrdersShort=" + getOpenOrdersShort() + ", positionLong=" + getPositionLong() + ", positionShort=" + getPositionShort() + ")";
    }
}
