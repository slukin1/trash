package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class HbgDialogShowFrequency implements Serializable {
    private static final long serialVersionUID = 7869970754117699966L;
    public int maxTimes;
    public int step;
    public String unitType;

    public boolean canEqual(Object obj) {
        return obj instanceof HbgDialogShowFrequency;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgDialogShowFrequency)) {
            return false;
        }
        HbgDialogShowFrequency hbgDialogShowFrequency = (HbgDialogShowFrequency) obj;
        if (!hbgDialogShowFrequency.canEqual(this)) {
            return false;
        }
        String unitType2 = getUnitType();
        String unitType3 = hbgDialogShowFrequency.getUnitType();
        if (unitType2 != null ? unitType2.equals(unitType3) : unitType3 == null) {
            return getStep() == hbgDialogShowFrequency.getStep() && getMaxTimes() == hbgDialogShowFrequency.getMaxTimes();
        }
        return false;
    }

    public int getMaxTimes() {
        return this.maxTimes;
    }

    public int getStep() {
        return this.step;
    }

    public String getUnitType() {
        return this.unitType;
    }

    public int hashCode() {
        String unitType2 = getUnitType();
        return (((((unitType2 == null ? 43 : unitType2.hashCode()) + 59) * 59) + getStep()) * 59) + getMaxTimes();
    }

    public void setMaxTimes(int i11) {
        this.maxTimes = i11;
    }

    public void setStep(int i11) {
        this.step = i11;
    }

    public void setUnitType(String str) {
        this.unitType = str;
    }

    public String toString() {
        return "HbgDialogShowFrequency(unitType=" + getUnitType() + ", step=" + getStep() + ", maxTimes=" + getMaxTimes() + ")";
    }
}
