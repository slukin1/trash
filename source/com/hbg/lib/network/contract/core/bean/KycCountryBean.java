package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class KycCountryBean implements Serializable {
    @SerializedName("country_code")
    private int countryCode;

    public int getCountryCode() {
        return this.countryCode;
    }
}
