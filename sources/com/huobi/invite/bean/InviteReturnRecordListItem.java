package com.huobi.invite.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.invite.viewhandler.InviteReturnRecordListItemHandler;
import java.io.Serializable;

public class InviteReturnRecordListItem implements s9.a, Serializable {
    private static final long serialVersionUID = -5376041395244466137L;
    private String account;
    @SerializedName("brokerage-amount")
    private Double brokerageAmount;
    @SerializedName("brokerage-ht")
    private Double brokerageHt;
    @SerializedName("brokerage-point")
    private Double brokeragePoint;
    public a callback;
    private long date;

    /* renamed from: id  reason: collision with root package name */
    private int f74508id;
    private String state;

    public interface a {
        void M5(InviteReturnRecordListItem inviteReturnRecordListItem);
    }

    public String getAccount() {
        return this.account;
    }

    public Double getBrokerageAmount() {
        return this.brokerageAmount;
    }

    public Double getBrokerageHt() {
        return this.brokerageHt;
    }

    public Double getBrokeragePoint() {
        return this.brokeragePoint;
    }

    public long getDate() {
        return this.date;
    }

    public int getId() {
        return this.f74508id;
    }

    public String getState() {
        return this.state;
    }

    public String getViewHandlerName() {
        return InviteReturnRecordListItemHandler.class.getName();
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setBrokerageAmount(Double d11) {
        this.brokerageAmount = d11;
    }

    public void setBrokerageHt(Double d11) {
        this.brokerageHt = d11;
    }

    public void setBrokeragePoint(Double d11) {
        this.brokeragePoint = d11;
    }

    public void setDate(long j11) {
        this.date = j11;
    }

    public void setId(int i11) {
        this.f74508id = i11;
    }

    public void setState(String str) {
        this.state = str;
    }
}
