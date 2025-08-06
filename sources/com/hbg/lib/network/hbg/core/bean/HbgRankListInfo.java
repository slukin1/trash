package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HbgRankListInfo implements Serializable {
    private HbgRankMapInfo declineMap = new HbgRankMapInfo();
    private List<HbgSymbolPrice> hotList = new ArrayList();
    private boolean loadedError = false;
    private List<HbgSymbolPrice> newCurrencyList = new ArrayList();
    private List<HbgSymbolPrice> turnOverList = new ArrayList();
    private HbgRankMapInfo upDownMap = new HbgRankMapInfo();

    public boolean canEqual(Object obj) {
        return obj instanceof HbgRankListInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HbgRankListInfo)) {
            return false;
        }
        HbgRankListInfo hbgRankListInfo = (HbgRankListInfo) obj;
        if (!hbgRankListInfo.canEqual(this) || isLoadedError() != hbgRankListInfo.isLoadedError()) {
            return false;
        }
        List<HbgSymbolPrice> turnOverList2 = getTurnOverList();
        List<HbgSymbolPrice> turnOverList3 = hbgRankListInfo.getTurnOverList();
        if (turnOverList2 != null ? !turnOverList2.equals(turnOverList3) : turnOverList3 != null) {
            return false;
        }
        List<HbgSymbolPrice> hotList2 = getHotList();
        List<HbgSymbolPrice> hotList3 = hbgRankListInfo.getHotList();
        if (hotList2 != null ? !hotList2.equals(hotList3) : hotList3 != null) {
            return false;
        }
        List<HbgSymbolPrice> newCurrencyList2 = getNewCurrencyList();
        List<HbgSymbolPrice> newCurrencyList3 = hbgRankListInfo.getNewCurrencyList();
        if (newCurrencyList2 != null ? !newCurrencyList2.equals(newCurrencyList3) : newCurrencyList3 != null) {
            return false;
        }
        HbgRankMapInfo upDownMap2 = getUpDownMap();
        HbgRankMapInfo upDownMap3 = hbgRankListInfo.getUpDownMap();
        if (upDownMap2 != null ? !upDownMap2.equals(upDownMap3) : upDownMap3 != null) {
            return false;
        }
        HbgRankMapInfo declineMap2 = getDeclineMap();
        HbgRankMapInfo declineMap3 = hbgRankListInfo.getDeclineMap();
        return declineMap2 != null ? declineMap2.equals(declineMap3) : declineMap3 == null;
    }

    public HbgRankMapInfo getDeclineMap() {
        return this.declineMap;
    }

    public List<HbgSymbolPrice> getHotList() {
        return this.hotList;
    }

    public List<HbgSymbolPrice> getNewCurrencyList() {
        return this.newCurrencyList;
    }

    public List<HbgSymbolPrice> getTurnOverList() {
        return this.turnOverList;
    }

    public HbgRankMapInfo getUpDownMap() {
        return this.upDownMap;
    }

    public int hashCode() {
        int i11 = isLoadedError() ? 79 : 97;
        List<HbgSymbolPrice> turnOverList2 = getTurnOverList();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (turnOverList2 == null ? 43 : turnOverList2.hashCode());
        List<HbgSymbolPrice> hotList2 = getHotList();
        int hashCode2 = (hashCode * 59) + (hotList2 == null ? 43 : hotList2.hashCode());
        List<HbgSymbolPrice> newCurrencyList2 = getNewCurrencyList();
        int hashCode3 = (hashCode2 * 59) + (newCurrencyList2 == null ? 43 : newCurrencyList2.hashCode());
        HbgRankMapInfo upDownMap2 = getUpDownMap();
        int hashCode4 = (hashCode3 * 59) + (upDownMap2 == null ? 43 : upDownMap2.hashCode());
        HbgRankMapInfo declineMap2 = getDeclineMap();
        int i13 = hashCode4 * 59;
        if (declineMap2 != null) {
            i12 = declineMap2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isLoadedError() {
        return this.loadedError;
    }

    public void setDeclineMap(HbgRankMapInfo hbgRankMapInfo) {
        this.declineMap = hbgRankMapInfo;
    }

    public void setHotList(List<HbgSymbolPrice> list) {
        this.hotList = list;
    }

    public void setLoadedError(boolean z11) {
        this.loadedError = z11;
    }

    public void setNewCurrencyList(List<HbgSymbolPrice> list) {
        this.newCurrencyList = list;
    }

    public void setTurnOverList(List<HbgSymbolPrice> list) {
        this.turnOverList = list;
    }

    public void setUpDownMap(HbgRankMapInfo hbgRankMapInfo) {
        this.upDownMap = hbgRankMapInfo;
    }

    public String toString() {
        return "HbgRankListInfo(loadedError=" + isLoadedError() + ", turnOverList=" + getTurnOverList() + ", hotList=" + getHotList() + ", newCurrencyList=" + getNewCurrencyList() + ", upDownMap=" + getUpDownMap() + ", declineMap=" + getDeclineMap() + ")";
    }
}
