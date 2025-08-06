package com.hbg.lib.network.hbg.core;

import java.io.Serializable;

public class VipLevel implements Serializable {
    public static final int LEVEL_BLACK = 5;
    public static final int LEVEL_ELITE = 1;
    public static final int LEVEL_GOLD = 3;
    public static final int LEVEL_NORMAL = 0;
    public static final int LEVEL_PLATINUM = 4;
    public static final int LEVEL_SILVER = 2;

    /* renamed from: id  reason: collision with root package name */
    private int f70215id;
    private int score;

    public boolean canEqual(Object obj) {
        return obj instanceof VipLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VipLevel)) {
            return false;
        }
        VipLevel vipLevel = (VipLevel) obj;
        return vipLevel.canEqual(this) && getId() == vipLevel.getId() && getScore() == vipLevel.getScore();
    }

    public int getId() {
        return this.f70215id;
    }

    public int getScore() {
        return this.score;
    }

    public int hashCode() {
        return ((getId() + 59) * 59) + getScore();
    }

    public void setId(int i11) {
        this.f70215id = i11;
    }

    public void setScore(int i11) {
        this.score = i11;
    }

    public String toString() {
        return "VipLevel(id=" + getId() + ", score=" + getScore() + ")";
    }
}
