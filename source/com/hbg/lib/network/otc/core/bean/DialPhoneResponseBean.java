package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class DialPhoneResponseBean implements Serializable {
    private String countDown;
    private String phone;
    private String secretNo;

    public boolean canEqual(Object obj) {
        return obj instanceof DialPhoneResponseBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DialPhoneResponseBean)) {
            return false;
        }
        DialPhoneResponseBean dialPhoneResponseBean = (DialPhoneResponseBean) obj;
        if (!dialPhoneResponseBean.canEqual(this)) {
            return false;
        }
        String phone2 = getPhone();
        String phone3 = dialPhoneResponseBean.getPhone();
        if (phone2 != null ? !phone2.equals(phone3) : phone3 != null) {
            return false;
        }
        String secretNo2 = getSecretNo();
        String secretNo3 = dialPhoneResponseBean.getSecretNo();
        if (secretNo2 != null ? !secretNo2.equals(secretNo3) : secretNo3 != null) {
            return false;
        }
        String countDown2 = getCountDown();
        String countDown3 = dialPhoneResponseBean.getCountDown();
        return countDown2 != null ? countDown2.equals(countDown3) : countDown3 == null;
    }

    public String getCountDown() {
        return this.countDown;
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
        int hashCode2 = ((hashCode + 59) * 59) + (secretNo2 == null ? 43 : secretNo2.hashCode());
        String countDown2 = getCountDown();
        int i12 = hashCode2 * 59;
        if (countDown2 != null) {
            i11 = countDown2.hashCode();
        }
        return i12 + i11;
    }

    public void setCountDown(String str) {
        this.countDown = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setSecretNo(String str) {
        this.secretNo = str;
    }

    public String toString() {
        return "DialPhoneResponseBean(phone=" + getPhone() + ", secretNo=" + getSecretNo() + ", countDown=" + getCountDown() + ")";
    }
}
