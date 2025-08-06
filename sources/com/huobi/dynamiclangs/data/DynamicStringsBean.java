package com.huobi.dynamiclangs.data;

import com.hbg.lib.core.lang.DynamicLang;
import java.io.Serializable;

public class DynamicStringsBean implements Serializable {
    public static final int SOURCE_FLUTTER = 1;
    public static final int SOURCE_NATIVE = 0;
    private static final long serialVersionUID = -4020328899478358979L;

    /* renamed from: id  reason: collision with root package name */
    private Long f43858id;
    private String key;
    private String lang;
    private int source;
    private String value;

    public DynamicStringsBean(Long l11, String str, String str2, String str3, int i11) {
        this.f43858id = l11;
        this.lang = str;
        this.key = str2;
        this.value = str3;
        this.source = i11;
    }

    public static String createLang(DynamicLang dynamicLang) {
        return dynamicLang.getLocale_lang() + "_" + dynamicLang.getLocale_country();
    }

    public boolean canEqual(Object obj) {
        return obj instanceof DynamicStringsBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DynamicStringsBean)) {
            return false;
        }
        DynamicStringsBean dynamicStringsBean = (DynamicStringsBean) obj;
        if (!dynamicStringsBean.canEqual(this)) {
            return false;
        }
        Long id2 = getId();
        Long id3 = dynamicStringsBean.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String lang2 = getLang();
        String lang3 = dynamicStringsBean.getLang();
        if (lang2 != null ? !lang2.equals(lang3) : lang3 != null) {
            return false;
        }
        String key2 = getKey();
        String key3 = dynamicStringsBean.getKey();
        if (key2 != null ? !key2.equals(key3) : key3 != null) {
            return false;
        }
        String value2 = getValue();
        String value3 = dynamicStringsBean.getValue();
        if (value2 != null ? value2.equals(value3) : value3 == null) {
            return getSource() == dynamicStringsBean.getSource();
        }
        return false;
    }

    public Long getId() {
        return this.f43858id;
    }

    public String getKey() {
        return this.key;
    }

    public String getLang() {
        return this.lang;
    }

    public int getSource() {
        return this.source;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        Long id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String lang2 = getLang();
        int hashCode2 = ((hashCode + 59) * 59) + (lang2 == null ? 43 : lang2.hashCode());
        String key2 = getKey();
        int hashCode3 = (hashCode2 * 59) + (key2 == null ? 43 : key2.hashCode());
        String value2 = getValue();
        int i12 = hashCode3 * 59;
        if (value2 != null) {
            i11 = value2.hashCode();
        }
        return ((i12 + i11) * 59) + getSource();
    }

    public void setId(Long l11) {
        this.f43858id = l11;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setSource(int i11) {
        this.source = i11;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "DynamicStringsBean(id=" + getId() + ", lang=" + getLang() + ", key=" + getKey() + ", value=" + getValue() + ", source=" + getSource() + ")";
    }

    public DynamicStringsBean() {
    }
}
