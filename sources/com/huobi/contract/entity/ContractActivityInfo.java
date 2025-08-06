package com.huobi.contract.entity;

import java.io.Serializable;

public class ContractActivityInfo implements Serializable {
    public static final int STATUS_END = 3;
    public static final int STATUS_IN = 2;
    public static final int STATUS_PRE = 1;
    private static final long serialVersionUID = 8144050282187908901L;
    private String activityId;
    private long currentTime;
    private long endTime;
    private String productId;
    private long startTime;
    private int status;
    private String title;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractActivityInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractActivityInfo)) {
            return false;
        }
        ContractActivityInfo contractActivityInfo = (ContractActivityInfo) obj;
        if (!contractActivityInfo.canEqual(this) || getStatus() != contractActivityInfo.getStatus()) {
            return false;
        }
        String activityId2 = getActivityId();
        String activityId3 = contractActivityInfo.getActivityId();
        if (activityId2 != null ? !activityId2.equals(activityId3) : activityId3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = contractActivityInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        if (getStartTime() != contractActivityInfo.getStartTime() || getEndTime() != contractActivityInfo.getEndTime()) {
            return false;
        }
        String productId2 = getProductId();
        String productId3 = contractActivityInfo.getProductId();
        if (productId2 != null ? !productId2.equals(productId3) : productId3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = contractActivityInfo.getUrl();
        if (url2 != null ? url2.equals(url3) : url3 == null) {
            return getCurrentTime() == contractActivityInfo.getCurrentTime();
        }
        return false;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public long getCurrentTime() {
        return this.currentTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getProductId() {
        return this.productId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String activityId2 = getActivityId();
        int i11 = 43;
        int status2 = ((getStatus() + 59) * 59) + (activityId2 == null ? 43 : activityId2.hashCode());
        String title2 = getTitle();
        int i12 = status2 * 59;
        int hashCode = title2 == null ? 43 : title2.hashCode();
        long startTime2 = getStartTime();
        int i13 = ((i12 + hashCode) * 59) + ((int) (startTime2 ^ (startTime2 >>> 32)));
        long endTime2 = getEndTime();
        int i14 = (i13 * 59) + ((int) (endTime2 ^ (endTime2 >>> 32)));
        String productId2 = getProductId();
        int hashCode2 = (i14 * 59) + (productId2 == null ? 43 : productId2.hashCode());
        String url2 = getUrl();
        int i15 = hashCode2 * 59;
        if (url2 != null) {
            i11 = url2.hashCode();
        }
        int i16 = i15 + i11;
        long currentTime2 = getCurrentTime();
        return (i16 * 59) + ((int) ((currentTime2 >>> 32) ^ currentTime2));
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public void setCurrentTime(long j11) {
        this.currentTime = j11;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setStartTime(long j11) {
        this.startTime = j11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "ContractActivityInfo(status=" + getStatus() + ", activityId=" + getActivityId() + ", title=" + getTitle() + ", startTime=" + getStartTime() + ", endTime=" + getEndTime() + ", productId=" + getProductId() + ", url=" + getUrl() + ", currentTime=" + getCurrentTime() + ")";
    }
}
