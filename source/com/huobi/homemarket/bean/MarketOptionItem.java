package com.huobi.homemarket.bean;

import com.hbg.lib.network.option.core.bean.OptionMarketIndexInfo;
import java.io.Serializable;

public class MarketOptionItem implements Serializable {
    private OptionMarketIndexInfo callInfo;
    private String contractType;
    private String deliveryDate;
    private String exercisePrice;
    private OptionMarketIndexInfo putInfo;
    private String symbol;
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof MarketOptionItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketOptionItem)) {
            return false;
        }
        MarketOptionItem marketOptionItem = (MarketOptionItem) obj;
        if (!marketOptionItem.canEqual(this)) {
            return false;
        }
        OptionMarketIndexInfo callInfo2 = getCallInfo();
        OptionMarketIndexInfo callInfo3 = marketOptionItem.getCallInfo();
        if (callInfo2 != null ? !callInfo2.equals(callInfo3) : callInfo3 != null) {
            return false;
        }
        OptionMarketIndexInfo putInfo2 = getPutInfo();
        OptionMarketIndexInfo putInfo3 = marketOptionItem.getPutInfo();
        if (putInfo2 != null ? !putInfo2.equals(putInfo3) : putInfo3 != null) {
            return false;
        }
        String exercisePrice2 = getExercisePrice();
        String exercisePrice3 = marketOptionItem.getExercisePrice();
        if (exercisePrice2 != null ? !exercisePrice2.equals(exercisePrice3) : exercisePrice3 != null) {
            return false;
        }
        String deliveryDate2 = getDeliveryDate();
        String deliveryDate3 = marketOptionItem.getDeliveryDate();
        if (deliveryDate2 != null ? !deliveryDate2.equals(deliveryDate3) : deliveryDate3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = marketOptionItem.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = marketOptionItem.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = marketOptionItem.getTradePartition();
        return tradePartition2 != null ? tradePartition2.equals(tradePartition3) : tradePartition3 == null;
    }

    public OptionMarketIndexInfo getCallInfo() {
        return this.callInfo;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public String getExercisePrice() {
        return this.exercisePrice;
    }

    public OptionMarketIndexInfo getPutInfo() {
        return this.putInfo;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        OptionMarketIndexInfo callInfo2 = getCallInfo();
        int i11 = 43;
        int hashCode = callInfo2 == null ? 43 : callInfo2.hashCode();
        OptionMarketIndexInfo putInfo2 = getPutInfo();
        int hashCode2 = ((hashCode + 59) * 59) + (putInfo2 == null ? 43 : putInfo2.hashCode());
        String exercisePrice2 = getExercisePrice();
        int hashCode3 = (hashCode2 * 59) + (exercisePrice2 == null ? 43 : exercisePrice2.hashCode());
        String deliveryDate2 = getDeliveryDate();
        int hashCode4 = (hashCode3 * 59) + (deliveryDate2 == null ? 43 : deliveryDate2.hashCode());
        String contractType2 = getContractType();
        int hashCode5 = (hashCode4 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String symbol2 = getSymbol();
        int hashCode6 = (hashCode5 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String tradePartition2 = getTradePartition();
        int i12 = hashCode6 * 59;
        if (tradePartition2 != null) {
            i11 = tradePartition2.hashCode();
        }
        return i12 + i11;
    }

    public void setCallInfo(OptionMarketIndexInfo optionMarketIndexInfo) {
        this.callInfo = optionMarketIndexInfo;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public void setExercisePrice(String str) {
        this.exercisePrice = str;
    }

    public void setPutInfo(OptionMarketIndexInfo optionMarketIndexInfo) {
        this.putInfo = optionMarketIndexInfo;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "MarketOptionItem(callInfo=" + getCallInfo() + ", putInfo=" + getPutInfo() + ", exercisePrice=" + getExercisePrice() + ", deliveryDate=" + getDeliveryDate() + ", contractType=" + getContractType() + ", symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ")";
    }
}
