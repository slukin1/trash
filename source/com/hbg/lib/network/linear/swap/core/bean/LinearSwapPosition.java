package com.hbg.lib.network.linear.swap.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.pro.socket.response.ContractPositionWsData;
import java.math.BigDecimal;

public class LinearSwapPosition extends ContractPositionWsData {
    private static final long serialVersionUID = 7519437576766416282L;
    @SerializedName("created_time")
    private long createdTime;
    public String fee;
    @SerializedName("funding_fee")
    public String fundingFee;
    @SerializedName("initial_margin")
    private String initialMargin;
    private boolean isFromNet;
    @SerializedName("maintenance_margin")
    private String maintenanceMargin;
    @SerializedName("margin_account")
    public String marginAccount;
    @SerializedName("margin_asset")
    public String marginAsset;
    @SerializedName("margin_mode")
    public String marginMode;
    @SerializedName("margin_rate")
    public String marginRate;
    @SerializedName("mark_price")
    private String markPrice;
    @SerializedName("open_avg_price")
    private String openAvgPrice;
    @SerializedName("position_side")
    private String positionSide;
    public String state;
    private int version;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinearSwapPosition linearSwapPosition = (LinearSwapPosition) obj;
        if (!TextUtils.equals(this.contractCode, linearSwapPosition.contractCode) || !TextUtils.equals(this.direction, linearSwapPosition.direction) || !TextUtils.equals(this.marginMode, linearSwapPosition.marginMode) || !TextUtils.equals(this.contractShortType, linearSwapPosition.contractShortType)) {
            return false;
        }
        return true;
    }

    public String getAvgCostPrice() {
        String str = this.costOpen;
        if (str == null || str.isEmpty()) {
            return this.openAvgPrice;
        }
        return this.costOpen;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public String getFee() {
        return this.fee;
    }

    public String getFinalPositionMargin() {
        String str = this.positionMargin;
        if (str == null || str.isEmpty()) {
            return this.initialMargin;
        }
        return this.positionMargin;
    }

    public String getFundingFee() {
        return this.fundingFee;
    }

    public String getInitialMargin() {
        return this.initialMargin;
    }

    public String getLastPrice() {
        return getPositionPrice();
    }

    public String getMaintenanceMargin() {
        return this.maintenanceMargin;
    }

    public String getMarginAccount() {
        return this.marginAccount;
    }

    public String getMarginAsset() {
        return this.marginAsset;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getMarginRate() {
        return this.marginRate;
    }

    public String getMarkPrice() {
        return this.markPrice;
    }

    public String getNewPositionRate() {
        String str = this.newRiskRate;
        if (str == null || str.isEmpty()) {
            return this.marginRate;
        }
        return this.newRiskRate;
    }

    public String getOpenAvgPrice() {
        return this.openAvgPrice;
    }

    public String getPositionPrice() {
        String str = this.lastPrice;
        if (str == null || str.isEmpty()) {
            return this.markPrice;
        }
        return this.lastPrice;
    }

    public String getPositionRate() {
        String str = this.riskRate;
        if (str == null || str.isEmpty()) {
            return this.marginRate;
        }
        return this.riskRate;
    }

    public String getPositionSide() {
        return this.positionSide;
    }

    public String getState() {
        return this.state;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean hasVolume() {
        return new BigDecimal(this.volume).doubleValue() > 0.0d;
    }

    public boolean isFromNet() {
        return this.isFromNet;
    }

    public void setCreatedTime(long j11) {
        this.createdTime = j11;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setFromNet(boolean z11) {
        this.isFromNet = z11;
    }

    public void setFundingFee(String str) {
        this.fundingFee = str;
    }

    public void setInitialMargin(String str) {
        this.initialMargin = str;
    }

    public void setMaintenanceMargin(String str) {
        this.maintenanceMargin = str;
    }

    public void setMarginAccount(String str) {
        this.marginAccount = str;
    }

    public void setMarginAsset(String str) {
        this.marginAsset = str;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setMarginRate(String str) {
        this.marginRate = str;
    }

    public void setMarkPrice(String str) {
        this.markPrice = str;
    }

    public void setOpenAvgPrice(String str) {
        this.openAvgPrice = str;
    }

    public void setPositionSide(String str) {
        this.positionSide = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }
}
