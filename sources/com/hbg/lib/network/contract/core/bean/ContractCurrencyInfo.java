package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ContractCurrencyInfo implements Serializable {
    public static final int CONTRACT_STATUS_DELIVERY = 6;
    public static final int CONTRACT_STATUS_DELIVERY_COMPLETED = 8;
    public static final int CONTRACT_STATUS_SETTLE = 5;
    public static final int CONTRACT_STATUS_SETTLE_COMPLETED = 7;
    public static final int CONTRACT_STATUS_STOP = 3;
    public static final int CONTRACT_STATUS_STOP_EXCHANGE = 9;
    public static final int CONTRACT_STATUS_TRADE = 1;
    public static final int TYPE_CONTRACT = 1;
    public static final int TYPE_SWAP = 0;
    @SerializedName("activity_id")
    private String activityId;
    @SerializedName("activity_title")
    private String activityTitle;
    @SerializedName("activity_url")
    private String activityUrl;
    private List<CurrencyAdjust> adjust;
    @SerializedName("amount_precision")
    private int amountPrecision;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_size")
    private String contractFace;
    @SerializedName("contract_short_type")
    private String contractShortType;
    @SerializedName("contract_status")
    private int contractStatus;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("create_date")
    private String createDate;
    @SerializedName("delivery_date")
    private String delivDate;
    @SerializedName("delivery_time")
    private long delivTime;
    @SerializedName("fee_amount_precision")
    private int feeAmountPrecision;
    private boolean isPercentVisible = true;
    private int itemType = 0;
    @SerializedName("limit_close")
    private String limitClose;
    @SerializedName("limit_open")
    private String limitOpen;
    @SerializedName("market_open")
    private String marketOpen;
    private boolean nightMode;
    private boolean notSupportTrade;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_precision")
    private int pricePrecision;
    @SerializedName("price_tick")
    private String priceTick;
    @SerializedName("settlement_time")
    private long settlementTime;
    private String symbol;
    private SymbolPrice symbolPrice;

    public static class CurrencyAdjust implements Serializable {
        private static final long serialVersionUID = 7121549187324544143L;
        private String adjustFactor;
        private int leverRate;

        public boolean canEqual(Object obj) {
            return obj instanceof CurrencyAdjust;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CurrencyAdjust)) {
                return false;
            }
            CurrencyAdjust currencyAdjust = (CurrencyAdjust) obj;
            if (!currencyAdjust.canEqual(this)) {
                return false;
            }
            String adjustFactor2 = getAdjustFactor();
            String adjustFactor3 = currencyAdjust.getAdjustFactor();
            if (adjustFactor2 != null ? adjustFactor2.equals(adjustFactor3) : adjustFactor3 == null) {
                return getLeverRate() == currencyAdjust.getLeverRate();
            }
            return false;
        }

        public String getAdjustFactor() {
            return this.adjustFactor;
        }

        public int getLeverRate() {
            return this.leverRate;
        }

        public int hashCode() {
            String adjustFactor2 = getAdjustFactor();
            return (((adjustFactor2 == null ? 43 : adjustFactor2.hashCode()) + 59) * 59) + getLeverRate();
        }

        public void setAdjustFactor(String str) {
            this.adjustFactor = str;
        }

        public void setLeverRate(int i11) {
            this.leverRate = i11;
        }

        public String toString() {
            return "CurrencyAdjust{adjustFactor=" + this.adjustFactor + ", leverRate=" + this.leverRate + '}';
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContractCurrencyInfo contractCurrencyInfo = (ContractCurrencyInfo) obj;
        if (!this.contractCode.equals(contractCurrencyInfo.contractCode) || !this.contractType.equals(contractCurrencyInfo.contractType) || !this.contractShortType.equals(contractCurrencyInfo.contractShortType)) {
            return false;
        }
        return true;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public String getActivityTitle() {
        return this.activityTitle;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public List<CurrencyAdjust> getAdjust() {
        return this.adjust;
    }

    public int getAmountPrecision() {
        return this.amountPrecision;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractFace() {
        return this.contractFace;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public int getContractStatus() {
        return this.contractStatus;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public String getDelivDate() {
        return this.delivDate;
    }

    public long getDelivTime() {
        return this.delivTime;
    }

    public int getFeeAmountPrecision() {
        return this.feeAmountPrecision;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getLimitClose() {
        return this.limitClose;
    }

    public String getLimitOpen() {
        return this.limitOpen;
    }

    public String getMarketOpen() {
        return this.marketOpen;
    }

    public int getOtherAmountPrecision() {
        return this.otherAmountPrecision;
    }

    public int getPricePrecision() {
        return this.pricePrecision;
    }

    public String getPriceTick() {
        return this.priceTick;
    }

    public long getSettlementTime() {
        return this.settlementTime;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public SymbolPrice getSymbolPrice() {
        return this.symbolPrice;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.contractCode, this.contractType, this.contractShortType});
    }

    public boolean isNightMode() {
        return this.nightMode;
    }

    public boolean isNotSupportTrade() {
        return this.notSupportTrade;
    }

    public boolean isPercentVisible() {
        return this.isPercentVisible;
    }

    public boolean isShowCover() {
        int i11 = this.contractStatus;
        return i11 == 6 || i11 == 5 || i11 == 8 || i11 == 7 || i11 == 3 || i11 == 9;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setActivityTitle(String str) {
        this.activityTitle = str;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setAdjust(List<CurrencyAdjust> list) {
        this.adjust = list;
    }

    public void setAmountPrecision(int i11) {
        this.amountPrecision = i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractFace(String str) {
        this.contractFace = str;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setContractStatus(int i11) {
        this.contractStatus = i11;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public void setDelivDate(String str) {
        this.delivDate = str;
    }

    public void setDelivTime(long j11) {
        this.delivTime = j11;
    }

    public void setFeeAmountPrecision(int i11) {
        this.feeAmountPrecision = i11;
    }

    public void setItemType(int i11) {
        this.itemType = i11;
    }

    public void setLimitClose(String str) {
        this.limitClose = str;
    }

    public void setLimitOpen(String str) {
        this.limitOpen = str;
    }

    public void setMarketOpen(String str) {
        this.marketOpen = str;
    }

    public void setNightMode(boolean z11) {
        this.nightMode = z11;
    }

    public void setNotSupportTrade(boolean z11) {
        this.notSupportTrade = z11;
    }

    public void setOtherAmountPrecision(int i11) {
        this.otherAmountPrecision = i11;
    }

    public void setPercentVisible(boolean z11) {
        this.isPercentVisible = z11;
    }

    public void setPricePrecision(int i11) {
        this.pricePrecision = i11;
    }

    public void setPriceTick(String str) {
        this.priceTick = str;
    }

    public void setSettlementTime(long j11) {
        this.settlementTime = j11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolPrice(SymbolPrice symbolPrice2) {
        this.symbolPrice = symbolPrice2;
    }

    public String toString() {
        return "ContractCurrencyInfo(itemType=" + getItemType() + ", symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", contractFace=" + getContractFace() + ", priceTick=" + getPriceTick() + ", delivDate=" + getDelivDate() + ", delivTime=" + getDelivTime() + ", settlementTime=" + getSettlementTime() + ", createDate=" + getCreateDate() + ", contractStatus=" + getContractStatus() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", pricePrecision=" + getPricePrecision() + ", limitOpen=" + getLimitOpen() + ", limitClose=" + getLimitClose() + ", marketOpen=" + getMarketOpen() + ", contractShortType=" + getContractShortType() + ", activityTitle=" + getActivityTitle() + ", activityId=" + getActivityId() + ", activityUrl=" + getActivityUrl() + ", adjust=" + getAdjust() + ", symbolPrice=" + getSymbolPrice() + ", isPercentVisible=" + isPercentVisible() + ", nightMode=" + isNightMode() + ", notSupportTrade=" + isNotSupportTrade() + ")";
    }
}
