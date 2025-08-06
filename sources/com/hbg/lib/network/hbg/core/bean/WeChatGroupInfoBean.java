package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class WeChatGroupInfoBean implements Serializable {
    private String wxCode;
    private String wxUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof WeChatGroupInfoBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WeChatGroupInfoBean)) {
            return false;
        }
        WeChatGroupInfoBean weChatGroupInfoBean = (WeChatGroupInfoBean) obj;
        if (!weChatGroupInfoBean.canEqual(this)) {
            return false;
        }
        String wxUrl2 = getWxUrl();
        String wxUrl3 = weChatGroupInfoBean.getWxUrl();
        if (wxUrl2 != null ? !wxUrl2.equals(wxUrl3) : wxUrl3 != null) {
            return false;
        }
        String wxCode2 = getWxCode();
        String wxCode3 = weChatGroupInfoBean.getWxCode();
        return wxCode2 != null ? wxCode2.equals(wxCode3) : wxCode3 == null;
    }

    public String getWxCode() {
        return this.wxCode;
    }

    public String getWxUrl() {
        return this.wxUrl;
    }

    public int hashCode() {
        String wxUrl2 = getWxUrl();
        int i11 = 43;
        int hashCode = wxUrl2 == null ? 43 : wxUrl2.hashCode();
        String wxCode2 = getWxCode();
        int i12 = (hashCode + 59) * 59;
        if (wxCode2 != null) {
            i11 = wxCode2.hashCode();
        }
        return i12 + i11;
    }

    public void setWxCode(String str) {
        this.wxCode = str;
    }

    public void setWxUrl(String str) {
        this.wxUrl = str;
    }

    public String toString() {
        return "WeChatGroupInfoBean(wxUrl=" + getWxUrl() + ", wxCode=" + getWxCode() + ")";
    }
}
