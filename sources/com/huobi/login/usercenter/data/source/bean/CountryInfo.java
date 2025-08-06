package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CountryInfo implements Serializable {
    private static final long serialVersionUID = -3322296840146875036L;
    @SerializedName("country_id")
    private String countryId;
    @SerializedName("region_id")
    private String regionId;
    @SerializedName("show_msg")
    private boolean showMsg;

    public String getCountryId() {
        return this.countryId;
    }

    public String getRegionId() {
        return this.regionId;
    }

    public boolean isShowMsg() {
        return this.showMsg;
    }

    public void setCountryId(String str) {
        this.countryId = str;
    }

    public void setRegionId(String str) {
        this.regionId = str;
    }

    public void setShowMsg(boolean z11) {
        this.showMsg = z11;
    }
}
