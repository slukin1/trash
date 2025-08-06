package com.hbg.lib.network.linear.swap.core.bean;

import java.io.Serializable;
import java.util.Objects;

public class ContractBondAdjustDetailQuestParams implements Serializable {
    private String amount;
    private String contractCode;
    private String direction;
    private boolean isAdd;
    private String marginAccount;
    private String tradePartition;

    public ContractBondAdjustDetailQuestParams(String str, String str2, String str3, boolean z11, String str4, String str5) {
        this.contractCode = str;
        this.marginAccount = str2;
        this.tradePartition = str3;
        this.isAdd = z11;
        this.amount = str4;
        this.direction = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContractBondAdjustDetailQuestParams)) {
            return false;
        }
        ContractBondAdjustDetailQuestParams contractBondAdjustDetailQuestParams = (ContractBondAdjustDetailQuestParams) obj;
        if (isAdd() != contractBondAdjustDetailQuestParams.isAdd() || !Objects.equals(getContractCode(), contractBondAdjustDetailQuestParams.getContractCode()) || !Objects.equals(getMarginAccount(), contractBondAdjustDetailQuestParams.getMarginAccount()) || !Objects.equals(getTradePartition(), contractBondAdjustDetailQuestParams.getTradePartition()) || !Objects.equals(getAmount(), contractBondAdjustDetailQuestParams.getAmount()) || !Objects.equals(getDirection(), contractBondAdjustDetailQuestParams.getDirection())) {
            return false;
        }
        return true;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getMarginAccount() {
        return this.marginAccount;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{getContractCode(), getMarginAccount(), getTradePartition(), Boolean.valueOf(isAdd()), getAmount(), getDirection()});
    }

    public boolean isAdd() {
        return this.isAdd;
    }

    public void setAdd(boolean z11) {
        this.isAdd = z11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setMarginAccount(String str) {
        this.marginAccount = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "ContractBondAdjustDetailQuestParams{contractCode='" + this.contractCode + '\'' + ", marginAccount='" + this.marginAccount + '\'' + ", tradePartition='" + this.tradePartition + '\'' + ", isAdd=" + this.isAdd + ", amount='" + this.amount + '\'' + ", direction='" + this.direction + '\'' + '}';
    }
}
