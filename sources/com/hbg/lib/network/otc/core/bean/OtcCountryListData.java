package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OtcCountryListData implements Serializable {
    @SerializedName("area_code")
    private String areaCode;
    @SerializedName("country_id")
    private int countryId;
    @SerializedName("name_cn")
    private String nameCn;
    @SerializedName("name_en")
    private String nameEn;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCountryListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCountryListData)) {
            return false;
        }
        OtcCountryListData otcCountryListData = (OtcCountryListData) obj;
        if (!otcCountryListData.canEqual(this)) {
            return false;
        }
        String areaCode2 = getAreaCode();
        String areaCode3 = otcCountryListData.getAreaCode();
        if (areaCode2 != null ? !areaCode2.equals(areaCode3) : areaCode3 != null) {
            return false;
        }
        String nameCn2 = getNameCn();
        String nameCn3 = otcCountryListData.getNameCn();
        if (nameCn2 != null ? !nameCn2.equals(nameCn3) : nameCn3 != null) {
            return false;
        }
        String nameEn2 = getNameEn();
        String nameEn3 = otcCountryListData.getNameEn();
        if (nameEn2 != null ? nameEn2.equals(nameEn3) : nameEn3 == null) {
            return getCountryId() == otcCountryListData.getCountryId();
        }
        return false;
    }

    public String getAreaCode() {
        return this.areaCode;
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
        String areaCode2 = getAreaCode();
        int i11 = 43;
        int hashCode = areaCode2 == null ? 43 : areaCode2.hashCode();
        String nameCn2 = getNameCn();
        int hashCode2 = ((hashCode + 59) * 59) + (nameCn2 == null ? 43 : nameCn2.hashCode());
        String nameEn2 = getNameEn();
        int i12 = hashCode2 * 59;
        if (nameEn2 != null) {
            i11 = nameEn2.hashCode();
        }
        return ((i12 + i11) * 59) + getCountryId();
    }

    public void setAreaCode(String str) {
        this.areaCode = str;
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
        return "OtcCountryListData(areaCode=" + getAreaCode() + ", nameCn=" + getNameCn() + ", nameEn=" + getNameEn() + ", countryId=" + getCountryId() + ")";
    }
}
