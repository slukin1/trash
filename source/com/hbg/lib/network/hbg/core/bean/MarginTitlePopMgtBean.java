package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MarginTitlePopMgtBean implements Serializable {
    public static final int SHOW = 1;
    @SerializedName("isShow")
    private int isShow;
    @SerializedName("tag")
    private String tag;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginTitlePopMgtBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginTitlePopMgtBean)) {
            return false;
        }
        MarginTitlePopMgtBean marginTitlePopMgtBean = (MarginTitlePopMgtBean) obj;
        if (!marginTitlePopMgtBean.canEqual(this) || getIsShow() != marginTitlePopMgtBean.getIsShow()) {
            return false;
        }
        String tag2 = getTag();
        String tag3 = marginTitlePopMgtBean.getTag();
        return tag2 != null ? tag2.equals(tag3) : tag3 == null;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String tag2 = getTag();
        return ((getIsShow() + 59) * 59) + (tag2 == null ? 43 : tag2.hashCode());
    }

    public void setIsShow(int i11) {
        this.isShow = i11;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String toString() {
        return "MarginTitlePopMgtBean{isShow=" + this.isShow + ", tag='" + this.tag + '\'' + '}';
    }
}
