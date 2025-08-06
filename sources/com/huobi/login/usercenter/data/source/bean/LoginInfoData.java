package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LoginInfoData implements Serializable {
    @SerializedName("auth_token")
    private String authToken;
    @SerializedName("bind_pass_key")
    private int bindPassKey;
    @SerializedName("email")
    private String email;
    @SerializedName("forbid_country")
    private boolean forbidCountry;
    @SerializedName("forbid_country_message")
    private String forbidCountryMessage;
    @SerializedName("know_device")
    private boolean knowDevice;
    @SerializedName("phone")
    private String phone;
    @SerializedName("require_types")
    private List<Login2FAOption> requireTypes;
    @SerializedName("switch_types")
    private List<Login2FAOption> switchTypes;
    @SerializedName("ticket")
    private String ticket;
    @SerializedName("token")
    private String token;
    @SerializedName("token_url")
    private String tokenUrl;
    @SerializedName("tsv_token")
    private String tsvToken;
    @SerializedName("type")
    private int type;
    @SerializedName("uc_token")
    private String ucToken;

    public static class Login2FAOption implements Serializable {
        private Integer priority;
        private String tag;
        private int type;

        public boolean canEqual(Object obj) {
            return obj instanceof Login2FAOption;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Login2FAOption)) {
                return false;
            }
            Login2FAOption login2FAOption = (Login2FAOption) obj;
            if (!login2FAOption.canEqual(this) || getType() != login2FAOption.getType()) {
                return false;
            }
            String tag2 = getTag();
            String tag3 = login2FAOption.getTag();
            if (tag2 != null ? !tag2.equals(tag3) : tag3 != null) {
                return false;
            }
            Integer priority2 = getPriority();
            Integer priority3 = login2FAOption.getPriority();
            return priority2 != null ? priority2.equals(priority3) : priority3 == null;
        }

        public Integer getPriority() {
            this.priority = 1;
            int i11 = this.type;
            if (i11 == 1) {
                this.priority = 2;
            } else if (i11 == 2) {
                this.priority = 3;
            } else if (i11 == 3) {
                this.priority = 1;
            }
            return this.priority;
        }

        public String getTag() {
            return this.tag;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            String tag2 = getTag();
            int i11 = 43;
            int type2 = ((getType() + 59) * 59) + (tag2 == null ? 43 : tag2.hashCode());
            Integer priority2 = getPriority();
            int i12 = type2 * 59;
            if (priority2 != null) {
                i11 = priority2.hashCode();
            }
            return i12 + i11;
        }

        public void setPriority(Integer num) {
            this.priority = num;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public String toString() {
            return "LoginInfoData.Login2FAOption(type=" + getType() + ", tag=" + getTag() + ", priority=" + getPriority() + ")";
        }
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public String getEmail() {
        return this.email;
    }

    public String getForbidCountryMessage() {
        return this.forbidCountryMessage;
    }

    public String getPhone() {
        return this.phone;
    }

    public List<Login2FAOption> getRequireTypes() {
        return this.requireTypes;
    }

    public List<Login2FAOption> getSwitchTypes() {
        return this.switchTypes;
    }

    public String getTicket() {
        return this.ticket;
    }

    public String getToken() {
        return this.token;
    }

    public String getTokenUrl() {
        return this.tokenUrl;
    }

    public String getTsvToken() {
        return this.tsvToken;
    }

    public int getType() {
        return this.type;
    }

    public String getUcToken() {
        return this.ucToken;
    }

    public boolean isBindPassKey() {
        return this.bindPassKey == 1;
    }

    public boolean isForbidCountry() {
        return this.forbidCountry;
    }

    public boolean isKnowDevice() {
        return this.knowDevice;
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setForbidCountry(boolean z11) {
        this.forbidCountry = z11;
    }

    public void setForbidCountryMessage(String str) {
        this.forbidCountryMessage = str;
    }

    public void setKnowDevice(boolean z11) {
        this.knowDevice = z11;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRequireTypes(List<Login2FAOption> list) {
        this.requireTypes = list;
    }

    public void setSwitchTypes(List<Login2FAOption> list) {
        this.switchTypes = list;
    }

    public void setTicket(String str) {
        this.ticket = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTokenUrl(String str) {
        this.tokenUrl = str;
    }

    public void setTsvToken(String str) {
        this.tsvToken = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUcToken(String str) {
        this.ucToken = str;
    }
}
