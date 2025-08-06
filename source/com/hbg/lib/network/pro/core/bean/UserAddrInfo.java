package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class UserAddrInfo implements Serializable {
    private String address;
    private String chain;

    public boolean canEqual(Object obj) {
        return obj instanceof UserAddrInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAddrInfo)) {
            return false;
        }
        UserAddrInfo userAddrInfo = (UserAddrInfo) obj;
        if (!userAddrInfo.canEqual(this)) {
            return false;
        }
        String chain2 = getChain();
        String chain3 = userAddrInfo.getChain();
        if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
            return false;
        }
        String address2 = getAddress();
        String address3 = userAddrInfo.getAddress();
        return address2 != null ? address2.equals(address3) : address3 == null;
    }

    public String getAddress() {
        return this.address;
    }

    public String getChain() {
        return this.chain;
    }

    public int hashCode() {
        String chain2 = getChain();
        int i11 = 43;
        int hashCode = chain2 == null ? 43 : chain2.hashCode();
        String address2 = getAddress();
        int i12 = (hashCode + 59) * 59;
        if (address2 != null) {
            i11 = address2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public String toString() {
        return "UserAddrInfo(chain=" + getChain() + ", address=" + getAddress() + ")";
    }
}
