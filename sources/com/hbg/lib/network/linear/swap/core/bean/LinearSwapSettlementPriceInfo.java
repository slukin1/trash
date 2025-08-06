package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapSettlementPriceInfo implements Serializable {
    private static final long serialVersionUID = -3068760316542840024L;
    @SerializedName("business_type")
    private String businessType;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("estimated_settlement_price")
    private String estimatedSettlementPrice;
    private String pair;
    @SerializedName("settlement_type")
    private String settlementType;
    @SerializedName("trade_partition")
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapSettlementPriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapSettlementPriceInfo)) {
            return false;
        }
        LinearSwapSettlementPriceInfo linearSwapSettlementPriceInfo = (LinearSwapSettlementPriceInfo) obj;
        if (!linearSwapSettlementPriceInfo.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapSettlementPriceInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String estimatedSettlementPrice2 = getEstimatedSettlementPrice();
        String estimatedSettlementPrice3 = linearSwapSettlementPriceInfo.getEstimatedSettlementPrice();
        if (estimatedSettlementPrice2 != null ? !estimatedSettlementPrice2.equals(estimatedSettlementPrice3) : estimatedSettlementPrice3 != null) {
            return false;
        }
        String settlementType2 = getSettlementType();
        String settlementType3 = linearSwapSettlementPriceInfo.getSettlementType();
        if (settlementType2 != null ? !settlementType2.equals(settlementType3) : settlementType3 != null) {
            return false;
        }
        String businessType2 = getBusinessType();
        String businessType3 = linearSwapSettlementPriceInfo.getBusinessType();
        if (businessType2 != null ? !businessType2.equals(businessType3) : businessType3 != null) {
            return false;
        }
        String pair2 = getPair();
        String pair3 = linearSwapSettlementPriceInfo.getPair();
        if (pair2 != null ? !pair2.equals(pair3) : pair3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = linearSwapSettlementPriceInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = linearSwapSettlementPriceInfo.getTradePartition();
        return tradePartition2 != null ? tradePartition2.equals(tradePartition3) : tradePartition3 == null;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getEstimatedSettlementPrice() {
        return this.estimatedSettlementPrice;
    }

    public String getPair() {
        return this.pair;
    }

    public String getSettlementType() {
        return this.settlementType;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        String estimatedSettlementPrice2 = getEstimatedSettlementPrice();
        int hashCode2 = ((hashCode + 59) * 59) + (estimatedSettlementPrice2 == null ? 43 : estimatedSettlementPrice2.hashCode());
        String settlementType2 = getSettlementType();
        int hashCode3 = (hashCode2 * 59) + (settlementType2 == null ? 43 : settlementType2.hashCode());
        String businessType2 = getBusinessType();
        int hashCode4 = (hashCode3 * 59) + (businessType2 == null ? 43 : businessType2.hashCode());
        String pair2 = getPair();
        int hashCode5 = (hashCode4 * 59) + (pair2 == null ? 43 : pair2.hashCode());
        String contractType2 = getContractType();
        int hashCode6 = (hashCode5 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String tradePartition2 = getTradePartition();
        int i12 = hashCode6 * 59;
        if (tradePartition2 != null) {
            i11 = tradePartition2.hashCode();
        }
        return i12 + i11;
    }

    public void setBusinessType(String str) {
        this.businessType = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setEstimatedSettlementPrice(String str) {
        this.estimatedSettlementPrice = str;
    }

    public void setPair(String str) {
        this.pair = str;
    }

    public void setSettlementType(String str) {
        this.settlementType = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "LinearSwapSettlementPriceInfo(contractCode=" + getContractCode() + ", estimatedSettlementPrice=" + getEstimatedSettlementPrice() + ", settlementType=" + getSettlementType() + ", businessType=" + getBusinessType() + ", pair=" + getPair() + ", contractType=" + getContractType() + ", tradePartition=" + getTradePartition() + ")";
    }
}
