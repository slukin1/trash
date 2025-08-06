package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcAdvertLabelBean implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    public int f78264id;
    public String name;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcAdvertLabelBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcAdvertLabelBean)) {
            return false;
        }
        OtcAdvertLabelBean otcAdvertLabelBean = (OtcAdvertLabelBean) obj;
        if (!otcAdvertLabelBean.canEqual(this) || getId() != otcAdvertLabelBean.getId()) {
            return false;
        }
        String name2 = getName();
        String name3 = otcAdvertLabelBean.getName();
        return name2 != null ? name2.equals(name3) : name3 == null;
    }

    public int getId() {
        return this.f78264id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String name2 = getName();
        return ((getId() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
    }

    public void setId(int i11) {
        this.f78264id = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "OtcAdvertLabelBean(id=" + getId() + ", name=" + getName() + ")";
    }
}
