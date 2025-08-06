package com.huobi.points.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Points implements Serializable {
    public static final String STATE_CANCELED = "canceled";
    public static final String STATE_DENIED = "denied";
    public static final String STATE_FINISHED = "finished";
    public static final String STATE_FROZEN = "frozen";
    public static final String STATE_PRE_SUBMITTED = "pre-submitted";
    public static final String STATE_SUBMITTED = "submitted";
    public static final String STATE_UNFROZEN = "unfrozen";
    public static final String STATE_UNKNONW = "unknown";
    private static final long serialVersionUID = 3357701693115991507L;
    private String account;
    @SerializedName("created-at")
    private long createdAt;
    private String currency;
    private String email;
    @SerializedName("gift-currency")
    private String giftCurrency;

    /* renamed from: id  reason: collision with root package name */
    private long f80471id;
    private String name;
    private String phone;
    private String price;
    private int quantity;
    private String state;
    @SerializedName("total-amount")
    private String totalAmount;
    @SerializedName("total-gift")
    private String totalGift;
    @SerializedName("total-points")
    private String totalPoints;
    private String type;
    private String uid;
    @SerializedName("updated-at")
    private long updatedAt;

    public String getAccount() {
        return this.account;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGiftCurrency() {
        return this.giftCurrency;
    }

    public long getId() {
        return this.f80471id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getState() {
        return this.state;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTotalGift() {
        return this.totalGift;
    }

    public String getTotalPoints() {
        return this.totalPoints;
    }

    public String getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setGiftCurrency(String str) {
        this.giftCurrency = str;
    }

    public void setId(long j11) {
        this.f80471id = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuantity(int i11) {
        this.quantity = i11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public void setTotalGift(String str) {
        this.totalGift = str;
    }

    public void setTotalPoints(String str) {
        this.totalPoints = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }

    public String toString() {
        return "Points{account='" + this.account + '\'' + ", createdAt=" + this.createdAt + ", currency='" + this.currency + '\'' + ", email='" + this.email + '\'' + ", giftCurrency='" + this.giftCurrency + '\'' + ", id=" + this.f80471id + ", name='" + this.name + '\'' + ", phone='" + this.phone + '\'' + ", price='" + this.price + '\'' + ", quantity=" + this.quantity + ", state='" + this.state + '\'' + ", totalAmount='" + this.totalAmount + '\'' + ", totalGift='" + this.totalGift + '\'' + ", totalPoints='" + this.totalPoints + '\'' + ", type='" + this.type + '\'' + ", uid='" + this.uid + '\'' + ", updatedAt=" + this.updatedAt + '}';
    }
}
