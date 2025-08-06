package com.huobi.account.entity;

import java.io.Serializable;
import java.util.List;

public class H5SelectWidgetData implements Serializable {
    private long defaultId;
    private List<H5SelectWidgetDataItem> list;

    public boolean canEqual(Object obj) {
        return obj instanceof H5SelectWidgetData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H5SelectWidgetData)) {
            return false;
        }
        H5SelectWidgetData h5SelectWidgetData = (H5SelectWidgetData) obj;
        if (!h5SelectWidgetData.canEqual(this) || getDefaultId() != h5SelectWidgetData.getDefaultId()) {
            return false;
        }
        List<H5SelectWidgetDataItem> list2 = getList();
        List<H5SelectWidgetDataItem> list3 = h5SelectWidgetData.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public long getDefaultId() {
        return this.defaultId;
    }

    public List<H5SelectWidgetDataItem> getList() {
        return this.list;
    }

    public int hashCode() {
        long defaultId2 = getDefaultId();
        List<H5SelectWidgetDataItem> list2 = getList();
        return ((((int) (defaultId2 ^ (defaultId2 >>> 32))) + 59) * 59) + (list2 == null ? 43 : list2.hashCode());
    }

    public void setDefaultId(long j11) {
        this.defaultId = j11;
    }

    public void setList(List<H5SelectWidgetDataItem> list2) {
        this.list = list2;
    }

    public String toString() {
        return "H5SelectWidgetData(defaultId=" + getDefaultId() + ", list=" + getList() + ")";
    }
}
