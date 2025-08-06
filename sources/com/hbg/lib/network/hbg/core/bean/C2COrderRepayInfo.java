package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2COrderRepayInfo implements Serializable {
    private String availableAmount;
    private long orderId;
    private String remainAmount;
    private String remainCount;
    private String remainInterest;
    private String userMinRepayAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof C2COrderRepayInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2COrderRepayInfo)) {
            return false;
        }
        C2COrderRepayInfo c2COrderRepayInfo = (C2COrderRepayInfo) obj;
        if (!c2COrderRepayInfo.canEqual(this) || getOrderId() != c2COrderRepayInfo.getOrderId()) {
            return false;
        }
        String remainInterest2 = getRemainInterest();
        String remainInterest3 = c2COrderRepayInfo.getRemainInterest();
        if (remainInterest2 != null ? !remainInterest2.equals(remainInterest3) : remainInterest3 != null) {
            return false;
        }
        String remainAmount2 = getRemainAmount();
        String remainAmount3 = c2COrderRepayInfo.getRemainAmount();
        if (remainAmount2 != null ? !remainAmount2.equals(remainAmount3) : remainAmount3 != null) {
            return false;
        }
        String remainCount2 = getRemainCount();
        String remainCount3 = c2COrderRepayInfo.getRemainCount();
        if (remainCount2 != null ? !remainCount2.equals(remainCount3) : remainCount3 != null) {
            return false;
        }
        String userMinRepayAmount2 = getUserMinRepayAmount();
        String userMinRepayAmount3 = c2COrderRepayInfo.getUserMinRepayAmount();
        if (userMinRepayAmount2 != null ? !userMinRepayAmount2.equals(userMinRepayAmount3) : userMinRepayAmount3 != null) {
            return false;
        }
        String availableAmount2 = getAvailableAmount();
        String availableAmount3 = c2COrderRepayInfo.getAvailableAmount();
        return availableAmount2 != null ? availableAmount2.equals(availableAmount3) : availableAmount3 == null;
    }

    public String getAvailableAmount() {
        return this.availableAmount;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getRemainAmount() {
        return this.remainAmount;
    }

    public String getRemainCount() {
        return this.remainCount;
    }

    public String getRemainInterest() {
        return this.remainInterest;
    }

    public String getUserMinRepayAmount() {
        return this.userMinRepayAmount;
    }

    public int hashCode() {
        long orderId2 = getOrderId();
        String remainInterest2 = getRemainInterest();
        int i11 = 43;
        int hashCode = ((((int) (orderId2 ^ (orderId2 >>> 32))) + 59) * 59) + (remainInterest2 == null ? 43 : remainInterest2.hashCode());
        String remainAmount2 = getRemainAmount();
        int hashCode2 = (hashCode * 59) + (remainAmount2 == null ? 43 : remainAmount2.hashCode());
        String remainCount2 = getRemainCount();
        int hashCode3 = (hashCode2 * 59) + (remainCount2 == null ? 43 : remainCount2.hashCode());
        String userMinRepayAmount2 = getUserMinRepayAmount();
        int hashCode4 = (hashCode3 * 59) + (userMinRepayAmount2 == null ? 43 : userMinRepayAmount2.hashCode());
        String availableAmount2 = getAvailableAmount();
        int i12 = hashCode4 * 59;
        if (availableAmount2 != null) {
            i11 = availableAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableAmount(String str) {
        this.availableAmount = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setRemainAmount(String str) {
        this.remainAmount = str;
    }

    public void setRemainCount(String str) {
        this.remainCount = str;
    }

    public void setRemainInterest(String str) {
        this.remainInterest = str;
    }

    public void setUserMinRepayAmount(String str) {
        this.userMinRepayAmount = str;
    }

    public String toString() {
        return "C2COrderRepayInfo(orderId=" + getOrderId() + ", remainInterest=" + getRemainInterest() + ", remainAmount=" + getRemainAmount() + ", remainCount=" + getRemainCount() + ", userMinRepayAmount=" + getUserMinRepayAmount() + ", availableAmount=" + getAvailableAmount() + ")";
    }
}
