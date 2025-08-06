package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class NewFeed implements Serializable {
    public static final int ITEM_TYPE_AD = 999;
    public static final int ITEM_TYPE_COMMENT = 4;
    public static final int ITEM_TYPE_CONTRACT = 100;
    public static final int ITEM_TYPE_DEEP = 2;
    public static final int ITEM_TYPE_FLASH_INFORMATION = 1;
    public static final int ITEM_TYPE_LIVE = 6;
    public static final int ITEM_TYPE_MARKET_REMIND = 3;
    public static final int ITEM_TYPE_RECOMMEND = 500;
    public static final int ITEM_TYPE_RECOMMEND_LIVE = 11;
    public static final int ITEM_TYPE_SPECIAL = 14;
    public static final int ITEM_TYPE_TOPIC = 10;
    public int actionType = 2;
    public List<CardIndexItem> cardIndexList;
    @SerializedName("items")
    public List<FeedItem> items;
    public List<LiveDetailBean> liveInfoList;
    public List<NewFlashInformation> newsflashList;
    public List<TopicItem> topic;
    @SerializedName("updateType")
    public int updateType;

    public static class CardIndexItem implements Serializable {
        public Banner banner;
        public int index;
        public int type;

        public static class Banner implements Serializable {
            public int pageType;
        }
    }

    public static class FeedItem implements Serializable {
        @SerializedName("id")

        /* renamed from: id  reason: collision with root package name */
        private long f70259id;
        @SerializedName("itemContent")
        private Object itemContent;
        @SerializedName("itemType")
        private int itemType;
        @SerializedName("recom_base_info")
        private String recomBaseInfo = "";

        public boolean equals(Object obj) {
            if (!(obj instanceof FeedItem)) {
                return super.equals(obj);
            }
            FeedItem feedItem = (FeedItem) obj;
            return this.f70259id == feedItem.f70259id && this.itemType == feedItem.itemType;
        }

        public long getId() {
            return this.f70259id;
        }

        public Object getItemContent() {
            return this.itemContent;
        }

        public int getItemType() {
            return this.itemType;
        }

        public String getRecomBaseInfo() {
            return this.recomBaseInfo;
        }

        public void setId(long j11) {
            this.f70259id = j11;
        }

        public void setItemContent(Object obj) {
            this.itemContent = obj;
        }

        public void setItemType(int i11) {
            this.itemType = i11;
        }

        public void setRecomBaseInfo(String str) {
            this.recomBaseInfo = str;
        }
    }

    public static class TopicItem implements Serializable {
        public int classify;
        public long createdTime;
        public int identification;
        public int isTop;
        public int joinNums;
        public int order;
        public int refined;
        public String specialIde;
        public String title;
        public int topicId;
        public int type;
        public String url;
    }

    public List<FeedItem> getItems() {
        return this.items;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setItems(List<FeedItem> list) {
        this.items = list;
    }
}
