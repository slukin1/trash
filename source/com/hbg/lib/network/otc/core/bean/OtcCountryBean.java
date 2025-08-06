package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcCountryBean implements Serializable {
    private int code;
    private int currencyId;

    /* renamed from: id  reason: collision with root package name */
    private int f70588id;
    private String nameCn;
    private String nameEn;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCountryBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCountryBean)) {
            return false;
        }
        OtcCountryBean otcCountryBean = (OtcCountryBean) obj;
        if (!otcCountryBean.canEqual(this) || getId() != otcCountryBean.getId() || getCode() != otcCountryBean.getCode()) {
            return false;
        }
        String nameCn2 = getNameCn();
        String nameCn3 = otcCountryBean.getNameCn();
        if (nameCn2 != null ? !nameCn2.equals(nameCn3) : nameCn3 != null) {
            return false;
        }
        String nameEn2 = getNameEn();
        String nameEn3 = otcCountryBean.getNameEn();
        if (nameEn2 != null ? nameEn2.equals(nameEn3) : nameEn3 == null) {
            return getCurrencyId() == otcCountryBean.getCurrencyId();
        }
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public int getId() {
        return this.f70588id;
    }

    public String getNameCn() {
        return this.nameCn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public int hashCode() {
        int id2 = ((getId() + 59) * 59) + getCode();
        String nameCn2 = getNameCn();
        int i11 = 43;
        int hashCode = (id2 * 59) + (nameCn2 == null ? 43 : nameCn2.hashCode());
        String nameEn2 = getNameEn();
        int i12 = hashCode * 59;
        if (nameEn2 != null) {
            i11 = nameEn2.hashCode();
        }
        return ((i12 + i11) * 59) + getCurrencyId();
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setCurrencyId(int i11) {
        this.currencyId = i11;
    }

    public void setId(int i11) {
        this.f70588id = i11;
    }

    public void setNameCn(String str) {
        this.nameCn = str;
    }

    public void setNameEn(String str) {
        this.nameEn = str;
    }

    public String toString() {
        return "OtcCountryBean(id=" + getId() + ", code=" + getCode() + ", nameCn=" + getNameCn() + ", nameEn=" + getNameEn() + ", currencyId=" + getCurrencyId() + ")";
    }
}
