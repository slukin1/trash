package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InviteReturnSum implements Serializable {
    private static final long serialVersionUID = -2848597842865455824L;
    @SerializedName("brokerage-amount")
    private Double inviteReturnAmount;
    @SerializedName("brokerage-ht")
    private Double inviteReturnHt;
    @SerializedName("brokerage-point")
    private Double inviteReturnPoint;

    public Double getInviteReturnAmount() {
        return this.inviteReturnAmount;
    }

    public Double getInviteReturnHt() {
        return this.inviteReturnHt;
    }

    public Double getInviteReturnPoint() {
        return this.inviteReturnPoint;
    }

    public void setInviteReturnAmount(Double d11) {
        this.inviteReturnAmount = d11;
    }

    public void setInviteReturnHt(Double d11) {
        this.inviteReturnHt = d11;
    }

    public void setInviteReturnPoint(Double d11) {
        this.inviteReturnPoint = d11;
    }
}
