package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;

public class LinearSwapBondAdjustDetail implements Serializable {
    private ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams;
    @SerializedName("liquidation_price")
    private BigDecimal estimatedStrongParity;
    @SerializedName("withdraw_available_in")
    private BigDecimal maxAddBond;
    @SerializedName("withdraw_available_out")
    private BigDecimal maxReduceBond;
    @SerializedName("margin_position")
    private BigDecimal positionBond;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapBondAdjustDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapBondAdjustDetail)) {
            return false;
        }
        LinearSwapBondAdjustDetail linearSwapBondAdjustDetail = (LinearSwapBondAdjustDetail) obj;
        if (!linearSwapBondAdjustDetail.canEqual(this)) {
            return false;
        }
        BigDecimal positionBond2 = getPositionBond();
        BigDecimal positionBond3 = linearSwapBondAdjustDetail.getPositionBond();
        if (positionBond2 != null ? !positionBond2.equals(positionBond3) : positionBond3 != null) {
            return false;
        }
        BigDecimal estimatedStrongParity2 = getEstimatedStrongParity();
        BigDecimal estimatedStrongParity3 = linearSwapBondAdjustDetail.getEstimatedStrongParity();
        if (estimatedStrongParity2 != null ? !estimatedStrongParity2.equals(estimatedStrongParity3) : estimatedStrongParity3 != null) {
            return false;
        }
        BigDecimal maxReduceBond2 = getMaxReduceBond();
        BigDecimal maxReduceBond3 = linearSwapBondAdjustDetail.getMaxReduceBond();
        if (maxReduceBond2 != null ? !maxReduceBond2.equals(maxReduceBond3) : maxReduceBond3 != null) {
            return false;
        }
        BigDecimal maxAddBond2 = getMaxAddBond();
        BigDecimal maxAddBond3 = linearSwapBondAdjustDetail.getMaxAddBond();
        if (maxAddBond2 != null ? !maxAddBond2.equals(maxAddBond3) : maxAddBond3 != null) {
            return false;
        }
        ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams2 = getContractBondAdjustDetailQuestParams();
        ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams3 = linearSwapBondAdjustDetail.getContractBondAdjustDetailQuestParams();
        return contractBondAdjustDetailQuestParams2 != null ? contractBondAdjustDetailQuestParams2.equals(contractBondAdjustDetailQuestParams3) : contractBondAdjustDetailQuestParams3 == null;
    }

    public ContractBondAdjustDetailQuestParams getContractBondAdjustDetailQuestParams() {
        return this.contractBondAdjustDetailQuestParams;
    }

    public BigDecimal getEstimatedStrongParity() {
        return this.estimatedStrongParity;
    }

    public BigDecimal getMaxAddBond() {
        return this.maxAddBond;
    }

    public BigDecimal getMaxReduceBond() {
        return this.maxReduceBond;
    }

    public BigDecimal getPositionBond() {
        return this.positionBond;
    }

    public int hashCode() {
        BigDecimal positionBond2 = getPositionBond();
        int i11 = 43;
        int hashCode = positionBond2 == null ? 43 : positionBond2.hashCode();
        BigDecimal estimatedStrongParity2 = getEstimatedStrongParity();
        int hashCode2 = ((hashCode + 59) * 59) + (estimatedStrongParity2 == null ? 43 : estimatedStrongParity2.hashCode());
        BigDecimal maxReduceBond2 = getMaxReduceBond();
        int hashCode3 = (hashCode2 * 59) + (maxReduceBond2 == null ? 43 : maxReduceBond2.hashCode());
        BigDecimal maxAddBond2 = getMaxAddBond();
        int hashCode4 = (hashCode3 * 59) + (maxAddBond2 == null ? 43 : maxAddBond2.hashCode());
        ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams2 = getContractBondAdjustDetailQuestParams();
        int i12 = hashCode4 * 59;
        if (contractBondAdjustDetailQuestParams2 != null) {
            i11 = contractBondAdjustDetailQuestParams2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractBondAdjustDetailQuestParams(ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams2) {
        this.contractBondAdjustDetailQuestParams = contractBondAdjustDetailQuestParams2;
    }

    public void setEstimatedStrongParity(BigDecimal bigDecimal) {
        this.estimatedStrongParity = bigDecimal;
    }

    public void setMaxAddBond(BigDecimal bigDecimal) {
        this.maxAddBond = bigDecimal;
    }

    public void setMaxReduceBond(BigDecimal bigDecimal) {
        this.maxReduceBond = bigDecimal;
    }

    public void setPositionBond(BigDecimal bigDecimal) {
        this.positionBond = bigDecimal;
    }

    public String toString() {
        return "LinearSwapBondAdjustDetail{positionBond=" + this.positionBond + ", estimatedStrongParity=" + this.estimatedStrongParity + ", maxReduceBond=" + this.maxReduceBond + ", maxAddBond=" + this.maxAddBond + ", contractBondAdjustDetailQuestParams=" + this.contractBondAdjustDetailQuestParams + '}';
    }
}
