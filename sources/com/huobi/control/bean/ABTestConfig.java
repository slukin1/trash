package com.huobi.control.bean;

import java.io.Serializable;

public class ABTestConfig implements Serializable {
    private String name;

    public boolean canEqual(Object obj) {
        return obj instanceof ABTestConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ABTestConfig)) {
            return false;
        }
        ABTestConfig aBTestConfig = (ABTestConfig) obj;
        if (!aBTestConfig.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = aBTestConfig.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String name2 = getName();
        return 59 + (name2 == null ? 43 : name2.hashCode());
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ABTestConfig(name=" + getName() + ")";
    }
}
