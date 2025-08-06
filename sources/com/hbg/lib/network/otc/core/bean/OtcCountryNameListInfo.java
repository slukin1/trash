package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcCountryNameListInfo implements Serializable {
    public List<CountryNameBean> countryNameData;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCountryNameListInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCountryNameListInfo)) {
            return false;
        }
        OtcCountryNameListInfo otcCountryNameListInfo = (OtcCountryNameListInfo) obj;
        if (!otcCountryNameListInfo.canEqual(this)) {
            return false;
        }
        List<CountryNameBean> countryNameData2 = getCountryNameData();
        List<CountryNameBean> countryNameData3 = otcCountryNameListInfo.getCountryNameData();
        return countryNameData2 != null ? countryNameData2.equals(countryNameData3) : countryNameData3 == null;
    }

    public List<CountryNameBean> getCountryNameData() {
        return this.countryNameData;
    }

    public int hashCode() {
        List<CountryNameBean> countryNameData2 = getCountryNameData();
        return 59 + (countryNameData2 == null ? 43 : countryNameData2.hashCode());
    }

    public void setCountryNameData(List<CountryNameBean> list) {
        this.countryNameData = list;
    }

    public String toString() {
        return "OtcCountryNameListInfo(countryNameData=" + getCountryNameData() + ")";
    }
}
