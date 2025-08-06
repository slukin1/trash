package com.huobi.finance.bean;

import com.google.gson.annotations.Expose;
import com.huobi.finance.viewhandler.VirtualAddressViewHander;
import java.io.Serializable;
import s9.a;

public class VirtualAddressInfo implements Serializable, a {
    public static final String LEVEL_DEFAULT = "default";
    public static final String LEVEL_NORMAL = "normal";
    public static final String LEVEL_PROCESSING = "processing";
    public static final String LEVEL_SECURITY = "security";
    private static final long serialVersionUID = 7029900227619676531L;
    private String address;
    private String alias;
    private String chain;
    private String currency;

    /* renamed from: id  reason: collision with root package name */
    private long f45393id;
    @Expose(serialize = false)
    private boolean isChecked;
    @Expose(serialize = false)
    private boolean isSelect;
    private String level = "default";
    @Expose(serialize = false)
    private transient VirtualAddressViewHander.a onDeleteClickListener;
    private String tag;
    private String token;

    public String getAddress() {
        return this.address;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getChain() {
        return this.chain;
    }

    public String getCurrency() {
        return this.currency;
    }

    public long getId() {
        return this.f45393id;
    }

    public boolean getIsSelect() {
        return this.isSelect;
    }

    public String getLevel() {
        return this.level;
    }

    public VirtualAddressViewHander.a getOnDeleteClickListener() {
        return this.onDeleteClickListener;
    }

    public String getTag() {
        return this.tag;
    }

    public String getToken() {
        return this.token;
    }

    public String getViewHandlerName() {
        return VirtualAddressViewHander.class.getName();
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setChain(String str) {
        this.chain = str;
    }

    public void setChecked(boolean z11) {
        this.isChecked = z11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setId(long j11) {
        this.f45393id = j11;
    }

    public void setIsSelect(boolean z11) {
        this.isSelect = z11;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setOnDeleteClickListener(VirtualAddressViewHander.a aVar) {
        this.onDeleteClickListener = aVar;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
