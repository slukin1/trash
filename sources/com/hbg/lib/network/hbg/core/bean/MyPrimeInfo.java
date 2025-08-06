package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MyPrimeInfo implements Serializable {
    @SerializedName("backgroundUrl")
    private String backgroundUrl;
    @SerializedName("level")
    private int level;
    @SerializedName("list")
    private List<AccountLevelCardData> list;
    @SerializedName("maxLevel")
    private boolean maxLevel;
    @SerializedName("name")
    private String name;
    @SerializedName("nextLevel")
    private int nextLevel;
    @SerializedName("showStatus")
    private boolean showStatus;
    @SerializedName("unlockHighlightText")
    private String unlockHighlightText;
    @SerializedName("unlockText")
    private String unlockText;
    @SerializedName("url")
    private String url;

    public String getBackgroundUrl() {
        return this.backgroundUrl;
    }

    public int getLevel() {
        return this.level;
    }

    public List<AccountLevelCardData> getList() {
        return this.list;
    }

    public String getName() {
        return this.name;
    }

    public int getNextLevel() {
        return this.nextLevel;
    }

    public String getUnlockHighlightText() {
        return this.unlockHighlightText;
    }

    public String getUnlockText() {
        return this.unlockText;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isMaxLevel() {
        return this.maxLevel;
    }

    public boolean isShowStatus() {
        return this.showStatus;
    }

    public void setBackgroundUrl(String str) {
        this.backgroundUrl = str;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setList(List<AccountLevelCardData> list2) {
        this.list = list2;
    }

    public void setMaxLevel(boolean z11) {
        this.maxLevel = z11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNextLevel(int i11) {
        this.nextLevel = i11;
    }

    public void setShowStatus(boolean z11) {
        this.showStatus = z11;
    }

    public void setUnlockHighlightText(String str) {
        this.unlockHighlightText = str;
    }

    public void setUnlockText(String str) {
        this.unlockText = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
