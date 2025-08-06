package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionCurrencyInfo implements Serializable {
    @SerializedName("activity_id")
    private String activityId;
    @SerializedName("activity_title")
    private String activityTitle;
    @SerializedName("activity_url")
    private String activityUrl;
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
    @SerializedName("delivery_currency")
    private String deliveryCurrency;
    @SerializedName("delivery_date")
    private String deliveryDate;
    @SerializedName("delivery_time")
    private long deliveryTime;
    @SerializedName("exercise_price")
    private String exercisePrice;
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
    @SerializedName("option_code")
    private String optionCode;
    @SerializedName("option_right_type")
    private String optionRightType;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_precision")
    private int pricePrecision;
    @SerializedName("price_tick")
    private String priceTick;
    @SerializedName("quote_currency")
    private String quoteCurrency;
    private String symbol;
    @SerializedName("trade_partition")
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionCurrencyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionCurrencyInfo)) {
            return false;
        }
        OptionCurrencyInfo optionCurrencyInfo = (OptionCurrencyInfo) obj;
        if (!optionCurrencyInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionCurrencyInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionCurrencyInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = optionCurrencyInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = optionCurrencyInfo.getOptionCode();
        if (optionCode2 != null ? !optionCode2.equals(optionCode3) : optionCode3 != null) {
            return false;
        }
        String contractFace2 = getContractFace();
        String contractFace3 = optionCurrencyInfo.getContractFace();
        if (contractFace2 != null ? !contractFace2.equals(contractFace3) : contractFace3 != null) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = optionCurrencyInfo.getPriceTick();
        if (priceTick2 != null ? !priceTick2.equals(priceTick3) : priceTick3 != null) {
            return false;
        }
        String deliveryDate2 = getDeliveryDate();
        String deliveryDate3 = optionCurrencyInfo.getDeliveryDate();
        if (deliveryDate2 != null ? !deliveryDate2.equals(deliveryDate3) : deliveryDate3 != null) {
            return false;
        }
        if (getDeliveryTime() != optionCurrencyInfo.getDeliveryTime()) {
            return false;
        }
        String createDate2 = getCreateDate();
        String createDate3 = optionCurrencyInfo.getCreateDate();
        if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
            return false;
        }
        if (getContractStatus() != optionCurrencyInfo.getContractStatus() || getAmountPrecision() != optionCurrencyInfo.getAmountPrecision() || getFeeAmountPrecision() != optionCurrencyInfo.getFeeAmountPrecision() || getOtherAmountPrecision() != optionCurrencyInfo.getOtherAmountPrecision() || getPricePrecision() != optionCurrencyInfo.getPricePrecision()) {
            return false;
        }
        String limitOpen2 = getLimitOpen();
        String limitOpen3 = optionCurrencyInfo.getLimitOpen();
        if (limitOpen2 != null ? !limitOpen2.equals(limitOpen3) : limitOpen3 != null) {
            return false;
        }
        String limitClose2 = getLimitClose();
        String limitClose3 = optionCurrencyInfo.getLimitClose();
        if (limitClose2 != null ? !limitClose2.equals(limitClose3) : limitClose3 != null) {
            return false;
        }
        String marketOpen2 = getMarketOpen();
        String marketOpen3 = optionCurrencyInfo.getMarketOpen();
        if (marketOpen2 != null ? !marketOpen2.equals(marketOpen3) : marketOpen3 != null) {
            return false;
        }
        String marketClose2 = getMarketClose();
        String marketClose3 = optionCurrencyInfo.getMarketClose();
        if (marketClose2 != null ? !marketClose2.equals(marketClose3) : marketClose3 != null) {
            return false;
        }
        String contractShortType2 = getContractShortType();
        String contractShortType3 = optionCurrencyInfo.getContractShortType();
        if (contractShortType2 != null ? !contractShortType2.equals(contractShortType3) : contractShortType3 != null) {
            return false;
        }
        String optionRightType2 = getOptionRightType();
        String optionRightType3 = optionCurrencyInfo.getOptionRightType();
        if (optionRightType2 != null ? !optionRightType2.equals(optionRightType3) : optionRightType3 != null) {
            return false;
        }
        String exercisePrice2 = getExercisePrice();
        String exercisePrice3 = optionCurrencyInfo.getExercisePrice();
        if (exercisePrice2 != null ? !exercisePrice2.equals(exercisePrice3) : exercisePrice3 != null) {
            return false;
        }
        String deliveryCurrency2 = getDeliveryCurrency();
        String deliveryCurrency3 = optionCurrencyInfo.getDeliveryCurrency();
        if (deliveryCurrency2 != null ? !deliveryCurrency2.equals(deliveryCurrency3) : deliveryCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = optionCurrencyInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionCurrencyInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String activityTitle2 = getActivityTitle();
        String activityTitle3 = optionCurrencyInfo.getActivityTitle();
        if (activityTitle2 != null ? !activityTitle2.equals(activityTitle3) : activityTitle3 != null) {
            return false;
        }
        String activityId2 = getActivityId();
        String activityId3 = optionCurrencyInfo.getActivityId();
        if (activityId2 != null ? !activityId2.equals(activityId3) : activityId3 != null) {
            return false;
        }
        String activityUrl2 = getActivityUrl();
        String activityUrl3 = optionCurrencyInfo.getActivityUrl();
        return activityUrl2 != null ? activityUrl2.equals(activityUrl3) : activityUrl3 == null;
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

    public String getDeliveryCurrency() {
        return this.deliveryCurrency;
    }

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public long getDeliveryTime() {
        return this.deliveryTime;
    }

    public String getExercisePrice() {
        return this.exercisePrice;
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

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getOptionRightType() {
        return this.optionRightType;
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

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String optionCode2 = getOptionCode();
        int hashCode4 = (hashCode3 * 59) + (optionCode2 == null ? 43 : optionCode2.hashCode());
        String contractFace2 = getContractFace();
        int hashCode5 = (hashCode4 * 59) + (contractFace2 == null ? 43 : contractFace2.hashCode());
        String priceTick2 = getPriceTick();
        int hashCode6 = (hashCode5 * 59) + (priceTick2 == null ? 43 : priceTick2.hashCode());
        String deliveryDate2 = getDeliveryDate();
        int hashCode7 = (hashCode6 * 59) + (deliveryDate2 == null ? 43 : deliveryDate2.hashCode());
        long deliveryTime2 = getDeliveryTime();
        int i12 = (hashCode7 * 59) + ((int) (deliveryTime2 ^ (deliveryTime2 >>> 32)));
        String createDate2 = getCreateDate();
        int hashCode8 = (((((((((((i12 * 59) + (createDate2 == null ? 43 : createDate2.hashCode())) * 59) + getContractStatus()) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getOtherAmountPrecision()) * 59) + getPricePrecision();
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
        String optionRightType2 = getOptionRightType();
        int hashCode14 = (hashCode13 * 59) + (optionRightType2 == null ? 43 : optionRightType2.hashCode());
        String exercisePrice2 = getExercisePrice();
        int hashCode15 = (hashCode14 * 59) + (exercisePrice2 == null ? 43 : exercisePrice2.hashCode());
        String deliveryCurrency2 = getDeliveryCurrency();
        int hashCode16 = (hashCode15 * 59) + (deliveryCurrency2 == null ? 43 : deliveryCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode17 = (hashCode16 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String tradePartition2 = getTradePartition();
        int hashCode18 = (hashCode17 * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String activityTitle2 = getActivityTitle();
        int hashCode19 = (hashCode18 * 59) + (activityTitle2 == null ? 43 : activityTitle2.hashCode());
        String activityId2 = getActivityId();
        int hashCode20 = (hashCode19 * 59) + (activityId2 == null ? 43 : activityId2.hashCode());
        String activityUrl2 = getActivityUrl();
        int i13 = hashCode20 * 59;
        if (activityUrl2 != null) {
            i11 = activityUrl2.hashCode();
        }
        return i13 + i11;
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

    public void setDeliveryCurrency(String str) {
        this.deliveryCurrency = str;
    }

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public void setDeliveryTime(long j11) {
        this.deliveryTime = j11;
    }

    public void setExercisePrice(String str) {
        this.exercisePrice = str;
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

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setOptionRightType(String str) {
        this.optionRightType = str;
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

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "OptionCurrencyInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", optionCode=" + getOptionCode() + ", contractFace=" + getContractFace() + ", priceTick=" + getPriceTick() + ", deliveryDate=" + getDeliveryDate() + ", deliveryTime=" + getDeliveryTime() + ", createDate=" + getCreateDate() + ", contractStatus=" + getContractStatus() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", pricePrecision=" + getPricePrecision() + ", limitOpen=" + getLimitOpen() + ", limitClose=" + getLimitClose() + ", marketOpen=" + getMarketOpen() + ", marketClose=" + getMarketClose() + ", contractShortType=" + getContractShortType() + ", optionRightType=" + getOptionRightType() + ", exercisePrice=" + getExercisePrice() + ", deliveryCurrency=" + getDeliveryCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", tradePartition=" + getTradePartition() + ", activityTitle=" + getActivityTitle() + ", activityId=" + getActivityId() + ", activityUrl=" + getActivityUrl() + ")";
    }
}
