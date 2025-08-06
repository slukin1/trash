package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class VerifyResultBean implements Serializable {
    private String verifyMessage;
    private Boolean verifyResult;

    public boolean canEqual(Object obj) {
        return obj instanceof VerifyResultBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VerifyResultBean)) {
            return false;
        }
        VerifyResultBean verifyResultBean = (VerifyResultBean) obj;
        if (!verifyResultBean.canEqual(this)) {
            return false;
        }
        String verifyMessage2 = getVerifyMessage();
        String verifyMessage3 = verifyResultBean.getVerifyMessage();
        if (verifyMessage2 != null ? !verifyMessage2.equals(verifyMessage3) : verifyMessage3 != null) {
            return false;
        }
        Boolean verifyResult2 = getVerifyResult();
        Boolean verifyResult3 = verifyResultBean.getVerifyResult();
        return verifyResult2 != null ? verifyResult2.equals(verifyResult3) : verifyResult3 == null;
    }

    public String getVerifyMessage() {
        return this.verifyMessage;
    }

    public Boolean getVerifyResult() {
        return this.verifyResult;
    }

    public int hashCode() {
        String verifyMessage2 = getVerifyMessage();
        int i11 = 43;
        int hashCode = verifyMessage2 == null ? 43 : verifyMessage2.hashCode();
        Boolean verifyResult2 = getVerifyResult();
        int i12 = (hashCode + 59) * 59;
        if (verifyResult2 != null) {
            i11 = verifyResult2.hashCode();
        }
        return i12 + i11;
    }

    public void setVerifyMessage(String str) {
        this.verifyMessage = str;
    }

    public void setVerifyResult(Boolean bool) {
        this.verifyResult = bool;
    }

    public String toString() {
        return "VerifyResultBean(verifyMessage=" + getVerifyMessage() + ", verifyResult=" + getVerifyResult() + ")";
    }
}
