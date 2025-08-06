package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcOrderFee implements Serializable {
    private static final long serialVersionUID = -713899182010444710L;
    private String clearingFee;
    private String clearingFeeName;
    private int clearingStatus;
    private String coinFee;
    private String coinFeeName;
    private String pointFee;
    private String pointFeeName;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOrderFee;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderFee)) {
            return false;
        }
        OtcOrderFee otcOrderFee = (OtcOrderFee) obj;
        if (!otcOrderFee.canEqual(this)) {
            return false;
        }
        String coinFee2 = getCoinFee();
        String coinFee3 = otcOrderFee.getCoinFee();
        if (coinFee2 != null ? !coinFee2.equals(coinFee3) : coinFee3 != null) {
            return false;
        }
        String coinFeeName2 = getCoinFeeName();
        String coinFeeName3 = otcOrderFee.getCoinFeeName();
        if (coinFeeName2 != null ? !coinFeeName2.equals(coinFeeName3) : coinFeeName3 != null) {
            return false;
        }
        String pointFee2 = getPointFee();
        String pointFee3 = otcOrderFee.getPointFee();
        if (pointFee2 != null ? !pointFee2.equals(pointFee3) : pointFee3 != null) {
            return false;
        }
        String pointFeeName2 = getPointFeeName();
        String pointFeeName3 = otcOrderFee.getPointFeeName();
        if (pointFeeName2 != null ? !pointFeeName2.equals(pointFeeName3) : pointFeeName3 != null) {
            return false;
        }
        String clearingFee2 = getClearingFee();
        String clearingFee3 = otcOrderFee.getClearingFee();
        if (clearingFee2 != null ? !clearingFee2.equals(clearingFee3) : clearingFee3 != null) {
            return false;
        }
        String clearingFeeName2 = getClearingFeeName();
        String clearingFeeName3 = otcOrderFee.getClearingFeeName();
        if (clearingFeeName2 != null ? clearingFeeName2.equals(clearingFeeName3) : clearingFeeName3 == null) {
            return getClearingStatus() == otcOrderFee.getClearingStatus();
        }
        return false;
    }

    public String getClearingFee() {
        return this.clearingFee;
    }

    public String getClearingFeeName() {
        return this.clearingFeeName;
    }

    public int getClearingStatus() {
        return this.clearingStatus;
    }

    public String getCoinFee() {
        return this.coinFee;
    }

    public String getCoinFeeName() {
        return this.coinFeeName;
    }

    public String getPointFee() {
        return this.pointFee;
    }

    public String getPointFeeName() {
        return this.pointFeeName;
    }

    public int hashCode() {
        String coinFee2 = getCoinFee();
        int i11 = 43;
        int hashCode = coinFee2 == null ? 43 : coinFee2.hashCode();
        String coinFeeName2 = getCoinFeeName();
        int hashCode2 = ((hashCode + 59) * 59) + (coinFeeName2 == null ? 43 : coinFeeName2.hashCode());
        String pointFee2 = getPointFee();
        int hashCode3 = (hashCode2 * 59) + (pointFee2 == null ? 43 : pointFee2.hashCode());
        String pointFeeName2 = getPointFeeName();
        int hashCode4 = (hashCode3 * 59) + (pointFeeName2 == null ? 43 : pointFeeName2.hashCode());
        String clearingFee2 = getClearingFee();
        int hashCode5 = (hashCode4 * 59) + (clearingFee2 == null ? 43 : clearingFee2.hashCode());
        String clearingFeeName2 = getClearingFeeName();
        int i12 = hashCode5 * 59;
        if (clearingFeeName2 != null) {
            i11 = clearingFeeName2.hashCode();
        }
        return ((i12 + i11) * 59) + getClearingStatus();
    }

    public void setClearingFee(String str) {
        this.clearingFee = str;
    }

    public void setClearingFeeName(String str) {
        this.clearingFeeName = str;
    }

    public void setClearingStatus(int i11) {
        this.clearingStatus = i11;
    }

    public void setCoinFee(String str) {
        this.coinFee = str;
    }

    public void setCoinFeeName(String str) {
        this.coinFeeName = str;
    }

    public void setPointFee(String str) {
        this.pointFee = str;
    }

    public void setPointFeeName(String str) {
        this.pointFeeName = str;
    }

    public String toString() {
        return "OtcOrderFee(coinFee=" + getCoinFee() + ", coinFeeName=" + getCoinFeeName() + ", pointFee=" + getPointFee() + ", pointFeeName=" + getPointFeeName() + ", clearingFee=" + getClearingFee() + ", clearingFeeName=" + getClearingFeeName() + ", clearingStatus=" + getClearingStatus() + ")";
    }
}
