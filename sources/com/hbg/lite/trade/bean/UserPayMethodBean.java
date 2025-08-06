package com.hbg.lite.trade.bean;

import java.io.Serializable;

public class UserPayMethodBean implements Serializable {
    public static final int IS_ACTIVITE = 1;
    public static final int IS_NOT_ACTIVITE = 0;
    private String bankAddress;
    private String bankName;
    private String bankNumber;
    private int bankType;

    /* renamed from: id  reason: collision with root package name */
    private String f77503id;
    private int isShow;
    private String qrCode;
    private int status;
    private String userId;
    private String userName;

    public boolean canEqual(Object obj) {
        return obj instanceof UserPayMethodBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserPayMethodBean)) {
            return false;
        }
        UserPayMethodBean userPayMethodBean = (UserPayMethodBean) obj;
        if (!userPayMethodBean.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = userPayMethodBean.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = userPayMethodBean.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = userPayMethodBean.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getBankType() != userPayMethodBean.getBankType()) {
            return false;
        }
        String bankNumber2 = getBankNumber();
        String bankNumber3 = userPayMethodBean.getBankNumber();
        if (bankNumber2 != null ? !bankNumber2.equals(bankNumber3) : bankNumber3 != null) {
            return false;
        }
        String bankName2 = getBankName();
        String bankName3 = userPayMethodBean.getBankName();
        if (bankName2 != null ? !bankName2.equals(bankName3) : bankName3 != null) {
            return false;
        }
        String bankAddress2 = getBankAddress();
        String bankAddress3 = userPayMethodBean.getBankAddress();
        if (bankAddress2 != null ? !bankAddress2.equals(bankAddress3) : bankAddress3 != null) {
            return false;
        }
        String qrCode2 = getQrCode();
        String qrCode3 = userPayMethodBean.getQrCode();
        if (qrCode2 != null ? qrCode2.equals(qrCode3) : qrCode3 == null) {
            return getStatus() == userPayMethodBean.getStatus() && getIsShow() == userPayMethodBean.getIsShow();
        }
        return false;
    }

    public String getBankAddress() {
        return this.bankAddress;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBankNumber() {
        return this.bankNumber;
    }

    public int getBankType() {
        return this.bankType;
    }

    public String getId() {
        return this.f77503id;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String userId2 = getUserId();
        int hashCode2 = ((hashCode + 59) * 59) + (userId2 == null ? 43 : userId2.hashCode());
        String userName2 = getUserName();
        int hashCode3 = (((hashCode2 * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + getBankType();
        String bankNumber2 = getBankNumber();
        int hashCode4 = (hashCode3 * 59) + (bankNumber2 == null ? 43 : bankNumber2.hashCode());
        String bankName2 = getBankName();
        int hashCode5 = (hashCode4 * 59) + (bankName2 == null ? 43 : bankName2.hashCode());
        String bankAddress2 = getBankAddress();
        int hashCode6 = (hashCode5 * 59) + (bankAddress2 == null ? 43 : bankAddress2.hashCode());
        String qrCode2 = getQrCode();
        int i12 = hashCode6 * 59;
        if (qrCode2 != null) {
            i11 = qrCode2.hashCode();
        }
        return ((((i12 + i11) * 59) + getStatus()) * 59) + getIsShow();
    }

    public void setBankAddress(String str) {
        this.bankAddress = str;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBankNumber(String str) {
        this.bankNumber = str;
    }

    public void setBankType(int i11) {
        this.bankType = i11;
    }

    public void setId(String str) {
        this.f77503id = str;
    }

    public void setIsShow(int i11) {
        this.isShow = i11;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "UserPayMethodBean(id=" + getId() + ", userId=" + getUserId() + ", userName=" + getUserName() + ", bankType=" + getBankType() + ", bankNumber=" + getBankNumber() + ", bankName=" + getBankName() + ", bankAddress=" + getBankAddress() + ", qrCode=" + getQrCode() + ", status=" + getStatus() + ", isShow=" + getIsShow() + ")";
    }
}
