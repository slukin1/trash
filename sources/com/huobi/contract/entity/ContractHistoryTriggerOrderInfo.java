package com.huobi.contract.entity;

import com.huobi.contract.viewhandler.ContractHistoryTriggerOrderHandler;
import s9.a;

public class ContractHistoryTriggerOrderInfo extends ContractTriggerOrderRspInfo implements a {
    private static final long serialVersionUID = -7729360501838990017L;
    private transient ContractHistoryTriggerOrderHandler.a callback;
    private String contractFace;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractHistoryTriggerOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractHistoryTriggerOrderInfo)) {
            return false;
        }
        ContractHistoryTriggerOrderInfo contractHistoryTriggerOrderInfo = (ContractHistoryTriggerOrderInfo) obj;
        if (!contractHistoryTriggerOrderInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String contractFace2 = getContractFace();
        String contractFace3 = contractHistoryTriggerOrderInfo.getContractFace();
        return contractFace2 != null ? contractFace2.equals(contractFace3) : contractFace3 == null;
    }

    public ContractHistoryTriggerOrderHandler.a getCallback() {
        return this.callback;
    }

    public String getContractFace() {
        return this.contractFace;
    }

    public String getViewHandlerName() {
        return ContractHistoryTriggerOrderHandler.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String contractFace2 = getContractFace();
        return (hashCode * 59) + (contractFace2 == null ? 43 : contractFace2.hashCode());
    }

    public boolean isBuy() {
        return "buy".equals(getDirection());
    }

    public boolean isDelivery() {
        return "settlement".equals(getOrderSource());
    }

    public boolean isExplose() {
        return "risk".equals(getOrderSource());
    }

    public boolean isOpen() {
        return "open".equals(getOffset());
    }

    public void setCallback(ContractHistoryTriggerOrderHandler.a aVar) {
        this.callback = aVar;
    }

    public void setContractFace(String str) {
        this.contractFace = str;
    }

    public String toString() {
        return "ContractHistoryTriggerOrderInfo(contractFace=" + getContractFace() + ", callback=" + getCallback() + ")";
    }
}
