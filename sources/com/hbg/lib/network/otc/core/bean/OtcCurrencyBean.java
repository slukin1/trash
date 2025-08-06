package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcCurrencyBean implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private int f70589id;
    private String nameCn;
    private String nameEn;
    private String nameShort;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCurrencyBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCurrencyBean)) {
            return false;
        }
        OtcCurrencyBean otcCurrencyBean = (OtcCurrencyBean) obj;
        if (!otcCurrencyBean.canEqual(this) || getId() != otcCurrencyBean.getId()) {
            return false;
        }
        String nameCn2 = getNameCn();
        String nameCn3 = otcCurrencyBean.getNameCn();
        if (nameCn2 != null ? !nameCn2.equals(nameCn3) : nameCn3 != null) {
            return false;
        }
        String nameEn2 = getNameEn();
        String nameEn3 = otcCurrencyBean.getNameEn();
        if (nameEn2 != null ? !nameEn2.equals(nameEn3) : nameEn3 != null) {
            return false;
        }
        String nameShort2 = getNameShort();
        String nameShort3 = otcCurrencyBean.getNameShort();
        return nameShort2 != null ? nameShort2.equals(nameShort3) : nameShort3 == null;
    }

    public int getId() {
        return this.f70589id;
    }

    public String getNameCn() {
        return this.nameCn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public String getNameShort() {
        return this.nameShort;
    }

    public int hashCode() {
        String nameCn2 = getNameCn();
        int i11 = 43;
        int id2 = ((getId() + 59) * 59) + (nameCn2 == null ? 43 : nameCn2.hashCode());
        String nameEn2 = getNameEn();
        int hashCode = (id2 * 59) + (nameEn2 == null ? 43 : nameEn2.hashCode());
        String nameShort2 = getNameShort();
        int i12 = hashCode * 59;
        if (nameShort2 != null) {
            i11 = nameShort2.hashCode();
        }
        return i12 + i11;
    }

    public void setId(int i11) {
        this.f70589id = i11;
    }

    public void setNameCn(String str) {
        this.nameCn = str;
    }

    public void setNameEn(String str) {
        this.nameEn = str;
    }

    public void setNameShort(String str) {
        this.nameShort = str;
    }

    public String toString() {
        return "OtcCurrencyBean(id=" + getId() + ", nameCn=" + getNameCn() + ", nameEn=" + getNameEn() + ", nameShort=" + getNameShort() + ")";
    }
}
