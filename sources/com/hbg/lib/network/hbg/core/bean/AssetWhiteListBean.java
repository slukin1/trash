package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AssetWhiteListBean implements Serializable {
    public static final int SYSTEM_OK = 1;
    private int system;
    private int version;

    public boolean canEqual(Object obj) {
        return obj instanceof AssetWhiteListBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetWhiteListBean)) {
            return false;
        }
        AssetWhiteListBean assetWhiteListBean = (AssetWhiteListBean) obj;
        return assetWhiteListBean.canEqual(this) && getSystem() == assetWhiteListBean.getSystem() && getVersion() == assetWhiteListBean.getVersion();
    }

    public int getSystem() {
        return this.system;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return ((getSystem() + 59) * 59) + getVersion();
    }

    public void setSystem(int i11) {
        this.system = i11;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }

    public String toString() {
        return "AssetWhiteListBean(system=" + getSystem() + ", version=" + getVersion() + ")";
    }
}
