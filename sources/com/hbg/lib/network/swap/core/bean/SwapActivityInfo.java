package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapActivityInfo implements Serializable {
    public static final int STATUS_END = 4;
    public static final int STATUS_IN_PROGRESS = 3;
    public static final int STATUS_SIGNING_UP = 2;
    public static final int STATUS_SIGN_UP_PRE = 1;
    private static final long serialVersionUID = 8144050282187908901L;
    @SerializedName("activity_id")
    private String activityId;
    @SerializedName("current_time")
    private long currentTime;
    @SerializedName("end_time")
    private long endTime;
    @SerializedName("join_person")
    private int joinPerson;
    @SerializedName("join_time")
    private long joinTime;
    @SerializedName("product_id")
    private String productId;
    @SerializedName("start_time")
    private long startTime;
    private int status;
    private String title;
    @SerializedName("total_gift")
    private int totalGift;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapActivityInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapActivityInfo)) {
            return false;
        }
        SwapActivityInfo swapActivityInfo = (SwapActivityInfo) obj;
        if (!swapActivityInfo.canEqual(this) || getStatus() != swapActivityInfo.getStatus()) {
            return false;
        }
        String activityId2 = getActivityId();
        String activityId3 = swapActivityInfo.getActivityId();
        if (activityId2 != null ? !activityId2.equals(activityId3) : activityId3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = swapActivityInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        if (getStartTime() != swapActivityInfo.getStartTime() || getEndTime() != swapActivityInfo.getEndTime() || getTotalGift() != swapActivityInfo.getTotalGift() || getJoinPerson() != swapActivityInfo.getJoinPerson()) {
            return false;
        }
        String productId2 = getProductId();
        String productId3 = swapActivityInfo.getProductId();
        if (productId2 != null ? !productId2.equals(productId3) : productId3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = swapActivityInfo.getUrl();
        if (url2 != null ? url2.equals(url3) : url3 == null) {
            return getCurrentTime() == swapActivityInfo.getCurrentTime() && getJoinTime() == swapActivityInfo.getJoinTime();
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
        return "SwapActivityInfo(status=" + getStatus() + ", activityId=" + getActivityId() + ", title=" + getTitle() + ", startTime=" + getStartTime() + ", endTime=" + getEndTime() + ", totalGift=" + getTotalGift() + ", joinPerson=" + getJoinPerson() + ", productId=" + getProductId() + ", url=" + getUrl() + ", currentTime=" + getCurrentTime() + ", joinTime=" + getJoinTime() + ")";
    }
}
