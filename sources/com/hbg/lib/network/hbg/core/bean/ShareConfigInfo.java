package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ShareConfigInfo implements Serializable {
    @SerializedName("desc")
    private String desc;
    @SerializedName("name")
    private String name;
    @SerializedName("open")
    private boolean open;

    public ShareConfigInfo() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ShareConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShareConfigInfo)) {
            return false;
        }
        ShareConfigInfo shareConfigInfo = (ShareConfigInfo) obj;
        if (!shareConfigInfo.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = shareConfigInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        if (isOpen() != shareConfigInfo.isOpen()) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = shareConfigInfo.getDesc();
        return desc2 != null ? desc2.equals(desc3) : desc3 == null;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = (((name2 == null ? 43 : name2.hashCode()) + 59) * 59) + (isOpen() ? 79 : 97);
        String desc2 = getDesc();
        int i12 = hashCode * 59;
        if (desc2 != null) {
            i11 = desc2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpen(boolean z11) {
        this.open = z11;
    }

    public String toString() {
        return "ShareConfigInfo(name=" + getName() + ", open=" + isOpen() + ", desc=" + getDesc() + ")";
    }

    public ShareConfigInfo(String str, boolean z11, String str2) {
        this.name = str;
        this.open = z11;
        this.desc = str2;
    }
}
