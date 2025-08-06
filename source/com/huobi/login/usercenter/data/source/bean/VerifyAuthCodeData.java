package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import java.io.Serializable;
import java.util.List;

public class VerifyAuthCodeData implements Serializable {
    public static String FLOW_TYPE_LOGIN = "LOGIN_DIRECT";
    public static String FLOW_TYPE_LOGIN_2FA = "LOGIN_2FA";
    public static String FLOW_TYPE_REGISTER = "REGISTER";
    @SerializedName("auth_token")
    private String authToken;
    @SerializedName("flow_type")
    private String flowType;
    @SerializedName("know_device")
    private boolean knowDevice;
    @SerializedName("require_types")
    private List<LoginInfoData.Login2FAOption> requireTypes;
    @SerializedName("switch_types")
    private List<LoginInfoData.Login2FAOption> switchTypes;
    @SerializedName("ticket")
    private String ticket;
    @SerializedName("token")
    private String token;
    @SerializedName("uc_token")
    private String ucToken;

    public String getAuthToken() {
        return this.authToken;
    }

    public String getFlowType() {
        return this.flowType;
    }

    public List<LoginInfoData.Login2FAOption> getRequireTypes() {
        return this.requireTypes;
    }

    public List<LoginInfoData.Login2FAOption> getSwitchTypes() {
        return this.switchTypes;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getToken() {
        return this.token;
    }

    public String getUcToken() {
        return this.ucToken;
    }

    public boolean isKnowDevice() {
        return this.knowDevice;
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public void setFlowType(String str) {
        this.flowType = str;
    }

    public void setKnowDevice(boolean z11) {
        this.knowDevice = z11;
    }

    public void setRequireTypes(List<LoginInfoData.Login2FAOption> list) {
        this.requireTypes = list;
    }

    public void setSwitchTypes(List<LoginInfoData.Login2FAOption> list) {
        this.switchTypes = list;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUcToken(String str) {
        this.ucToken = str;
    }
}
