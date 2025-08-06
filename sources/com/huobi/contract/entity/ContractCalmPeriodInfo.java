package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractCalmPeriodInfo implements Serializable {
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_OK = 0;
    @SerializedName("cooling_off_begin_time")
    private long coolingOffBeginTime;
    @SerializedName("cooling_off_end_time")
    private long coolingOffEndTime;
    @SerializedName("off")
    private boolean off;
    public int status = 0;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCalmPeriodInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCalmPeriodInfo)) {
            return false;
        }
        ContractCalmPeriodInfo contractCalmPeriodInfo = (ContractCalmPeriodInfo) obj;
        return contractCalmPeriodInfo.canEqual(this) && getStatus() == contractCalmPeriodInfo.getStatus() && isOff() == contractCalmPeriodInfo.isOff() && getCoolingOffBeginTime() == contractCalmPeriodInfo.getCoolingOffBeginTime() && getCoolingOffEndTime() == contractCalmPeriodInfo.getCoolingOffEndTime();
    }

    public long getCoolingOffBeginTime() {
        return this.coolingOffBeginTime;
    }

    public long getCoolingOffEndTime() {
        return this.coolingOffEndTime;
    }

    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int status2 = ((getStatus() + 59) * 59) + (isOff() ? 79 : 97);
        long coolingOffBeginTime2 = getCoolingOffBeginTime();
        int i11 = (status2 * 59) + ((int) (coolingOffBeginTime2 ^ (coolingOffBeginTime2 >>> 32)));
        long coolingOffEndTime2 = getCoolingOffEndTime();
        return (i11 * 59) + ((int) ((coolingOffEndTime2 >>> 32) ^ coolingOffEndTime2));
    }

    public boolean isOff() {
        return this.off;
    }

    public void setCoolingOffBeginTime(long j11) {
        this.coolingOffBeginTime = j11;
    }

    public void setCoolingOffEndTime(long j11) {
        this.coolingOffEndTime = j11;
    }

    public void setOff(boolean z11) {
        this.off = z11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "ContractCalmPeriodInfo{off=" + this.off + ", coolingOffBeginTime=" + this.coolingOffBeginTime + ", coolingOffEndTime=" + this.coolingOffEndTime + '}';
    }
}
