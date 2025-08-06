package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PasskeyLoginData implements Serializable {
    @SerializedName("forbid_country")
    private String forbidCountry;
    @SerializedName("forbid_country_message")
    private String forbidCountryMsg;
    private String ticket;
    @SerializedName("token_url")
    private String tokenUrl;
    @SerializedName("uc_token")
    private String ucToken;

    public String getForbidCountry() {
        return this.forbidCountry;
    }

    public String getForbidCountryMsg() {
        return this.forbidCountryMsg;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getTokenUrl() {
        return this.tokenUrl;
    }

    public String getUcToken() {
        return this.ucToken;
    }
}
