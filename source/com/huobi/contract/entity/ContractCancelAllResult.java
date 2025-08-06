package com.huobi.contract.entity;

import java.io.Serializable;
import java.util.List;

public class ContractCancelAllResult implements Serializable {
    private static final long serialVersionUID = -4662518681686098484L;
    private List<ContractOrderErrorInfo> errors;
    private List<Integer> succcess;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCancelAllResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCancelAllResult)) {
            return false;
        }
        ContractCancelAllResult contractCancelAllResult = (ContractCancelAllResult) obj;
        if (!contractCancelAllResult.canEqual(this)) {
            return false;
        }
        List<ContractOrderErrorInfo> errors2 = getErrors();
        List<ContractOrderErrorInfo> errors3 = contractCancelAllResult.getErrors();
        if (errors2 != null ? !errors2.equals(errors3) : errors3 != null) {
            return false;
        }
        List<Integer> succcess2 = getSucccess();
        List<Integer> succcess3 = contractCancelAllResult.getSucccess();
        return succcess2 != null ? succcess2.equals(succcess3) : succcess3 == null;
    }

    public List<ContractOrderErrorInfo> getErrors() {
        return this.errors;
    }

    public List<Integer> getSucccess() {
        return this.succcess;
    }

    public int hashCode() {
        List<ContractOrderErrorInfo> errors2 = getErrors();
        int i11 = 43;
        int hashCode = errors2 == null ? 43 : errors2.hashCode();
        List<Integer> succcess2 = getSucccess();
        int i12 = (hashCode + 59) * 59;
        if (succcess2 != null) {
            i11 = succcess2.hashCode();
        }
        return i12 + i11;
    }

    public void setErrors(List<ContractOrderErrorInfo> list) {
        this.errors = list;
    }

    public void setSucccess(List<Integer> list) {
        this.succcess = list;
    }

    public String toString() {
        return "ContractCancelAllResult(errors=" + getErrors() + ", succcess=" + getSucccess() + ")";
    }
}
