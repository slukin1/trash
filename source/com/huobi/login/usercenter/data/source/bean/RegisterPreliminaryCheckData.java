package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RegisterPreliminaryCheckData implements Serializable {
    @SerializedName("email_valid")
    private int emailValid;
    @SerializedName("ip_valid")
    private int ipValid;

    public int getEmailValid() {
        return this.emailValid;
    }

    public boolean getEmailValidSuccess() {
        return this.emailValid == 1;
    }

    public int getIpValid() {
        return this.ipValid;
    }

    public boolean getIpValidSuccess() {
        return this.ipValid == 1;
    }

    public void setEmailValid(int i11) {
        this.emailValid = i11;
    }

    public void setIpValid(int i11) {
        this.ipValid = i11;
    }
}
