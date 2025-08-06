package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcAppIdConfigInfo implements Serializable {
    public String BRL;
    public String EUR;
    public String GBP;
    public String RUB;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcAppIdConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcAppIdConfigInfo)) {
            return false;
        }
        OtcAppIdConfigInfo otcAppIdConfigInfo = (OtcAppIdConfigInfo) obj;
        if (!otcAppIdConfigInfo.canEqual(this)) {
            return false;
        }
        String rub = getRUB();
        String rub2 = otcAppIdConfigInfo.getRUB();
        if (rub != null ? !rub.equals(rub2) : rub2 != null) {
            return false;
        }
        String gbp = getGBP();
        String gbp2 = otcAppIdConfigInfo.getGBP();
        if (gbp != null ? !gbp.equals(gbp2) : gbp2 != null) {
            return false;
        }
        String eur = getEUR();
        String eur2 = otcAppIdConfigInfo.getEUR();
        if (eur != null ? !eur.equals(eur2) : eur2 != null) {
            return false;
        }
        String brl = getBRL();
        String brl2 = otcAppIdConfigInfo.getBRL();
        return brl != null ? brl.equals(brl2) : brl2 == null;
    }

    public String getBRL() {
        return this.BRL;
    }

    public String getEUR() {
        return this.EUR;
    }

    public String getGBP() {
        return this.GBP;
    }

    public String getRUB() {
        return this.RUB;
    }

    public int hashCode() {
        String rub = getRUB();
        int i11 = 43;
        int hashCode = rub == null ? 43 : rub.hashCode();
        String gbp = getGBP();
        int hashCode2 = ((hashCode + 59) * 59) + (gbp == null ? 43 : gbp.hashCode());
        String eur = getEUR();
        int hashCode3 = (hashCode2 * 59) + (eur == null ? 43 : eur.hashCode());
        String brl = getBRL();
        int i12 = hashCode3 * 59;
        if (brl != null) {
            i11 = brl.hashCode();
        }
        return i12 + i11;
    }

    public void setBRL(String str) {
        this.BRL = str;
    }

    public void setEUR(String str) {
        this.EUR = str;
    }

    public void setGBP(String str) {
        this.GBP = str;
    }

    public void setRUB(String str) {
        this.RUB = str;
    }

    public String toString() {
        return "OtcAppIdConfigInfo(RUB=" + getRUB() + ", GBP=" + getGBP() + ", EUR=" + getEUR() + ", BRL=" + getBRL() + ")";
    }
}
