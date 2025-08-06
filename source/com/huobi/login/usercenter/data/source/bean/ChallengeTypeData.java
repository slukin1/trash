package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ChallengeTypeData implements Serializable {
    private String challenge;
    @SerializedName("credential_ids")
    private List<String> credentialIds;
    @SerializedName("login_name")
    private String loginName;
    @SerializedName("user_verification")
    private String userVerification;
    @SerializedName("user_uuid")
    private String uuid;

    public String getChallenge() {
        return this.challenge;
    }

    public List<String> getCredentialIds() {
        return this.credentialIds;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getUserVerification() {
        return this.userVerification;
    }

    public String getUuid() {
        return this.uuid;
    }
}
