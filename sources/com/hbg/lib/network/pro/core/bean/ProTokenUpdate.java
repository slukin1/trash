package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class ProTokenUpdate implements Serializable {
    public String proToken;

    public ProTokenUpdate(String str) {
        this.proToken = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ProTokenUpdate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProTokenUpdate)) {
            return false;
        }
        ProTokenUpdate proTokenUpdate = (ProTokenUpdate) obj;
        if (!proTokenUpdate.canEqual(this)) {
            return false;
        }
        String proToken2 = getProToken();
        String proToken3 = proTokenUpdate.getProToken();
        return proToken2 != null ? proToken2.equals(proToken3) : proToken3 == null;
    }

    public String getProToken() {
        return this.proToken;
    }

    public int hashCode() {
        String proToken2 = getProToken();
        return 59 + (proToken2 == null ? 43 : proToken2.hashCode());
    }

    public void setProToken(String str) {
        this.proToken = str;
    }

    public String toString() {
        return "ProTokenUpdate(proToken=" + getProToken() + ")";
    }
}
