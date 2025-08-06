package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class VipInfoResult implements Serializable {
    private long expiredAt;
    private int level;
    private int score;

    public boolean canEqual(Object obj) {
        return obj instanceof VipInfoResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VipInfoResult)) {
            return false;
        }
        VipInfoResult vipInfoResult = (VipInfoResult) obj;
        return vipInfoResult.canEqual(this) && getLevel() == vipInfoResult.getLevel() && getScore() == vipInfoResult.getScore() && getExpiredAt() == vipInfoResult.getExpiredAt();
    }

    public long getExpiredAt() {
        return this.expiredAt;
    }

    public int getLevel() {
        return this.level;
    }

    public int getScore() {
        return this.score;
    }

    public int hashCode() {
        int level2 = ((getLevel() + 59) * 59) + getScore();
        long expiredAt2 = getExpiredAt();
        return (level2 * 59) + ((int) ((expiredAt2 >>> 32) ^ expiredAt2));
    }

    public void setExpiredAt(long j11) {
        this.expiredAt = j11;
    }

    public void setLevel(int i11) {
        this.level = i11;
    }

    public void setScore(int i11) {
        this.score = i11;
    }

    public String toString() {
        return "VipInfoResult(level=" + getLevel() + ", score=" + getScore() + ", expiredAt=" + getExpiredAt() + ")";
    }
}
