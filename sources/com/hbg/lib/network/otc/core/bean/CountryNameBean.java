package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class CountryNameBean implements Serializable {
    public int country_id;
    public String name;

    public boolean canEqual(Object obj) {
        return obj instanceof CountryNameBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CountryNameBean)) {
            return false;
        }
        CountryNameBean countryNameBean = (CountryNameBean) obj;
        if (!countryNameBean.canEqual(this) || getCountry_id() != countryNameBean.getCountry_id()) {
            return false;
        }
        String name2 = getName();
        String name3 = countryNameBean.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public int getCountry_id() {
        return this.country_id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String name2 = getName();
        return ((getCountry_id() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
    }

    public void setCountry_id(int i11) {
        this.country_id = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "CountryNameBean(country_id=" + getCountry_id() + ", name=" + getName() + ")";
    }
}
