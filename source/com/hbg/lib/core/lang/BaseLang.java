package com.hbg.lib.core.lang;

import java.io.Serializable;
import java.util.Locale;

public abstract class BaseLang implements Serializable {
    public String header;
    public Locale locale;
    public String str;
    public String url;
    public String zendeskLocaleStr;

    public String getCurAppLocaleName() {
        return this.str;
    }

    public String getLanguageHeader() {
        return this.header;
    }

    public String getLanguageUrlPath() {
        return this.url;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public abstract String getSensorsLanguage();

    public String getZendeskLocaleStr() {
        return this.zendeskLocaleStr;
    }

    public boolean isDynamicLang() {
        return false;
    }

    public void setLocale(String str2, String str3) {
        this.locale = new Locale(str2, str3);
    }
}
