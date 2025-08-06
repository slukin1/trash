package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HbgDialogConfigInfo implements Serializable {
    private static final long serialVersionUID = -2343399076297967620L;
    public int alphaValue;
    public HbgDialogAppVersion appVersion;
    public String businessCategory;
    public long businessId;
    public List<Integer> deviceType;
    public long dialogId;
    public List<HbgDialogItem> dialogItem;
    public long endTime;
    public long interval;
    public List<String> languageBlacklist;
    public boolean localShow;
    public int operation;
    public String pageId;
    public List<Integer> pageIds;
    public int positionType;
    public String recomBaseInfo;
    public String remark;
    public int showCount;
    public HbgDialogShowFrequency showFrequency;
    public int showLevel;
    public int showNotLogin;
    public long showTime;
    public int showType;
    public long startTime;
    public int updateStrategy;
    public String url;
    public List<String> userPortrait;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HbgDialogConfigInfo)) {
            return false;
        }
        if (this.dialogId == ((HbgDialogConfigInfo) obj).dialogId) {
            return true;
        }
        return false;
    }

    public int getAlphaValue() {
        return this.alphaValue;
    }

    public HbgDialogAppVersion getAppVersion() {
        return this.appVersion;
    }

    public String getBusinessCategory() {
        return this.businessCategory;
    }

    public long getBusinessId() {
        return this.businessId;
    }

    public List<Integer> getDeviceType() {
        return this.deviceType;
    }

    public long getDialogId() {
        return this.dialogId;
    }

    public List<HbgDialogItem> getDialogItem() {
        return this.dialogItem;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getInterval() {
        return this.interval;
    }

    public List<String> getLanguageBlacklist() {
        return this.languageBlacklist;
    }

    public int getOperation() {
        return this.operation;
    }

    public String getPageId() {
        return this.pageId;
    }

    public List<Integer> getPageIds() {
        return this.pageIds;
    }

    public int getPositionType() {
        return this.positionType;
    }

    public String getRecomBaseInfo() {
        return this.recomBaseInfo;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getShowCount() {
        return this.showCount;
    }

    public HbgDialogShowFrequency getShowFrequency() {
        return this.showFrequency;
    }

    public int getShowLevel() {
        return this.showLevel;
    }

    public int getShowNotLogin() {
        return this.showNotLogin;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public int getShowType() {
        return this.showType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getUpdateStrategy() {
        return this.updateStrategy;
    }

    public String getUrl() {
        return this.url;
    }

    public List<String> getUserPortrait() {
        return this.userPortrait;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.dialogId)});
    }

    public boolean isLocalShow() {
        return this.localShow;
    }

    public void setAlphaValue(int i11) {
        this.alphaValue = i11;
    }

    public void setAppVersion(HbgDialogAppVersion hbgDialogAppVersion) {
        this.appVersion = hbgDialogAppVersion;
    }

    public void setBusinessCategory(String str) {
        this.businessCategory = str;
    }

    public void setBusinessId(long j11) {
        this.businessId = j11;
    }

    public void setDeviceType(List<Integer> list) {
        this.deviceType = list;
    }

    public void setDialogId(long j11) {
        this.dialogId = j11;
    }

    public void setDialogItem(List<HbgDialogItem> list) {
        this.dialogItem = list;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setInterval(long j11) {
        this.interval = j11;
    }

    public void setLanguageBlacklist(List<String> list) {
        this.languageBlacklist = list;
    }

    public void setLocalShow(boolean z11) {
        this.localShow = z11;
    }

    public void setOperation(int i11) {
        this.operation = i11;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public void setPageIds(List<Integer> list) {
        this.pageIds = list;
    }

    public void setPositionType(int i11) {
        this.positionType = i11;
    }

    public void setRecomBaseInfo(String str) {
        this.recomBaseInfo = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setShowCount(int i11) {
        this.showCount = i11;
    }

    public void setShowFrequency(HbgDialogShowFrequency hbgDialogShowFrequency) {
        this.showFrequency = hbgDialogShowFrequency;
    }

    public void setShowLevel(int i11) {
        this.showLevel = i11;
    }

    public void setShowNotLogin(int i11) {
        this.showNotLogin = i11;
    }

    public void setShowTime(long j11) {
        this.showTime = j11;
    }

    public void setShowType(int i11) {
        this.showType = i11;
    }

    public void setStartTime(long j11) {
        this.startTime = j11;
    }

    public void setUpdateStrategy(int i11) {
        this.updateStrategy = i11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserPortrait(List<String> list) {
        this.userPortrait = list;
    }

    public String toString() {
        return "HbgDialogConfigInfo(dialogId=" + getDialogId() + ", businessCategory=" + getBusinessCategory() + ", businessId=" + getBusinessId() + ", positionType=" + getPositionType() + ", appVersion=" + getAppVersion() + ", dialogItem=" + getDialogItem() + ", showFrequency=" + getShowFrequency() + ", startTime=" + getStartTime() + ", endTime=" + getEndTime() + ", url=" + getUrl() + ", pageId=" + getPageId() + ", pageIds=" + getPageIds() + ", showType=" + getShowType() + ", showTime=" + getShowTime() + ", interval=" + getInterval() + ", alphaValue=" + getAlphaValue() + ", languageBlacklist=" + getLanguageBlacklist() + ", showCount=" + getShowCount() + ", showLevel=" + getShowLevel() + ", showNotLogin=" + getShowNotLogin() + ", deviceType=" + getDeviceType() + ", userPortrait=" + getUserPortrait() + ", operation=" + getOperation() + ", remark=" + getRemark() + ", updateStrategy=" + getUpdateStrategy() + ", recomBaseInfo=" + getRecomBaseInfo() + ", localShow=" + isLocalShow() + ")";
    }
}
