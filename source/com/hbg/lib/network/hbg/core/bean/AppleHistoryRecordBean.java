package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AppleHistoryRecordBean implements Serializable {
    private Long applyDate;
    private String businessNo;
    private String linkExtra;
    private Long recordBeginDate;
    private Long recordEndDate;
    private int status;
    private String uid;
    private String userEmail;

    public boolean canEqual(Object obj) {
        return obj instanceof AppleHistoryRecordBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppleHistoryRecordBean)) {
            return false;
        }
        AppleHistoryRecordBean appleHistoryRecordBean = (AppleHistoryRecordBean) obj;
        if (!appleHistoryRecordBean.canEqual(this)) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = appleHistoryRecordBean.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        if (getStatus() != appleHistoryRecordBean.getStatus()) {
            return false;
        }
        Long applyDate2 = getApplyDate();
        Long applyDate3 = appleHistoryRecordBean.getApplyDate();
        if (applyDate2 != null ? !applyDate2.equals(applyDate3) : applyDate3 != null) {
            return false;
        }
        Long recordBeginDate2 = getRecordBeginDate();
        Long recordBeginDate3 = appleHistoryRecordBean.getRecordBeginDate();
        if (recordBeginDate2 != null ? !recordBeginDate2.equals(recordBeginDate3) : recordBeginDate3 != null) {
            return false;
        }
        Long recordEndDate2 = getRecordEndDate();
        Long recordEndDate3 = appleHistoryRecordBean.getRecordEndDate();
        if (recordEndDate2 != null ? !recordEndDate2.equals(recordEndDate3) : recordEndDate3 != null) {
            return false;
        }
        String businessNo2 = getBusinessNo();
        String businessNo3 = appleHistoryRecordBean.getBusinessNo();
        if (businessNo2 != null ? !businessNo2.equals(businessNo3) : businessNo3 != null) {
            return false;
        }
        String linkExtra2 = getLinkExtra();
        String linkExtra3 = appleHistoryRecordBean.getLinkExtra();
        if (linkExtra2 != null ? !linkExtra2.equals(linkExtra3) : linkExtra3 != null) {
            return false;
        }
        String userEmail2 = getUserEmail();
        String userEmail3 = appleHistoryRecordBean.getUserEmail();
        return userEmail2 != null ? userEmail2.equals(userEmail3) : userEmail3 == null;
    }

    public Long getApplyDate() {
        return this.applyDate;
    }

    public String getBusinessNo() {
        return this.businessNo;
    }

    public String getLinkExtra() {
        return this.linkExtra;
    }

    public Long getRecordBeginDate() {
        return this.recordBeginDate;
    }

    public Long getRecordEndDate() {
        return this.recordEndDate;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public int hashCode() {
        String uid2 = getUid();
        int i11 = 43;
        int hashCode = (((uid2 == null ? 43 : uid2.hashCode()) + 59) * 59) + getStatus();
        Long applyDate2 = getApplyDate();
        int hashCode2 = (hashCode * 59) + (applyDate2 == null ? 43 : applyDate2.hashCode());
        Long recordBeginDate2 = getRecordBeginDate();
        int hashCode3 = (hashCode2 * 59) + (recordBeginDate2 == null ? 43 : recordBeginDate2.hashCode());
        Long recordEndDate2 = getRecordEndDate();
        int hashCode4 = (hashCode3 * 59) + (recordEndDate2 == null ? 43 : recordEndDate2.hashCode());
        String businessNo2 = getBusinessNo();
        int hashCode5 = (hashCode4 * 59) + (businessNo2 == null ? 43 : businessNo2.hashCode());
        String linkExtra2 = getLinkExtra();
        int hashCode6 = (hashCode5 * 59) + (linkExtra2 == null ? 43 : linkExtra2.hashCode());
        String userEmail2 = getUserEmail();
        int i12 = hashCode6 * 59;
        if (userEmail2 != null) {
            i11 = userEmail2.hashCode();
        }
        return i12 + i11;
    }

    public void setApplyDate(Long l11) {
        this.applyDate = l11;
    }

    public void setBusinessNo(String str) {
        this.businessNo = str;
    }

    public void setLinkExtra(String str) {
        this.linkExtra = str;
    }

    public void setRecordBeginDate(Long l11) {
        this.recordBeginDate = l11;
    }

    public void setRecordEndDate(Long l11) {
        this.recordEndDate = l11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserEmail(String str) {
        this.userEmail = str;
    }

    public String toString() {
        return "AppleHistoryRecordBean(uid=" + getUid() + ", status=" + getStatus() + ", applyDate=" + getApplyDate() + ", recordBeginDate=" + getRecordBeginDate() + ", recordEndDate=" + getRecordEndDate() + ", businessNo=" + getBusinessNo() + ", linkExtra=" + getLinkExtra() + ", userEmail=" + getUserEmail() + ")";
    }
}
