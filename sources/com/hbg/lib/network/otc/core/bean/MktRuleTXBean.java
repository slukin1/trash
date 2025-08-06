package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class MktRuleTXBean implements Serializable {
    public String link;
    public String name;
    public String title;
    public String type;
    public String variable;

    public boolean canEqual(Object obj) {
        return obj instanceof MktRuleTXBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MktRuleTXBean)) {
            return false;
        }
        MktRuleTXBean mktRuleTXBean = (MktRuleTXBean) obj;
        if (!mktRuleTXBean.canEqual(this)) {
            return false;
        }
        String variable2 = getVariable();
        String variable3 = mktRuleTXBean.getVariable();
        if (variable2 != null ? !variable2.equals(variable3) : variable3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = mktRuleTXBean.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = mktRuleTXBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String link2 = getLink();
        String link3 = mktRuleTXBean.getLink();
        if (link2 != null ? !link2.equals(link3) : link3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = mktRuleTXBean.getTitle();
        return title2 != null ? title2.equals(title3) : title3 == null;
    }

    public String getLink() {
        return this.link;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getVariable() {
        return this.variable;
    }

    public int hashCode() {
        String variable2 = getVariable();
        int i11 = 43;
        int hashCode = variable2 == null ? 43 : variable2.hashCode();
        String type2 = getType();
        int hashCode2 = ((hashCode + 59) * 59) + (type2 == null ? 43 : type2.hashCode());
        String name2 = getName();
        int hashCode3 = (hashCode2 * 59) + (name2 == null ? 43 : name2.hashCode());
        String link2 = getLink();
        int hashCode4 = (hashCode3 * 59) + (link2 == null ? 43 : link2.hashCode());
        String title2 = getTitle();
        int i12 = hashCode4 * 59;
        if (title2 != null) {
            i11 = title2.hashCode();
        }
        return i12 + i11;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVariable(String str) {
        this.variable = str;
    }

    public String toString() {
        return "MktRuleTXBean(variable=" + getVariable() + ", type=" + getType() + ", name=" + getName() + ", link=" + getLink() + ", title=" + getTitle() + ")";
    }
}
