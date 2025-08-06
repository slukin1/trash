package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class UnifyKycStepState implements Serializable {
    private static final long serialVersionUID = -5577650285459677240L;
    @SerializedName("authState")
    private int authState;
    @SerializedName("authStep")
    private String authStep;
    @SerializedName("authStepName")
    private String authStepName;
    @SerializedName("dependencies")
    private List<String> dependencies;
    @SerializedName("itemStates")
    private List<UnifyKycItemState> itemStates;

    public boolean canEqual(Object obj) {
        return obj instanceof UnifyKycStepState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifyKycStepState)) {
            return false;
        }
        UnifyKycStepState unifyKycStepState = (UnifyKycStepState) obj;
        if (!unifyKycStepState.canEqual(this) || getAuthState() != unifyKycStepState.getAuthState()) {
            return false;
        }
        String authStep2 = getAuthStep();
        String authStep3 = unifyKycStepState.getAuthStep();
        if (authStep2 != null ? !authStep2.equals(authStep3) : authStep3 != null) {
            return false;
        }
        String authStepName2 = getAuthStepName();
        String authStepName3 = unifyKycStepState.getAuthStepName();
        if (authStepName2 != null ? !authStepName2.equals(authStepName3) : authStepName3 != null) {
            return false;
        }
        List<String> dependencies2 = getDependencies();
        List<String> dependencies3 = unifyKycStepState.getDependencies();
        if (dependencies2 != null ? !dependencies2.equals(dependencies3) : dependencies3 != null) {
            return false;
        }
        List<UnifyKycItemState> itemStates2 = getItemStates();
        List<UnifyKycItemState> itemStates3 = unifyKycStepState.getItemStates();
        return itemStates2 != null ? itemStates2.equals(itemStates3) : itemStates3 == null;
    }

    public int getAuthState() {
        return this.authState;
    }

    public String getAuthStep() {
        return this.authStep;
    }

    public String getAuthStepName() {
        return this.authStepName;
    }

    public List<String> getDependencies() {
        return this.dependencies;
    }

    public List<UnifyKycItemState> getItemStates() {
        return this.itemStates;
    }

    public int hashCode() {
        String authStep2 = getAuthStep();
        int i11 = 43;
        int authState2 = ((getAuthState() + 59) * 59) + (authStep2 == null ? 43 : authStep2.hashCode());
        String authStepName2 = getAuthStepName();
        int hashCode = (authState2 * 59) + (authStepName2 == null ? 43 : authStepName2.hashCode());
        List<String> dependencies2 = getDependencies();
        int hashCode2 = (hashCode * 59) + (dependencies2 == null ? 43 : dependencies2.hashCode());
        List<UnifyKycItemState> itemStates2 = getItemStates();
        int i12 = hashCode2 * 59;
        if (itemStates2 != null) {
            i11 = itemStates2.hashCode();
        }
        return i12 + i11;
    }

    public void setAuthState(int i11) {
        this.authState = i11;
    }

    public void setAuthStep(String str) {
        this.authStep = str;
    }

    public void setAuthStepName(String str) {
        this.authStepName = str;
    }

    public void setDependencies(List<String> list) {
        this.dependencies = list;
    }

    public void setItemStates(List<UnifyKycItemState> list) {
        this.itemStates = list;
    }

    public String toString() {
        return "UnifyKycStepState(authState=" + getAuthState() + ", authStep=" + getAuthStep() + ", authStepName=" + getAuthStepName() + ", dependencies=" + getDependencies() + ", itemStates=" + getItemStates() + ")";
    }
}
