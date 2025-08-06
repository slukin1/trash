package com.hbg.lib.network.newkyc.bean;

import java.io.Serializable;

public class KycCountryInfo implements Serializable {
    private static final long serialVersionUID = -3146030084598284965L;
    private int countryId;
    private String countryName;
    private String flagUrl;
    private String nameCn;
    private String nameEn;
    private int type;

    public int getCountryId() {
        return this.countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getFlagUrl() {
        return this.flagUrl;
    }

    public String getNameCn() {
        return this.nameCn;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public int getType() {
        return this.type;
    }

    public void setCountryId(int i11) {
        this.countryId = i11;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setFlagUrl(String str) {
        this.flagUrl = str;
    }

    public void setNameCn(String str) {
        this.nameCn = str;
    }

    public void setNameEn(String str) {
        this.nameEn = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }
}
