package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class MktRulePageChildBean implements Serializable {
    public int index;
    public int type;
    public Object value;

    public boolean canEqual(Object obj) {
        return obj instanceof MktRulePageChildBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MktRulePageChildBean)) {
            return false;
        }
        MktRulePageChildBean mktRulePageChildBean = (MktRulePageChildBean) obj;
        if (!mktRulePageChildBean.canEqual(this)) {
            return false;
        }
        Object value2 = getValue();
        Object value3 = mktRulePageChildBean.getValue();
        if (value2 != null ? value2.equals(value3) : value3 == null) {
            return getType() == mktRulePageChildBean.getType() && getIndex() == mktRulePageChildBean.getIndex();
        }
        return false;
    }

    public int getIndex() {
        return this.index;
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object value2 = getValue();
        return (((((value2 == null ? 43 : value2.hashCode()) + 59) * 59) + getType()) * 59) + getIndex();
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        return "MktRulePageChildBean(value=" + getValue() + ", type=" + getType() + ", index=" + getIndex() + ")";
    }
}
