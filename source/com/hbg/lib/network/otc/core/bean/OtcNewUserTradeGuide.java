package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcNewUserTradeGuide implements Serializable {
    public boolean canEqual(Object obj) {
        return obj instanceof OtcNewUserTradeGuide;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof OtcNewUserTradeGuide) && ((OtcNewUserTradeGuide) obj).canEqual(this);
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "OtcNewUserTradeGuide()";
    }
}
