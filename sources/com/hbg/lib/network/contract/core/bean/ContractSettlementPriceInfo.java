package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractSettlementPriceInfo implements Serializable {
    public static final String SETTLEMENT_TYPE_DELIVERY = "delivery";
    public static final String SETTLEMENT_TYPE_SETTLEMENT = "settlement";
    private static final long serialVersionUID = -3870413815842451207L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("estimated_settlement_price")
    private String estimatedSettlementPrice;
    @SerializedName("settlement_type")
    private String settlementType;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractSettlementPriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractSettlementPriceInfo)) {
            return false;
        }
        ContractSettlementPriceInfo contractSettlementPriceInfo = (ContractSettlementPriceInfo) obj;
        if (!contractSettlementPriceInfo.canEqual(this)) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractSettlementPriceInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractSettlementPriceInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String estimatedSettlementPrice2 = getEstimatedSettlementPrice();
        String estimatedSettlementPrice3 = contractSettlementPriceInfo.getEstimatedSettlementPrice();
        if (estimatedSettlementPrice2 != null ? !estimatedSettlementPrice2.equals(estimatedSettlementPrice3) : estimatedSettlementPrice3 != null) {
            return false;
        }
        String settlementType2 = getSettlementType();
        String settlementType3 = contractSettlementPriceInfo.getSettlementType();
        return settlementType2 != null ? settlementType2.equals(settlementType3) : settlementType3 == null;
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

    public String getSettlementType() {
        return this.settlementType;
    }

    public int hashCode() {
        String contractType2 = getContractType();
        int i11 = 43;
        int hashCode = contractType2 == null ? 43 : contractType2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String estimatedSettlementPrice2 = getEstimatedSettlementPrice();
        int hashCode3 = (hashCode2 * 59) + (estimatedSettlementPrice2 == null ? 43 : estimatedSettlementPrice2.hashCode());
        String settlementType2 = getSettlementType();
        int i12 = hashCode3 * 59;
        if (settlementType2 != null) {
            i11 = settlementType2.hashCode();
        }
        return i12 + i11;
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

    public void setSettlementType(String str) {
        this.settlementType = str;
    }

    public String toString() {
        return "ContractSettlementPriceInfo(contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", estimatedSettlementPrice=" + getEstimatedSettlementPrice() + ", settlementType=" + getSettlementType() + ")";
    }
}
