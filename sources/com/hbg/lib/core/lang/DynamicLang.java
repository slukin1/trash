package com.hbg.lib.core.lang;

import java.util.Locale;

public class DynamicLang extends BaseLang {
    private static final String TAG = "DynamicLang";
    private String flutter;
    private String locale_country;
    private String locale_lang;
    private String native_android;
    private String sensorsLanguage;
    private String strings;

    public DynamicLang() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof DynamicLang;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicLang)) {
            return false;
        }
        DynamicLang dynamicLang = (DynamicLang) obj;
        if (!dynamicLang.canEqual(this)) {
            return false;
        }
        String sensorsLanguage2 = getSensorsLanguage();
        String sensorsLanguage3 = dynamicLang.getSensorsLanguage();
        if (sensorsLanguage2 != null ? !sensorsLanguage2.equals(sensorsLanguage3) : sensorsLanguage3 != null) {
            return false;
        }
        String locale_lang2 = getLocale_lang();
        String locale_lang3 = dynamicLang.getLocale_lang();
        if (locale_lang2 != null ? !locale_lang2.equals(locale_lang3) : locale_lang3 != null) {
            return false;
        }
        String locale_country2 = getLocale_country();
        String locale_country3 = dynamicLang.getLocale_country();
        if (locale_country2 != null ? !locale_country2.equals(locale_country3) : locale_country3 != null) {
            return false;
        }
        String flutter2 = getFlutter();
        String flutter3 = dynamicLang.getFlutter();
        if (flutter2 != null ? !flutter2.equals(flutter3) : flutter3 != null) {
            return false;
        }
        String native_android2 = getNative_android();
        String native_android3 = dynamicLang.getNative_android();
        if (native_android2 != null ? !native_android2.equals(native_android3) : native_android3 != null) {
            return false;
        }
        String strings2 = getStrings();
        String strings3 = dynamicLang.getStrings();
        return strings2 != null ? strings2.equals(strings3) : strings3 == null;
    }

    public String getFlutter() {
        return this.flutter;
    }

    public String getLocale_country() {
        return this.locale_country;
    }

    public String getLocale_lang() {
        return this.locale_lang;
    }

    public String getNative_android() {
        return this.native_android;
    }

    public String getSensorsLanguage() {
        return this.sensorsLanguage;
    }

    public String getStrings() {
        return this.strings;
    }

    public int hashCode() {
        String sensorsLanguage2 = getSensorsLanguage();
        int i11 = 43;
        int hashCode = sensorsLanguage2 == null ? 43 : sensorsLanguage2.hashCode();
        String locale_lang2 = getLocale_lang();
        int hashCode2 = ((hashCode + 59) * 59) + (locale_lang2 == null ? 43 : locale_lang2.hashCode());
        String locale_country2 = getLocale_country();
        int hashCode3 = (hashCode2 * 59) + (locale_country2 == null ? 43 : locale_country2.hashCode());
        String flutter2 = getFlutter();
        int hashCode4 = (hashCode3 * 59) + (flutter2 == null ? 43 : flutter2.hashCode());
        String native_android2 = getNative_android();
        int hashCode5 = (hashCode4 * 59) + (native_android2 == null ? 43 : native_android2.hashCode());
        String strings2 = getStrings();
        int i12 = hashCode5 * 59;
        if (strings2 != null) {
            i11 = strings2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isDynamicLang() {
        return true;
    }

    public void setFlutter(String str) {
        this.flutter = str;
    }

    public void setLocale_country(String str) {
        this.locale_country = str;
    }

    public void setLocale_lang(String str) {
        this.locale_lang = str;
    }

    public void setNative_android(String str) {
        this.native_android = str;
    }

    public void setSensorsLanguage(String str) {
        this.sensorsLanguage = str;
    }

    public void setStrings(String str) {
        this.strings = str;
    }

    public void setUrls(String str, String str2, String str3) {
        this.flutter = str;
        this.native_android = str2;
        this.strings = str3;
    }

    public String toString() {
        return "DynamicLang(sensorsLanguage=" + getSensorsLanguage() + ", locale_lang=" + getLocale_lang() + ", locale_country=" + getLocale_country() + ", flutter=" + getFlutter() + ", native_android=" + getNative_android() + ", strings=" + getStrings() + ")";
    }

    public DynamicLang(String str, String str2, String str3, String str4, String str5, String str6) {
        this.locale_lang = str;
        this.locale_country = str2;
        this.locale = new Locale(str, str2);
        this.str = str3;
        this.header = str4;
        this.url = str5;
        this.zendeskLocaleStr = str6;
    }
}
