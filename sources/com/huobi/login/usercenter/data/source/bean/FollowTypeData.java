package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FollowTypeData implements Serializable {
    public static String FLOW_TYPE_LOGIN_PASS_KEY = "LOGIN_PASS_KEY";
    @SerializedName("auth_code_login_token")
    private String authCodeLoginToken;
    @SerializedName("flow_type")
    private String flowType;
    @SerializedName("login_name_type")
    private String login_name_type;

    public String getAuthCodeLoginToken() {
        return this.authCodeLoginToken;
    }

    public String getFlowType() {
        return this.flowType;
    }

    public String getLogin_name_type() {
        return this.login_name_type;
    }
}
