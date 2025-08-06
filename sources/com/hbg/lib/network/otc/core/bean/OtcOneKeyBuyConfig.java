package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcOneKeyBuyConfig implements Serializable {
    private List<Integer> coinList;
    private List<Integer> payList;
    private long updateTime = 0;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOneKeyBuyConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOneKeyBuyConfig)) {
            return false;
        }
        OtcOneKeyBuyConfig otcOneKeyBuyConfig = (OtcOneKeyBuyConfig) obj;
        if (!otcOneKeyBuyConfig.canEqual(this)) {
            return false;
        }
        List<Integer> coinList2 = getCoinList();
        List<Integer> coinList3 = otcOneKeyBuyConfig.getCoinList();
        if (coinList2 != null ? !coinList2.equals(coinList3) : coinList3 != null) {
            return false;
        }
        List<Integer> payList2 = getPayList();
        List<Integer> payList3 = otcOneKeyBuyConfig.getPayList();
        if (payList2 != null ? payList2.equals(payList3) : payList3 == null) {
            return getUpdateTime() == otcOneKeyBuyConfig.getUpdateTime();
        }
        return false;
    }

    public List<Integer> getCoinList() {
        return this.coinList;
    }

    public List<Integer> getPayList() {
        return this.payList;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        List<Integer> coinList2 = getCoinList();
        int i11 = 43;
        int hashCode = coinList2 == null ? 43 : coinList2.hashCode();
        List<Integer> payList2 = getPayList();
        int i12 = (hashCode + 59) * 59;
        if (payList2 != null) {
            i11 = payList2.hashCode();
        }
        long updateTime2 = getUpdateTime();
        return ((i12 + i11) * 59) + ((int) ((updateTime2 >>> 32) ^ updateTime2));
    }

    public void setCoinList(List<Integer> list) {
        this.coinList = list;
    }

    public void setPayList(List<Integer> list) {
        this.payList = list;
    }

    public void setUpdateTime(long j11) {
        this.updateTime = j11;
    }

    public String toString() {
        return "OtcOneKeyBuyConfig(coinList=" + getCoinList() + ", payList=" + getPayList() + ", updateTime=" + getUpdateTime() + ")";
    }
}
