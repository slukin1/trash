package com.hbg.lib.network.uc.retrofit.bean;

import java.io.Serializable;

public class DynamicLangData implements Serializable {
    public static int STATUS_ENABLE = 1;
    private String crowdin_lang;
    private String flutter;
    private String header;
    private int index;
    private String locale_country;
    private String locale_lang;
    private String native_android;
    private String sensors_language;
    private int status;
    private String str;
    private String strings;
    private String url;
    private String zendesk_url;

    public boolean canEqual(Object obj) {
        return obj instanceof DynamicLangData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicLangData)) {
            return false;
        }
        DynamicLangData dynamicLangData = (DynamicLangData) obj;
        if (!dynamicLangData.canEqual(this)) {
            return false;
        }
        String str2 = getStr();
        String str3 = dynamicLangData.getStr();
        if (str2 != null ? !str2.equals(str3) : str3 != null) {
            return false;
        }
        String crowdin_lang2 = getCrowdin_lang();
        String crowdin_lang3 = dynamicLangData.getCrowdin_lang();
        if (crowdin_lang2 != null ? !crowdin_lang2.equals(crowdin_lang3) : crowdin_lang3 != null) {
            return false;
        }
        String locale_lang2 = getLocale_lang();
        String locale_lang3 = dynamicLangData.getLocale_lang();
        if (locale_lang2 != null ? !locale_lang2.equals(locale_lang3) : locale_lang3 != null) {
            return false;
        }
        String header2 = getHeader();
        String header3 = dynamicLangData.getHeader();
        if (header2 != null ? !header2.equals(header3) : header3 != null) {
            return false;
        }
        if (getIndex() != dynamicLangData.getIndex()) {
            return false;
        }
        String sensors_language2 = getSensors_language();
        String sensors_language3 = dynamicLangData.getSensors_language();
        if (sensors_language2 != null ? !sensors_language2.equals(sensors_language3) : sensors_language3 != null) {
            return false;
        }
        String zendesk_url2 = getZendesk_url();
        String zendesk_url3 = dynamicLangData.getZendesk_url();
        if (zendesk_url2 != null ? !zendesk_url2.equals(zendesk_url3) : zendesk_url3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = dynamicLangData.getUrl();
        if (url2 != null ? !url2.equals(url3) : url3 != null) {
            return false;
        }
        String locale_country2 = getLocale_country();
        String locale_country3 = dynamicLangData.getLocale_country();
        if (locale_country2 != null ? !locale_country2.equals(locale_country3) : locale_country3 != null) {
            return false;
        }
        if (getStatus() != dynamicLangData.getStatus()) {
            return false;
        }
        String flutter2 = getFlutter();
        String flutter3 = dynamicLangData.getFlutter();
        if (flutter2 != null ? !flutter2.equals(flutter3) : flutter3 != null) {
            return false;
        }
        String native_android2 = getNative_android();
        String native_android3 = dynamicLangData.getNative_android();
        if (native_android2 != null ? !native_android2.equals(native_android3) : native_android3 != null) {
            return false;
        }
        String strings2 = getStrings();
        String strings3 = dynamicLangData.getStrings();
        return strings2 != null ? strings2.equals(strings3) : strings3 == null;
    }

    public String getCrowdin_lang() {
        return this.crowdin_lang;
    }

    public String getFlutter() {
        return this.flutter;
    }

    public String getHeader() {
        return this.header;
    }

    public int getIndex() {
        return this.index;
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

    public String getSensors_language() {
        return this.sensors_language;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStr() {
        return this.str;
    }

    public String getStrings() {
        return this.strings;
    }

    public String getUrl() {
        return this.url;
    }

    public String getZendesk_url() {
        return this.zendesk_url;
    }

    public int hashCode() {
        String str2 = getStr();
        int i11 = 43;
        int hashCode = str2 == null ? 43 : str2.hashCode();
        String crowdin_lang2 = getCrowdin_lang();
        int hashCode2 = ((hashCode + 59) * 59) + (crowdin_lang2 == null ? 43 : crowdin_lang2.hashCode());
        String locale_lang2 = getLocale_lang();
        int hashCode3 = (hashCode2 * 59) + (locale_lang2 == null ? 43 : locale_lang2.hashCode());
        String header2 = getHeader();
        int hashCode4 = (((hashCode3 * 59) + (header2 == null ? 43 : header2.hashCode())) * 59) + getIndex();
        String sensors_language2 = getSensors_language();
        int hashCode5 = (hashCode4 * 59) + (sensors_language2 == null ? 43 : sensors_language2.hashCode());
        String zendesk_url2 = getZendesk_url();
        int hashCode6 = (hashCode5 * 59) + (zendesk_url2 == null ? 43 : zendesk_url2.hashCode());
        String url2 = getUrl();
        int hashCode7 = (hashCode6 * 59) + (url2 == null ? 43 : url2.hashCode());
        String locale_country2 = getLocale_country();
        int hashCode8 = (((hashCode7 * 59) + (locale_country2 == null ? 43 : locale_country2.hashCode())) * 59) + getStatus();
        String flutter2 = getFlutter();
        int hashCode9 = (hashCode8 * 59) + (flutter2 == null ? 43 : flutter2.hashCode());
        String native_android2 = getNative_android();
        int hashCode10 = (hashCode9 * 59) + (native_android2 == null ? 43 : native_android2.hashCode());
        String strings2 = getStrings();
        int i12 = hashCode10 * 59;
        if (strings2 != null) {
            i11 = strings2.hashCode();
        }
        return i12 + i11;
    }

    public void setCrowdin_lang(String str2) {
        this.crowdin_lang = str2;
    }

    public void setFlutter(String str2) {
        this.flutter = str2;
    }

    public void setHeader(String str2) {
        this.header = str2;
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setLocale_country(String str2) {
        this.locale_country = str2;
    }

    public void setLocale_lang(String str2) {
        this.locale_lang = str2;
    }

    public void setNative_android(String str2) {
        this.native_android = str2;
    }

    public void setSensors_language(String str2) {
        this.sensors_language = str2;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setStr(String str2) {
        this.str = str2;
    }

    public void setStrings(String str2) {
        this.strings = str2;
    }

    public void setUrl(String str2) {
        this.url = str2;
    }

    public void setZendesk_url(String str2) {
        this.zendesk_url = str2;
    }

    public String toString() {
        return "DynamicLangData(str=" + getStr() + ", crowdin_lang=" + getCrowdin_lang() + ", locale_lang=" + getLocale_lang() + ", header=" + getHeader() + ", index=" + getIndex() + ", sensors_language=" + getSensors_language() + ", zendesk_url=" + getZendesk_url() + ", url=" + getUrl() + ", locale_country=" + getLocale_country() + ", status=" + getStatus() + ", flutter=" + getFlutter() + ", native_android=" + getNative_android() + ", strings=" + getStrings() + ")";
    }
}
