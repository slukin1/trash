package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcUniversalAssetBean implements Serializable {
    private String fullName;
    private String name;
    private int scale;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcUniversalAssetBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcUniversalAssetBean)) {
            return false;
        }
        OtcUniversalAssetBean otcUniversalAssetBean = (OtcUniversalAssetBean) obj;
        if (!otcUniversalAssetBean.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = otcUniversalAssetBean.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String fullName2 = getFullName();
        String fullName3 = otcUniversalAssetBean.getFullName();
        if (fullName2 != null ? !fullName2.equals(fullName3) : fullName3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = otcUniversalAssetBean.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return getScale() == otcUniversalAssetBean.getScale();
        }
        return false;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getName() {
        return this.name;
    }

    public int getScale() {
        return this.scale;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        String fullName2 = getFullName();
        int hashCode2 = ((hashCode + 59) * 59) + (fullName2 == null ? 43 : fullName2.hashCode());
        String symbol2 = getSymbol();
        int i12 = hashCode2 * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
        }
        return ((i12 + i11) * 59) + getScale();
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setScale(int i11) {
        this.scale = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "OtcUniversalAssetBean(name=" + getName() + ", fullName=" + getFullName() + ", symbol=" + getSymbol() + ", scale=" + getScale() + ")";
    }
}
