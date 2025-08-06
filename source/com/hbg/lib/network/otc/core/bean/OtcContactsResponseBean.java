package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class OtcContactsResponseBean implements Serializable {
    private List<Map> contacts;
    private boolean isShow;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcContactsResponseBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcContactsResponseBean)) {
            return false;
        }
        OtcContactsResponseBean otcContactsResponseBean = (OtcContactsResponseBean) obj;
        if (!otcContactsResponseBean.canEqual(this) || isShow() != otcContactsResponseBean.isShow()) {
            return false;
        }
        List<Map> contacts2 = getContacts();
        List<Map> contacts3 = otcContactsResponseBean.getContacts();
        return contacts2 != null ? contacts2.equals(contacts3) : contacts3 == null;
    }

    public List<Map> getContacts() {
        return this.contacts;
    }

    public int hashCode() {
        int i11 = isShow() ? 79 : 97;
        List<Map> contacts2 = getContacts();
        return ((i11 + 59) * 59) + (contacts2 == null ? 43 : contacts2.hashCode());
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setContacts(List<Map> list) {
        this.contacts = list;
    }

    public void setShow(boolean z11) {
        this.isShow = z11;
    }

    public String toString() {
        return "OtcContactsResponseBean(isShow=" + isShow() + ", contacts=" + getContacts() + ")";
    }
}
