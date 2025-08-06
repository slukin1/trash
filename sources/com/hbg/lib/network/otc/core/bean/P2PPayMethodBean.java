package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class P2PPayMethodBean implements Serializable {
    private String color;
    private Boolean isRecommend;
    private String name;
    private int payMethodId;

    public boolean canEqual(Object obj) {
        return obj instanceof P2PPayMethodBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof P2PPayMethodBean)) {
            return false;
        }
        P2PPayMethodBean p2PPayMethodBean = (P2PPayMethodBean) obj;
        if (!p2PPayMethodBean.canEqual(this) || getPayMethodId() != p2PPayMethodBean.getPayMethodId()) {
            return false;
        }
        String name2 = getName();
        String name3 = p2PPayMethodBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String color2 = getColor();
        String color3 = p2PPayMethodBean.getColor();
        if (color2 != null ? !color2.equals(color3) : color3 != null) {
            return false;
        }
        Boolean isRecommend2 = getIsRecommend();
        Boolean isRecommend3 = p2PPayMethodBean.getIsRecommend();
        return isRecommend2 != null ? isRecommend2.equals(isRecommend3) : isRecommend3 == null;
    }

    public String getColor() {
        return this.color;
    }

    public Boolean getIsRecommend() {
        return this.isRecommend;
    }

    public String getName() {
        return this.name;
    }

    public int getPayMethodId() {
        return this.payMethodId;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int payMethodId2 = ((getPayMethodId() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String color2 = getColor();
        int hashCode = (payMethodId2 * 59) + (color2 == null ? 43 : color2.hashCode());
        Boolean isRecommend2 = getIsRecommend();
        int i12 = hashCode * 59;
        if (isRecommend2 != null) {
            i11 = isRecommend2.hashCode();
        }
        return i12 + i11;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setIsRecommend(Boolean bool) {
        this.isRecommend = bool;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPayMethodId(int i11) {
        this.payMethodId = i11;
    }

    public String toString() {
        return "P2PPayMethodBean(payMethodId=" + getPayMethodId() + ", name=" + getName() + ", color=" + getColor() + ", isRecommend=" + getIsRecommend() + ")";
    }
}
