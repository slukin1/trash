package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class LiteLoginCheckInfo implements Serializable {
    private static final long serialVersionUID = 9161208049368709229L;
    private boolean liteWhitelist;

    public boolean canEqual(Object obj) {
        return obj instanceof LiteLoginCheckInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteLoginCheckInfo)) {
            return false;
        }
        LiteLoginCheckInfo liteLoginCheckInfo = (LiteLoginCheckInfo) obj;
        return liteLoginCheckInfo.canEqual(this) && isLiteWhitelist() == liteLoginCheckInfo.isLiteWhitelist();
    }

    public int hashCode() {
        return 59 + (isLiteWhitelist() ? 79 : 97);
    }

    public boolean isLiteWhitelist() {
        return this.liteWhitelist;
    }

    public void setLiteWhitelist(boolean z11) {
        this.liteWhitelist = z11;
    }

    public String toString() {
        return "LiteLoginCheckInfo(liteWhitelist=" + isLiteWhitelist() + ")";
    }
}
