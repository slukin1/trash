package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class UnifyKycInfo implements Serializable {
    private static final long serialVersionUID = -3753203358232785460L;
    @SerializedName("authBizCode")
    private String authBizCode;
    @SerializedName("authBizName")
    private String authBizName;
    @SerializedName("authSubjectCode")
    private String authSubjectCode;
    @SerializedName("authSubjectName")
    private String authSubjectName;
    @SerializedName("baseInfo")
    private UnifyKycBaseInfo baseInfo;
    @SerializedName("entranceCountryId")
    private String entranceCountryId;
    @SerializedName("entranceName")
    private String entranceName;
    @SerializedName("entranceUrl")
    private String entranceUrl;
    @SerializedName("finalAuthState")
    private int finalAuthState;
    @SerializedName("showOldEntrance")
    private boolean showOldEntrance = true;
    @SerializedName("stepStates")
    private List<UnifyKycStepState> stepStates;
    @SerializedName("uid")
    private long uid;

    public boolean canEqual(Object obj) {
        return obj instanceof UnifyKycInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnifyKycInfo)) {
            return false;
        }
        UnifyKycInfo unifyKycInfo = (UnifyKycInfo) obj;
        if (!unifyKycInfo.canEqual(this)) {
            return false;
        }
        String authBizCode2 = getAuthBizCode();
        String authBizCode3 = unifyKycInfo.getAuthBizCode();
        if (authBizCode2 != null ? !authBizCode2.equals(authBizCode3) : authBizCode3 != null) {
            return false;
        }
        String authBizName2 = getAuthBizName();
        String authBizName3 = unifyKycInfo.getAuthBizName();
        if (authBizName2 != null ? !authBizName2.equals(authBizName3) : authBizName3 != null) {
            return false;
        }
        String authSubjectCode2 = getAuthSubjectCode();
        String authSubjectCode3 = unifyKycInfo.getAuthSubjectCode();
        if (authSubjectCode2 != null ? !authSubjectCode2.equals(authSubjectCode3) : authSubjectCode3 != null) {
            return false;
        }
        String authSubjectName2 = getAuthSubjectName();
        String authSubjectName3 = unifyKycInfo.getAuthSubjectName();
        if (authSubjectName2 != null ? !authSubjectName2.equals(authSubjectName3) : authSubjectName3 != null) {
            return false;
        }
        String entranceCountryId2 = getEntranceCountryId();
        String entranceCountryId3 = unifyKycInfo.getEntranceCountryId();
        if (entranceCountryId2 != null ? !entranceCountryId2.equals(entranceCountryId3) : entranceCountryId3 != null) {
            return false;
        }
        String entranceName2 = getEntranceName();
        String entranceName3 = unifyKycInfo.getEntranceName();
        if (entranceName2 != null ? !entranceName2.equals(entranceName3) : entranceName3 != null) {
            return false;
        }
        String entranceUrl2 = getEntranceUrl();
        String entranceUrl3 = unifyKycInfo.getEntranceUrl();
        if (entranceUrl2 != null ? !entranceUrl2.equals(entranceUrl3) : entranceUrl3 != null) {
            return false;
        }
        if (isShowOldEntrance() != unifyKycInfo.isShowOldEntrance() || getFinalAuthState() != unifyKycInfo.getFinalAuthState() || getUid() != unifyKycInfo.getUid()) {
            return false;
        }
        UnifyKycBaseInfo baseInfo2 = getBaseInfo();
        UnifyKycBaseInfo baseInfo3 = unifyKycInfo.getBaseInfo();
        if (baseInfo2 != null ? !baseInfo2.equals(baseInfo3) : baseInfo3 != null) {
            return false;
        }
        List<UnifyKycStepState> stepStates2 = getStepStates();
        List<UnifyKycStepState> stepStates3 = unifyKycInfo.getStepStates();
        return stepStates2 != null ? stepStates2.equals(stepStates3) : stepStates3 == null;
    }

    public String getAuthBizCode() {
        return this.authBizCode;
    }

    public String getAuthBizName() {
        return this.authBizName;
    }

    public String getAuthSubjectCode() {
        return this.authSubjectCode;
    }

    public String getAuthSubjectName() {
        return this.authSubjectName;
    }

    public UnifyKycBaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public String getEntranceCountryId() {
        return this.entranceCountryId;
    }

    public String getEntranceName() {
        return this.entranceName;
    }

    public String getEntranceUrl() {
        return this.entranceUrl;
    }

    public int getFinalAuthState() {
        return this.finalAuthState;
    }

    public List<UnifyKycStepState> getStepStates() {
        return this.stepStates;
    }

    public long getUid() {
        return this.uid;
    }

    public int hashCode() {
        String authBizCode2 = getAuthBizCode();
        int i11 = 43;
        int hashCode = authBizCode2 == null ? 43 : authBizCode2.hashCode();
        String authBizName2 = getAuthBizName();
        int hashCode2 = ((hashCode + 59) * 59) + (authBizName2 == null ? 43 : authBizName2.hashCode());
        String authSubjectCode2 = getAuthSubjectCode();
        int hashCode3 = (hashCode2 * 59) + (authSubjectCode2 == null ? 43 : authSubjectCode2.hashCode());
        String authSubjectName2 = getAuthSubjectName();
        int hashCode4 = (hashCode3 * 59) + (authSubjectName2 == null ? 43 : authSubjectName2.hashCode());
        String entranceCountryId2 = getEntranceCountryId();
        int hashCode5 = (hashCode4 * 59) + (entranceCountryId2 == null ? 43 : entranceCountryId2.hashCode());
        String entranceName2 = getEntranceName();
        int hashCode6 = (hashCode5 * 59) + (entranceName2 == null ? 43 : entranceName2.hashCode());
        String entranceUrl2 = getEntranceUrl();
        int hashCode7 = (((((hashCode6 * 59) + (entranceUrl2 == null ? 43 : entranceUrl2.hashCode())) * 59) + (isShowOldEntrance() ? 79 : 97)) * 59) + getFinalAuthState();
        long uid2 = getUid();
        int i12 = (hashCode7 * 59) + ((int) (uid2 ^ (uid2 >>> 32)));
        UnifyKycBaseInfo baseInfo2 = getBaseInfo();
        int hashCode8 = (i12 * 59) + (baseInfo2 == null ? 43 : baseInfo2.hashCode());
        List<UnifyKycStepState> stepStates2 = getStepStates();
        int i13 = hashCode8 * 59;
        if (stepStates2 != null) {
            i11 = stepStates2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isShowOldEntrance() {
        return this.showOldEntrance;
    }

    public void setAuthBizCode(String str) {
        this.authBizCode = str;
    }

    public void setAuthBizName(String str) {
        this.authBizName = str;
    }

    public void setAuthSubjectCode(String str) {
        this.authSubjectCode = str;
    }

    public void setAuthSubjectName(String str) {
        this.authSubjectName = str;
    }

    public void setBaseInfo(UnifyKycBaseInfo unifyKycBaseInfo) {
        this.baseInfo = unifyKycBaseInfo;
    }

    public void setEntranceCountryId(String str) {
        this.entranceCountryId = str;
    }

    public void setEntranceName(String str) {
        this.entranceName = str;
    }

    public void setEntranceUrl(String str) {
        this.entranceUrl = str;
    }

    public void setFinalAuthState(int i11) {
        this.finalAuthState = i11;
    }

    public void setShowOldEntrance(boolean z11) {
        this.showOldEntrance = z11;
    }

    public void setStepStates(List<UnifyKycStepState> list) {
        this.stepStates = list;
    }

    public void setUid(long j11) {
        this.uid = j11;
    }

    public String toString() {
        return "UnifyKycInfo(authBizCode=" + getAuthBizCode() + ", authBizName=" + getAuthBizName() + ", authSubjectCode=" + getAuthSubjectCode() + ", authSubjectName=" + getAuthSubjectName() + ", entranceCountryId=" + getEntranceCountryId() + ", entranceName=" + getEntranceName() + ", entranceUrl=" + getEntranceUrl() + ", showOldEntrance=" + isShowOldEntrance() + ", finalAuthState=" + getFinalAuthState() + ", uid=" + getUid() + ", baseInfo=" + getBaseInfo() + ", stepStates=" + getStepStates() + ")";
    }
}
