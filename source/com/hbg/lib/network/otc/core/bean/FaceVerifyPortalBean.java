package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class FaceVerifyPortalBean implements Serializable {
    private String bizId;
    private String qrCodeUrl;
    private int remoteType;
    private String verifyToken;
    private int verifyType;

    public boolean canEqual(Object obj) {
        return obj instanceof FaceVerifyPortalBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FaceVerifyPortalBean)) {
            return false;
        }
        FaceVerifyPortalBean faceVerifyPortalBean = (FaceVerifyPortalBean) obj;
        if (!faceVerifyPortalBean.canEqual(this)) {
            return false;
        }
        String bizId2 = getBizId();
        String bizId3 = faceVerifyPortalBean.getBizId();
        if (bizId2 != null ? !bizId2.equals(bizId3) : bizId3 != null) {
            return false;
        }
        String qrCodeUrl2 = getQrCodeUrl();
        String qrCodeUrl3 = faceVerifyPortalBean.getQrCodeUrl();
        if (qrCodeUrl2 != null ? !qrCodeUrl2.equals(qrCodeUrl3) : qrCodeUrl3 != null) {
            return false;
        }
        if (getRemoteType() != faceVerifyPortalBean.getRemoteType()) {
            return false;
        }
        String verifyToken2 = getVerifyToken();
        String verifyToken3 = faceVerifyPortalBean.getVerifyToken();
        if (verifyToken2 != null ? verifyToken2.equals(verifyToken3) : verifyToken3 == null) {
            return getVerifyType() == faceVerifyPortalBean.getVerifyType();
        }
        return false;
    }

    public String getBizId() {
        return this.bizId;
    }

    public String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public int getRemoteType() {
        return this.remoteType;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public int getVerifyType() {
        return this.verifyType;
    }

    public int hashCode() {
        String bizId2 = getBizId();
        int i11 = 43;
        int hashCode = bizId2 == null ? 43 : bizId2.hashCode();
        String qrCodeUrl2 = getQrCodeUrl();
        int hashCode2 = ((((hashCode + 59) * 59) + (qrCodeUrl2 == null ? 43 : qrCodeUrl2.hashCode())) * 59) + getRemoteType();
        String verifyToken2 = getVerifyToken();
        int i12 = hashCode2 * 59;
        if (verifyToken2 != null) {
            i11 = verifyToken2.hashCode();
        }
        return ((i12 + i11) * 59) + getVerifyType();
    }

    public void setBizId(String str) {
        this.bizId = str;
    }

    public void setQrCodeUrl(String str) {
        this.qrCodeUrl = str;
    }

    public void setRemoteType(int i11) {
        this.remoteType = i11;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }

    public void setVerifyType(int i11) {
        this.verifyType = i11;
    }

    public String toString() {
        return "FaceVerifyPortalBean(bizId=" + getBizId() + ", qrCodeUrl=" + getQrCodeUrl() + ", remoteType=" + getRemoteType() + ", verifyToken=" + getVerifyToken() + ", verifyType=" + getVerifyType() + ")";
    }
}
