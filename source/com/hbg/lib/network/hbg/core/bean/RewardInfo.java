package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RewardInfo implements Serializable {
    @SerializedName("bagItems")
    private List<BagItemsBean> bagItems;
    @SerializedName("hasUpdate")
    private boolean hasUpdate;
    @SerializedName("icon")
    private String icon;
    @SerializedName("title")
    private String title;
    @SerializedName("uri")
    private String uri;

    public static class BagItemsBean {
        @SerializedName("count")
        private String count;
        @SerializedName("icon")
        private String icon;
        @SerializedName("incrementalValue")
        private String incrementalValue;
        @SerializedName("title")
        private String title;
        @SerializedName("type")
        private int type;
        @SerializedName("uri")
        private String uri;

        public String getCount() {
            return this.count;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getIncrementalValue() {
            return this.incrementalValue;
        }

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public String getUri() {
            return this.uri;
        }

        public void setCount(String str) {
            this.count = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setIncrementalValue(String str) {
            this.incrementalValue = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setUri(String str) {
            this.uri = str;
        }
    }

    public List<BagItemsBean> getBagItems() {
        return this.bagItems;
    }

    public boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUri() {
        return this.uri;
    }

    public void setBagItems(List<BagItemsBean> list) {
        this.bagItems = list;
    }

    public void setHasUpdate(boolean z11) {
        this.hasUpdate = z11;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }
}
