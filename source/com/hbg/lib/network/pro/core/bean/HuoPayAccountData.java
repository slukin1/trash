package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HuoPayAccountData implements Serializable {
    private String address;
    @SerializedName("address-tag")
    private String addressTag;
    private String chain;
    private String currency;
    @SerializedName("hg-user-id")
    private String hgUserId;
    @SerializedName("hp-user-id")
    private String hpUserId;
    private int status;

    public boolean canEqual(Object obj) {
        return obj instanceof HuoPayAccountData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HuoPayAccountData)) {
            return false;
        }
        HuoPayAccountData huoPayAccountData = (HuoPayAccountData) obj;
        if (!huoPayAccountData.canEqual(this) || getStatus() != huoPayAccountData.getStatus()) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = huoPayAccountData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String chain2 = getChain();
        String chain3 = huoPayAccountData.getChain();
        if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
            return false;
        }
        String address2 = getAddress();
        String address3 = huoPayAccountData.getAddress();
        if (address2 != null ? !address2.equals(address3) : address3 != null) {
            return false;
        }
        String addressTag2 = getAddressTag();
        String addressTag3 = huoPayAccountData.getAddressTag();
        if (addressTag2 != null ? !addressTag2.equals(addressTag3) : addressTag3 != null) {
            return false;
        }
        String hgUserId2 = getHgUserId();
        String hgUserId3 = huoPayAccountData.getHgUserId();
        if (hgUserId2 != null ? !hgUserId2.equals(hgUserId3) : hgUserId3 != null) {
            return false;
        }
        String hpUserId2 = getHpUserId();
        String hpUserId3 = huoPayAccountData.getHpUserId();
        return hpUserId2 != null ? hpUserId2.equals(hpUserId3) : hpUserId3 == null;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAddressTag() {
        return this.addressTag;
    }

    public String getChain() {
        return this.chain;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getHgUserId() {
        return this.hgUserId;
    }

    public String getHpUserId() {
        return this.hpUserId;
    }

    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int status2 = ((getStatus() + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String chain2 = getChain();
        int hashCode = (status2 * 59) + (chain2 == null ? 43 : chain2.hashCode());
        String address2 = getAddress();
        int hashCode2 = (hashCode * 59) + (address2 == null ? 43 : address2.hashCode());
        String addressTag2 = getAddressTag();
        int hashCode3 = (hashCode2 * 59) + (addressTag2 == null ? 43 : addressTag2.hashCode());
        String hgUserId2 = getHgUserId();
        int hashCode4 = (hashCode3 * 59) + (hgUserId2 == null ? 43 : hgUserId2.hashCode());
        String hpUserId2 = getHpUserId();
        int i12 = hashCode4 * 59;
        if (hpUserId2 != null) {
            i11 = hpUserId2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isAvailable() {
        return this.status == 1;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAddressTag(String str) {
        this.addressTag = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setHgUserId(String str) {
        this.hgUserId = str;
    }

    public void setHpUserId(String str) {
        this.hpUserId = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "HuoPayAccountData(status=" + getStatus() + ", currency=" + getCurrency() + ", chain=" + getChain() + ", address=" + getAddress() + ", addressTag=" + getAddressTag() + ", hgUserId=" + getHgUserId() + ", hpUserId=" + getHpUserId() + ")";
    }
}
