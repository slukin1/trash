package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.option.core.util.OptionDirection;
import java.io.Serializable;

public class OptionPositionInfo implements Serializable {
    public static final String RIGHT_TYPE_C = "C";
    public static final String RIGHT_TYPE_P = "P";
    private static final long serialVersionUID = 7961532336761266315L;
    private String available;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("cost_hold")
    private String costHold;
    @SerializedName("cost_open")
    private String costOpen;
    @SerializedName("delivery_date")
    private String deliveryDate;
    private String direction;
    @SerializedName("exercise_price")
    private String exercisePrice;
    private String frozen;
    @SerializedName("index_price")
    private String indexPrice;
    @SerializedName("last_price")
    private String lastPrice;
    @SerializedName("margin_asset")
    private String marginAsset;
    @SerializedName("margin_currency")
    private String marginCurrency;
    @SerializedName("option_code")
    private String optionCode;
    @SerializedName("option_right_type")
    private String optionRightType;
    @SerializedName("position_margin")
    private String positionMargin;
    @SerializedName("position_value")
    private String positionValue;
    private String profit;
    @SerializedName("profit_rate")
    private String profitRate;
    @SerializedName("profit_unreal")
    private String profitUnreal;
    @SerializedName("quote_asset")
    private String quoteAsset;
    private String symbol;
    @SerializedName("trade_partition")
    private String tradePartition;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionPositionInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionPositionInfo)) {
            return false;
        }
        OptionPositionInfo optionPositionInfo = (OptionPositionInfo) obj;
        if (!optionPositionInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionPositionInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionPositionInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionPositionInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = optionPositionInfo.getOptionCode();
        if (optionCode2 != null ? !optionCode2.equals(optionCode3) : optionCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = optionPositionInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = optionPositionInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = optionPositionInfo.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String frozen2 = getFrozen();
        String frozen3 = optionPositionInfo.getFrozen();
        if (frozen2 != null ? !frozen2.equals(frozen3) : frozen3 != null) {
            return false;
        }
        String costOpen2 = getCostOpen();
        String costOpen3 = optionPositionInfo.getCostOpen();
        if (costOpen2 != null ? !costOpen2.equals(costOpen3) : costOpen3 != null) {
            return false;
        }
        String costHold2 = getCostHold();
        String costHold3 = optionPositionInfo.getCostHold();
        if (costHold2 != null ? !costHold2.equals(costHold3) : costHold3 != null) {
            return false;
        }
        String profitUnreal2 = getProfitUnreal();
        String profitUnreal3 = optionPositionInfo.getProfitUnreal();
        if (profitUnreal2 != null ? !profitUnreal2.equals(profitUnreal3) : profitUnreal3 != null) {
            return false;
        }
        String profitRate2 = getProfitRate();
        String profitRate3 = optionPositionInfo.getProfitRate();
        if (profitRate2 != null ? !profitRate2.equals(profitRate3) : profitRate3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = optionPositionInfo.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        String positionMargin2 = getPositionMargin();
        String positionMargin3 = optionPositionInfo.getPositionMargin();
        if (positionMargin2 != null ? !positionMargin2.equals(positionMargin3) : positionMargin3 != null) {
            return false;
        }
        String marginCurrency2 = getMarginCurrency();
        String marginCurrency3 = optionPositionInfo.getMarginCurrency();
        if (marginCurrency2 != null ? !marginCurrency2.equals(marginCurrency3) : marginCurrency3 != null) {
            return false;
        }
        String positionValue2 = getPositionValue();
        String positionValue3 = optionPositionInfo.getPositionValue();
        if (positionValue2 != null ? !positionValue2.equals(positionValue3) : positionValue3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = optionPositionInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String lastPrice2 = getLastPrice();
        String lastPrice3 = optionPositionInfo.getLastPrice();
        if (lastPrice2 != null ? !lastPrice2.equals(lastPrice3) : lastPrice3 != null) {
            return false;
        }
        String deliveryDate2 = getDeliveryDate();
        String deliveryDate3 = optionPositionInfo.getDeliveryDate();
        if (deliveryDate2 != null ? !deliveryDate2.equals(deliveryDate3) : deliveryDate3 != null) {
            return false;
        }
        String optionRightType2 = getOptionRightType();
        String optionRightType3 = optionPositionInfo.getOptionRightType();
        if (optionRightType2 != null ? !optionRightType2.equals(optionRightType3) : optionRightType3 != null) {
            return false;
        }
        String exercisePrice2 = getExercisePrice();
        String exercisePrice3 = optionPositionInfo.getExercisePrice();
        if (exercisePrice2 != null ? !exercisePrice2.equals(exercisePrice3) : exercisePrice3 != null) {
            return false;
        }
        String quoteAsset2 = getQuoteAsset();
        String quoteAsset3 = optionPositionInfo.getQuoteAsset();
        if (quoteAsset2 != null ? !quoteAsset2.equals(quoteAsset3) : quoteAsset3 != null) {
            return false;
        }
        String marginAsset2 = getMarginAsset();
        String marginAsset3 = optionPositionInfo.getMarginAsset();
        if (marginAsset2 != null ? !marginAsset2.equals(marginAsset3) : marginAsset3 != null) {
            return false;
        }
        String indexPrice2 = getIndexPrice();
        String indexPrice3 = optionPositionInfo.getIndexPrice();
        return indexPrice2 != null ? indexPrice2.equals(indexPrice3) : indexPrice3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getCostHold() {
        return this.costHold;
    }

    public String getCostOpen() {
        return this.costOpen;
    }

    public String getDeliveryDate() {
        return this.deliveryDate;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getExercisePrice() {
        return this.exercisePrice;
    }

    public String getFrozen() {
        return this.frozen;
    }

    public String getIndexPrice() {
        return this.indexPrice;
    }

    public String getLastPrice() {
        return this.lastPrice;
    }

    public String getMarginAsset() {
        return this.marginAsset;
    }

    public String getMarginCurrency() {
        return this.marginCurrency;
    }

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getOptionRightType() {
        return this.optionRightType;
    }

    public String getPositionMargin() {
        return this.positionMargin;
    }

    public String getPositionValue() {
        return this.positionValue;
    }

    public String getProfit() {
        return this.profit;
    }

    public String getProfitRate() {
        return this.profitRate;
    }

    public String getProfitUnreal() {
        return this.profitUnreal;
    }

    public String getQuoteAsset() {
        return this.quoteAsset;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String tradePartition2 = getTradePartition();
        int hashCode2 = ((hashCode + 59) * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String optionCode2 = getOptionCode();
        int hashCode4 = (hashCode3 * 59) + (optionCode2 == null ? 43 : optionCode2.hashCode());
        String contractType2 = getContractType();
        int hashCode5 = (hashCode4 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String volume2 = getVolume();
        int hashCode6 = (hashCode5 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String available2 = getAvailable();
        int hashCode7 = (hashCode6 * 59) + (available2 == null ? 43 : available2.hashCode());
        String frozen2 = getFrozen();
        int hashCode8 = (hashCode7 * 59) + (frozen2 == null ? 43 : frozen2.hashCode());
        String costOpen2 = getCostOpen();
        int hashCode9 = (hashCode8 * 59) + (costOpen2 == null ? 43 : costOpen2.hashCode());
        String costHold2 = getCostHold();
        int hashCode10 = (hashCode9 * 59) + (costHold2 == null ? 43 : costHold2.hashCode());
        String profitUnreal2 = getProfitUnreal();
        int hashCode11 = (hashCode10 * 59) + (profitUnreal2 == null ? 43 : profitUnreal2.hashCode());
        String profitRate2 = getProfitRate();
        int hashCode12 = (hashCode11 * 59) + (profitRate2 == null ? 43 : profitRate2.hashCode());
        String profit2 = getProfit();
        int hashCode13 = (hashCode12 * 59) + (profit2 == null ? 43 : profit2.hashCode());
        String positionMargin2 = getPositionMargin();
        int hashCode14 = (hashCode13 * 59) + (positionMargin2 == null ? 43 : positionMargin2.hashCode());
        String marginCurrency2 = getMarginCurrency();
        int hashCode15 = (hashCode14 * 59) + (marginCurrency2 == null ? 43 : marginCurrency2.hashCode());
        String positionValue2 = getPositionValue();
        int hashCode16 = (hashCode15 * 59) + (positionValue2 == null ? 43 : positionValue2.hashCode());
        String direction2 = getDirection();
        int hashCode17 = (hashCode16 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String lastPrice2 = getLastPrice();
        int hashCode18 = (hashCode17 * 59) + (lastPrice2 == null ? 43 : lastPrice2.hashCode());
        String deliveryDate2 = getDeliveryDate();
        int hashCode19 = (hashCode18 * 59) + (deliveryDate2 == null ? 43 : deliveryDate2.hashCode());
        String optionRightType2 = getOptionRightType();
        int hashCode20 = (hashCode19 * 59) + (optionRightType2 == null ? 43 : optionRightType2.hashCode());
        String exercisePrice2 = getExercisePrice();
        int hashCode21 = (hashCode20 * 59) + (exercisePrice2 == null ? 43 : exercisePrice2.hashCode());
        String quoteAsset2 = getQuoteAsset();
        int hashCode22 = (hashCode21 * 59) + (quoteAsset2 == null ? 43 : quoteAsset2.hashCode());
        String marginAsset2 = getMarginAsset();
        int hashCode23 = (hashCode22 * 59) + (marginAsset2 == null ? 43 : marginAsset2.hashCode());
        String indexPrice2 = getIndexPrice();
        int i12 = hashCode23 * 59;
        if (indexPrice2 != null) {
            i11 = indexPrice2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isDuo() {
        return OptionDirection.BUY.direction.equalsIgnoreCase(this.direction);
    }

    public boolean isRiseType() {
        return "C".equals(getOptionRightType());
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCostHold(String str) {
        this.costHold = str;
    }

    public void setCostOpen(String str) {
        this.costOpen = str;
    }

    public void setDeliveryDate(String str) {
        this.deliveryDate = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setExercisePrice(String str) {
        this.exercisePrice = str;
    }

    public void setFrozen(String str) {
        this.frozen = str;
    }

    public void setIndexPrice(String str) {
        this.indexPrice = str;
    }

    public void setLastPrice(String str) {
        this.lastPrice = str;
    }

    public void setMarginAsset(String str) {
        this.marginAsset = str;
    }

    public void setMarginCurrency(String str) {
        this.marginCurrency = str;
    }

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setOptionRightType(String str) {
        this.optionRightType = str;
    }

    public void setPositionMargin(String str) {
        this.positionMargin = str;
    }

    public void setPositionValue(String str) {
        this.positionValue = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setProfitRate(String str) {
        this.profitRate = str;
    }

    public void setProfitUnreal(String str) {
        this.profitUnreal = str;
    }

    public void setQuoteAsset(String str) {
        this.quoteAsset = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "OptionPositionInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", contractCode=" + getContractCode() + ", optionCode=" + getOptionCode() + ", contractType=" + getContractType() + ", volume=" + getVolume() + ", available=" + getAvailable() + ", frozen=" + getFrozen() + ", costOpen=" + getCostOpen() + ", costHold=" + getCostHold() + ", profitUnreal=" + getProfitUnreal() + ", profitRate=" + getProfitRate() + ", profit=" + getProfit() + ", positionMargin=" + getPositionMargin() + ", marginCurrency=" + getMarginCurrency() + ", positionValue=" + getPositionValue() + ", direction=" + getDirection() + ", lastPrice=" + getLastPrice() + ", deliveryDate=" + getDeliveryDate() + ", optionRightType=" + getOptionRightType() + ", exercisePrice=" + getExercisePrice() + ", quoteAsset=" + getQuoteAsset() + ", marginAsset=" + getMarginAsset() + ", indexPrice=" + getIndexPrice() + ")";
    }
}
