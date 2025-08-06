package com.huobi.login.usercenter.data.source.bean;

import java.io.Serializable;

public class KvStore implements Serializable {
    public static final String N = "N";
    public static final String QUICK_WITHDRAW = "QUICK_WITHDRAW";
    public static final String Y = "Y";
    private static final long serialVersionUID = -7271952267040945469L;
    private long gmt_created;
    private long gmt_modified;

    /* renamed from: id  reason: collision with root package name */
    private long f75650id;
    private String store_key;
    private String store_value;
    private int user_id;
    private String website;

    public long getGmt_created() {
        return this.gmt_created;
    }

    public long getGmt_modified() {
        return this.gmt_modified;
    }

    public long getId() {
        return this.f75650id;
    }

    public String getStore_key() {
        return this.store_key;
    }

    public String getStore_value() {
        return this.store_value;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setGmt_created(long j11) {
        this.gmt_created = j11;
    }

    public void setGmt_modified(long j11) {
        this.gmt_modified = j11;
    }

    public void setId(long j11) {
        this.f75650id = j11;
    }

    public void setStore_key(String str) {
        this.store_key = str;
    }

    public void setStore_value(String str) {
        this.store_value = str;
    }

    public void setUser_id(int i11) {
        this.user_id = i11;
    }

    public void setWebsite(String str) {
        this.website = str;
    }
}
