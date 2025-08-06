package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ShareConfigList implements Serializable {
    @SerializedName("platformList")
    private List<ShareConfigInfo> infoList;

    public boolean canEqual(Object obj) {
        return obj instanceof ShareConfigList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareConfigList)) {
            return false;
        }
        ShareConfigList shareConfigList = (ShareConfigList) obj;
        if (!shareConfigList.canEqual(this)) {
            return false;
        }
        List<ShareConfigInfo> infoList2 = getInfoList();
        List<ShareConfigInfo> infoList3 = shareConfigList.getInfoList();
        return infoList2 != null ? infoList2.equals(infoList3) : infoList3 == null;
    }

    public List<ShareConfigInfo> getInfoList() {
        return this.infoList;
    }

    public int hashCode() {
        List<ShareConfigInfo> infoList2 = getInfoList();
        return 59 + (infoList2 == null ? 43 : infoList2.hashCode());
    }

    public void setInfoList(List<ShareConfigInfo> list) {
        this.infoList = list;
    }

    public String toString() {
        return "ShareConfigList(infoList=" + getInfoList() + ")";
    }
}
