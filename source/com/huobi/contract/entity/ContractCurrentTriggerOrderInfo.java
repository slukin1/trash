package com.huobi.contract.entity;

import com.huobi.contract.viewhandler.ContractCurrentTriggerOrderHandler;

public class ContractCurrentTriggerOrderInfo extends ContractTriggerOrderRspInfo implements s9.a {
    private static final long serialVersionUID = -7729360501838990017L;
    private a callback;
    private transient String contractFace;

    public interface a {
        void a(ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCurrentTriggerOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrentTriggerOrderInfo)) {
            return false;
        }
        ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo = (ContractCurrentTriggerOrderInfo) obj;
        if (!contractCurrentTriggerOrderInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = contractCurrentTriggerOrderInfo.getCallback();
        return callback2 != null ? callback2.equals(callback3) : callback3 == null;
    }

    public a getCallback() {
        return this.callback;
    }

    public String getContractFace() {
        return this.contractFace;
    }

    public String getViewHandlerName() {
        return ContractCurrentTriggerOrderHandler.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        a callback2 = getCallback();
        return (hashCode * 59) + (callback2 == null ? 43 : callback2.hashCode());
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

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setContractFace(String str) {
        this.contractFace = str;
    }

    public String toString() {
        return "ContractCurrentTriggerOrderInfo(contractFace=" + getContractFace() + ", callback=" + getCallback() + ")";
    }
}
