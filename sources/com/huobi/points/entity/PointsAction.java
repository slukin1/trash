package com.huobi.points.entity;

import com.google.gson.annotations.SerializedName;
import com.huobi.points.viewhandler.PointsActionViewHandler;
import java.io.Serializable;
import s9.a;

public class PointsAction implements a, Serializable {
    public static final String DIRECTION_IN = "in";
    public static final String DIRECTION_OUT = "out";
    public static final String STATE_FINISHED = "finished";
    public static final String STATE_INVALID = "invalid";
    public static final String STATE_PREPARED = "prepared";
    public static final String TYPE_ACTIVITY_TRANSFER_IN = "activity-transfer-in";
    public static final String TYPE_ACTIVITY_TRANSFER_OUT = "activity-transfer-out";
    public static final String TYPE_ALL_MARGIN_INTEREST_DEDUCTION = "margin-interest-deduction,super-margin-interest-deduct-repay";
    public static final String TYPE_BROKERAGE = "brokerage";
    public static final String TYPE_FEE_DEDUCTION = "fee-deduction";
    public static final String TYPE_GLOBAL_FORCE_POINT_TO_SYSTEM = "global-force-point-to-system";
    public static final String TYPE_GLOBAL_FORCE_SYSTEM_TO_POINT = "global-force-system-to-point";
    public static final String TYPE_INVALID = "invalid";
    public static final String TYPE_MARGIN_INTEREST_DEDUCTION = "margin-interest-deduction";
    public static final String TYPE_MASTER_POINT_TRANSFER_IN = "master-point-transfer-in";
    public static final String TYPE_MASTER_POINT_TRANSFER_OUT = "master-point-transfer-out";
    public static final String TYPE_MINE_POOL_PAY = "mine-pool-pay";
    public static final String TYPE_POINTS_EXCHANGE = "limit-point-transfer-in-auto";
    public static final String TYPE_POINTS_REFUND = "point-buy-back-point-to-system";
    public static final String TYPE_POINTS_REVOKE = "limit-point-transfer-out";
    public static final String TYPE_PURCHASE = "purchase";
    public static final String TYPE_PURCHASE_GIFT = "purchase-gift";
    public static final String TYPE_SUPER_MARGIN_INTEREST_DEDUCTION = "super-margin-interest-deduct-repay";
    public static final String TYPE_TRANSFER = "transfer-out,transfer-in";
    public static final String TYPE_TRANSFER_BETWEEN_MASTER = "master-point-transfer-in,master-point-transfer-out";
    public static final String TYPE_TRANSFER_IN = "transfer-in";
    public static final String TYPE_TRANSFER_OUT = "transfer-out";
    private static final long serialVersionUID = -1237816315314136247L;
    @SerializedName("created-at")
    private long createdAt;
    private String currency;
    private String direction;

    /* renamed from: id  reason: collision with root package name */
    private long f80472id;
    @SerializedName("order-id")
    private long orderId;
    private String points;
    private String price;
    private String state;
    private String type;
    @SerializedName("updated-at")
    private long updatedAt;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDirection() {
        return this.direction;
    }

    public long getId() {
        return this.f80472id;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getPoints() {
        return this.points;
    }

    public String getPrice() {
        return this.price;
    }

    public String getState() {
        return this.state;
    }

    public String getType() {
        return this.type;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getViewHandlerName() {
        return PointsActionViewHandler.class.getName();
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setId(long j11) {
        this.f80472id = j11;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }
}
