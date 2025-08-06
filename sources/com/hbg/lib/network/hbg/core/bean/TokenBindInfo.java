package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class TokenBindInfo implements Serializable {
    private static final long serialVersionUID = -9175498530803512276L;
    private String address;
    private String eqInfo;

    /* renamed from: ip  reason: collision with root package name */
    private String f70269ip;
    private boolean success;
    private boolean webKnowDevice = true;

    public boolean canEqual(Object obj) {
        return obj instanceof TokenBindInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenBindInfo)) {
            return false;
        }
        TokenBindInfo tokenBindInfo = (TokenBindInfo) obj;
        if (!tokenBindInfo.canEqual(this)) {
            return false;
        }
        String ip2 = getIp();
        String ip3 = tokenBindInfo.getIp();
        if (ip2 != null ? !ip2.equals(ip3) : ip3 != null) {
            return false;
        }
        String address2 = getAddress();
        String address3 = tokenBindInfo.getAddress();
        if (address2 != null ? !address2.equals(address3) : address3 != null) {
            return false;
        }
        String eqInfo2 = getEqInfo();
        String eqInfo3 = tokenBindInfo.getEqInfo();
        if (eqInfo2 != null ? eqInfo2.equals(eqInfo3) : eqInfo3 == null) {
            return isSuccess() == tokenBindInfo.isSuccess() && isWebKnowDevice() == tokenBindInfo.isWebKnowDevice();
        }
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public String getEqInfo() {
        return this.eqInfo;
    }

    public String getIp() {
        return this.f70269ip;
    }

    public int hashCode() {
        String ip2 = getIp();
        int i11 = 43;
        int hashCode = ip2 == null ? 43 : ip2.hashCode();
        String address2 = getAddress();
        int hashCode2 = ((hashCode + 59) * 59) + (address2 == null ? 43 : address2.hashCode());
        String eqInfo2 = getEqInfo();
        int i12 = hashCode2 * 59;
        if (eqInfo2 != null) {
            i11 = eqInfo2.hashCode();
        }
        int i13 = 79;
        int i14 = (((i12 + i11) * 59) + (isSuccess() ? 79 : 97)) * 59;
        if (!isWebKnowDevice()) {
            i13 = 97;
        }
        return i14 + i13;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isWebKnowDevice() {
        return this.webKnowDevice;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setEqInfo(String str) {
        this.eqInfo = str;
    }

    public void setIp(String str) {
        this.f70269ip = str;
    }

    public void setSuccess(boolean z11) {
        this.success = z11;
    }

    public void setWebKnowDevice(boolean z11) {
        this.webKnowDevice = z11;
    }

    public String toString() {
        return "TokenBindInfo(ip=" + getIp() + ", address=" + getAddress() + ", eqInfo=" + getEqInfo() + ", success=" + isSuccess() + ", webKnowDevice=" + isWebKnowDevice() + ")";
    }
}
