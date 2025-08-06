package com.huobi.otc.event;

import java.io.Serializable;

public class LinksJumpOtcEvent implements Serializable {
    public String cryptoName;
    public String fiatName;
    public int siteType = 1;

    public boolean canEqual(Object obj) {
        return obj instanceof LinksJumpOtcEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinksJumpOtcEvent)) {
            return false;
        }
        LinksJumpOtcEvent linksJumpOtcEvent = (LinksJumpOtcEvent) obj;
        if (!linksJumpOtcEvent.canEqual(this)) {
            return false;
        }
        String cryptoName2 = getCryptoName();
        String cryptoName3 = linksJumpOtcEvent.getCryptoName();
        if (cryptoName2 != null ? !cryptoName2.equals(cryptoName3) : cryptoName3 != null) {
            return false;
        }
        String fiatName2 = getFiatName();
        String fiatName3 = linksJumpOtcEvent.getFiatName();
        if (fiatName2 != null ? fiatName2.equals(fiatName3) : fiatName3 == null) {
            return getSiteType() == linksJumpOtcEvent.getSiteType();
        }
        return false;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public String getFiatName() {
        return this.fiatName;
    }

    public int getSiteType() {
        return this.siteType;
    }

    public int hashCode() {
        String cryptoName2 = getCryptoName();
        int i11 = 43;
        int hashCode = cryptoName2 == null ? 43 : cryptoName2.hashCode();
        String fiatName2 = getFiatName();
        int i12 = (hashCode + 59) * 59;
        if (fiatName2 != null) {
            i11 = fiatName2.hashCode();
        }
        return ((i12 + i11) * 59) + getSiteType();
    }

    public void setCryptoName(String str) {
        this.cryptoName = str;
    }

    public void setFiatName(String str) {
        this.fiatName = str;
    }

    public void setSiteType(int i11) {
        this.siteType = i11;
    }

    public String toString() {
        return "LinksJumpOtcEvent(cryptoName=" + getCryptoName() + ", fiatName=" + getFiatName() + ", siteType=" + getSiteType() + ")";
    }
}
