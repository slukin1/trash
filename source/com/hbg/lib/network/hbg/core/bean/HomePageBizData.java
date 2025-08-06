package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HomePageBizData implements Serializable {
    private long beginTime;
    private String bgImageUrl;
    private long endTime;
    private String extension;
    private String extensionText;
    private Extra extra;
    private int flag;
    private String focusContent;
    private int focusType;
    private String frontImageUrl;
    private String iconLabel;
    private String imageUrl;
    private int materialId;
    private String name;
    private int show;
    private int style;
    private Summary summary;
    private String tagUrl;
    private String title;
    private int type;
    private HomePageJumpData url;

    public static class Extra implements Serializable {
        private String depositTag;

        public String getDepositTag() {
            return this.depositTag;
        }

        public void setDepositTag(String str) {
            this.depositTag = str;
        }
    }

    public static class Summary implements Serializable {
        private String color;
        private String content;

        public String getColor() {
            return this.color;
        }

        public String getContent() {
            return this.content;
        }

        public void setColor(String str) {
            this.color = str;
        }

        public void setContent(String str) {
            this.content = str;
        }
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public String getBgImageUrl() {
        return this.bgImageUrl;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getExtensionText() {
        return this.extensionText;
    }

    public Extra getExtra() {
        return this.extra;
    }

    public int getFlag() {
        return this.flag;
    }

    public String getFocusContent() {
        return this.focusContent;
    }

    public int getFocusType() {
        return this.focusType;
    }

    public String getFrontImageUrl() {
        return this.frontImageUrl;
    }

    public String getIconLabel() {
        return this.iconLabel;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMaterialId() {
        return this.materialId;
    }

    public String getName() {
        return this.name;
    }

    public int getShow() {
        return this.show;
    }

    public int getStyle() {
        return this.style;
    }

    public Summary getSummary() {
        return this.summary;
    }

    public String getTagUrl() {
        return this.tagUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public HomePageJumpData getUrl() {
        return this.url;
    }

    public void setBeginTime(long j11) {
        this.beginTime = j11;
    }

    public void setBgImageUrl(String str) {
        this.bgImageUrl = str;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setExtensionText(String str) {
        this.extensionText = str;
    }

    public void setExtra(Extra extra2) {
        this.extra = extra2;
    }

    public void setFlag(int i11) {
        this.flag = i11;
    }

    public void setFocusContent(String str) {
        this.focusContent = str;
    }

    public void setFocusType(int i11) {
        this.focusType = i11;
    }

    public void setFrontImageUrl(String str) {
        this.frontImageUrl = str;
    }

    public void setIconLabel(String str) {
        this.iconLabel = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMaterialId(int i11) {
        this.materialId = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShow(int i11) {
        this.show = i11;
    }

    public void setStyle(int i11) {
        this.style = i11;
    }

    public void setSummary(Summary summary2) {
        this.summary = summary2;
    }

    public void setTagUrl(String str) {
        this.tagUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUrl(HomePageJumpData homePageJumpData) {
        this.url = homePageJumpData;
    }

    public String toString() {
        return "HomePageBizData{flag=" + this.flag + ", type=" + this.type + ", name='" + this.name + '\'' + ", show=" + this.show + ", title='" + this.title + '\'' + ", summary=" + this.summary + ", imageUrl='" + this.imageUrl + '\'' + ", frontImageUrl='" + this.frontImageUrl + '\'' + ", bgImageUrl='" + this.bgImageUrl + '\'' + ", tagUrl='" + this.tagUrl + '\'' + ", url=" + this.url + ", focusType=" + this.focusType + ", focusContent='" + this.focusContent + '\'' + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ", extra=" + this.extra + ", style=" + this.style + ", iconLabel='" + this.iconLabel + '\'' + ", materialId=" + this.materialId + ", extension='" + this.extension + '\'' + ", extensionText='" + this.extensionText + '\'' + '}';
    }
}
