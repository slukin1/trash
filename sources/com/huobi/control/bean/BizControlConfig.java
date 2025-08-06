package com.huobi.control.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class BizControlConfig implements Serializable {
    private static final long serialVersionUID = -791927911413469216L;
    @SerializedName("controlList")
    private List<BizControlConfigItem> controlList;

    public boolean canEqual(Object obj) {
        return obj instanceof BizControlConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BizControlConfig)) {
            return false;
        }
        BizControlConfig bizControlConfig = (BizControlConfig) obj;
        if (!bizControlConfig.canEqual(this)) {
            return false;
        }
        List<BizControlConfigItem> controlList2 = getControlList();
        List<BizControlConfigItem> controlList3 = bizControlConfig.getControlList();
        return controlList2 != null ? controlList2.equals(controlList3) : controlList3 == null;
    }

    public List<BizControlConfigItem> getControlList() {
        return this.controlList;
    }

    public int hashCode() {
        List<BizControlConfigItem> controlList2 = getControlList();
        return 59 + (controlList2 == null ? 43 : controlList2.hashCode());
    }

    public void setControlList(List<BizControlConfigItem> list) {
        this.controlList = list;
    }

    public String toString() {
        return "BizControlConfig(controlList=" + getControlList() + ")";
    }
}
