package com.huobi.points.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huobi.points.viewhandler.PointsPackViewOpeningHandler;
import com.huobi.points.viewhandler.PointsPackViewPendingHandler;
import com.huobi.points.viewhandler.PointsPackViewSoldOutHandler;
import java.io.Serializable;
import s9.a;

public class PointsPack implements Serializable, a {
    public static final String PURCHASABLE_TYPE_FORBIDDEN = "forbidden";
    public static final String PURCHASABLE_TYPE_UNKNOWN = "unknown";
    public static final String PURCHASABLE_TYPE_UNKNOWN_ALLOW = "allow";
    public static final String STATE_CLOSED = "closed";
    public static final String STATE_EXPIRED = "expired";
    public static final String STATE_INVISIBLE = "invisible";
    public static final String STATE_OPENING = "opening";
    public static final String STATE_PENDING = "pending";
    public static final String STATE_SOLD_OUT = "sold-out";
    public static final String STATE_UNKNOWN = "unknown";
    private static final long serialVersionUID = -7121386817487237991L;
    @SerializedName("close-at")
    private long closeAt;
    private String currency;
    private String extra;
    @SerializedName("gift-amount")
    private String giftAmount;
    @SerializedName("gift-currency")
    private String giftCurrency;

    /* renamed from: id  reason: collision with root package name */
    private long f80473id;
    private long limit;
    private String name;
    @Expose(serialize = false)
    public hq.a onIntervalCancelListener;
    @SerializedName("open-at")
    private long openAt;
    private long points;
    private String price;
    private String purchasable;
    private long quota;
    private String state;
    private String tag;
    @SerializedName("updated-at")
    private long updatedAt;
    @SerializedName(" white-tags")
    private String whiteTags;

    public long getCloseAt() {
        return this.closeAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getGiftAmount() {
        return this.giftAmount;
    }

    public String getGiftCurrency() {
        return this.giftCurrency;
    }

    public long getId() {
        return this.f80473id;
    }

    public long getLimit() {
        return this.limit;
    }

    public String getName() {
        return this.name;
    }

    public hq.a getOnIntervalCancelListener() {
        return this.onIntervalCancelListener;
    }

    public long getOpenAt() {
        return this.openAt;
    }

    public long getPoints() {
        return this.points;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPurchasable() {
        return this.purchasable;
    }

    public long getQuota() {
        return this.quota;
    }

    public String getState() {
        return this.state;
    }

    public String getTag() {
        return this.tag;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getViewHandlerName() {
        if (STATE_PENDING.equals(this.state)) {
            return PointsPackViewPendingHandler.class.getName();
        }
        if (STATE_OPENING.equals(this.state)) {
            return PointsPackViewOpeningHandler.class.getName();
        }
        if (STATE_SOLD_OUT.equals(this.state)) {
            return PointsPackViewSoldOutHandler.class.getName();
        }
        return PointsPackViewPendingHandler.class.getName();
    }

    public String getWhiteTags() {
        return this.whiteTags;
    }

    public void setCloseAt(long j11) {
        this.closeAt = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setGiftAmount(String str) {
        this.giftAmount = str;
    }

    public void setGiftCurrency(String str) {
        this.giftCurrency = str;
    }

    public void setId(long j11) {
        this.f80473id = j11;
    }

    public void setLimit(long j11) {
        this.limit = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnIntervalCancelListener(hq.a aVar) {
        this.onIntervalCancelListener = aVar;
    }

    public void setOpenAt(long j11) {
        this.openAt = j11;
    }

    public void setPoints(long j11) {
        this.points = j11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPurchasable(String str) {
        this.purchasable = str;
    }

    public void setQuota(long j11) {
        this.quota = j11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }

    public void setWhiteTags(String str) {
        this.whiteTags = str;
    }
}
