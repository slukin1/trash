package com.huobi.otc.bean;

import java.io.Serializable;
import java.util.Objects;

public class OtcBannerBean implements Serializable {
    private String bannerType;
    private String imageUrl;
    private String jumpUrl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OtcBannerBean otcBannerBean = (OtcBannerBean) obj;
        if (!Objects.equals(this.imageUrl, otcBannerBean.imageUrl) || !Objects.equals(this.jumpUrl, otcBannerBean.jumpUrl) || !Objects.equals(this.bannerType, otcBannerBean.bannerType)) {
            return false;
        }
        return true;
    }

    public String getBannerType() {
        return this.bannerType;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.imageUrl, this.jumpUrl, this.bannerType});
    }

    public void setBannerType(String str) {
        this.bannerType = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public String toString() {
        return "OtcBannerBean(imageUrl=" + getImageUrl() + ", jumpUrl=" + getJumpUrl() + ", bannerType=" + getBannerType() + ")";
    }
}
