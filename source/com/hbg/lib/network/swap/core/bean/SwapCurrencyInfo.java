package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class SwapCurrencyInfo implements Serializable {
    public static final int CONTRACT_STATUS_DELIVERY = 6;
    public static final int CONTRACT_STATUS_DELIVERY_COMPLETED = 8;
    public static final int CONTRACT_STATUS_SETTLE = 5;
    public static final int CONTRACT_STATUS_SETTLE_COMPLETED = 7;
    public static final int CONTRACT_STATUS_STOP = 3;
    public static final int CONTRACT_STATUS_TO_BE_OPEN = 4;
    public static final int CONTRACT_STATUS_TRADE = 1;
    public static final int DELIVERY_NOT_SET = -1;
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
    private String deliveryDate;
    @SerializedName("delivery_time")
    private long deliveryTime;
    @SerializedName("fee_amount_precision")
    private int feeAmountPrecision;
    @SerializedName("limit_close")
    private String limitClose;
    @SerializedName("limit_open")
    private String limitOpen;
    @SerializedName("market_close")
    private String marketClose;
    @SerializedName("market_open")
    private String marketOpen;
    private boolean notSupportTrade;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_precision")
    private int pricePrecision;
    @SerializedName("price_tick")
    private String priceTick;
    @SerializedName("settlement_time")
    private Long settlementTime;
    private String symbol;

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

    public boolean canEqual(Object obj) {
        return obj instanceof SwapCurrencyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCurrencyInfo)) {
            return false;
        }
        SwapCurrencyInfo swapCurrencyInfo = (SwapCurrencyInfo) obj;
        if (!swapCurrencyInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = swapCurrencyInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapCurrencyInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = swapCurrencyInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractFace2 = getContractFace();
        String contractFace3 = swapCurrencyInfo.getContractFace();
        if (contractFace2 != null ? !contractFace2.equals(contractFace3) : contractFace3 != null) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = swapCurrencyInfo.getPriceTick();
        if (priceTick2 != null ? !priceTick2.equals(priceTick3) : priceTick3 != null) {
            return false;
        }
        String deliveryDate2 = getDeliveryDate();
        String deliveryDate3 = swapCurrencyInfo.getDeliveryDate();
        if (deliveryDate2 != null ? !deliveryDate2.equals(deliveryDate3) : deliveryDate3 != null) {
            return false;
        }
        if (getDeliveryTime() != swapCurrencyInfo.getDeliveryTime()) {
            return false;
        }
        Long settlementTime2 = getSettlementTime();
        Long settlementTime3 = swapCurrencyInfo.getSettlementTime();
        if (settlementTime2 != null ? !settlementTime2.equals(settlementTime3) : settlementTime3 != null) {
            return false;
        }
        String createDate2 = getCreateDate();
        String createDate3 = swapCurrencyInfo.getCreateDate();
        if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
            return false;
        }
        if (getContractStatus() != swapCurrencyInfo.getContractStatus() || getAmountPrecision() != swapCurrencyInfo.getAmountPrecision() || getFeeAmountPrecision() != swapCurrencyInfo.getFeeAmountPrecision() || getOtherAmountPrecision() != swapCurrencyInfo.getOtherAmountPrecision() || getPricePrecision() != swapCurrencyInfo.getPricePrecision()) {
            return false;
        }
        String limitOpen2 = getLimitOpen();
        String limitOpen3 = swapCurrencyInfo.getLimitOpen();
        if (limitOpen2 != null ? !limitOpen2.equals(limitOpen3) : limitOpen3 != null) {
            return false;
        }
        String limitClose2 = getLimitClose();
        String limitClose3 = swapCurrencyInfo.getLimitClose();
        if (limitClose2 != null ? !limitClose2.equals(limitClose3) : limitClose3 != null) {
            return false;
        }
        String marketOpen2 = getMarketOpen();
        String marketOpen3 = swapCurrencyInfo.getMarketOpen();
        if (marketOpen2 != null ? !marketOpen2.equals(marketOpen3) : marketOpen3 != null) {
            return false;
        }
        String marketClose2 = getMarketClose();
        String marketClose3 = swapCurrencyInfo.getMarketClose();
        if (marketClose2 != null ? !marketClose2.equals(marketClose3) : marketClose3 != null) {
            return false;
        }
        String contractShortType2 = getContractShortType();
        String contractShortType3 = swapCurrencyInfo.getContractShortType();
        if (contractShortType2 != null ? !contractShortType2.equals(contractShortType3) : contractShortType3 != null) {
            return false;
        }
        String activityTitle2 = getActivityTitle();
        String activityTitle3 = swapCurrencyInfo.getActivityTitle();
        if (activityTitle2 != null ? !activityTitle2.equals(activityTitle3) : activityTitle3 != null) {
            return false;
        }
        String activityId2 = getActivityId();
        String activityId3 = swapCurrencyInfo.getActivityId();
        if (activityId2 != null ? !activityId2.equals(activityId3) : activityId3 != null) {
            return false;
        }
        String activityUrl2 = getActivityUrl();
        String activityUrl3 = swapCurrencyInfo.getActivityUrl();
        if (activityUrl2 != null ? !activityUrl2.equals(activityUrl3) : activityUrl3 != null) {
            return false;
        }
        List<CurrencyAdjust> adjust2 = getAdjust();
        List<CurrencyAdjust> adjust3 = swapCurrencyInfo.getAdjust();
        if (adjust2 != null ? adjust2.equals(adjust3) : adjust3 == null) {
            return isNotSupportTrade() == swapCurrencyInfo.isNotSupportTrade();
        }
        return false;
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

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public long getDeliveryTime() {
        return this.deliveryTime;
    }

    public int getFeeAmountPrecision() {
        return this.feeAmountPrecision;
    }

    public String getLimitClose() {
        return this.limitClose;
    }

    public String getLimitOpen() {
        return this.limitOpen;
    }

    public String getMarketClose() {
        return this.marketClose;
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

    public Long getSettlementTime() {
        return this.settlementTime;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractFace2 = getContractFace();
        int hashCode4 = (hashCode3 * 59) + (contractFace2 == null ? 43 : contractFace2.hashCode());
        String priceTick2 = getPriceTick();
        int hashCode5 = (hashCode4 * 59) + (priceTick2 == null ? 43 : priceTick2.hashCode());
        String deliveryDate2 = getDeliveryDate();
        int hashCode6 = (hashCode5 * 59) + (deliveryDate2 == null ? 43 : deliveryDate2.hashCode());
        long deliveryTime2 = getDeliveryTime();
        int i12 = (hashCode6 * 59) + ((int) (deliveryTime2 ^ (deliveryTime2 >>> 32)));
        Long settlementTime2 = getSettlementTime();
        int hashCode7 = (i12 * 59) + (settlementTime2 == null ? 43 : settlementTime2.hashCode());
        String createDate2 = getCreateDate();
        int hashCode8 = (((((((((((hashCode7 * 59) + (createDate2 == null ? 43 : createDate2.hashCode())) * 59) + getContractStatus()) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getOtherAmountPrecision()) * 59) + getPricePrecision();
        String limitOpen2 = getLimitOpen();
        int hashCode9 = (hashCode8 * 59) + (limitOpen2 == null ? 43 : limitOpen2.hashCode());
        String limitClose2 = getLimitClose();
        int hashCode10 = (hashCode9 * 59) + (limitClose2 == null ? 43 : limitClose2.hashCode());
        String marketOpen2 = getMarketOpen();
        int hashCode11 = (hashCode10 * 59) + (marketOpen2 == null ? 43 : marketOpen2.hashCode());
        String marketClose2 = getMarketClose();
        int hashCode12 = (hashCode11 * 59) + (marketClose2 == null ? 43 : marketClose2.hashCode());
        String contractShortType2 = getContractShortType();
        int hashCode13 = (hashCode12 * 59) + (contractShortType2 == null ? 43 : contractShortType2.hashCode());
        String activityTitle2 = getActivityTitle();
        int hashCode14 = (hashCode13 * 59) + (activityTitle2 == null ? 43 : activityTitle2.hashCode());
        String activityId2 = getActivityId();
        int hashCode15 = (hashCode14 * 59) + (activityId2 == null ? 43 : activityId2.hashCode());
        String activityUrl2 = getActivityUrl();
        int hashCode16 = (hashCode15 * 59) + (activityUrl2 == null ? 43 : activityUrl2.hashCode());
        List<CurrencyAdjust> adjust2 = getAdjust();
        int i13 = hashCode16 * 59;
        if (adjust2 != null) {
            i11 = adjust2.hashCode();
        }
        return ((i13 + i11) * 59) + (isNotSupportTrade() ? 79 : 97);
    }

    public boolean isNotSupportTrade() {
        return this.notSupportTrade;
    }

    public boolean isShowCover() {
        int i11 = this.contractStatus;
        return i11 == 6 || i11 == 5 || i11 == 8 || i11 == 7 || i11 == 3 || i11 == 4;
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

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public void setDeliveryTime(long j11) {
        this.deliveryTime = j11;
    }

    public void setFeeAmountPrecision(int i11) {
        this.feeAmountPrecision = i11;
    }

    public void setLimitClose(String str) {
        this.limitClose = str;
    }

    public void setLimitOpen(String str) {
        this.limitOpen = str;
    }

    public void setMarketClose(String str) {
        this.marketClose = str;
    }

    public void setMarketOpen(String str) {
        this.marketOpen = str;
    }

    public void setNotSupportTrade(boolean z11) {
        this.notSupportTrade = z11;
    }

    public void setOtherAmountPrecision(int i11) {
        this.otherAmountPrecision = i11;
    }

    public void setPricePrecision(int i11) {
        this.pricePrecision = i11;
    }

    public void setPriceTick(String str) {
        this.priceTick = str;
    }

    public void setSettlementTime(Long l11) {
        this.settlementTime = l11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "SwapCurrencyInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", contractFace=" + getContractFace() + ", priceTick=" + getPriceTick() + ", deliveryDate=" + getDeliveryDate() + ", deliveryTime=" + getDeliveryTime() + ", settlementTime=" + getSettlementTime() + ", createDate=" + getCreateDate() + ", contractStatus=" + getContractStatus() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", pricePrecision=" + getPricePrecision() + ", limitOpen=" + getLimitOpen() + ", limitClose=" + getLimitClose() + ", marketOpen=" + getMarketOpen() + ", marketClose=" + getMarketClose() + ", contractShortType=" + getContractShortType() + ", activityTitle=" + getActivityTitle() + ", activityId=" + getActivityId() + ", activityUrl=" + getActivityUrl() + ", adjust=" + getAdjust() + ", notSupportTrade=" + isNotSupportTrade() + ")";
    }
}
