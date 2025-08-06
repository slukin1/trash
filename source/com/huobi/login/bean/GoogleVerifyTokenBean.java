package com.huobi.login.bean;

import java.io.Serializable;

public class GoogleVerifyTokenBean implements Serializable {
    private String captcha_id;
    private String recaptcha;

    public boolean canEqual(Object obj) {
        return obj instanceof GoogleVerifyTokenBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleVerifyTokenBean)) {
            return false;
        }
        GoogleVerifyTokenBean googleVerifyTokenBean = (GoogleVerifyTokenBean) obj;
        if (!googleVerifyTokenBean.canEqual(this)) {
            return false;
        }
        String recaptcha2 = getRecaptcha();
        String recaptcha3 = googleVerifyTokenBean.getRecaptcha();
        if (recaptcha2 != null ? !recaptcha2.equals(recaptcha3) : recaptcha3 != null) {
            return false;
        }
        String captcha_id2 = getCaptcha_id();
        String captcha_id3 = googleVerifyTokenBean.getCaptcha_id();
        return captcha_id2 != null ? captcha_id2.equals(captcha_id3) : captcha_id3 == null;
    }

    public String getCaptcha_id() {
        return this.captcha_id;
    }

    public String getRecaptcha() {
        return this.recaptcha;
    }

    public int hashCode() {
        String recaptcha2 = getRecaptcha();
        int i11 = 43;
        int hashCode = recaptcha2 == null ? 43 : recaptcha2.hashCode();
        String captcha_id2 = getCaptcha_id();
        int i12 = (hashCode + 59) * 59;
        if (captcha_id2 != null) {
            i11 = captcha_id2.hashCode();
        }
        return i12 + i11;
    }

    public void setCaptcha_id(String str) {
        this.captcha_id = str;
    }

    public void setRecaptcha(String str) {
        this.recaptcha = str;
    }

    public String toString() {
        return "GoogleVerifyTokenBean(recaptcha=" + getRecaptcha() + ", captcha_id=" + getCaptcha_id() + ")";
    }
}
