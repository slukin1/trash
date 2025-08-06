package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HuoPayOrderParam implements Serializable {
    @SerializedName("addr-tag")
    private String addrTag;
    private String address;
    private String amount;
    private String chain;
    private String currency;
    private String honey;
    private String token;

    public boolean canEqual(Object obj) {
        return obj instanceof HuoPayOrderParam;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HuoPayOrderParam)) {
            return false;
        }
        HuoPayOrderParam huoPayOrderParam = (HuoPayOrderParam) obj;
        if (!huoPayOrderParam.canEqual(this)) {
            return false;
        }
        String addrTag2 = getAddrTag();
        String addrTag3 = huoPayOrderParam.getAddrTag();
        if (addrTag2 != null ? !addrTag2.equals(addrTag3) : addrTag3 != null) {
            return false;
        }
        String address2 = getAddress();
        String address3 = huoPayOrderParam.getAddress();
        if (address2 != null ? !address2.equals(address3) : address3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = huoPayOrderParam.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String chain2 = getChain();
        String chain3 = huoPayOrderParam.getChain();
        if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = huoPayOrderParam.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String honey2 = getHoney();
        String honey3 = huoPayOrderParam.getHoney();
        if (honey2 != null ? !honey2.equals(honey3) : honey3 != null) {
            return false;
        }
        String token2 = getToken();
        String token3 = huoPayOrderParam.getToken();
        return token2 != null ? token2.equals(token3) : token3 == null;
    }

    public String getAddrTag() {
        return this.addrTag;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getChain() {
        return this.chain;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getHoney() {
        return this.honey;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        String addrTag2 = getAddrTag();
        int i11 = 43;
        int hashCode = addrTag2 == null ? 43 : addrTag2.hashCode();
        String address2 = getAddress();
        int hashCode2 = ((hashCode + 59) * 59) + (address2 == null ? 43 : address2.hashCode());
        String amount2 = getAmount();
        int hashCode3 = (hashCode2 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String chain2 = getChain();
        int hashCode4 = (hashCode3 * 59) + (chain2 == null ? 43 : chain2.hashCode());
        String currency2 = getCurrency();
        int hashCode5 = (hashCode4 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String honey2 = getHoney();
        int hashCode6 = (hashCode5 * 59) + (honey2 == null ? 43 : honey2.hashCode());
        String token2 = getToken();
        int i12 = hashCode6 * 59;
        if (token2 != null) {
            i11 = token2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddrTag(String str) {
        this.addrTag = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setHoney(String str) {
        this.honey = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "HuoPayOrderParam(addrTag=" + getAddrTag() + ", address=" + getAddress() + ", amount=" + getAmount() + ", chain=" + getChain() + ", currency=" + getCurrency() + ", honey=" + getHoney() + ", token=" + getToken() + ")";
    }
}
