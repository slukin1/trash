package com.huobi.login.bean;

import java.io.Serializable;

public class CaptchaVerifyBean implements Serializable {
    private CaptchaParam captcha_param;

    public static class CaptchaParam implements Serializable {
        private Object params;
        private int type;

        public boolean canEqual(Object obj) {
            return obj instanceof CaptchaParam;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CaptchaParam)) {
                return false;
            }
            CaptchaParam captchaParam = (CaptchaParam) obj;
            if (!captchaParam.canEqual(this) || getType() != captchaParam.getType()) {
                return false;
            }
            Object params2 = getParams();
            Object params3 = captchaParam.getParams();
            return params2 != null ? params2.equals(params3) : params3 == null;
        }

        public Object getParams() {
            return this.params;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            Object params2 = getParams();
            return ((getType() + 59) * 59) + (params2 == null ? 43 : params2.hashCode());
        }

        public void setParams(Object obj) {
            this.params = obj;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public String toString() {
            return "CaptchaVerifyBean.CaptchaParam(type=" + getType() + ", params=" + getParams() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CaptchaVerifyBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptchaVerifyBean)) {
            return false;
        }
        CaptchaVerifyBean captchaVerifyBean = (CaptchaVerifyBean) obj;
        if (!captchaVerifyBean.canEqual(this)) {
            return false;
        }
        CaptchaParam captcha_param2 = getCaptcha_param();
        CaptchaParam captcha_param3 = captchaVerifyBean.getCaptcha_param();
        return captcha_param2 != null ? captcha_param2.equals(captcha_param3) : captcha_param3 == null;
    }

    public CaptchaParam getCaptcha_param() {
        return this.captcha_param;
    }

    public int hashCode() {
        CaptchaParam captcha_param2 = getCaptcha_param();
        return 59 + (captcha_param2 == null ? 43 : captcha_param2.hashCode());
    }

    public void setCaptcha_param(CaptchaParam captchaParam) {
        this.captcha_param = captchaParam;
    }

    public String toString() {
        return "CaptchaVerifyBean(captcha_param=" + getCaptcha_param() + ")";
    }
}
