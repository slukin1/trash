package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.finance.viewhandler.OneOffAddressViewHandler;
import java.io.Serializable;
import s9.a;

public class OneOffAddress implements a, Serializable {
    public static final String STATE_ASSIGNED = "assigned";
    public static final String STATE_CONFIRMED = "confirmed";
    private static final long serialVersionUID = -327297473903839L;
    @SerializedName("account-id")
    private long accountId;
    private String address;
    @SerializedName("assigned-at")
    private long assignedAt;
    @SerializedName("confirmed-at")
    private long confirmedAt;
    @SerializedName("created-at")
    private long createdAt;
    private String currency;

    /* renamed from: id  reason: collision with root package name */
    private long f45381id;
    private String state;
    @SerializedName("updated-at")
    private long updatedAt;
    @SerializedName("user-id")
    private long userId;

    public long getAccountId() {
        return this.accountId;
    }

    public String getAddress() {
        return this.address;
    }

    public long getAssignedAt() {
        return this.assignedAt;
    }

    public long getConfirmedAt() {
        return this.confirmedAt;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getId() {
        return this.f45381id;
    }

    public String getState() {
        return this.state;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getViewHandlerName() {
        return OneOffAddressViewHandler.class.getName();
    }

    public void setAccountId(long j11) {
        this.accountId = j11;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssignedAt(long j11) {
        this.assignedAt = j11;
    }

    public void setConfirmedAt(long j11) {
        this.confirmedAt = j11;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setId(long j11) {
        this.f45381id = j11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }

    public void setUserId(long j11) {
        this.userId = j11;
    }
}
