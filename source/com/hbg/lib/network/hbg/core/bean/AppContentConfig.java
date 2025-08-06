package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AppContentConfig implements Serializable {
    private String shareCn;
    private String shareEn;
    private String shareOverseaCn;
    private String shareOverseaEn;

    public boolean canEqual(Object obj) {
        return obj instanceof AppContentConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppContentConfig)) {
            return false;
        }
        AppContentConfig appContentConfig = (AppContentConfig) obj;
        if (!appContentConfig.canEqual(this)) {
            return false;
        }
        String shareOverseaCn2 = getShareOverseaCn();
        String shareOverseaCn3 = appContentConfig.getShareOverseaCn();
        if (shareOverseaCn2 != null ? !shareOverseaCn2.equals(shareOverseaCn3) : shareOverseaCn3 != null) {
            return false;
        }
        String shareOverseaEn2 = getShareOverseaEn();
        String shareOverseaEn3 = appContentConfig.getShareOverseaEn();
        if (shareOverseaEn2 != null ? !shareOverseaEn2.equals(shareOverseaEn3) : shareOverseaEn3 != null) {
            return false;
        }
        String shareCn2 = getShareCn();
        String shareCn3 = appContentConfig.getShareCn();
        if (shareCn2 != null ? !shareCn2.equals(shareCn3) : shareCn3 != null) {
            return false;
        }
        String shareEn2 = getShareEn();
        String shareEn3 = appContentConfig.getShareEn();
        return shareEn2 != null ? shareEn2.equals(shareEn3) : shareEn3 == null;
    }

    public String getShareCn() {
        return this.shareCn;
    }

    public String getShareEn() {
        return this.shareEn;
    }

    public String getShareOverseaCn() {
        return this.shareOverseaCn;
    }

    public String getShareOverseaEn() {
        return this.shareOverseaEn;
    }

    public int hashCode() {
        String shareOverseaCn2 = getShareOverseaCn();
        int i11 = 43;
        int hashCode = shareOverseaCn2 == null ? 43 : shareOverseaCn2.hashCode();
        String shareOverseaEn2 = getShareOverseaEn();
        int hashCode2 = ((hashCode + 59) * 59) + (shareOverseaEn2 == null ? 43 : shareOverseaEn2.hashCode());
        String shareCn2 = getShareCn();
        int hashCode3 = (hashCode2 * 59) + (shareCn2 == null ? 43 : shareCn2.hashCode());
        String shareEn2 = getShareEn();
        int i12 = hashCode3 * 59;
        if (shareEn2 != null) {
            i11 = shareEn2.hashCode();
        }
        return i12 + i11;
    }

    public void setShareCn(String str) {
        this.shareCn = str;
    }

    public void setShareEn(String str) {
        this.shareEn = str;
    }

    public void setShareOverseaCn(String str) {
        this.shareOverseaCn = str;
    }

    public void setShareOverseaEn(String str) {
        this.shareOverseaEn = str;
    }

    public String toString() {
        return "AppContentConfig(shareOverseaCn=" + getShareOverseaCn() + ", shareOverseaEn=" + getShareOverseaEn() + ", shareCn=" + getShareCn() + ", shareEn=" + getShareEn() + ")";
    }
}
