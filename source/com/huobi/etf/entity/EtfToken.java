package com.huobi.etf.entity;

import java.io.Serializable;

public class EtfToken implements Serializable {
    private static final long serialVersionUID = 348586453157941959L;
    private String token;

    public boolean canEqual(Object obj) {
        return obj instanceof EtfToken;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtfToken)) {
            return false;
        }
        EtfToken etfToken = (EtfToken) obj;
        if (!etfToken.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = etfToken.getToken();
        return token2 != null ? token2.equals(token3) : token3 == null;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        String token2 = getToken();
        return 59 + (token2 == null ? 43 : token2.hashCode());
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "EtfToken(token=" + getToken() + ")";
    }
}
