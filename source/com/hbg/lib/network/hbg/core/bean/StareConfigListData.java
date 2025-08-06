package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class StareConfigListData implements Serializable {
    private List<StareInfo> list;
    private int openStare;

    public boolean canEqual(Object obj) {
        return obj instanceof StareConfigListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StareConfigListData)) {
            return false;
        }
        StareConfigListData stareConfigListData = (StareConfigListData) obj;
        if (!stareConfigListData.canEqual(this) || getOpenStare() != stareConfigListData.getOpenStare()) {
            return false;
        }
        List<StareInfo> list2 = getList();
        List<StareInfo> list3 = stareConfigListData.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public List<StareInfo> getList() {
        return this.list;
    }

    public int getOpenStare() {
        return this.openStare;
    }

    public int hashCode() {
        List<StareInfo> list2 = getList();
        return ((getOpenStare() + 59) * 59) + (list2 == null ? 43 : list2.hashCode());
    }

    public void setList(List<StareInfo> list2) {
        this.list = list2;
    }

    public void setOpenStare(int i11) {
        this.openStare = i11;
    }

    public String toString() {
        return "StareConfigListData(openStare=" + getOpenStare() + ", list=" + getList() + ")";
    }
}
