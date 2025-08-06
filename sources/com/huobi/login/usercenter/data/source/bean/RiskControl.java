package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RiskControl implements Serializable {
    @SerializedName("captcha_type")
    private int captcha_type;
    @SerializedName("items")
    private List<ItemsBean> items;
    @SerializedName("low_risk_items")
    private List<ItemsBean> lowItems;
    @SerializedName("risk")
    private int risk;
    @SerializedName("itemsv3")
    private List<ItemsBean> webItems;

    public static class ItemsBean implements Serializable {
        @SerializedName("properties")
        private PropertiesBean properties;
        @SerializedName("type")
        private int type;

        public PropertiesBean getProperties() {
            return this.properties;
        }

        public int getType() {
            return this.type;
        }

        public void setProperties(PropertiesBean propertiesBean) {
            this.properties = propertiesBean;
        }

        public void setType(int i11) {
            this.type = i11;
        }
    }

    public static class PropertiesBean implements Serializable {
        @SerializedName("captcha_id")
        private String captchaId;

        public String getCaptchaId() {
            return this.captchaId;
        }

        public void setCaptchaId(String str) {
            this.captchaId = str;
        }
    }

    public int getCaptcha_type() {
        return this.captcha_type;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public List<ItemsBean> getLowItems() {
        return this.lowItems;
    }

    public int getRisk() {
        return this.risk;
    }

    public List<ItemsBean> getWebItems() {
        return this.webItems;
    }

    public void setCaptcha_type(int i11) {
        this.captcha_type = i11;
    }

    public void setItems(List<ItemsBean> list) {
        this.items = list;
    }

    public void setLowItems(List<ItemsBean> list) {
        this.lowItems = list;
    }

    public void setRisk(int i11) {
        this.risk = i11;
    }

    public void setWebItems(List<ItemsBean> list) {
        this.webItems = list;
    }
}
