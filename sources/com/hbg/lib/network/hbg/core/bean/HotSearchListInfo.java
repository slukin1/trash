package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class HotSearchListInfo implements Serializable {
    private List<String> appSearchList;
    private List<String> buyCurrencyList;
    private List<String> newCurrencyList;

    public boolean canEqual(Object obj) {
        return obj instanceof HotSearchListInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotSearchListInfo)) {
            return false;
        }
        HotSearchListInfo hotSearchListInfo = (HotSearchListInfo) obj;
        if (!hotSearchListInfo.canEqual(this)) {
            return false;
        }
        List<String> buyCurrencyList2 = getBuyCurrencyList();
        List<String> buyCurrencyList3 = hotSearchListInfo.getBuyCurrencyList();
        if (buyCurrencyList2 != null ? !buyCurrencyList2.equals(buyCurrencyList3) : buyCurrencyList3 != null) {
            return false;
        }
        List<String> newCurrencyList2 = getNewCurrencyList();
        List<String> newCurrencyList3 = hotSearchListInfo.getNewCurrencyList();
        if (newCurrencyList2 != null ? !newCurrencyList2.equals(newCurrencyList3) : newCurrencyList3 != null) {
            return false;
        }
        List<String> appSearchList2 = getAppSearchList();
        List<String> appSearchList3 = hotSearchListInfo.getAppSearchList();
        return appSearchList2 != null ? appSearchList2.equals(appSearchList3) : appSearchList3 == null;
    }

    public List<String> getAppSearchList() {
        return this.appSearchList;
    }

    public List<String> getBuyCurrencyList() {
        return this.buyCurrencyList;
    }

    public List<String> getNewCurrencyList() {
        return this.newCurrencyList;
    }

    public int hashCode() {
        List<String> buyCurrencyList2 = getBuyCurrencyList();
        int i11 = 43;
        int hashCode = buyCurrencyList2 == null ? 43 : buyCurrencyList2.hashCode();
        List<String> newCurrencyList2 = getNewCurrencyList();
        int hashCode2 = ((hashCode + 59) * 59) + (newCurrencyList2 == null ? 43 : newCurrencyList2.hashCode());
        List<String> appSearchList2 = getAppSearchList();
        int i12 = hashCode2 * 59;
        if (appSearchList2 != null) {
            i11 = appSearchList2.hashCode();
        }
        return i12 + i11;
    }

    public void setAppSearchList(List<String> list) {
        this.appSearchList = list;
    }

    public void setBuyCurrencyList(List<String> list) {
        this.buyCurrencyList = list;
    }

    public void setNewCurrencyList(List<String> list) {
        this.newCurrencyList = list;
    }

    public String toString() {
        return "HotSearchListInfo(buyCurrencyList=" + getBuyCurrencyList() + ", newCurrencyList=" + getNewCurrencyList() + ", appSearchList=" + getAppSearchList() + ")";
    }
}
