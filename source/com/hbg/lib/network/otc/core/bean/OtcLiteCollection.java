package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcLiteCollection implements Serializable {
    private static final long serialVersionUID = 3930501198834558215L;
    private OtcLiteConvert convert;
    private List<OtcLiteQueryData> wallet;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcLiteCollection;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcLiteCollection)) {
            return false;
        }
        OtcLiteCollection otcLiteCollection = (OtcLiteCollection) obj;
        if (!otcLiteCollection.canEqual(this)) {
            return false;
        }
        OtcLiteConvert convert2 = getConvert();
        OtcLiteConvert convert3 = otcLiteCollection.getConvert();
        if (convert2 != null ? !convert2.equals(convert3) : convert3 != null) {
            return false;
        }
        List<OtcLiteQueryData> wallet2 = getWallet();
        List<OtcLiteQueryData> wallet3 = otcLiteCollection.getWallet();
        return wallet2 != null ? wallet2.equals(wallet3) : wallet3 == null;
    }

    public OtcLiteConvert getConvert() {
        return this.convert;
    }

    public List<OtcLiteQueryData> getWallet() {
        return this.wallet;
    }

    public int hashCode() {
        OtcLiteConvert convert2 = getConvert();
        int i11 = 43;
        int hashCode = convert2 == null ? 43 : convert2.hashCode();
        List<OtcLiteQueryData> wallet2 = getWallet();
        int i12 = (hashCode + 59) * 59;
        if (wallet2 != null) {
            i11 = wallet2.hashCode();
        }
        return i12 + i11;
    }

    public void setConvert(OtcLiteConvert otcLiteConvert) {
        this.convert = otcLiteConvert;
    }

    public void setWallet(List<OtcLiteQueryData> list) {
        this.wallet = list;
    }

    public String toString() {
        return "OtcLiteCollection(convert=" + getConvert() + ", wallet=" + getWallet() + ")";
    }
}
