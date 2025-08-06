package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HbgRankMapInfo implements Serializable {
    @SerializedName("all")
    private List<HbgSymbolPrice> allUpDownList = new ArrayList();
    @SerializedName("btc")
    private List<HbgSymbolPrice> btcUpDownList = new ArrayList();
    @SerializedName("etp")
    private List<HbgSymbolPrice> etpUpDownList = new ArrayList();
    @SerializedName("ht")
    private List<HbgSymbolPrice> htUpDownList = new ArrayList();
    @SerializedName("usdt")
    private List<HbgSymbolPrice> usdtUpDownList = new ArrayList();

    public boolean canEqual(Object obj) {
        return obj instanceof HbgRankMapInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgRankMapInfo)) {
            return false;
        }
        HbgRankMapInfo hbgRankMapInfo = (HbgRankMapInfo) obj;
        if (!hbgRankMapInfo.canEqual(this)) {
            return false;
        }
        List<HbgSymbolPrice> allUpDownList2 = getAllUpDownList();
        List<HbgSymbolPrice> allUpDownList3 = hbgRankMapInfo.getAllUpDownList();
        if (allUpDownList2 != null ? !allUpDownList2.equals(allUpDownList3) : allUpDownList3 != null) {
            return false;
        }
        List<HbgSymbolPrice> htUpDownList2 = getHtUpDownList();
        List<HbgSymbolPrice> htUpDownList3 = hbgRankMapInfo.getHtUpDownList();
        if (htUpDownList2 != null ? !htUpDownList2.equals(htUpDownList3) : htUpDownList3 != null) {
            return false;
        }
        List<HbgSymbolPrice> usdtUpDownList2 = getUsdtUpDownList();
        List<HbgSymbolPrice> usdtUpDownList3 = hbgRankMapInfo.getUsdtUpDownList();
        if (usdtUpDownList2 != null ? !usdtUpDownList2.equals(usdtUpDownList3) : usdtUpDownList3 != null) {
            return false;
        }
        List<HbgSymbolPrice> btcUpDownList2 = getBtcUpDownList();
        List<HbgSymbolPrice> btcUpDownList3 = hbgRankMapInfo.getBtcUpDownList();
        if (btcUpDownList2 != null ? !btcUpDownList2.equals(btcUpDownList3) : btcUpDownList3 != null) {
            return false;
        }
        List<HbgSymbolPrice> etpUpDownList2 = getEtpUpDownList();
        List<HbgSymbolPrice> etpUpDownList3 = hbgRankMapInfo.getEtpUpDownList();
        return etpUpDownList2 != null ? etpUpDownList2.equals(etpUpDownList3) : etpUpDownList3 == null;
    }

    public List<HbgSymbolPrice> getAllUpDownList() {
        return this.allUpDownList;
    }

    public List<HbgSymbolPrice> getBtcUpDownList() {
        return this.btcUpDownList;
    }

    public List<HbgSymbolPrice> getEtpUpDownList() {
        return this.etpUpDownList;
    }

    public List<HbgSymbolPrice> getHtUpDownList() {
        return this.htUpDownList;
    }

    public List<HbgSymbolPrice> getUsdtUpDownList() {
        return this.usdtUpDownList;
    }

    public int hashCode() {
        List<HbgSymbolPrice> allUpDownList2 = getAllUpDownList();
        int i11 = 43;
        int hashCode = allUpDownList2 == null ? 43 : allUpDownList2.hashCode();
        List<HbgSymbolPrice> htUpDownList2 = getHtUpDownList();
        int hashCode2 = ((hashCode + 59) * 59) + (htUpDownList2 == null ? 43 : htUpDownList2.hashCode());
        List<HbgSymbolPrice> usdtUpDownList2 = getUsdtUpDownList();
        int hashCode3 = (hashCode2 * 59) + (usdtUpDownList2 == null ? 43 : usdtUpDownList2.hashCode());
        List<HbgSymbolPrice> btcUpDownList2 = getBtcUpDownList();
        int hashCode4 = (hashCode3 * 59) + (btcUpDownList2 == null ? 43 : btcUpDownList2.hashCode());
        List<HbgSymbolPrice> etpUpDownList2 = getEtpUpDownList();
        int i12 = hashCode4 * 59;
        if (etpUpDownList2 != null) {
            i11 = etpUpDownList2.hashCode();
        }
        return i12 + i11;
    }

    public void setAllUpDownList(List<HbgSymbolPrice> list) {
        this.allUpDownList = list;
    }

    public void setBtcUpDownList(List<HbgSymbolPrice> list) {
        this.btcUpDownList = list;
    }

    public void setEtpUpDownList(List<HbgSymbolPrice> list) {
        this.etpUpDownList = list;
    }

    public void setHtUpDownList(List<HbgSymbolPrice> list) {
        this.htUpDownList = list;
    }

    public void setUsdtUpDownList(List<HbgSymbolPrice> list) {
        this.usdtUpDownList = list;
    }

    public String toString() {
        return "HbgRankMapInfo(allUpDownList=" + getAllUpDownList() + ", htUpDownList=" + getHtUpDownList() + ", usdtUpDownList=" + getUsdtUpDownList() + ", btcUpDownList=" + getBtcUpDownList() + ", etpUpDownList=" + getEtpUpDownList() + ")";
    }
}
