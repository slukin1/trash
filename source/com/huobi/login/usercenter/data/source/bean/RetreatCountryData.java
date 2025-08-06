package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RetreatCountryData implements Serializable {
    @SerializedName("retreat_country_message")
    private String retreatCountryMessage;

    public String getRetreatCountryMessage() {
        return this.retreatCountryMessage;
    }

    public void setRetreatCountryMessage(String str) {
        this.retreatCountryMessage = str;
    }
}
