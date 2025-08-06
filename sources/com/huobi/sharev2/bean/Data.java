package com.huobi.sharev2.bean;

import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;

public final class Data implements Serializable {
    private String buttonId = "";
    private ArrayList<String> channelList = new ArrayList<>();
    private ArrayList<String> extendChannelList = new ArrayList<>();
    private JsonObject extendChannelParam;
    private String floatContent = "";
    private ArrayList<String> images = new ArrayList<>();
    private String pageId = "";
    private String qrcodeSubTitle = "";
    private String qrcodeTitle = "";
    private String shareThumbImage = "";
    private String shareTitle = "";
    private String shareUrl = "";
    private boolean showQRCode;
    private boolean showTail;
    private String source = "";

    public final String getButtonId() {
        return this.buttonId;
    }

    public final ArrayList<String> getChannelList() {
        return this.channelList;
    }

    public final ArrayList<String> getExtendChannelList() {
        return this.extendChannelList;
    }

    public final JsonObject getExtendChannelParam() {
        return this.extendChannelParam;
    }

    public final String getFloatContent() {
        return this.floatContent;
    }

    public final ArrayList<String> getImages() {
        return this.images;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getQrcodeSubTitle() {
        return this.qrcodeSubTitle;
    }

    public final String getQrcodeTitle() {
        return this.qrcodeTitle;
    }

    public final String getShareThumbImage() {
        return this.shareThumbImage;
    }

    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final boolean getShowQRCode() {
        return this.showQRCode;
    }

    public final boolean getShowTail() {
        return this.showTail;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setButtonId(String str) {
        this.buttonId = str;
    }

    public final void setChannelList(ArrayList<String> arrayList) {
        this.channelList = arrayList;
    }

    public final void setExtendChannelList(ArrayList<String> arrayList) {
        this.extendChannelList = arrayList;
    }

    public final void setExtendChannelParam(JsonObject jsonObject) {
        this.extendChannelParam = jsonObject;
    }

    public final void setFloatContent(String str) {
        this.floatContent = str;
    }

    public final void setImages(ArrayList<String> arrayList) {
        this.images = arrayList;
    }

    public final void setPageId(String str) {
        this.pageId = str;
    }

    public final void setQrcodeSubTitle(String str) {
        this.qrcodeSubTitle = str;
    }

    public final void setQrcodeTitle(String str) {
        this.qrcodeTitle = str;
    }

    public final void setShareThumbImage(String str) {
        this.shareThumbImage = str;
    }

    public final void setShareTitle(String str) {
        this.shareTitle = str;
    }

    public final void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public final void setShowQRCode(boolean z11) {
        this.showQRCode = z11;
    }

    public final void setShowTail(boolean z11) {
        this.showTail = z11;
    }

    public final void setSource(String str) {
        this.source = str;
    }
}
