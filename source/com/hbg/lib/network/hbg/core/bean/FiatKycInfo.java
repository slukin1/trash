package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class FiatKycInfo implements Serializable {
    public static final int IDENTITY_TYPE_ID_CARD = 1;
    public static final int IDENTITY_TYPE_RESIDENCE_PERMIT = 2;
    public static final int STATE_CHECKING = 4;
    public static final int STATE_CHECK_FAIL = 5;
    public static final int STATE_CHECK_PASS = 6;
    public static final int STATE_INIT = 1;
    public static final int STATE_NVI_FAIL = 3;
    public static final int STATE_NVI_PASS = 2;
    private String birthday;
    private int distinctId;
    private String documentNo;
    private int gender;
    private String holdUrl;
    private String holdUrlForDownload;
    private String idBackUrl;
    private String idBackUrlForDownload;
    private String idFrontUrl;
    private String idFrontUrlForDownload;
    private String idNo;
    private int identityType;
    private String name;
    private int nationalityId;

    /* renamed from: no  reason: collision with root package name */
    private String f70239no;
    private boolean proStatus = true;
    private int provinceId;
    private String reason;
    private String seri;
    private int state = 1;
    private String surname;

    public boolean canEqual(Object obj) {
        return obj instanceof FiatKycInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FiatKycInfo)) {
            return false;
        }
        FiatKycInfo fiatKycInfo = (FiatKycInfo) obj;
        if (!fiatKycInfo.canEqual(this) || getState() != fiatKycInfo.getState() || isProStatus() != fiatKycInfo.isProStatus() || getIdentityType() != fiatKycInfo.getIdentityType()) {
            return false;
        }
        String idNo2 = getIdNo();
        String idNo3 = fiatKycInfo.getIdNo();
        if (idNo2 != null ? !idNo2.equals(idNo3) : idNo3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = fiatKycInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String surname2 = getSurname();
        String surname3 = fiatKycInfo.getSurname();
        if (surname2 != null ? !surname2.equals(surname3) : surname3 != null) {
            return false;
        }
        if (getGender() != fiatKycInfo.getGender() || getNationalityId() != fiatKycInfo.getNationalityId()) {
            return false;
        }
        String birthday2 = getBirthday();
        String birthday3 = fiatKycInfo.getBirthday();
        if (birthday2 != null ? !birthday2.equals(birthday3) : birthday3 != null) {
            return false;
        }
        if (getProvinceId() != fiatKycInfo.getProvinceId() || getDistinctId() != fiatKycInfo.getDistinctId()) {
            return false;
        }
        String documentNo2 = getDocumentNo();
        String documentNo3 = fiatKycInfo.getDocumentNo();
        if (documentNo2 != null ? !documentNo2.equals(documentNo3) : documentNo3 != null) {
            return false;
        }
        String seri2 = getSeri();
        String seri3 = fiatKycInfo.getSeri();
        if (seri2 != null ? !seri2.equals(seri3) : seri3 != null) {
            return false;
        }
        String no2 = getNo();
        String no3 = fiatKycInfo.getNo();
        if (no2 != null ? !no2.equals(no3) : no3 != null) {
            return false;
        }
        String reason2 = getReason();
        String reason3 = fiatKycInfo.getReason();
        if (reason2 != null ? !reason2.equals(reason3) : reason3 != null) {
            return false;
        }
        String idFrontUrl2 = getIdFrontUrl();
        String idFrontUrl3 = fiatKycInfo.getIdFrontUrl();
        if (idFrontUrl2 != null ? !idFrontUrl2.equals(idFrontUrl3) : idFrontUrl3 != null) {
            return false;
        }
        String idBackUrl2 = getIdBackUrl();
        String idBackUrl3 = fiatKycInfo.getIdBackUrl();
        if (idBackUrl2 != null ? !idBackUrl2.equals(idBackUrl3) : idBackUrl3 != null) {
            return false;
        }
        String holdUrl2 = getHoldUrl();
        String holdUrl3 = fiatKycInfo.getHoldUrl();
        if (holdUrl2 != null ? !holdUrl2.equals(holdUrl3) : holdUrl3 != null) {
            return false;
        }
        String idFrontUrlForDownload2 = getIdFrontUrlForDownload();
        String idFrontUrlForDownload3 = fiatKycInfo.getIdFrontUrlForDownload();
        if (idFrontUrlForDownload2 != null ? !idFrontUrlForDownload2.equals(idFrontUrlForDownload3) : idFrontUrlForDownload3 != null) {
            return false;
        }
        String idBackUrlForDownload2 = getIdBackUrlForDownload();
        String idBackUrlForDownload3 = fiatKycInfo.getIdBackUrlForDownload();
        if (idBackUrlForDownload2 != null ? !idBackUrlForDownload2.equals(idBackUrlForDownload3) : idBackUrlForDownload3 != null) {
            return false;
        }
        String holdUrlForDownload2 = getHoldUrlForDownload();
        String holdUrlForDownload3 = fiatKycInfo.getHoldUrlForDownload();
        return holdUrlForDownload2 != null ? holdUrlForDownload2.equals(holdUrlForDownload3) : holdUrlForDownload3 == null;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public int getDistinctId() {
        return this.distinctId;
    }

    public String getDocumentNo() {
        return this.documentNo;
    }

    public int getGender() {
        return this.gender;
    }

    public String getHoldUrl() {
        return this.holdUrl;
    }

    public String getHoldUrlForDownload() {
        return this.holdUrlForDownload;
    }

    public String getIdBackUrl() {
        return this.idBackUrl;
    }

    public String getIdBackUrlForDownload() {
        return this.idBackUrlForDownload;
    }

    public String getIdFrontUrl() {
        return this.idFrontUrl;
    }

    public String getIdFrontUrlForDownload() {
        return this.idFrontUrlForDownload;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public int getIdentityType() {
        return this.identityType;
    }

    public String getName() {
        return this.name;
    }

    public int getNationalityId() {
        return this.nationalityId;
    }

    public String getNo() {
        return this.f70239no;
    }

    public int getProvinceId() {
        return this.provinceId;
    }

    public String getReason() {
        return this.reason;
    }

    public String getSeri() {
        return this.seri;
    }

    public int getState() {
        return this.state;
    }

    public String getSurname() {
        return this.surname;
    }

    public int hashCode() {
        int state2 = ((((getState() + 59) * 59) + (isProStatus() ? 79 : 97)) * 59) + getIdentityType();
        String idNo2 = getIdNo();
        int i11 = 43;
        int hashCode = (state2 * 59) + (idNo2 == null ? 43 : idNo2.hashCode());
        String name2 = getName();
        int hashCode2 = (hashCode * 59) + (name2 == null ? 43 : name2.hashCode());
        String surname2 = getSurname();
        int hashCode3 = (((((hashCode2 * 59) + (surname2 == null ? 43 : surname2.hashCode())) * 59) + getGender()) * 59) + getNationalityId();
        String birthday2 = getBirthday();
        int hashCode4 = (((((hashCode3 * 59) + (birthday2 == null ? 43 : birthday2.hashCode())) * 59) + getProvinceId()) * 59) + getDistinctId();
        String documentNo2 = getDocumentNo();
        int hashCode5 = (hashCode4 * 59) + (documentNo2 == null ? 43 : documentNo2.hashCode());
        String seri2 = getSeri();
        int hashCode6 = (hashCode5 * 59) + (seri2 == null ? 43 : seri2.hashCode());
        String no2 = getNo();
        int hashCode7 = (hashCode6 * 59) + (no2 == null ? 43 : no2.hashCode());
        String reason2 = getReason();
        int hashCode8 = (hashCode7 * 59) + (reason2 == null ? 43 : reason2.hashCode());
        String idFrontUrl2 = getIdFrontUrl();
        int hashCode9 = (hashCode8 * 59) + (idFrontUrl2 == null ? 43 : idFrontUrl2.hashCode());
        String idBackUrl2 = getIdBackUrl();
        int hashCode10 = (hashCode9 * 59) + (idBackUrl2 == null ? 43 : idBackUrl2.hashCode());
        String holdUrl2 = getHoldUrl();
        int hashCode11 = (hashCode10 * 59) + (holdUrl2 == null ? 43 : holdUrl2.hashCode());
        String idFrontUrlForDownload2 = getIdFrontUrlForDownload();
        int hashCode12 = (hashCode11 * 59) + (idFrontUrlForDownload2 == null ? 43 : idFrontUrlForDownload2.hashCode());
        String idBackUrlForDownload2 = getIdBackUrlForDownload();
        int hashCode13 = (hashCode12 * 59) + (idBackUrlForDownload2 == null ? 43 : idBackUrlForDownload2.hashCode());
        String holdUrlForDownload2 = getHoldUrlForDownload();
        int i12 = hashCode13 * 59;
        if (holdUrlForDownload2 != null) {
            i11 = holdUrlForDownload2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isProStatus() {
        return this.proStatus;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setDistinctId(int i11) {
        this.distinctId = i11;
    }

    public void setDocumentNo(String str) {
        this.documentNo = str;
    }

    public void setGender(int i11) {
        this.gender = i11;
    }

    public void setHoldUrl(String str) {
        this.holdUrl = str;
    }

    public void setHoldUrlForDownload(String str) {
        this.holdUrlForDownload = str;
    }

    public void setIdBackUrl(String str) {
        this.idBackUrl = str;
    }

    public void setIdBackUrlForDownload(String str) {
        this.idBackUrlForDownload = str;
    }

    public void setIdFrontUrl(String str) {
        this.idFrontUrl = str;
    }

    public void setIdFrontUrlForDownload(String str) {
        this.idFrontUrlForDownload = str;
    }

    public void setIdNo(String str) {
        this.idNo = str;
    }

    public void setIdentityType(int i11) {
        this.identityType = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNationalityId(int i11) {
        this.nationalityId = i11;
    }

    public void setNo(String str) {
        this.f70239no = str;
    }

    public void setProStatus(boolean z11) {
        this.proStatus = z11;
    }

    public void setProvinceId(int i11) {
        this.provinceId = i11;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setSeri(String str) {
        this.seri = str;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setSurname(String str) {
        this.surname = str;
    }

    public String toString() {
        return "FiatKycInfo(state=" + getState() + ", proStatus=" + isProStatus() + ", identityType=" + getIdentityType() + ", idNo=" + getIdNo() + ", name=" + getName() + ", surname=" + getSurname() + ", gender=" + getGender() + ", nationalityId=" + getNationalityId() + ", birthday=" + getBirthday() + ", provinceId=" + getProvinceId() + ", distinctId=" + getDistinctId() + ", documentNo=" + getDocumentNo() + ", seri=" + getSeri() + ", no=" + getNo() + ", reason=" + getReason() + ", idFrontUrl=" + getIdFrontUrl() + ", idBackUrl=" + getIdBackUrl() + ", holdUrl=" + getHoldUrl() + ", idFrontUrlForDownload=" + getIdFrontUrlForDownload() + ", idBackUrlForDownload=" + getIdBackUrlForDownload() + ", holdUrlForDownload=" + getHoldUrlForDownload() + ")";
    }
}
