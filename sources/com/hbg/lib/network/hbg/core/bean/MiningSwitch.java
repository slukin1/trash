package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class MiningSwitch implements Serializable {
    private int switchStatus;

    public boolean canEqual(Object obj) {
        return obj instanceof MiningSwitch;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MiningSwitch)) {
            return false;
        }
        MiningSwitch miningSwitch = (MiningSwitch) obj;
        return miningSwitch.canEqual(this) && getSwitchStatus() == miningSwitch.getSwitchStatus();
    }

    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public int hashCode() {
        return 59 + getSwitchStatus();
    }

    public boolean isMiningSwitchOn() {
        return this.switchStatus == 1;
    }

    public void setSwitchStatus(int i11) {
        this.switchStatus = i11;
    }

    public String toString() {
        return "MiningSwitch(switchStatus=" + getSwitchStatus() + ")";
    }
}
