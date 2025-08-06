package com.huobi.otc.bean;

import com.huobi.otc.handler.LiteSecurityMakerInfoHandler;
import s9.a;

public class LiteSecurityMakerInfoBean implements a {
    public int areaType;
    public int iconId;
    public String securityDesc = "";

    public LiteSecurityMakerInfoBean(int i11, String str, int i12) {
        this.iconId = i11;
        this.securityDesc = str;
        this.areaType = i12;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LiteSecurityMakerInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteSecurityMakerInfoBean)) {
            return false;
        }
        LiteSecurityMakerInfoBean liteSecurityMakerInfoBean = (LiteSecurityMakerInfoBean) obj;
        if (!liteSecurityMakerInfoBean.canEqual(this) || getIconId() != liteSecurityMakerInfoBean.getIconId()) {
            return false;
        }
        String securityDesc2 = getSecurityDesc();
        String securityDesc3 = liteSecurityMakerInfoBean.getSecurityDesc();
        if (securityDesc2 != null ? securityDesc2.equals(securityDesc3) : securityDesc3 == null) {
            return getAreaType() == liteSecurityMakerInfoBean.getAreaType();
        }
        return false;
    }

    public int getAreaType() {
        return this.areaType;
    }

    public int getIconId() {
        return this.iconId;
    }

    public String getSecurityDesc() {
        return this.securityDesc;
    }

    public String getViewHandlerName() {
        return LiteSecurityMakerInfoHandler.class.getName();
    }

    public int hashCode() {
        String securityDesc2 = getSecurityDesc();
        return ((((getIconId() + 59) * 59) + (securityDesc2 == null ? 43 : securityDesc2.hashCode())) * 59) + getAreaType();
    }

    public void setAreaType(int i11) {
        this.areaType = i11;
    }

    public void setIconId(int i11) {
        this.iconId = i11;
    }

    public void setSecurityDesc(String str) {
        this.securityDesc = str;
    }

    public String toString() {
        return "LiteSecurityMakerInfoBean(iconId=" + getIconId() + ", securityDesc=" + getSecurityDesc() + ", areaType=" + getAreaType() + ")";
    }
}
