package com.huobi.account.helper;

import com.google.gson.Gson;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AuthData implements Serializable {
    private static final long serialVersionUID = 4369933555544462526L;
    private String email_code;
    private String ga_code;
    private String sms_code;

    public String getEmail_code() {
        return this.email_code;
    }

    public String getGa_code() {
        return this.ga_code;
    }

    public String getSms_code() {
        return this.sms_code;
    }

    public void setEmail_code(String str) {
        this.email_code = str;
    }

    public void setGa_code(String str) {
        this.ga_code = str;
    }

    public void setSms_code(String str) {
        this.sms_code = str;
    }

    public String toString() {
        try {
            return URLEncoder.encode(new Gson().toJson((Object) this), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
