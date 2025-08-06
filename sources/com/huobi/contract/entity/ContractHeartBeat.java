package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractHeartBeat implements Serializable {
    public static final String SYS_NORMAL = "1";
    public static final String SYS_SAFEGUARD = "0";
    public String heartbeat;
    @SerializedName("linear_swap_estimated_recovery_time")
    private long linearSwapEstimatedRecoveryTime;
    @SerializedName("linear_swap_heartbeat")
    private String linearSwapHeartbeat;
    @SerializedName("option_estimated_recovery_time")
    private long optionEstimatedRecoveryTime;
    @SerializedName("option_heartbeat")
    private String optionHeartbeat;
    @SerializedName("swap_estimated_recovery_time")
    private long swapEstimatedRecoveryTime;
    @SerializedName("swap_heartbeat")
    private String swapHeartbeat;
    @SerializedName("estimated_recovery_time")
    public long time;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractHeartBeat;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractHeartBeat)) {
            return false;
        }
        ContractHeartBeat contractHeartBeat = (ContractHeartBeat) obj;
        if (!contractHeartBeat.canEqual(this)) {
            return false;
        }
        String heartbeat2 = getHeartbeat();
        String heartbeat3 = contractHeartBeat.getHeartbeat();
        if (heartbeat2 != null ? !heartbeat2.equals(heartbeat3) : heartbeat3 != null) {
            return false;
        }
        if (getTime() != contractHeartBeat.getTime()) {
            return false;
        }
        String swapHeartbeat2 = getSwapHeartbeat();
        String swapHeartbeat3 = contractHeartBeat.getSwapHeartbeat();
        if (swapHeartbeat2 != null ? !swapHeartbeat2.equals(swapHeartbeat3) : swapHeartbeat3 != null) {
            return false;
        }
        String optionHeartbeat2 = getOptionHeartbeat();
        String optionHeartbeat3 = contractHeartBeat.getOptionHeartbeat();
        if (optionHeartbeat2 != null ? !optionHeartbeat2.equals(optionHeartbeat3) : optionHeartbeat3 != null) {
            return false;
        }
        String linearSwapHeartbeat2 = getLinearSwapHeartbeat();
        String linearSwapHeartbeat3 = contractHeartBeat.getLinearSwapHeartbeat();
        if (linearSwapHeartbeat2 != null ? linearSwapHeartbeat2.equals(linearSwapHeartbeat3) : linearSwapHeartbeat3 == null) {
            return getSwapEstimatedRecoveryTime() == contractHeartBeat.getSwapEstimatedRecoveryTime() && getOptionEstimatedRecoveryTime() == contractHeartBeat.getOptionEstimatedRecoveryTime() && getLinearSwapEstimatedRecoveryTime() == contractHeartBeat.getLinearSwapEstimatedRecoveryTime();
        }
        return false;
    }

    public String getHeartbeat() {
        return this.heartbeat;
    }

    public long getLinearSwapEstimatedRecoveryTime() {
        return this.linearSwapEstimatedRecoveryTime;
    }

    public String getLinearSwapHeartbeat() {
        return this.linearSwapHeartbeat;
    }

    public long getOptionEstimatedRecoveryTime() {
        return this.optionEstimatedRecoveryTime;
    }

    public String getOptionHeartbeat() {
        return this.optionHeartbeat;
    }

    public long getSwapEstimatedRecoveryTime() {
        return this.swapEstimatedRecoveryTime;
    }

    public String getSwapHeartbeat() {
        return this.swapHeartbeat;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        String heartbeat2 = getHeartbeat();
        int i11 = 43;
        int hashCode = heartbeat2 == null ? 43 : heartbeat2.hashCode();
        long time2 = getTime();
        int i12 = ((hashCode + 59) * 59) + ((int) (time2 ^ (time2 >>> 32)));
        String swapHeartbeat2 = getSwapHeartbeat();
        int hashCode2 = (i12 * 59) + (swapHeartbeat2 == null ? 43 : swapHeartbeat2.hashCode());
        String optionHeartbeat2 = getOptionHeartbeat();
        int hashCode3 = (hashCode2 * 59) + (optionHeartbeat2 == null ? 43 : optionHeartbeat2.hashCode());
        String linearSwapHeartbeat2 = getLinearSwapHeartbeat();
        int i13 = hashCode3 * 59;
        if (linearSwapHeartbeat2 != null) {
            i11 = linearSwapHeartbeat2.hashCode();
        }
        long swapEstimatedRecoveryTime2 = getSwapEstimatedRecoveryTime();
        long optionEstimatedRecoveryTime2 = getOptionEstimatedRecoveryTime();
        long linearSwapEstimatedRecoveryTime2 = getLinearSwapEstimatedRecoveryTime();
        return ((((((i13 + i11) * 59) + ((int) (swapEstimatedRecoveryTime2 ^ (swapEstimatedRecoveryTime2 >>> 32)))) * 59) + ((int) (optionEstimatedRecoveryTime2 ^ (optionEstimatedRecoveryTime2 >>> 32)))) * 59) + ((int) ((linearSwapEstimatedRecoveryTime2 >>> 32) ^ linearSwapEstimatedRecoveryTime2));
    }

    public boolean isLinearSwapSafeguard() {
        return "0".equals(this.linearSwapHeartbeat);
    }

    public boolean isOptionSafeguard() {
        return "0".equals(this.optionHeartbeat);
    }

    public boolean isSafeguard() {
        return isSysSafeguard() && isSwapSafeguard();
    }

    public boolean isSwapSafeguard() {
        return "0".equals(this.swapHeartbeat);
    }

    public boolean isSysSafeguard() {
        return "0".equals(this.heartbeat);
    }

    public void setHeartbeat(String str) {
        this.heartbeat = str;
    }

    public void setLinearSwapEstimatedRecoveryTime(long j11) {
        this.linearSwapEstimatedRecoveryTime = j11;
    }

    public void setLinearSwapHeartbeat(String str) {
        this.linearSwapHeartbeat = str;
    }

    public void setOptionEstimatedRecoveryTime(long j11) {
        this.optionEstimatedRecoveryTime = j11;
    }

    public void setOptionHeartbeat(String str) {
        this.optionHeartbeat = str;
    }

    public void setSwapEstimatedRecoveryTime(long j11) {
        this.swapEstimatedRecoveryTime = j11;
    }

    public void setSwapHeartbeat(String str) {
        this.swapHeartbeat = str;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "ContractHeartBeat(heartbeat=" + getHeartbeat() + ", time=" + getTime() + ", swapHeartbeat=" + getSwapHeartbeat() + ", optionHeartbeat=" + getOptionHeartbeat() + ", linearSwapHeartbeat=" + getLinearSwapHeartbeat() + ", swapEstimatedRecoveryTime=" + getSwapEstimatedRecoveryTime() + ", optionEstimatedRecoveryTime=" + getOptionEstimatedRecoveryTime() + ", linearSwapEstimatedRecoveryTime=" + getLinearSwapEstimatedRecoveryTime() + ")";
    }
}
