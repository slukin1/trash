package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class SmartDomainUrl implements Serializable {
    private static final long serialVersionUID = 7505022181785848275L;
    public String url;

    public boolean canEqual(Object obj) {
        return obj instanceof SmartDomainUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmartDomainUrl)) {
            return false;
        }
        SmartDomainUrl smartDomainUrl = (SmartDomainUrl) obj;
        if (!smartDomainUrl.canEqual(this)) {
            return false;
        }
        String url2 = getUrl();
        String url3 = smartDomainUrl.getUrl();
        return url2 != null ? url2.equals(url3) : url3 == null;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String url2 = getUrl();
        return 59 + (url2 == null ? 43 : url2.hashCode());
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "SmartDomainUrl(url=" + getUrl() + ")";
    }
}
