package com.hbg.lib.network.hbg.core.bean;

public class SpotConfigInfo {
    private String name;
    private String value;

    public boolean canEqual(Object obj) {
        return obj instanceof SpotConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpotConfigInfo)) {
            return false;
        }
        SpotConfigInfo spotConfigInfo = (SpotConfigInfo) obj;
        if (!spotConfigInfo.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = spotConfigInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String value2 = getValue();
        String value3 = spotConfigInfo.getValue();
        return value2 != null ? value2.equals(value3) : value3 == null;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        String value2 = getValue();
        int i12 = (hashCode + 59) * 59;
        if (value2 != null) {
            i11 = value2.hashCode();
        }
        return i12 + i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "SpotConfigInfo(name=" + getName() + ", value=" + getValue() + ")";
    }
}
