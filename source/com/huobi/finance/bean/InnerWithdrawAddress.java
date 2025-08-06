package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InnerWithdrawAddress implements Serializable {
    @SerializedName("address")
    private String address;
    @SerializedName("exchange-id")
    private String exchangeId;
    @SerializedName("exchange-name")
    private String exchangeName;
    private String tag;
    @SerializedName("uid")
    private String uid;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.exchangeId;
        String str2 = ((InnerWithdrawAddress) obj).exchangeId;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public String getExchangeId() {
        return this.exchangeId;
    }

    public String getExchangeName() {
        return this.exchangeName;
    }

    public String getTag() {
        return this.tag;
    }

    public String getUid() {
        return this.uid;
    }

    public int hashCode() {
        String str = this.exchangeId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setExchangeId(String str) {
        this.exchangeId = str;
    }

    public void setExchangeName(String str) {
        this.exchangeName = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "InnerWithdrawAddress(uid=" + getUid() + ", exchangeId=" + getExchangeId() + ", exchangeName=" + getExchangeName() + ", address=" + getAddress() + ", tag=" + getTag() + ")";
    }
}
