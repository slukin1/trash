package com.huobi.entity;

import java.io.Serializable;

public class SelectData implements Serializable {
    private String name;
    private long selectId;

    public boolean canEqual(Object obj) {
        return obj instanceof SelectData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SelectData)) {
            return false;
        }
        SelectData selectData = (SelectData) obj;
        if (!selectData.canEqual(this) || getSelectId() != selectData.getSelectId()) {
            return false;
        }
        String name2 = getName();
        String name3 = selectData.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public String getName() {
        return this.name;
    }

    public long getSelectId() {
        return this.selectId;
    }

    public int hashCode() {
        long selectId2 = getSelectId();
        String name2 = getName();
        return ((((int) (selectId2 ^ (selectId2 >>> 32))) + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelectId(long j11) {
        this.selectId = j11;
    }

    public String toString() {
        return "SelectData(selectId=" + getSelectId() + ", name=" + getName() + ")";
    }
}
