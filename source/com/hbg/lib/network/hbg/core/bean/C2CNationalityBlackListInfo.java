package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CNationalityBlackListInfo implements Serializable {
    private String countryCode;
    private int countryId;
    private String nameCn;
    private String nameEn;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CNationalityBlackListInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CNationalityBlackListInfo)) {
            return false;
        }
        C2CNationalityBlackListInfo c2CNationalityBlackListInfo = (C2CNationalityBlackListInfo) obj;
        if (!c2CNationalityBlackListInfo.canEqual(this)) {
            return false;
        }
        String countryCode2 = getCountryCode();
        String countryCode3 = c2CNationalityBlackListInfo.getCountryCode();
        if (countryCode2 != null ? !countryCode2.equals(countryCode3) : countryCode3 != null) {
            return false;
        }
        if (getCountryId() != c2CNationalityBlackListInfo.getCountryId()) {
            return false;
        }
        String nameCn2 = getNameCn();
        String nameCn3 = c2CNationalityBlackListInfo.getNameCn();
        if (nameCn2 != null ? !nameCn2.equals(nameCn3) : nameCn3 != null) {
            return false;
        }
        String nameEn2 = getNameEn();
        String nameEn3 = c2CNationalityBlackListInfo.getNameEn();
        return nameEn2 != null ? nameEn2.equals(nameEn3) : nameEn3 == null;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getNameCn() {
        return this.nameCn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public int hashCode() {
        String countryCode2 = getCountryCode();
        int i11 = 43;
        int hashCode = (((countryCode2 == null ? 43 : countryCode2.hashCode()) + 59) * 59) + getCountryId();
        String nameCn2 = getNameCn();
        int hashCode2 = (hashCode * 59) + (nameCn2 == null ? 43 : nameCn2.hashCode());
        String nameEn2 = getNameEn();
        int i12 = hashCode2 * 59;
        if (nameEn2 != null) {
            i11 = nameEn2.hashCode();
        }
        return i12 + i11;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCountryId(int i11) {
        this.countryId = i11;
    }

    public void setNameCn(String str) {
        this.nameCn = str;
    }

    public void setNameEn(String str) {
        this.nameEn = str;
    }

    public String toString() {
        return "C2CNationalityBlackListInfo(countryCode=" + getCountryCode() + ", countryId=" + getCountryId() + ", nameCn=" + getNameCn() + ", nameEn=" + getNameEn() + ")";
    }
}
