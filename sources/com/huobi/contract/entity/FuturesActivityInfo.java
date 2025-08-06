package com.huobi.contract.entity;

import java.io.Serializable;

public class FuturesActivityInfo implements Serializable {
    private String activityId;
    private long currentTime;
    private long endTime;
    private int joinPerson;
    private long joinTime;
    private String productId;
    private long startTime;
    private int status;
    private String title;
    private int totalGift;
    private String url;

    public static FuturesActivityInfo contractToFutures(ContractActivityInfo contractActivityInfo) {
        if (contractActivityInfo == null) {
            return null;
        }
        FuturesActivityInfo futuresActivityInfo = new FuturesActivityInfo();
        futuresActivityInfo.setStatus(contractActivityInfo.getStatus());
        futuresActivityInfo.setActivityId(contractActivityInfo.getActivityId());
        futuresActivityInfo.setTitle(contractActivityInfo.getTitle());
        futuresActivityInfo.setStartTime(contractActivityInfo.getStartTime());
        futuresActivityInfo.setEndTime(contractActivityInfo.getEndTime());
        futuresActivityInfo.setProductId(contractActivityInfo.getProductId());
        futuresActivityInfo.setUrl(contractActivityInfo.getUrl());
        futuresActivityInfo.setCurrentTime(contractActivityInfo.getCurrentTime());
        return futuresActivityInfo;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof FuturesActivityInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FuturesActivityInfo)) {
            return false;
        }
        FuturesActivityInfo futuresActivityInfo = (FuturesActivityInfo) obj;
        if (!futuresActivityInfo.canEqual(this) || getStatus() != futuresActivityInfo.getStatus()) {
            return false;
        }
        String activityId2 = getActivityId();
        String activityId3 = futuresActivityInfo.getActivityId();
        if (activityId2 != null ? !activityId2.equals(activityId3) : activityId3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = futuresActivityInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        if (getStartTime() != futuresActivityInfo.getStartTime() || getEndTime() != futuresActivityInfo.getEndTime() || getTotalGift() != futuresActivityInfo.getTotalGift() || getJoinPerson() != futuresActivityInfo.getJoinPerson()) {
            return false;
        }
        String productId2 = getProductId();
        String productId3 = futuresActivityInfo.getProductId();
        if (productId2 != null ? !productId2.equals(productId3) : productId3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = futuresActivityInfo.getUrl();
        if (url2 != null ? url2.equals(url3) : url3 == null) {
            return getCurrentTime() == futuresActivityInfo.getCurrentTime() && getJoinTime() == futuresActivityInfo.getJoinTime();
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

    public int getJoinPerson() {
        return this.joinPerson;
    }

    public long getJoinTime() {
        return this.joinTime;
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

    public int getTotalGift() {
        return this.totalGift;
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
        int totalGift2 = (((((i13 * 59) + ((int) (endTime2 ^ (endTime2 >>> 32)))) * 59) + getTotalGift()) * 59) + getJoinPerson();
        String productId2 = getProductId();
        int hashCode2 = (totalGift2 * 59) + (productId2 == null ? 43 : productId2.hashCode());
        String url2 = getUrl();
        int i14 = hashCode2 * 59;
        if (url2 != null) {
            i11 = url2.hashCode();
        }
        int i15 = i14 + i11;
        long currentTime2 = getCurrentTime();
        int i16 = (i15 * 59) + ((int) (currentTime2 ^ (currentTime2 >>> 32)));
        long joinTime2 = getJoinTime();
        return (i16 * 59) + ((int) ((joinTime2 >>> 32) ^ joinTime2));
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

    public void setJoinPerson(int i11) {
        this.joinPerson = i11;
    }

    public void setJoinTime(long j11) {
        this.joinTime = j11;
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

    public void setTotalGift(int i11) {
        this.totalGift = i11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "FuturesActivityInfo(status=" + getStatus() + ", activityId=" + getActivityId() + ", title=" + getTitle() + ", startTime=" + getStartTime() + ", endTime=" + getEndTime() + ", totalGift=" + getTotalGift() + ", joinPerson=" + getJoinPerson() + ", productId=" + getProductId() + ", url=" + getUrl() + ", currentTime=" + getCurrentTime() + ", joinTime=" + getJoinTime() + ")";
    }
}
