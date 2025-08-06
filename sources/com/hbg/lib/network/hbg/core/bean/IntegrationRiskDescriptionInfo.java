package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class IntegrationRiskDescriptionInfo implements Serializable {
    private String bannerUrl;
    private String content;

    /* renamed from: id  reason: collision with root package name */
    private long f70246id;
    private String path;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof IntegrationRiskDescriptionInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegrationRiskDescriptionInfo)) {
            return false;
        }
        IntegrationRiskDescriptionInfo integrationRiskDescriptionInfo = (IntegrationRiskDescriptionInfo) obj;
        if (!integrationRiskDescriptionInfo.canEqual(this) || getId() != integrationRiskDescriptionInfo.getId()) {
            return false;
        }
        String content2 = getContent();
        String content3 = integrationRiskDescriptionInfo.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        String path2 = getPath();
        String path3 = integrationRiskDescriptionInfo.getPath();
        if (path2 != null ? !path2.equals(path3) : path3 != null) {
            return false;
        }
        if (getType() != integrationRiskDescriptionInfo.getType()) {
            return false;
        }
        String bannerUrl2 = getBannerUrl();
        String bannerUrl3 = integrationRiskDescriptionInfo.getBannerUrl();
        return bannerUrl2 != null ? bannerUrl2.equals(bannerUrl3) : bannerUrl3 == null;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public String getContent() {
        return this.content;
    }

    public long getId() {
        return this.f70246id;
    }

    public String getPath() {
        return this.path;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        long id2 = getId();
        String content2 = getContent();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
        String path2 = getPath();
        int hashCode2 = (((hashCode * 59) + (path2 == null ? 43 : path2.hashCode())) * 59) + getType();
        String bannerUrl2 = getBannerUrl();
        int i12 = hashCode2 * 59;
        if (bannerUrl2 != null) {
            i11 = bannerUrl2.hashCode();
        }
        return i12 + i11;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(long j11) {
        this.f70246id = j11;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "IntegrationRiskDescriptionInfo(id=" + getId() + ", content=" + getContent() + ", path=" + getPath() + ", type=" + getType() + ", bannerUrl=" + getBannerUrl() + ")";
    }
}
