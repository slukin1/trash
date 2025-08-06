package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OtcQueryData implements Serializable {
    public static final int TYPE_AVAIL = 0;
    public static final int TYPE_BORROW = 2;
    public static final int TYPE_FROZEN = 1;
    private static final long serialVersionUID = 6361154256339381705L;
    @SerializedName("total")
    private String available;
    private String borrow;
    private int coinId;
    private String coinName;
    private String frozen;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcQueryData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcQueryData)) {
            return false;
        }
        OtcQueryData otcQueryData = (OtcQueryData) obj;
        if (!otcQueryData.canEqual(this) || getCoinId() != otcQueryData.getCoinId()) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = otcQueryData.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String frozen2 = getFrozen();
        String frozen3 = otcQueryData.getFrozen();
        if (frozen2 != null ? !frozen2.equals(frozen3) : frozen3 != null) {
            return false;
        }
        String borrow2 = getBorrow();
        String borrow3 = otcQueryData.getBorrow();
        if (borrow2 != null ? !borrow2.equals(borrow3) : borrow3 != null) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = otcQueryData.getCoinName();
        return coinName2 != null ? coinName2.equals(coinName3) : coinName3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getBorrow() {
        return this.borrow;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public String getFrozen() {
        return this.frozen;
    }

    public int hashCode() {
        String available2 = getAvailable();
        int i11 = 43;
        int coinId2 = ((getCoinId() + 59) * 59) + (available2 == null ? 43 : available2.hashCode());
        String frozen2 = getFrozen();
        int hashCode = (coinId2 * 59) + (frozen2 == null ? 43 : frozen2.hashCode());
        String borrow2 = getBorrow();
        int hashCode2 = (hashCode * 59) + (borrow2 == null ? 43 : borrow2.hashCode());
        String coinName2 = getCoinName();
        int i12 = hashCode2 * 59;
        if (coinName2 != null) {
            i11 = coinName2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setBorrow(String str) {
        this.borrow = str;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setFrozen(String str) {
        this.frozen = str;
    }

    public String toString() {
        return "OtcQueryData(coinId=" + getCoinId() + ", available=" + getAvailable() + ", frozen=" + getFrozen() + ", borrow=" + getBorrow() + ", coinName=" + getCoinName() + ")";
    }
}
