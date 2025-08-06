package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class MaxRateMiningProject implements Serializable {
    private String currency;
    private String maxViewYearRate;
    private String projectId;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof MaxRateMiningProject;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MaxRateMiningProject)) {
            return false;
        }
        MaxRateMiningProject maxRateMiningProject = (MaxRateMiningProject) obj;
        if (!maxRateMiningProject.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = maxRateMiningProject.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String projectId2 = getProjectId();
        String projectId3 = maxRateMiningProject.getProjectId();
        if (projectId2 != null ? !projectId2.equals(projectId3) : projectId3 != null) {
            return false;
        }
        String maxViewYearRate2 = getMaxViewYearRate();
        String maxViewYearRate3 = maxRateMiningProject.getMaxViewYearRate();
        if (maxViewYearRate2 != null ? !maxViewYearRate2.equals(maxViewYearRate3) : maxViewYearRate3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = maxRateMiningProject.getUrl();
        return url2 != null ? url2.equals(url3) : url3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getMaxViewYearRate() {
        return this.maxViewYearRate;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String projectId2 = getProjectId();
        int hashCode2 = ((hashCode + 59) * 59) + (projectId2 == null ? 43 : projectId2.hashCode());
        String maxViewYearRate2 = getMaxViewYearRate();
        int hashCode3 = (hashCode2 * 59) + (maxViewYearRate2 == null ? 43 : maxViewYearRate2.hashCode());
        String url2 = getUrl();
        int i12 = hashCode3 * 59;
        if (url2 != null) {
            i11 = url2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setMaxViewYearRate(String str) {
        this.maxViewYearRate = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "MaxRateMiningProject(currency=" + getCurrency() + ", projectId=" + getProjectId() + ", maxViewYearRate=" + getMaxViewYearRate() + ", url=" + getUrl() + ")";
    }
}
