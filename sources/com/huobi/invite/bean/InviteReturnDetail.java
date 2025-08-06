package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InviteReturnDetail implements Serializable {
    private static final long serialVersionUID = -8434607888767879264L;
    private String account;
    @SerializedName("amount-sum")
    private Double amountSum;
    @SerializedName("point-sum")
    private Double pointSum;
    @SerializedName("total-sum")
    private Double totalSum;

    public String getAccount() {
        return this.account;
    }

    public Double getAmountSum() {
        return this.amountSum;
    }

    public Double getPointSum() {
        return this.pointSum;
    }

    public Double getTotalSum() {
        return this.totalSum;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAmountSum(Double d11) {
        this.amountSum = d11;
    }

    public void setPointSum(Double d11) {
        this.pointSum = d11;
    }

    public void setTotalSum(Double d11) {
        this.totalSum = d11;
    }
}
