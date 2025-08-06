package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcCancelActionBean implements Serializable {
    private String link;
    private String name;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcCancelActionBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcCancelActionBean)) {
            return false;
        }
        OtcCancelActionBean otcCancelActionBean = (OtcCancelActionBean) obj;
        if (!otcCancelActionBean.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = otcCancelActionBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = otcCancelActionBean.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String link2 = getLink();
        String link3 = otcCancelActionBean.getLink();
        return link2 != null ? link2.equals(link3) : link3 == null;
    }

    public String getLink() {
        return this.link;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        String type2 = getType();
        int hashCode2 = ((hashCode + 59) * 59) + (type2 == null ? 43 : type2.hashCode());
        String link2 = getLink();
        int i12 = hashCode2 * 59;
        if (link2 != null) {
            i11 = link2.hashCode();
        }
        return i12 + i11;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "OtcCancelActionBean(name=" + getName() + ", type=" + getType() + ", link=" + getLink() + ")";
    }
}
