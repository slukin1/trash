package com.hbg.lib.network.pro.socket.bean;

import java.io.Serializable;

public class EtpNav implements Serializable {
    private static final long serialVersionUID = 696108522552887947L;
    private float nav;
    private long navTime;
    private float outstanding;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof EtpNav;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpNav)) {
            return false;
        }
        EtpNav etpNav = (EtpNav) obj;
        if (!etpNav.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = etpNav.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return Float.compare(getNav(), etpNav.getNav()) == 0 && getNavTime() == etpNav.getNavTime() && Float.compare(getOutstanding(), etpNav.getOutstanding()) == 0;
        }
        return false;
    }

    public float getNav() {
        return this.nav;
    }

    public long getNavTime() {
        return this.navTime;
    }

    public float getOutstanding() {
        return this.outstanding;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int hashCode = (((symbol2 == null ? 43 : symbol2.hashCode()) + 59) * 59) + Float.floatToIntBits(getNav());
        long navTime2 = getNavTime();
        return (((hashCode * 59) + ((int) (navTime2 ^ (navTime2 >>> 32)))) * 59) + Float.floatToIntBits(getOutstanding());
    }

    public void setNav(float f11) {
        this.nav = f11;
    }

    public void setNavTime(long j11) {
        this.navTime = j11;
    }

    public void setOutstanding(float f11) {
        this.outstanding = f11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "EtpNav(symbol=" + getSymbol() + ", nav=" + getNav() + ", navTime=" + getNavTime() + ", outstanding=" + getOutstanding() + ")";
    }
}
