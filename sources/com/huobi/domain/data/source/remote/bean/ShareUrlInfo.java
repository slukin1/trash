package com.huobi.domain.data.source.remote.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ShareUrlInfo implements Serializable {
    private static final long serialVersionUID = -831503040579541897L;
    @SerializedName("share_cn")
    private String shareCnUrl;
    @SerializedName("share_en")
    private String shareEnUrl;
    @SerializedName("share_oversea_cn")
    private String shareOverseaCnUrl;
    @SerializedName("share_oversea_en")
    private String shareOverseaEnUrl;

    public String getShareCnUrl() {
        return this.shareCnUrl;
    }

    public String getShareEnUrl() {
        return this.shareEnUrl;
    }

    public String getShareOverseaCnUrl() {
        return this.shareOverseaCnUrl;
    }

    public String getShareOverseaEnUrl() {
        return this.shareOverseaEnUrl;
    }

    public void setShareCnUrl(String str) {
        this.shareCnUrl = str;
    }

    public void setShareEnUrl(String str) {
        this.shareEnUrl = str;
    }

    public void setShareOverseaCnUrl(String str) {
        this.shareOverseaCnUrl = str;
    }

    public void setShareOverseaEnUrl(String str) {
        this.shareOverseaEnUrl = str;
    }
}
