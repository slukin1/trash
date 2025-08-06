package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import p9.a;

public class TsvTokenWrapper implements Serializable, a {
    private static final long serialVersionUID = -7146205529143420349L;
    @SerializedName("forbid_country")
    private boolean forbidCountry;
    @SerializedName("forbid_country_message")
    private String forbidCountryMessage;
    @SerializedName("ticket")
    private String ticket;
    @SerializedName("token_url")
    private String tokenUrl;
    @SerializedName("tsv_token")
    private String tsvToken;
    @SerializedName("uc_token")
    private String ucToken;

    public String getForbidCountryMessage() {
        return this.forbidCountryMessage;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getTokenUrl() {
        return this.tokenUrl;
    }

    public String getTsvToken() {
        return this.tsvToken;
    }

    public String getUcToken() {
        return this.ucToken;
    }

    public boolean isForbidCountry() {
        return this.forbidCountry;
    }
}
