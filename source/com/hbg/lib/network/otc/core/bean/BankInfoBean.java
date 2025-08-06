package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class BankInfoBean implements Serializable {
    private String bankAddress;
    private String bankName;
    private String bankNumber;
    private int bankType;

    /* renamed from: id  reason: collision with root package name */
    private int f70567id;
    private int isShow;
    private String payIconUrl;
    private String payName;
    private String qrCode;
    private String showMemuName;
    private int status;
    private String userName;

    public boolean canEqual(Object obj) {
        return obj instanceof BankInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankInfoBean)) {
            return false;
        }
        BankInfoBean bankInfoBean = (BankInfoBean) obj;
        if (!bankInfoBean.canEqual(this) || getId() != bankInfoBean.getId()) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = bankInfoBean.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getBankType() != bankInfoBean.getBankType()) {
            return false;
        }
        String bankNumber2 = getBankNumber();
        String bankNumber3 = bankInfoBean.getBankNumber();
        if (bankNumber2 != null ? !bankNumber2.equals(bankNumber3) : bankNumber3 != null) {
            return false;
        }
        String bankName2 = getBankName();
        String bankName3 = bankInfoBean.getBankName();
        if (bankName2 != null ? !bankName2.equals(bankName3) : bankName3 != null) {
            return false;
        }
        String bankAddress2 = getBankAddress();
        String bankAddress3 = bankInfoBean.getBankAddress();
        if (bankAddress2 != null ? !bankAddress2.equals(bankAddress3) : bankAddress3 != null) {
            return false;
        }
        String qrCode2 = getQrCode();
        String qrCode3 = bankInfoBean.getQrCode();
        if (qrCode2 != null ? !qrCode2.equals(qrCode3) : qrCode3 != null) {
            return false;
        }
        String payName2 = getPayName();
        String payName3 = bankInfoBean.getPayName();
        if (payName2 != null ? !payName2.equals(payName3) : payName3 != null) {
            return false;
        }
        if (getStatus() != bankInfoBean.getStatus() || getIsShow() != bankInfoBean.getIsShow()) {
            return false;
        }
        String showMemuName2 = getShowMemuName();
        String showMemuName3 = bankInfoBean.getShowMemuName();
        if (showMemuName2 != null ? !showMemuName2.equals(showMemuName3) : showMemuName3 != null) {
            return false;
        }
        String payIconUrl2 = getPayIconUrl();
        String payIconUrl3 = bankInfoBean.getPayIconUrl();
        return payIconUrl2 != null ? payIconUrl2.equals(payIconUrl3) : payIconUrl3 == null;
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

    public int getId() {
        return this.f70567id;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public String getPayIconUrl() {
        return this.payIconUrl;
    }

    public String getPayName() {
        return this.payName;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public String getShowMemuName() {
        return this.showMemuName;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String userName2 = getUserName();
        int i11 = 43;
        int id2 = ((((getId() + 59) * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + getBankType();
        String bankNumber2 = getBankNumber();
        int hashCode = (id2 * 59) + (bankNumber2 == null ? 43 : bankNumber2.hashCode());
        String bankName2 = getBankName();
        int hashCode2 = (hashCode * 59) + (bankName2 == null ? 43 : bankName2.hashCode());
        String bankAddress2 = getBankAddress();
        int hashCode3 = (hashCode2 * 59) + (bankAddress2 == null ? 43 : bankAddress2.hashCode());
        String qrCode2 = getQrCode();
        int hashCode4 = (hashCode3 * 59) + (qrCode2 == null ? 43 : qrCode2.hashCode());
        String payName2 = getPayName();
        int hashCode5 = (((((hashCode4 * 59) + (payName2 == null ? 43 : payName2.hashCode())) * 59) + getStatus()) * 59) + getIsShow();
        String showMemuName2 = getShowMemuName();
        int hashCode6 = (hashCode5 * 59) + (showMemuName2 == null ? 43 : showMemuName2.hashCode());
        String payIconUrl2 = getPayIconUrl();
        int i12 = hashCode6 * 59;
        if (payIconUrl2 != null) {
            i11 = payIconUrl2.hashCode();
        }
        return i12 + i11;
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

    public void setId(int i11) {
        this.f70567id = i11;
    }

    public void setIsShow(int i11) {
        this.isShow = i11;
    }

    public void setPayIconUrl(String str) {
        this.payIconUrl = str;
    }

    public void setPayName(String str) {
        this.payName = str;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public void setShowMemuName(String str) {
        this.showMemuName = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "BankInfoBean(id=" + getId() + ", userName=" + getUserName() + ", bankType=" + getBankType() + ", bankNumber=" + getBankNumber() + ", bankName=" + getBankName() + ", bankAddress=" + getBankAddress() + ", qrCode=" + getQrCode() + ", payName=" + getPayName() + ", status=" + getStatus() + ", isShow=" + getIsShow() + ", showMemuName=" + getShowMemuName() + ", payIconUrl=" + getPayIconUrl() + ")";
    }
}
