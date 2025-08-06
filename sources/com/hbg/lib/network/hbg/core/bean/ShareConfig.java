package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ShareConfig implements Serializable {
    @SerializedName("channelList")
    private List<String> channelList;
    @SerializedName("inviteCode")
    private String inviteCode;
    @SerializedName("needLogin")
    private int needLogin;
    @SerializedName("posterDescribe")
    private String posterDescribe;
    @SerializedName("posterSubTitle")
    private String posterSubTitle;
    @SerializedName("posterTitle")
    private String posterTitle;
    @SerializedName("qrCodeUrl")
    private String qrCodeUrl;
    @SerializedName("shareFloatingText")
    private String shareFloatingText;
    @SerializedName("shareTitle")
    private String shareTitle;
    @SerializedName("shareUrl")
    private String shareUrl;
    @SerializedName("showQRCode")
    private Boolean showQRCode;
    @SerializedName("showTail")
    private Boolean showTail;
    @SerializedName("source")
    private String source;
    @SerializedName("state")
    private int state;
    @SerializedName("tailImgUrl")
    private String tailImgUrl;

    public List<String> getChannelList() {
        return this.channelList;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public int getNeedLogin() {
        return this.needLogin;
    }

    public String getPosterDescribe() {
        return this.posterDescribe;
    }

    public String getPosterSubTitle() {
        return this.posterDescribe;
    }

    public String getPosterTitle() {
        return this.posterTitle;
    }

    public String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public String getShareFloatingText() {
        return this.shareFloatingText;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public Boolean getShowQRCode() {
        return this.showQRCode;
    }

    public Boolean getShowTail() {
        return this.showTail;
    }

    public String getSource() {
        return this.source;
    }

    public int getState() {
        return this.state;
    }

    public String getTailImgUrl() {
        return this.tailImgUrl;
    }

    public void setChannelList(List<String> list) {
        this.channelList = list;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setNeedLogin(int i11) {
        this.needLogin = i11;
    }

    public void setPosterDescribe(String str) {
        this.posterDescribe = str;
    }

    public void setPosterSubTitle(String str) {
        this.posterSubTitle = str;
    }

    public void setPosterTitle(String str) {
        this.posterTitle = str;
    }

    public void setQrCodeUrl(String str) {
        this.qrCodeUrl = str;
    }

    public void setShareFloatingText(String str) {
        this.shareFloatingText = str;
    }

    public void setShareTitle(String str) {
        this.shareTitle = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setShowQRCode(Boolean bool) {
        this.showQRCode = bool;
    }

    public void setShowTail(Boolean bool) {
        this.showTail = bool;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setTailImgUrl(String str) {
        this.tailImgUrl = str;
    }

    public String toString() {
        return "ShareConfig{posterSubTitle='" + this.posterSubTitle + '\'' + ", posterTitle='" + this.posterTitle + '\'' + ", qrCodeUrl='" + this.qrCodeUrl + '\'' + ", shareFloatingText='" + this.shareFloatingText + '\'' + ", shareTitle='" + this.shareTitle + '\'' + ", shareUrl='" + this.shareUrl + '\'' + ", tailImgUrl='" + this.tailImgUrl + '\'' + ", channelList=" + this.channelList + ", needLogin=" + this.needLogin + ", showQRCode=" + this.showQRCode + ", showTail=" + this.showTail + ", source='" + this.source + '\'' + ", state=" + this.state + ", inviteCode='" + this.inviteCode + '\'' + ", posterDescribe='" + this.posterDescribe + '\'' + '}';
    }
}
