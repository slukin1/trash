package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapSettlementPriceInfo implements Serializable {
    private static final long serialVersionUID = -3068760316542840024L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("estimated_settlement_price")
    private String estimatedSettlementPrice;
    @SerializedName("settlement_type")
    private String settlementType;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapSettlementPriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapSettlementPriceInfo)) {
            return false;
        }
        SwapSettlementPriceInfo swapSettlementPriceInfo = (SwapSettlementPriceInfo) obj;
        if (!swapSettlementPriceInfo.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapSettlementPriceInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String estimatedSettlementPrice2 = getEstimatedSettlementPrice();
        String estimatedSettlementPrice3 = swapSettlementPriceInfo.getEstimatedSettlementPrice();
        if (estimatedSettlementPrice2 != null ? !estimatedSettlementPrice2.equals(estimatedSettlementPrice3) : estimatedSettlementPrice3 != null) {
            return false;
        }
        String settlementType2 = getSettlementType();
        String settlementType3 = swapSettlementPriceInfo.getSettlementType();
        return settlementType2 != null ? settlementType2.equals(settlementType3) : settlementType3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getEstimatedSettlementPrice() {
        return this.estimatedSettlementPrice;
    }

    public String getSettlementType() {
        return this.settlementType;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        String estimatedSettlementPrice2 = getEstimatedSettlementPrice();
        int hashCode2 = ((hashCode + 59) * 59) + (estimatedSettlementPrice2 == null ? 43 : estimatedSettlementPrice2.hashCode());
        String settlementType2 = getSettlementType();
        int i12 = hashCode2 * 59;
        if (settlementType2 != null) {
            i11 = settlementType2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setEstimatedSettlementPrice(String str) {
        this.estimatedSettlementPrice = str;
    }

    public void setSettlementType(String str) {
        this.settlementType = str;
    }

    public String toString() {
        return "SwapSettlementPriceInfo(contractCode=" + getContractCode() + ", estimatedSettlementPrice=" + getEstimatedSettlementPrice() + ", settlementType=" + getSettlementType() + ")";
    }
}
