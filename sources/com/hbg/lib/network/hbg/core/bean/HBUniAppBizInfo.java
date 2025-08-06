package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public final class HBUniAppBizInfo implements Serializable {
    private String businessAppId = "";
    private Integer businessId = 0;
    private Integer forceUpgrade = 0;

    /* renamed from: id  reason: collision with root package name */
    private Integer f70242id = 0;
    private String md5 = "";
    private Integer report = 0;
    private String subAppVersion = "";
    private Integer subAppVersionCode = 0;
    private String updateContent = "";
    private String updateTitle = "";
    private String url = "";

    public final String getBusinessAppId() {
        return this.businessAppId;
    }

    public final Integer getBusinessId() {
        return this.businessId;
    }

    public final Integer getForceUpgrade() {
        return this.forceUpgrade;
    }

    public final Integer getId() {
        return this.f70242id;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final Integer getReport() {
        return this.report;
    }

    public final String getSubAppVersion() {
        return this.subAppVersion;
    }

    public final Integer getSubAppVersionCode() {
        return this.subAppVersionCode;
    }

    public final String getUpdateContent() {
        return this.updateContent;
    }

    public final String getUpdateTitle() {
        return this.updateTitle;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setBusinessAppId(String str) {
        this.businessAppId = str;
    }

    public final void setBusinessId(Integer num) {
        this.businessId = num;
    }

    public final void setForceUpgrade(Integer num) {
        this.forceUpgrade = num;
    }

    public final void setId(Integer num) {
        this.f70242id = num;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final void setReport(Integer num) {
        this.report = num;
    }

    public final void setSubAppVersion(String str) {
        this.subAppVersion = str;
    }

    public final void setSubAppVersionCode(Integer num) {
        this.subAppVersionCode = num;
    }

    public final void setUpdateContent(String str) {
        this.updateContent = str;
    }

    public final void setUpdateTitle(String str) {
        this.updateTitle = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "HBUniAppBizInfo(id=" + this.f70242id + ", businessId=" + this.businessId + ", businessAppId=" + this.businessAppId + ", subAppVersion=" + this.subAppVersion + ", subAppVersionCode=" + this.subAppVersionCode + ", forceUpgrade=" + this.forceUpgrade + ", updateTitle=" + this.updateTitle + ", updateContent=" + this.updateContent + ", url=" + this.url + ", md5=" + this.md5 + ", report=" + this.report + ')';
    }
}
