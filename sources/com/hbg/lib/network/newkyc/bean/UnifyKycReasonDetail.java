package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UnifyKycReasonDetail implements Serializable {
    private static final long serialVersionUID = 2574572204373997630L;
    @SerializedName("reason")
    private String reason;
    @SerializedName("rejectCode")
    private long rejectCode;

    public boolean canEqual(Object obj) {
        return obj instanceof UnifyKycReasonDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifyKycReasonDetail)) {
            return false;
        }
        UnifyKycReasonDetail unifyKycReasonDetail = (UnifyKycReasonDetail) obj;
        if (!unifyKycReasonDetail.canEqual(this) || getRejectCode() != unifyKycReasonDetail.getRejectCode()) {
            return false;
        }
        String reason2 = getReason();
        String reason3 = unifyKycReasonDetail.getReason();
        return reason2 != null ? reason2.equals(reason3) : reason3 == null;
    }

    public String getReason() {
        return this.reason;
    }

    public long getRejectCode() {
        return this.rejectCode;
    }

    public int hashCode() {
        long rejectCode2 = getRejectCode();
        String reason2 = getReason();
        return ((((int) (rejectCode2 ^ (rejectCode2 >>> 32))) + 59) * 59) + (reason2 == null ? 43 : reason2.hashCode());
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setRejectCode(long j11) {
        this.rejectCode = j11;
    }

    public String toString() {
        return "UnifyKycReasonDetail(rejectCode=" + getRejectCode() + ", reason=" + getReason() + ")";
    }
}
