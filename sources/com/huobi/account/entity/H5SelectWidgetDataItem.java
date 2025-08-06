package com.huobi.account.entity;

import java.io.Serializable;

public class H5SelectWidgetDataItem implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private long f40980id;
    private String name;

    public boolean canEqual(Object obj) {
        return obj instanceof H5SelectWidgetDataItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H5SelectWidgetDataItem)) {
            return false;
        }
        H5SelectWidgetDataItem h5SelectWidgetDataItem = (H5SelectWidgetDataItem) obj;
        if (!h5SelectWidgetDataItem.canEqual(this) || getId() != h5SelectWidgetDataItem.getId()) {
            return false;
        }
        String name2 = getName();
        String name3 = h5SelectWidgetDataItem.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public long getId() {
        return this.f40980id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        long id2 = getId();
        String name2 = getName();
        return ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
    }

    public void setId(long j11) {
        this.f40980id = j11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "H5SelectWidgetDataItem(id=" + getId() + ", name=" + getName() + ")";
    }
}
