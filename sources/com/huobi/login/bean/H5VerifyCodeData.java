package com.huobi.login.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.login.usercenter.data.source.bean.RiskControl;
import java.io.Serializable;
import java.util.List;

public class H5VerifyCodeData implements Serializable {
    private static final long serialVersionUID = 5671025350146203612L;
    private List<RiskControl.ItemsBean> items;
    @SerializedName("login_name")
    private String loginName;
    private int platform;
    private String scene;
    private int version = 3;

    public H5VerifyCodeData(String str, String str2, int i11, List<RiskControl.ItemsBean> list) {
        setLoginName(str);
        setScene(str2);
        setPlatform(i11);
        setItems(list);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof H5VerifyCodeData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof H5VerifyCodeData)) {
            return false;
        }
        H5VerifyCodeData h5VerifyCodeData = (H5VerifyCodeData) obj;
        if (!h5VerifyCodeData.canEqual(this)) {
            return false;
        }
        String loginName2 = getLoginName();
        String loginName3 = h5VerifyCodeData.getLoginName();
        if (loginName2 != null ? !loginName2.equals(loginName3) : loginName3 != null) {
            return false;
        }
        String scene2 = getScene();
        String scene3 = h5VerifyCodeData.getScene();
        if (scene2 != null ? !scene2.equals(scene3) : scene3 != null) {
            return false;
        }
        if (getPlatform() != h5VerifyCodeData.getPlatform()) {
            return false;
        }
        List<RiskControl.ItemsBean> items2 = getItems();
        List<RiskControl.ItemsBean> items3 = h5VerifyCodeData.getItems();
        if (items2 != null ? items2.equals(items3) : items3 == null) {
            return getVersion() == h5VerifyCodeData.getVersion();
        }
        return false;
    }

    public List<RiskControl.ItemsBean> getItems() {
        return this.items;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getScene() {
        return this.scene;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        String loginName2 = getLoginName();
        int i11 = 43;
        int hashCode = loginName2 == null ? 43 : loginName2.hashCode();
        String scene2 = getScene();
        int hashCode2 = ((((hashCode + 59) * 59) + (scene2 == null ? 43 : scene2.hashCode())) * 59) + getPlatform();
        List<RiskControl.ItemsBean> items2 = getItems();
        int i12 = hashCode2 * 59;
        if (items2 != null) {
            i11 = items2.hashCode();
        }
        return ((i12 + i11) * 59) + getVersion();
    }

    public void setItems(List<RiskControl.ItemsBean> list) {
        this.items = list;
    }

    public void setLoginName(String str) {
        this.loginName = str;
    }

    public void setPlatform(int i11) {
        this.platform = i11;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }

    public String toString() {
        return "H5VerifyCodeData(loginName=" + getLoginName() + ", scene=" + getScene() + ", platform=" + getPlatform() + ", items=" + getItems() + ", version=" + getVersion() + ")";
    }
}
