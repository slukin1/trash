package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class FunctionAvailableBean implements Serializable {
    private Boolean available;
    private Boolean open;

    public boolean canEqual(Object obj) {
        return obj instanceof FunctionAvailableBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionAvailableBean)) {
            return false;
        }
        FunctionAvailableBean functionAvailableBean = (FunctionAvailableBean) obj;
        if (!functionAvailableBean.canEqual(this)) {
            return false;
        }
        Boolean available2 = getAvailable();
        Boolean available3 = functionAvailableBean.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        Boolean open2 = getOpen();
        Boolean open3 = functionAvailableBean.getOpen();
        return open2 != null ? open2.equals(open3) : open3 == null;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public Boolean getOpen() {
        return this.open;
    }

    public int hashCode() {
        Boolean available2 = getAvailable();
        int i11 = 43;
        int hashCode = available2 == null ? 43 : available2.hashCode();
        Boolean open2 = getOpen();
        int i12 = (hashCode + 59) * 59;
        if (open2 != null) {
            i11 = open2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailable(Boolean bool) {
        this.available = bool;
    }

    public void setOpen(Boolean bool) {
        this.open = bool;
    }

    public String toString() {
        return "FunctionAvailableBean(available=" + getAvailable() + ", open=" + getOpen() + ")";
    }
}
