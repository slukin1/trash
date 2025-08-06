package com.huobi.contract.entity;

import java.io.Serializable;

public class WebLanguageData implements Serializable {
    private static final long serialVersionUID = -676069497261640983L;
    private String language;

    public WebLanguageData(String str) {
        setLanguage(str);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof WebLanguageData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebLanguageData)) {
            return false;
        }
        WebLanguageData webLanguageData = (WebLanguageData) obj;
        if (!webLanguageData.canEqual(this)) {
            return false;
        }
        String language2 = getLanguage();
        String language3 = webLanguageData.getLanguage();
        return language2 != null ? language2.equals(language3) : language3 == null;
    }

    public String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        String language2 = getLanguage();
        return 59 + (language2 == null ? 43 : language2.hashCode());
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String toString() {
        return "WebLanguageData(language=" + getLanguage() + ")";
    }
}
