package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OrderPhone implements Serializable {
    private String phone;
    private String secretNo;

    public boolean canEqual(Object obj) {
        return obj instanceof OrderPhone;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderPhone)) {
            return false;
        }
        OrderPhone orderPhone = (OrderPhone) obj;
        if (!orderPhone.canEqual(this)) {
            return false;
        }
        String phone2 = getPhone();
        String phone3 = orderPhone.getPhone();
        if (phone2 != null ? !phone2.equals(phone3) : phone3 != null) {
            return false;
        }
        String secretNo2 = getSecretNo();
        String secretNo3 = orderPhone.getSecretNo();
        return secretNo2 != null ? secretNo2.equals(secretNo3) : secretNo3 == null;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getSecretNo() {
        return this.secretNo;
    }

    public int hashCode() {
        String phone2 = getPhone();
        int i11 = 43;
        int hashCode = phone2 == null ? 43 : phone2.hashCode();
        String secretNo2 = getSecretNo();
        int i12 = (hashCode + 59) * 59;
        if (secretNo2 != null) {
            i11 = secretNo2.hashCode();
        }
        return i12 + i11;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSecretNo(String str) {
        this.secretNo = str;
    }

    public String toString() {
        return "OrderPhone(phone=" + getPhone() + ", secretNo=" + getSecretNo() + ")";
    }
}
