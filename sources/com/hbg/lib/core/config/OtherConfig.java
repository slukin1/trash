package com.hbg.lib.core.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OtherConfig implements Serializable {
    private static final long serialVersionUID = -5174887194403829375L;
    @SerializedName("app_download_host")
    private String appDownloadHost;
    private int backstageTimeMin;
    @SerializedName("google_play_package")
    private String googlePlayPackage;
    @SerializedName("google_play_url")
    private String googlePlayUrl;
    @SerializedName("kline_deep_num")
    private int klineDeepNum;
    @SerializedName("kline_num")
    private int klineNum;
    private int showIndexBubbleHint;
    @SerializedName("web_host_zh")
    private String webHostCn;
    @SerializedName("web_host_en")
    private String webHostEn;
    @SerializedName("web_host_ko")
    private String webHostKr;
    @SerializedName("web_host_ru")
    private String webHostRu;
    @SerializedName("web_host_tr")
    private String webHostTr;
    @SerializedName("web_host_vi")
    private String webHostVi;

    public boolean canEqual(Object obj) {
        return obj instanceof OtherConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtherConfig)) {
            return false;
        }
        OtherConfig otherConfig = (OtherConfig) obj;
        if (!otherConfig.canEqual(this) || getBackstageTimeMin() != otherConfig.getBackstageTimeMin() || getShowIndexBubbleHint() != otherConfig.getShowIndexBubbleHint() || getKlineNum() != otherConfig.getKlineNum() || getKlineDeepNum() != otherConfig.getKlineDeepNum()) {
            return false;
        }
        String webHostCn2 = getWebHostCn();
        String webHostCn3 = otherConfig.getWebHostCn();
        if (webHostCn2 != null ? !webHostCn2.equals(webHostCn3) : webHostCn3 != null) {
            return false;
        }
        String webHostEn2 = getWebHostEn();
        String webHostEn3 = otherConfig.getWebHostEn();
        if (webHostEn2 != null ? !webHostEn2.equals(webHostEn3) : webHostEn3 != null) {
            return false;
        }
        String webHostKr2 = getWebHostKr();
        String webHostKr3 = otherConfig.getWebHostKr();
        if (webHostKr2 != null ? !webHostKr2.equals(webHostKr3) : webHostKr3 != null) {
            return false;
        }
        String webHostTr2 = getWebHostTr();
        String webHostTr3 = otherConfig.getWebHostTr();
        if (webHostTr2 != null ? !webHostTr2.equals(webHostTr3) : webHostTr3 != null) {
            return false;
        }
        String webHostVi2 = getWebHostVi();
        String webHostVi3 = otherConfig.getWebHostVi();
        if (webHostVi2 != null ? !webHostVi2.equals(webHostVi3) : webHostVi3 != null) {
            return false;
        }
        String googlePlayUrl2 = getGooglePlayUrl();
        String googlePlayUrl3 = otherConfig.getGooglePlayUrl();
        if (googlePlayUrl2 != null ? !googlePlayUrl2.equals(googlePlayUrl3) : googlePlayUrl3 != null) {
            return false;
        }
        String googlePlayPackage2 = getGooglePlayPackage();
        String googlePlayPackage3 = otherConfig.getGooglePlayPackage();
        if (googlePlayPackage2 != null ? !googlePlayPackage2.equals(googlePlayPackage3) : googlePlayPackage3 != null) {
            return false;
        }
        String appDownloadHost2 = getAppDownloadHost();
        String appDownloadHost3 = otherConfig.getAppDownloadHost();
        if (appDownloadHost2 != null ? !appDownloadHost2.equals(appDownloadHost3) : appDownloadHost3 != null) {
            return false;
        }
        String webHostRu2 = getWebHostRu();
        String webHostRu3 = otherConfig.getWebHostRu();
        return webHostRu2 != null ? webHostRu2.equals(webHostRu3) : webHostRu3 == null;
    }

    public String getAppDownloadHost() {
        return this.appDownloadHost;
    }

    public int getBackstageTimeMin() {
        return this.backstageTimeMin;
    }

    public String getGooglePlayPackage() {
        return this.googlePlayPackage;
    }

    public String getGooglePlayUrl() {
        return this.googlePlayUrl;
    }

    public int getKlineDeepNum() {
        return this.klineDeepNum;
    }

    public int getKlineNum() {
        return this.klineNum;
    }

    public int getShowIndexBubbleHint() {
        return this.showIndexBubbleHint;
    }

    public String getWebHostCn() {
        return this.webHostCn;
    }

    public String getWebHostEn() {
        return this.webHostEn;
    }

    public String getWebHostKr() {
        return this.webHostKr;
    }

    public String getWebHostRu() {
        return this.webHostRu;
    }

    public String getWebHostTr() {
        return this.webHostTr;
    }

    public String getWebHostVi() {
        return this.webHostVi;
    }

    public int hashCode() {
        int backstageTimeMin2 = ((((((getBackstageTimeMin() + 59) * 59) + getShowIndexBubbleHint()) * 59) + getKlineNum()) * 59) + getKlineDeepNum();
        String webHostCn2 = getWebHostCn();
        int i11 = 43;
        int hashCode = (backstageTimeMin2 * 59) + (webHostCn2 == null ? 43 : webHostCn2.hashCode());
        String webHostEn2 = getWebHostEn();
        int hashCode2 = (hashCode * 59) + (webHostEn2 == null ? 43 : webHostEn2.hashCode());
        String webHostKr2 = getWebHostKr();
        int hashCode3 = (hashCode2 * 59) + (webHostKr2 == null ? 43 : webHostKr2.hashCode());
        String webHostTr2 = getWebHostTr();
        int hashCode4 = (hashCode3 * 59) + (webHostTr2 == null ? 43 : webHostTr2.hashCode());
        String webHostVi2 = getWebHostVi();
        int hashCode5 = (hashCode4 * 59) + (webHostVi2 == null ? 43 : webHostVi2.hashCode());
        String googlePlayUrl2 = getGooglePlayUrl();
        int hashCode6 = (hashCode5 * 59) + (googlePlayUrl2 == null ? 43 : googlePlayUrl2.hashCode());
        String googlePlayPackage2 = getGooglePlayPackage();
        int hashCode7 = (hashCode6 * 59) + (googlePlayPackage2 == null ? 43 : googlePlayPackage2.hashCode());
        String appDownloadHost2 = getAppDownloadHost();
        int hashCode8 = (hashCode7 * 59) + (appDownloadHost2 == null ? 43 : appDownloadHost2.hashCode());
        String webHostRu2 = getWebHostRu();
        int i12 = hashCode8 * 59;
        if (webHostRu2 != null) {
            i11 = webHostRu2.hashCode();
        }
        return i12 + i11;
    }

    public void setAppDownloadHost(String str) {
        this.appDownloadHost = str;
    }

    public void setBackstageTimeMin(int i11) {
        this.backstageTimeMin = i11;
    }

    public void setGooglePlayPackage(String str) {
        this.googlePlayPackage = str;
    }

    public void setGooglePlayUrl(String str) {
        this.googlePlayUrl = str;
    }

    public void setKlineDeepNum(int i11) {
        this.klineDeepNum = i11;
    }

    public void setKlineNum(int i11) {
        this.klineNum = i11;
    }

    public void setShowIndexBubbleHint(int i11) {
        this.showIndexBubbleHint = i11;
    }

    public void setWebHostCn(String str) {
        this.webHostCn = str;
    }

    public void setWebHostEn(String str) {
        this.webHostEn = str;
    }

    public void setWebHostKr(String str) {
        this.webHostKr = str;
    }

    public void setWebHostRu(String str) {
        this.webHostRu = str;
    }

    public void setWebHostTr(String str) {
        this.webHostTr = str;
    }

    public void setWebHostVi(String str) {
        this.webHostVi = str;
    }

    public String toString() {
        return "OtherConfig(backstageTimeMin=" + getBackstageTimeMin() + ", showIndexBubbleHint=" + getShowIndexBubbleHint() + ", klineNum=" + getKlineNum() + ", klineDeepNum=" + getKlineDeepNum() + ", webHostCn=" + getWebHostCn() + ", webHostEn=" + getWebHostEn() + ", webHostKr=" + getWebHostKr() + ", webHostTr=" + getWebHostTr() + ", webHostVi=" + getWebHostVi() + ", googlePlayUrl=" + getGooglePlayUrl() + ", googlePlayPackage=" + getGooglePlayPackage() + ", appDownloadHost=" + getAppDownloadHost() + ", webHostRu=" + getWebHostRu() + ")";
    }
}
