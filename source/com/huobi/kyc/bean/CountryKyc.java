package com.huobi.kyc.bean;

import java.io.Serializable;

public class CountryKyc implements Serializable {
    private String code;
    private String countries_e;
    private String countries_z;

    /* renamed from: id  reason: collision with root package name */
    private int f74777id;
    private String keywords;

    public String getCode() {
        return this.code;
    }

    public String getCountries_e() {
        return this.countries_e;
    }

    public String getCountries_z() {
        return this.countries_z;
    }

    public int getId() {
        return this.f74777id;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCountries_e(String str) {
        this.countries_e = str;
    }

    public void setCountries_z(String str) {
        this.countries_z = str;
    }

    public void setId(int i11) {
        this.f74777id = i11;
    }

    public void setKeywords(String str) {
        this.keywords = str;
    }
}
