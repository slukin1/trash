package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridLeverageRange implements Serializable {
    private int leverThreshold;
    private int maxLever;
    private int minLever;

    public boolean canEqual(Object obj) {
        return obj instanceof GridLeverageRange;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridLeverageRange)) {
            return false;
        }
        GridLeverageRange gridLeverageRange = (GridLeverageRange) obj;
        return gridLeverageRange.canEqual(this) && getMinLever() == gridLeverageRange.getMinLever() && getMaxLever() == gridLeverageRange.getMaxLever() && getLeverThreshold() == gridLeverageRange.getLeverThreshold();
    }

    public int getLeverThreshold() {
        return this.leverThreshold;
    }

    public int getMaxLever() {
        return this.maxLever;
    }

    public int getMinLever() {
        return this.minLever;
    }

    public int hashCode() {
        return ((((getMinLever() + 59) * 59) + getMaxLever()) * 59) + getLeverThreshold();
    }

    public void setLeverThreshold(int i11) {
        this.leverThreshold = i11;
    }

    public void setMaxLever(int i11) {
        this.maxLever = i11;
    }

    public void setMinLever(int i11) {
        this.minLever = i11;
    }

    public String toString() {
        return "GridLeverageRange(minLever=" + getMinLever() + ", maxLever=" + getMaxLever() + ", leverThreshold=" + getLeverThreshold() + ")";
    }
}
