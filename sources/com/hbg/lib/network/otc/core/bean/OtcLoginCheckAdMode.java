package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcLoginCheckAdMode implements Serializable {
    public boolean canEqual(Object obj) {
        return obj instanceof OtcLoginCheckAdMode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof OtcLoginCheckAdMode) && ((OtcLoginCheckAdMode) obj).canEqual(this);
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "OtcLoginCheckAdMode()";
    }
}
