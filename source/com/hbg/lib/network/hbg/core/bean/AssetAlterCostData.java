package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AssetAlterCostData implements Serializable {
    private String account;
    private String currency;
    private String sysCost;
    private Long updatedAt;
    private String userCost;

    public String getAccount() {
        return this.account;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getSysCost() {
        return this.sysCost;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUserCost() {
        return this.userCost;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setSysCost(String str) {
        this.sysCost = str;
    }

    public void setUpdatedAt(Long l11) {
        this.updatedAt = l11;
    }

    public void setUserCost(String str) {
        this.userCost = str;
    }

    public String toString() {
        return "AssetAlterCostData{currency='" + this.currency + '\'' + ", account='" + this.account + '\'' + ", sysCost='" + this.sysCost + '\'' + ", userCost='" + this.userCost + '\'' + ", updatedAt=" + this.updatedAt + '}';
    }
}
