package com.hbg.lib.network.swap.core.bean;

import java.io.Serializable;
import java.util.List;

public class SwapCancelResult implements Serializable {
    private static final long serialVersionUID = -4662518681686098484L;
    private List<SwapOrderErrorInfo> errors;
    private String successes;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapCancelResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCancelResult)) {
            return false;
        }
        SwapCancelResult swapCancelResult = (SwapCancelResult) obj;
        if (!swapCancelResult.canEqual(this)) {
            return false;
        }
        List<SwapOrderErrorInfo> errors2 = getErrors();
        List<SwapOrderErrorInfo> errors3 = swapCancelResult.getErrors();
        if (errors2 != null ? !errors2.equals(errors3) : errors3 != null) {
            return false;
        }
        String successes2 = getSuccesses();
        String successes3 = swapCancelResult.getSuccesses();
        return successes2 != null ? successes2.equals(successes3) : successes3 == null;
    }

    public List<SwapOrderErrorInfo> getErrors() {
        return this.errors;
    }

    public String getSuccesses() {
        return this.successes;
    }

    public int hashCode() {
        List<SwapOrderErrorInfo> errors2 = getErrors();
        int i11 = 43;
        int hashCode = errors2 == null ? 43 : errors2.hashCode();
        String successes2 = getSuccesses();
        int i12 = (hashCode + 59) * 59;
        if (successes2 != null) {
            i11 = successes2.hashCode();
        }
        return i12 + i11;
    }

    public void setErrors(List<SwapOrderErrorInfo> list) {
        this.errors = list;
    }

    public void setSuccesses(String str) {
        this.successes = str;
    }

    public String toString() {
        return "SwapCancelResult(errors=" + getErrors() + ", successes=" + getSuccesses() + ")";
    }
}
