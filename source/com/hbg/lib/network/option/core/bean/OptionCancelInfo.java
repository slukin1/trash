package com.hbg.lib.network.option.core.bean;

import com.hbg.lib.network.option.core.util.OptionOrderUtil;
import java.io.Serializable;
import java.util.List;

public class OptionCancelInfo implements Serializable {
    private static final long serialVersionUID = -8723262099154134122L;
    private List<OptionCancelErrorInfo> errors;
    private String successes;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionCancelInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionCancelInfo)) {
            return false;
        }
        OptionCancelInfo optionCancelInfo = (OptionCancelInfo) obj;
        if (!optionCancelInfo.canEqual(this)) {
            return false;
        }
        List<OptionCancelErrorInfo> errors2 = getErrors();
        List<OptionCancelErrorInfo> errors3 = optionCancelInfo.getErrors();
        if (errors2 != null ? !errors2.equals(errors3) : errors3 != null) {
            return false;
        }
        String successes2 = getSuccesses();
        String successes3 = optionCancelInfo.getSuccesses();
        return successes2 != null ? successes2.equals(successes3) : successes3 == null;
    }

    public List<OptionCancelErrorInfo> getErrors() {
        return this.errors;
    }

    public List<String> getSuccessOrderIds() {
        return OptionOrderUtil.a(this.successes);
    }

    public String getSuccesses() {
        return this.successes;
    }

    public int hashCode() {
        List<OptionCancelErrorInfo> errors2 = getErrors();
        int i11 = 43;
        int hashCode = errors2 == null ? 43 : errors2.hashCode();
        String successes2 = getSuccesses();
        int i12 = (hashCode + 59) * 59;
        if (successes2 != null) {
            i11 = successes2.hashCode();
        }
        return i12 + i11;
    }

    public void setErrors(List<OptionCancelErrorInfo> list) {
        this.errors = list;
    }

    public void setSuccesses(String str) {
        this.successes = str;
    }

    public String toString() {
        return "OptionCancelInfo(errors=" + getErrors() + ", successes=" + getSuccesses() + ")";
    }
}
