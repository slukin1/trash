package com.hbg.lib.core.lang;

public class LocalLang extends BaseLang {
    private static final long serialVersionUID = 8071874670225438409L;
    private boolean defaultLanguage;
    private String direction;
    private String localCountry;
    private String localLang;
    private String sensorsLanguage;

    public boolean canEqual(Object obj) {
        return obj instanceof LocalLang;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalLang)) {
            return false;
        }
        LocalLang localLang2 = (LocalLang) obj;
        if (!localLang2.canEqual(this)) {
            return false;
        }
        String localLang3 = getLocalLang();
        String localLang4 = localLang2.getLocalLang();
        if (localLang3 != null ? !localLang3.equals(localLang4) : localLang4 != null) {
            return false;
        }
        String localCountry2 = getLocalCountry();
        String localCountry3 = localLang2.getLocalCountry();
        if (localCountry2 != null ? !localCountry2.equals(localCountry3) : localCountry3 != null) {
            return false;
        }
        String sensorsLanguage2 = getSensorsLanguage();
        String sensorsLanguage3 = localLang2.getSensorsLanguage();
        if (sensorsLanguage2 != null ? !sensorsLanguage2.equals(sensorsLanguage3) : sensorsLanguage3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = localLang2.getDirection();
        if (direction2 != null ? direction2.equals(direction3) : direction3 == null) {
            return isDefaultLanguage() == localLang2.isDefaultLanguage();
        }
        return false;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getLocalCountry() {
        return this.localCountry;
    }

    public String getLocalLang() {
        return this.localLang;
    }

    public String getSensorsLanguage() {
        return this.sensorsLanguage;
    }

    public int hashCode() {
        String localLang2 = getLocalLang();
        int i11 = 43;
        int hashCode = localLang2 == null ? 43 : localLang2.hashCode();
        String localCountry2 = getLocalCountry();
        int hashCode2 = ((hashCode + 59) * 59) + (localCountry2 == null ? 43 : localCountry2.hashCode());
        String sensorsLanguage2 = getSensorsLanguage();
        int hashCode3 = (hashCode2 * 59) + (sensorsLanguage2 == null ? 43 : sensorsLanguage2.hashCode());
        String direction2 = getDirection();
        int i12 = hashCode3 * 59;
        if (direction2 != null) {
            i11 = direction2.hashCode();
        }
        return ((i12 + i11) * 59) + (isDefaultLanguage() ? 79 : 97);
    }

    public boolean isDefaultLanguage() {
        return this.defaultLanguage;
    }

    public void setDefaultLanguage(boolean z11) {
        this.defaultLanguage = z11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setLocalCountry(String str) {
        this.localCountry = str;
    }

    public void setLocalLang(String str) {
        this.localLang = str;
    }

    public void setSensorsLanguage(String str) {
        this.sensorsLanguage = str;
    }

    public String toString() {
        return "LocalLang(localLang=" + getLocalLang() + ", localCountry=" + getLocalCountry() + ", sensorsLanguage=" + getSensorsLanguage() + ", direction=" + getDirection() + ", defaultLanguage=" + isDefaultLanguage() + ")";
    }
}
