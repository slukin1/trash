package com.hbg.lib.network.otc.core;

public class OTCPageListExtendResponse<T1, T2> extends OTCPageListResponse<T1> {
    public T2 extend;

    public boolean canEqual(Object obj) {
        return obj instanceof OTCPageListExtendResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OTCPageListExtendResponse)) {
            return false;
        }
        OTCPageListExtendResponse oTCPageListExtendResponse = (OTCPageListExtendResponse) obj;
        if (!oTCPageListExtendResponse.canEqual(this)) {
            return false;
        }
        Object extend2 = getExtend();
        Object extend3 = oTCPageListExtendResponse.getExtend();
        return extend2 != null ? extend2.equals(extend3) : extend3 == null;
    }

    public T2 getExtend() {
        return this.extend;
    }

    public int hashCode() {
        Object extend2 = getExtend();
        return 59 + (extend2 == null ? 43 : extend2.hashCode());
    }

    public void setExtend(T2 t22) {
        this.extend = t22;
    }

    public String toString() {
        return "OTCPageListExtendResponse(extend=" + getExtend() + ")";
    }
}
