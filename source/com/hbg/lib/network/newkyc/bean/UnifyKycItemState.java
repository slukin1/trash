package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class UnifyKycItemState implements Serializable {
    private static final long serialVersionUID = 8032872888055884844L;
    @SerializedName("authItem")
    private String authItem;
    @SerializedName("authState")
    private int authState;
    @SerializedName("reason")
    private String reason;
    @SerializedName("reasonDetails")
    private List<UnifyKycReasonDetail> reasonDetails;
    @SerializedName("rejectCode")
    private int rejectCode;
    @SerializedName("required")
    private boolean required;

    public boolean canEqual(Object obj) {
        return obj instanceof UnifyKycItemState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifyKycItemState)) {
            return false;
        }
        UnifyKycItemState unifyKycItemState = (UnifyKycItemState) obj;
        if (!unifyKycItemState.canEqual(this)) {
            return false;
        }
        String authItem2 = getAuthItem();
        String authItem3 = unifyKycItemState.getAuthItem();
        if (authItem2 != null ? !authItem2.equals(authItem3) : authItem3 != null) {
            return false;
        }
        if (getAuthState() != unifyKycItemState.getAuthState()) {
            return false;
        }
        String reason2 = getReason();
        String reason3 = unifyKycItemState.getReason();
        if (reason2 != null ? !reason2.equals(reason3) : reason3 != null) {
            return false;
        }
        List<UnifyKycReasonDetail> reasonDetails2 = getReasonDetails();
        List<UnifyKycReasonDetail> reasonDetails3 = unifyKycItemState.getReasonDetails();
        if (reasonDetails2 != null ? reasonDetails2.equals(reasonDetails3) : reasonDetails3 == null) {
            return getRejectCode() == unifyKycItemState.getRejectCode() && isRequired() == unifyKycItemState.isRequired();
        }
        return false;
    }

    public String getAuthItem() {
        return this.authItem;
    }

    public int getAuthState() {
        return this.authState;
    }

    public String getReason() {
        return this.reason;
    }

    public List<UnifyKycReasonDetail> getReasonDetails() {
        return this.reasonDetails;
    }

    public int getRejectCode() {
        return this.rejectCode;
    }

    public int hashCode() {
        String authItem2 = getAuthItem();
        int i11 = 43;
        int hashCode = (((authItem2 == null ? 43 : authItem2.hashCode()) + 59) * 59) + getAuthState();
        String reason2 = getReason();
        int hashCode2 = (hashCode * 59) + (reason2 == null ? 43 : reason2.hashCode());
        List<UnifyKycReasonDetail> reasonDetails2 = getReasonDetails();
        int i12 = hashCode2 * 59;
        if (reasonDetails2 != null) {
            i11 = reasonDetails2.hashCode();
        }
        return ((((i12 + i11) * 59) + getRejectCode()) * 59) + (isRequired() ? 79 : 97);
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setAuthItem(String str) {
        this.authItem = str;
    }

    public void setAuthState(int i11) {
        this.authState = i11;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonDetails(List<UnifyKycReasonDetail> list) {
        this.reasonDetails = list;
    }

    public void setRejectCode(int i11) {
        this.rejectCode = i11;
    }

    public void setRequired(boolean z11) {
        this.required = z11;
    }

    public String toString() {
        return "UnifyKycItemState(authItem=" + getAuthItem() + ", authState=" + getAuthState() + ", reason=" + getReason() + ", reasonDetails=" + getReasonDetails() + ", rejectCode=" + getRejectCode() + ", required=" + isRequired() + ")";
    }
}
