package com.huobi.contract.entity;

import java.io.Serializable;

public class WebSessionData implements Serializable {
    private static final long serialVersionUID = -676069497261640983L;
    private String session;

    public WebSessionData(String str) {
        setSession(str);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof WebSessionData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebSessionData)) {
            return false;
        }
        WebSessionData webSessionData = (WebSessionData) obj;
        if (!webSessionData.canEqual(this)) {
            return false;
        }
        String session2 = getSession();
        String session3 = webSessionData.getSession();
        return session2 != null ? session2.equals(session3) : session3 == null;
    }

    public String getSession() {
        return this.session;
    }

    public int hashCode() {
        String session2 = getSession();
        return 59 + (session2 == null ? 43 : session2.hashCode());
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        return "WebSessionData(session=" + getSession() + ")";
    }
}
