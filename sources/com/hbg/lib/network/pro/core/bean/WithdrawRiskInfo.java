package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WithdrawRiskInfo implements Serializable {
    @SerializedName("address-id")
    private String addressId;
    @SerializedName("order-id")
    private int orderid;
    @SerializedName("risk-action-data")
    private RiskActionData riskActionData;
    private String state;

    public boolean canEqual(Object obj) {
        return obj instanceof WithdrawRiskInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawRiskInfo)) {
            return false;
        }
        WithdrawRiskInfo withdrawRiskInfo = (WithdrawRiskInfo) obj;
        if (!withdrawRiskInfo.canEqual(this)) {
            return false;
        }
        String addressId2 = getAddressId();
        String addressId3 = withdrawRiskInfo.getAddressId();
        if (addressId2 != null ? !addressId2.equals(addressId3) : addressId3 != null) {
            return false;
        }
        if (getOrderid() != withdrawRiskInfo.getOrderid()) {
            return false;
        }
        String state2 = getState();
        String state3 = withdrawRiskInfo.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        RiskActionData riskActionData2 = getRiskActionData();
        RiskActionData riskActionData3 = withdrawRiskInfo.getRiskActionData();
        return riskActionData2 != null ? riskActionData2.equals(riskActionData3) : riskActionData3 == null;
    }

    public String getAddressId() {
        return this.addressId;
    }

    public int getOrderid() {
        return this.orderid;
    }

    public RiskActionData getRiskActionData() {
        return this.riskActionData;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        String addressId2 = getAddressId();
        int i11 = 43;
        int hashCode = (((addressId2 == null ? 43 : addressId2.hashCode()) + 59) * 59) + getOrderid();
        String state2 = getState();
        int hashCode2 = (hashCode * 59) + (state2 == null ? 43 : state2.hashCode());
        RiskActionData riskActionData2 = getRiskActionData();
        int i12 = hashCode2 * 59;
        if (riskActionData2 != null) {
            i11 = riskActionData2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddressId(String str) {
        this.addressId = str;
    }

    public void setOrderid(int i11) {
        this.orderid = i11;
    }

    public void setRiskActionData(RiskActionData riskActionData2) {
        this.riskActionData = riskActionData2;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "WithdrawRiskInfo(addressId=" + getAddressId() + ", orderid=" + getOrderid() + ", state=" + getState() + ", riskActionData=" + getRiskActionData() + ")";
    }
}
