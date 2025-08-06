package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcLiteConvert implements Serializable {
    private static final long serialVersionUID = -1882970141269032889L;
    private String convertBtc;
    private String convertUsdt;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcLiteConvert;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcLiteConvert)) {
            return false;
        }
        OtcLiteConvert otcLiteConvert = (OtcLiteConvert) obj;
        if (!otcLiteConvert.canEqual(this)) {
            return false;
        }
        String convertBtc2 = getConvertBtc();
        String convertBtc3 = otcLiteConvert.getConvertBtc();
        if (convertBtc2 != null ? !convertBtc2.equals(convertBtc3) : convertBtc3 != null) {
            return false;
        }
        String convertUsdt2 = getConvertUsdt();
        String convertUsdt3 = otcLiteConvert.getConvertUsdt();
        return convertUsdt2 != null ? convertUsdt2.equals(convertUsdt3) : convertUsdt3 == null;
    }

    public String getConvertBtc() {
        return this.convertBtc;
    }

    public String getConvertUsdt() {
        return this.convertUsdt;
    }

    public int hashCode() {
        String convertBtc2 = getConvertBtc();
        int i11 = 43;
        int hashCode = convertBtc2 == null ? 43 : convertBtc2.hashCode();
        String convertUsdt2 = getConvertUsdt();
        int i12 = (hashCode + 59) * 59;
        if (convertUsdt2 != null) {
            i11 = convertUsdt2.hashCode();
        }
        return i12 + i11;
    }

    public void setConvertBtc(String str) {
        this.convertBtc = str;
    }

    public void setConvertUsdt(String str) {
        this.convertUsdt = str;
    }

    public String toString() {
        return "OtcLiteConvert(convertBtc=" + getConvertBtc() + ", convertUsdt=" + getConvertUsdt() + ")";
    }
}
