package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionMarketIndexInfo implements Serializable {
    public static final String RIGHT_TYPE_C = "C";
    public static final String RIGHT_TYPE_P = "P";
    private String amount;
    @SerializedName("ask_one")
    private String askOne;
    @SerializedName("bid_one")
    private String bidOne;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("delta")
    private String delta;
    @SerializedName("exercise_price")
    private String exercisePrice;
    @SerializedName("gamma")
    private String gamma;
    @SerializedName("index_price")
    private String indexPrice;

    /* renamed from: iv  reason: collision with root package name */
    private String f69259iv;
    @SerializedName("iv_ask_one")
    private String ivAskOne;
    @SerializedName("iv_bid_one")
    private String ivBidOne;
    @SerializedName("iv_latest_price")
    private String ivLatestPrice;
    @SerializedName("iv_mark_price")
    private String ivMarkPrice;
    @SerializedName("last_price")
    private String latestPrice;
    @SerializedName("mark_price")
    private String markPrice;
    @SerializedName("option_code")
    private String optionCode;
    @SerializedName("option_right_type")
    private String optionRightType;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("theta")
    private String theta;
    @SerializedName("trade_partition")
    private String tradePartition;
    @SerializedName("vega")
    private String vega;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionMarketIndexInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionMarketIndexInfo)) {
            return false;
        }
        OptionMarketIndexInfo optionMarketIndexInfo = (OptionMarketIndexInfo) obj;
        if (!optionMarketIndexInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionMarketIndexInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionMarketIndexInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = optionMarketIndexInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionMarketIndexInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = optionMarketIndexInfo.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = optionMarketIndexInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String iv2 = getIv();
        String iv3 = optionMarketIndexInfo.getIv();
        if (iv2 != null ? !iv2.equals(iv3) : iv3 != null) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = optionMarketIndexInfo.getOptionCode();
        if (optionCode2 != null ? !optionCode2.equals(optionCode3) : optionCode3 != null) {
            return false;
        }
        String ivLatestPrice2 = getIvLatestPrice();
        String ivLatestPrice3 = optionMarketIndexInfo.getIvLatestPrice();
        if (ivLatestPrice2 != null ? !ivLatestPrice2.equals(ivLatestPrice3) : ivLatestPrice3 != null) {
            return false;
        }
        String ivAskOne2 = getIvAskOne();
        String ivAskOne3 = optionMarketIndexInfo.getIvAskOne();
        if (ivAskOne2 != null ? !ivAskOne2.equals(ivAskOne3) : ivAskOne3 != null) {
            return false;
        }
        String ivBidOne2 = getIvBidOne();
        String ivBidOne3 = optionMarketIndexInfo.getIvBidOne();
        if (ivBidOne2 != null ? !ivBidOne2.equals(ivBidOne3) : ivBidOne3 != null) {
            return false;
        }
        String ivMarkPrice2 = getIvMarkPrice();
        String ivMarkPrice3 = optionMarketIndexInfo.getIvMarkPrice();
        if (ivMarkPrice2 != null ? !ivMarkPrice2.equals(ivMarkPrice3) : ivMarkPrice3 != null) {
            return false;
        }
        String delta2 = getDelta();
        String delta3 = optionMarketIndexInfo.getDelta();
        if (delta2 != null ? !delta2.equals(delta3) : delta3 != null) {
            return false;
        }
        String gamma2 = getGamma();
        String gamma3 = optionMarketIndexInfo.getGamma();
        if (gamma2 != null ? !gamma2.equals(gamma3) : gamma3 != null) {
            return false;
        }
        String theta2 = getTheta();
        String theta3 = optionMarketIndexInfo.getTheta();
        if (theta2 != null ? !theta2.equals(theta3) : theta3 != null) {
            return false;
        }
        String vega2 = getVega();
        String vega3 = optionMarketIndexInfo.getVega();
        if (vega2 != null ? !vega2.equals(vega3) : vega3 != null) {
            return false;
        }
        String askOne2 = getAskOne();
        String askOne3 = optionMarketIndexInfo.getAskOne();
        if (askOne2 != null ? !askOne2.equals(askOne3) : askOne3 != null) {
            return false;
        }
        String bidOne2 = getBidOne();
        String bidOne3 = optionMarketIndexInfo.getBidOne();
        if (bidOne2 != null ? !bidOne2.equals(bidOne3) : bidOne3 != null) {
            return false;
        }
        String latestPrice2 = getLatestPrice();
        String latestPrice3 = optionMarketIndexInfo.getLatestPrice();
        if (latestPrice2 != null ? !latestPrice2.equals(latestPrice3) : latestPrice3 != null) {
            return false;
        }
        String markPrice2 = getMarkPrice();
        String markPrice3 = optionMarketIndexInfo.getMarkPrice();
        if (markPrice2 != null ? !markPrice2.equals(markPrice3) : markPrice3 != null) {
            return false;
        }
        String indexPrice2 = getIndexPrice();
        String indexPrice3 = optionMarketIndexInfo.getIndexPrice();
        if (indexPrice2 != null ? !indexPrice2.equals(indexPrice3) : indexPrice3 != null) {
            return false;
        }
        String exercisePrice2 = getExercisePrice();
        String exercisePrice3 = optionMarketIndexInfo.getExercisePrice();
        if (exercisePrice2 != null ? !exercisePrice2.equals(exercisePrice3) : exercisePrice3 != null) {
            return false;
        }
        String optionRightType2 = getOptionRightType();
        String optionRightType3 = optionMarketIndexInfo.getOptionRightType();
        return optionRightType2 != null ? optionRightType2.equals(optionRightType3) : optionRightType3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getAskOne() {
        return this.askOne;
    }

    public String getBidOne() {
        return this.bidOne;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getDelta() {
        return this.delta;
    }

    public String getExercisePrice() {
        return this.exercisePrice;
    }

    public String getGamma() {
        return this.gamma;
    }

    public String getIndexPrice() {
        return this.indexPrice;
    }

    public String getIv() {
        return this.f69259iv;
    }

    public String getIvAskOne() {
        return this.ivAskOne;
    }

    public String getIvBidOne() {
        return this.ivBidOne;
    }

    public String getIvLatestPrice() {
        return this.ivLatestPrice;
    }

    public String getIvMarkPrice() {
        return this.ivMarkPrice;
    }

    public String getLatestPrice() {
        return this.latestPrice;
    }

    public String getMarkPrice() {
        return this.markPrice;
    }

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getOptionRightType() {
        return this.optionRightType;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTheta() {
        return this.theta;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public String getVega() {
        return this.vega;
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
        String contractType2 = getContractType();
        int hashCode3 = (hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode4 = (hashCode3 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String amount2 = getAmount();
        int hashCode5 = (hashCode4 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String volume2 = getVolume();
        int hashCode6 = (hashCode5 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String iv2 = getIv();
        int hashCode7 = (hashCode6 * 59) + (iv2 == null ? 43 : iv2.hashCode());
        String optionCode2 = getOptionCode();
        int hashCode8 = (hashCode7 * 59) + (optionCode2 == null ? 43 : optionCode2.hashCode());
        String ivLatestPrice2 = getIvLatestPrice();
        int hashCode9 = (hashCode8 * 59) + (ivLatestPrice2 == null ? 43 : ivLatestPrice2.hashCode());
        String ivAskOne2 = getIvAskOne();
        int hashCode10 = (hashCode9 * 59) + (ivAskOne2 == null ? 43 : ivAskOne2.hashCode());
        String ivBidOne2 = getIvBidOne();
        int hashCode11 = (hashCode10 * 59) + (ivBidOne2 == null ? 43 : ivBidOne2.hashCode());
        String ivMarkPrice2 = getIvMarkPrice();
        int hashCode12 = (hashCode11 * 59) + (ivMarkPrice2 == null ? 43 : ivMarkPrice2.hashCode());
        String delta2 = getDelta();
        int hashCode13 = (hashCode12 * 59) + (delta2 == null ? 43 : delta2.hashCode());
        String gamma2 = getGamma();
        int hashCode14 = (hashCode13 * 59) + (gamma2 == null ? 43 : gamma2.hashCode());
        String theta2 = getTheta();
        int hashCode15 = (hashCode14 * 59) + (theta2 == null ? 43 : theta2.hashCode());
        String vega2 = getVega();
        int hashCode16 = (hashCode15 * 59) + (vega2 == null ? 43 : vega2.hashCode());
        String askOne2 = getAskOne();
        int hashCode17 = (hashCode16 * 59) + (askOne2 == null ? 43 : askOne2.hashCode());
        String bidOne2 = getBidOne();
        int hashCode18 = (hashCode17 * 59) + (bidOne2 == null ? 43 : bidOne2.hashCode());
        String latestPrice2 = getLatestPrice();
        int hashCode19 = (hashCode18 * 59) + (latestPrice2 == null ? 43 : latestPrice2.hashCode());
        String markPrice2 = getMarkPrice();
        int hashCode20 = (hashCode19 * 59) + (markPrice2 == null ? 43 : markPrice2.hashCode());
        String indexPrice2 = getIndexPrice();
        int hashCode21 = (hashCode20 * 59) + (indexPrice2 == null ? 43 : indexPrice2.hashCode());
        String exercisePrice2 = getExercisePrice();
        int hashCode22 = (hashCode21 * 59) + (exercisePrice2 == null ? 43 : exercisePrice2.hashCode());
        String optionRightType2 = getOptionRightType();
        int i12 = hashCode22 * 59;
        if (optionRightType2 != null) {
            i11 = optionRightType2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isCallType() {
        return "C".equalsIgnoreCase(getOptionRightType());
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setAskOne(String str) {
        this.askOne = str;
    }

    public void setBidOne(String str) {
        this.bidOne = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setDelta(String str) {
        this.delta = str;
    }

    public void setExercisePrice(String str) {
        this.exercisePrice = str;
    }

    public void setGamma(String str) {
        this.gamma = str;
    }

    public void setIndexPrice(String str) {
        this.indexPrice = str;
    }

    public void setIv(String str) {
        this.f69259iv = str;
    }

    public void setIvAskOne(String str) {
        this.ivAskOne = str;
    }

    public void setIvBidOne(String str) {
        this.ivBidOne = str;
    }

    public void setIvLatestPrice(String str) {
        this.ivLatestPrice = str;
    }

    public void setIvMarkPrice(String str) {
        this.ivMarkPrice = str;
    }

    public void setLatestPrice(String str) {
        this.latestPrice = str;
    }

    public void setMarkPrice(String str) {
        this.markPrice = str;
    }

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setOptionRightType(String str) {
        this.optionRightType = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTheta(String str) {
        this.theta = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public void setVega(String str) {
        this.vega = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "OptionMarketIndexInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", amount=" + getAmount() + ", volume=" + getVolume() + ", iv=" + getIv() + ", optionCode=" + getOptionCode() + ", ivLatestPrice=" + getIvLatestPrice() + ", ivAskOne=" + getIvAskOne() + ", ivBidOne=" + getIvBidOne() + ", ivMarkPrice=" + getIvMarkPrice() + ", delta=" + getDelta() + ", gamma=" + getGamma() + ", theta=" + getTheta() + ", vega=" + getVega() + ", askOne=" + getAskOne() + ", bidOne=" + getBidOne() + ", latestPrice=" + getLatestPrice() + ", markPrice=" + getMarkPrice() + ", indexPrice=" + getIndexPrice() + ", exercisePrice=" + getExercisePrice() + ", optionRightType=" + getOptionRightType() + ")";
    }
}
