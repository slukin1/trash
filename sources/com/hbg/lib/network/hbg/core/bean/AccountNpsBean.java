package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AccountNpsBean implements Serializable {
    private String jumpUrl;
    private int showNps;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountNpsBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountNpsBean)) {
            return false;
        }
        AccountNpsBean accountNpsBean = (AccountNpsBean) obj;
        if (!accountNpsBean.canEqual(this) || getShowNps() != accountNpsBean.getShowNps()) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = accountNpsBean.getJumpUrl();
        return jumpUrl2 != null ? jumpUrl2.equals(jumpUrl3) : jumpUrl3 == null;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getShowNps() {
        return this.showNps;
    }

    public int hashCode() {
        String jumpUrl2 = getJumpUrl();
        return ((getShowNps() + 59) * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setShowNps(int i11) {
        this.showNps = i11;
    }

    public String toString() {
        return "AccountNpsBean(showNps=" + getShowNps() + ", jumpUrl=" + getJumpUrl() + ")";
    }
}
