package com.hbg.lib.data.future.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.option.core.bean.OptionCurrencyInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FutureContractInfo implements Serializable {
    public static final int CONTRACT_STATUS_DELIVERY = 6;
    public static final int CONTRACT_STATUS_DELIVERY_COMPLETED = 8;
    public static final int CONTRACT_STATUS_SETTLE = 5;
    public static final int CONTRACT_STATUS_SETTLE_COMPLETED = 7;
    public static final int CONTRACT_STATUS_STOP = 3;
    public static final int CONTRACT_STATUS_STOP_EXCHANGE = 9;
    public static final int CONTRACT_STATUS_TO_BE_OPEN = 4;
    public static final int CONTRACT_STATUS_TRADE = 1;
    public static final int DELIVERY_NOT_SET = -1;
    public static final String MARGIN_CROSS = "cross";
    public static final String MARGIN_ISOLATED = "isolated";
    public static final String RIGHT_TYPE_C = "C";
    public static final String RIGHT_TYPE_P = "P";
    public String activityId;
    public String activityTitle;
    public String activityUrl;
    public List<CurrencyAdjust> adjust;
    public int amountPrecision;
    public String businessType;
    public String contractCode;
    public String contractFace;
    public String contractShortType;
    public int contractStatus;
    public String contractType;
    public String createDate;
    public String deliveryCurrency;
    public String deliveryDate;
    public long deliveryTime;
    public String exercisePrice;
    public int feeAmountPrecision;
    public String limitClose;
    public String limitOpen;
    public String marketClose;
    public String marketOpen;
    public boolean notSupportTrade;
    public String optionCode;
    public String optionRightType;
    public int otherAmountPrecision;
    public String pair;
    public List<Map<String, String>> precisionList;
    public int pricePrecision;
    public String priceTick;
    public String quoteCurrency;
    public Long settlementTime;
    public String supportMarginMode;
    public String symbol;
    public String tradePartition;

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

    public FutureContractInfo convert(FutureContractInfo futureContractInfo, LinearSwapContractInfo linearSwapContractInfo) {
        futureContractInfo.setSymbol(linearSwapContractInfo.getSymbol());
        futureContractInfo.setContractCode(linearSwapContractInfo.getContractCode());
        futureContractInfo.setContractType(linearSwapContractInfo.getContractType());
        futureContractInfo.setContractFace(linearSwapContractInfo.getContractFace());
        futureContractInfo.setPriceTick(linearSwapContractInfo.getPriceTick());
        futureContractInfo.setDeliveryDate(linearSwapContractInfo.getDeliveryDate());
        futureContractInfo.setDeliveryTime(linearSwapContractInfo.getDeliveryTime());
        futureContractInfo.setSettlementTime(linearSwapContractInfo.getSettlementTime());
        futureContractInfo.setCreateDate(linearSwapContractInfo.getCreateDate());
        futureContractInfo.setContractStatus(linearSwapContractInfo.getContractStatus());
        futureContractInfo.setAmountPrecision(linearSwapContractInfo.getAmountPrecision());
        futureContractInfo.setFeeAmountPrecision(linearSwapContractInfo.getFeeAmountPrecision());
        futureContractInfo.setOtherAmountPrecision(linearSwapContractInfo.getOtherAmountPrecision());
        futureContractInfo.setPricePrecision(linearSwapContractInfo.getPricePrecision());
        futureContractInfo.setLimitOpen(linearSwapContractInfo.getLimitOpen());
        futureContractInfo.setLimitClose(linearSwapContractInfo.getLimitClose());
        futureContractInfo.setMarketOpen(linearSwapContractInfo.getMarketOpen());
        futureContractInfo.setMarketClose(linearSwapContractInfo.getMarketClose());
        futureContractInfo.setContractShortType(linearSwapContractInfo.getContractShortType());
        futureContractInfo.setSupportMarginMode(linearSwapContractInfo.getSupportMarginMode());
        futureContractInfo.setNotSupportTrade(linearSwapContractInfo.isNotSupportTrade());
        try {
            futureContractInfo.setQuoteCurrency(linearSwapContractInfo.getContractCode().split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        futureContractInfo.setTradePartition(linearSwapContractInfo.getTradePartition());
        futureContractInfo.setPair(linearSwapContractInfo.getPair());
        futureContractInfo.setBusinessType(linearSwapContractInfo.getBusinessType());
        futureContractInfo.setPrecisionList(linearSwapContractInfo.getPrecisionList());
        return futureContractInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FutureContractInfo futureContractInfo = (FutureContractInfo) obj;
        if (!this.contractCode.equals(futureContractInfo.contractCode) || !this.contractType.equals(futureContractInfo.contractType) || !this.contractShortType.equals(futureContractInfo.contractShortType)) {
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

    public String getBusinessType() {
        return this.businessType;
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

    public Long getFDeliveryTime() {
        return this.settlementTime;
    }

    public long getFSettlementTime() {
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

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getOptionRightType() {
        return this.optionRightType;
    }

    public int getOtherAmountPrecision() {
        return this.otherAmountPrecision;
    }

    public String getPair() {
        return this.pair;
    }

    public List<Map<String, String>> getPrecisionList() {
        return this.precisionList;
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

    public Long getSettlementTime() {
        return this.settlementTime;
    }

    public String getSupportMarginMode() {
        return this.supportMarginMode;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.contractCode, this.contractType, this.contractShortType});
    }

    public boolean isLinearSwapFuture() {
        return "futures".equals(this.businessType);
    }

    public boolean isLinearSwapSwap() {
        return "swap".equals(this.businessType);
    }

    public boolean isNotSupportTrade() {
        return this.notSupportTrade;
    }

    public boolean isOnlySupportCross() {
        return "futures".equals(this.businessType) && MARGIN_CROSS.equals(this.supportMarginMode);
    }

    public boolean isRightTypeC() {
        return "C".equalsIgnoreCase(this.optionRightType);
    }

    public boolean isShowCover() {
        int i11 = this.contractStatus;
        return i11 == 6 || i11 == 5 || i11 == 8 || i11 == 7 || i11 == 3 || i11 == 4;
    }

    public boolean isSupportCross() {
        return MARGIN_CROSS.equals(this.supportMarginMode);
    }

    public FutureContractInfo optionConvert(FutureContractInfo futureContractInfo, OptionCurrencyInfo optionCurrencyInfo) {
        futureContractInfo.setSymbol(optionCurrencyInfo.getSymbol());
        futureContractInfo.setContractCode(optionCurrencyInfo.getContractCode());
        futureContractInfo.setContractType(optionCurrencyInfo.getContractType());
        futureContractInfo.setOptionCode(optionCurrencyInfo.getOptionCode());
        futureContractInfo.setContractFace(optionCurrencyInfo.getContractFace());
        futureContractInfo.setPriceTick(optionCurrencyInfo.getPriceTick());
        futureContractInfo.setDeliveryDate(optionCurrencyInfo.getDeliveryDate());
        futureContractInfo.setDeliveryTime(optionCurrencyInfo.getDeliveryTime());
        futureContractInfo.setCreateDate(optionCurrencyInfo.getCreateDate());
        futureContractInfo.setContractStatus(optionCurrencyInfo.getContractStatus());
        futureContractInfo.setAmountPrecision(optionCurrencyInfo.getAmountPrecision());
        futureContractInfo.setFeeAmountPrecision(optionCurrencyInfo.getFeeAmountPrecision());
        futureContractInfo.setOtherAmountPrecision(optionCurrencyInfo.getOtherAmountPrecision());
        futureContractInfo.setPricePrecision(optionCurrencyInfo.getPricePrecision());
        futureContractInfo.setLimitOpen(optionCurrencyInfo.getLimitOpen());
        futureContractInfo.setLimitClose(optionCurrencyInfo.getLimitClose());
        futureContractInfo.setMarketOpen(optionCurrencyInfo.getMarketOpen());
        futureContractInfo.setMarketClose(optionCurrencyInfo.getMarketClose());
        futureContractInfo.setContractShortType(optionCurrencyInfo.getContractShortType());
        futureContractInfo.setOptionRightType(optionCurrencyInfo.getOptionRightType());
        futureContractInfo.setExercisePrice(optionCurrencyInfo.getExercisePrice());
        futureContractInfo.setDeliveryCurrency(optionCurrencyInfo.getDeliveryCurrency());
        futureContractInfo.setQuoteCurrency(optionCurrencyInfo.getQuoteCurrency());
        futureContractInfo.setTradePartition(optionCurrencyInfo.getTradePartition());
        return futureContractInfo;
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

    public void setBusinessType(String str) {
        this.businessType = str;
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

    public void setNotSupportTrade(boolean z11) {
        this.notSupportTrade = z11;
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

    public void setPair(String str) {
        this.pair = str;
    }

    public void setPrecisionList(List<Map<String, String>> list) {
        this.precisionList = list;
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

    public void setSettlementTime(Long l11) {
        this.settlementTime = l11;
    }

    public void setSupportMarginMode(String str) {
        this.supportMarginMode = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "FutureContractInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", optionCode=" + getOptionCode() + ", contractFace=" + getContractFace() + ", priceTick=" + getPriceTick() + ", deliveryDate=" + getDeliveryDate() + ", deliveryTime=" + getDeliveryTime() + ", settlementTime=" + getSettlementTime() + ", createDate=" + getCreateDate() + ", contractStatus=" + getContractStatus() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", pricePrecision=" + getPricePrecision() + ", limitOpen=" + getLimitOpen() + ", limitClose=" + getLimitClose() + ", marketOpen=" + getMarketOpen() + ", marketClose=" + getMarketClose() + ", contractShortType=" + getContractShortType() + ", optionRightType=" + getOptionRightType() + ", exercisePrice=" + getExercisePrice() + ", deliveryCurrency=" + getDeliveryCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", tradePartition=" + getTradePartition() + ", precisionList=" + getPrecisionList() + ", pair=" + getPair() + ", activityTitle=" + getActivityTitle() + ", activityId=" + getActivityId() + ", activityUrl=" + getActivityUrl() + ", adjust=" + getAdjust() + ", supportMarginMode=" + getSupportMarginMode() + ", notSupportTrade=" + isNotSupportTrade() + ", businessType=" + getBusinessType() + ")";
    }
}
