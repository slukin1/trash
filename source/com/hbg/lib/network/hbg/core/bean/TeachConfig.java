package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class TeachConfig implements Serializable {
    private static final long serialVersionUID = 7775208277564366656L;
    @SerializedName("videoList")
    private List<TeachConfigItem> teachConfigList;

    public boolean canEqual(Object obj) {
        return obj instanceof TeachConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeachConfig)) {
            return false;
        }
        TeachConfig teachConfig = (TeachConfig) obj;
        if (!teachConfig.canEqual(this)) {
            return false;
        }
        List<TeachConfigItem> teachConfigList2 = getTeachConfigList();
        List<TeachConfigItem> teachConfigList3 = teachConfig.getTeachConfigList();
        return teachConfigList2 != null ? teachConfigList2.equals(teachConfigList3) : teachConfigList3 == null;
    }

    public List<TeachConfigItem> getTeachConfigList() {
        return this.teachConfigList;
    }

    public int hashCode() {
        List<TeachConfigItem> teachConfigList2 = getTeachConfigList();
        return 59 + (teachConfigList2 == null ? 43 : teachConfigList2.hashCode());
    }

    public void setTeachConfigList(List<TeachConfigItem> list) {
        this.teachConfigList = list;
    }

    public String toString() {
        return "TeachConfig(teachConfigList=" + getTeachConfigList() + ")";
    }
}
