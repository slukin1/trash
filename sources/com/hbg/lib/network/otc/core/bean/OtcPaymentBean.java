package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcPaymentBean implements Serializable {
    private int bankType;
    private String color;

    /* renamed from: id  reason: collision with root package name */
    private int f70594id;
    private String payMethodName;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcPaymentBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcPaymentBean)) {
            return false;
        }
        OtcPaymentBean otcPaymentBean = (OtcPaymentBean) obj;
        if (!otcPaymentBean.canEqual(this) || getId() != otcPaymentBean.getId() || getBankType() != otcPaymentBean.getBankType()) {
            return false;
        }
        String color2 = getColor();
        String color3 = otcPaymentBean.getColor();
        if (color2 != null ? !color2.equals(color3) : color3 != null) {
            return false;
        }
        String payMethodName2 = getPayMethodName();
        String payMethodName3 = otcPaymentBean.getPayMethodName();
        return payMethodName2 != null ? payMethodName2.equals(payMethodName3) : payMethodName3 == null;
    }

    public int getBankType() {
        return this.bankType;
    }

    public String getColor() {
        return this.color;
    }

    public int getId() {
        return this.f70594id;
    }

    public String getPayMethodName() {
        return this.payMethodName;
    }

    public int hashCode() {
        int id2 = ((getId() + 59) * 59) + getBankType();
        String color2 = getColor();
        int i11 = 43;
        int hashCode = (id2 * 59) + (color2 == null ? 43 : color2.hashCode());
        String payMethodName2 = getPayMethodName();
        int i12 = hashCode * 59;
        if (payMethodName2 != null) {
            i11 = payMethodName2.hashCode();
        }
        return i12 + i11;
    }

    public void setBankType(int i11) {
        this.bankType = i11;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setId(int i11) {
        this.f70594id = i11;
    }

    public void setPayMethodName(String str) {
        this.payMethodName = str;
    }

    public String toString() {
        return "OtcPaymentBean(id=" + getId() + ", bankType=" + getBankType() + ", color=" + getColor() + ", payMethodName=" + getPayMethodName() + ")";
    }
}
