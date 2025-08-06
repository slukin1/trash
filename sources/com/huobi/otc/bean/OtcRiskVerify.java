package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcRiskVerify implements Serializable {
    private int comparisonType;
    private String liteUrl;
    private String nativeToken;
    private int nativeType;
    private String riskMsg;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcRiskVerify;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcRiskVerify)) {
            return false;
        }
        OtcRiskVerify otcRiskVerify = (OtcRiskVerify) obj;
        if (!otcRiskVerify.canEqual(this) || getNativeType() != otcRiskVerify.getNativeType()) {
            return false;
        }
        String nativeToken2 = getNativeToken();
        String nativeToken3 = otcRiskVerify.getNativeToken();
        if (nativeToken2 != null ? !nativeToken2.equals(nativeToken3) : nativeToken3 != null) {
            return false;
        }
        if (getComparisonType() != otcRiskVerify.getComparisonType()) {
            return false;
        }
        String liteUrl2 = getLiteUrl();
        String liteUrl3 = otcRiskVerify.getLiteUrl();
        if (liteUrl2 != null ? !liteUrl2.equals(liteUrl3) : liteUrl3 != null) {
            return false;
        }
        String riskMsg2 = getRiskMsg();
        String riskMsg3 = otcRiskVerify.getRiskMsg();
        return riskMsg2 != null ? riskMsg2.equals(riskMsg3) : riskMsg3 == null;
    }

    public int getComparisonType() {
        return this.comparisonType;
    }

    public String getLiteUrl() {
        return this.liteUrl;
    }

    public String getNativeToken() {
        return this.nativeToken;
    }

    public int getNativeType() {
        return this.nativeType;
    }

    public String getRiskMsg() {
        return this.riskMsg;
    }

    public int hashCode() {
        String nativeToken2 = getNativeToken();
        int i11 = 43;
        int nativeType2 = ((((getNativeType() + 59) * 59) + (nativeToken2 == null ? 43 : nativeToken2.hashCode())) * 59) + getComparisonType();
        String liteUrl2 = getLiteUrl();
        int hashCode = (nativeType2 * 59) + (liteUrl2 == null ? 43 : liteUrl2.hashCode());
        String riskMsg2 = getRiskMsg();
        int i12 = hashCode * 59;
        if (riskMsg2 != null) {
            i11 = riskMsg2.hashCode();
        }
        return i12 + i11;
    }

    public void setComparisonType(int i11) {
        this.comparisonType = i11;
    }

    public void setLiteUrl(String str) {
        this.liteUrl = str;
    }

    public void setNativeToken(String str) {
        this.nativeToken = str;
    }

    public void setNativeType(int i11) {
        this.nativeType = i11;
    }

    public void setRiskMsg(String str) {
        this.riskMsg = str;
    }

    public String toString() {
        return "OtcRiskVerify(nativeType=" + getNativeType() + ", nativeToken=" + getNativeToken() + ", comparisonType=" + getComparisonType() + ", liteUrl=" + getLiteUrl() + ", riskMsg=" + getRiskMsg() + ")";
    }
}
