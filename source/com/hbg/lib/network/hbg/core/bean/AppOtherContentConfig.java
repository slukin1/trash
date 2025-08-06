package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AppOtherContentConfig implements Serializable {
    @SerializedName("web_host_en")
    private String webHostEn;
    @SerializedName("web_host_ko")
    private String webHostKo;
    @SerializedName("web_host_tr")
    private String webHostTr;
    @SerializedName("web_host_vi")
    private String webHostVi;
    @SerializedName("web_host_zh")
    private String webHostZh;

    public boolean canEqual(Object obj) {
        return obj instanceof AppOtherContentConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppOtherContentConfig)) {
            return false;
        }
        AppOtherContentConfig appOtherContentConfig = (AppOtherContentConfig) obj;
        if (!appOtherContentConfig.canEqual(this)) {
            return false;
        }
        String webHostZh2 = getWebHostZh();
        String webHostZh3 = appOtherContentConfig.getWebHostZh();
        if (webHostZh2 != null ? !webHostZh2.equals(webHostZh3) : webHostZh3 != null) {
            return false;
        }
        String webHostEn2 = getWebHostEn();
        String webHostEn3 = appOtherContentConfig.getWebHostEn();
        if (webHostEn2 != null ? !webHostEn2.equals(webHostEn3) : webHostEn3 != null) {
            return false;
        }
        String webHostKo2 = getWebHostKo();
        String webHostKo3 = appOtherContentConfig.getWebHostKo();
        if (webHostKo2 != null ? !webHostKo2.equals(webHostKo3) : webHostKo3 != null) {
            return false;
        }
        String webHostTr2 = getWebHostTr();
        String webHostTr3 = appOtherContentConfig.getWebHostTr();
        if (webHostTr2 != null ? !webHostTr2.equals(webHostTr3) : webHostTr3 != null) {
            return false;
        }
        String webHostVi2 = getWebHostVi();
        String webHostVi3 = appOtherContentConfig.getWebHostVi();
        return webHostVi2 != null ? webHostVi2.equals(webHostVi3) : webHostVi3 == null;
    }

    public String getWebHostEn() {
        return this.webHostEn;
    }

    public String getWebHostKo() {
        return this.webHostKo;
    }

    public String getWebHostTr() {
        return this.webHostTr;
    }

    public String getWebHostVi() {
        return this.webHostVi;
    }

    public String getWebHostZh() {
        return this.webHostZh;
    }

    public int hashCode() {
        String webHostZh2 = getWebHostZh();
        int i11 = 43;
        int hashCode = webHostZh2 == null ? 43 : webHostZh2.hashCode();
        String webHostEn2 = getWebHostEn();
        int hashCode2 = ((hashCode + 59) * 59) + (webHostEn2 == null ? 43 : webHostEn2.hashCode());
        String webHostKo2 = getWebHostKo();
        int hashCode3 = (hashCode2 * 59) + (webHostKo2 == null ? 43 : webHostKo2.hashCode());
        String webHostTr2 = getWebHostTr();
        int hashCode4 = (hashCode3 * 59) + (webHostTr2 == null ? 43 : webHostTr2.hashCode());
        String webHostVi2 = getWebHostVi();
        int i12 = hashCode4 * 59;
        if (webHostVi2 != null) {
            i11 = webHostVi2.hashCode();
        }
        return i12 + i11;
    }

    public void setWebHostEn(String str) {
        this.webHostEn = str;
    }

    public void setWebHostKo(String str) {
        this.webHostKo = str;
    }

    public void setWebHostTr(String str) {
        this.webHostTr = str;
    }

    public void setWebHostVi(String str) {
        this.webHostVi = str;
    }

    public void setWebHostZh(String str) {
        this.webHostZh = str;
    }

    public String toString() {
        return "AppOtherContentConfig(webHostZh=" + getWebHostZh() + ", webHostEn=" + getWebHostEn() + ", webHostKo=" + getWebHostKo() + ", webHostTr=" + getWebHostTr() + ", webHostVi=" + getWebHostVi() + ")";
    }
}
