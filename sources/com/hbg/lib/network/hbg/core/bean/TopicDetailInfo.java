package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class TopicDetailInfo implements Serializable {
    private static final long serialVersionUID = -7366297612070029114L;
    private List<CoinInfo> coinList;
    private HeaderInfo info;
    private List<NewsInfo> newsList;
    private List<TabInfo> tabList;

    public static class CoinInfo implements Serializable {
        private static final long serialVersionUID = -1656654705417742141L;
        private String baseCurrency;
        private String coin;
        private String symbol;

        public String getBaseCurrency() {
            return this.baseCurrency;
        }

        public String getCoin() {
            return this.coin;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public void setBaseCurrency(String str) {
            this.baseCurrency = str;
        }

        public void setCoin(String str) {
            this.coin = str;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }
    }

    public static class HeaderInfo implements Serializable {
        private static final long serialVersionUID = -729984667927465777L;
        private int articleNums;
        private String desc;
        private int identification;
        private int joinNums;
        private int refined;
        private String title;
        private int topicId;
        private int visitNums;

        public int getArticleNums() {
            return this.articleNums;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getIdentification() {
            return this.identification;
        }

        public int getJoinNums() {
            return this.joinNums;
        }

        public int getRefined() {
            return this.refined;
        }

        public String getTitle() {
            return this.title;
        }

        public int getTopicId() {
            return this.topicId;
        }

        public int getVisitNums() {
            return this.visitNums;
        }

        public void setArticleNums(int i11) {
            this.articleNums = i11;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setIdentification(int i11) {
            this.identification = i11;
        }

        public void setJoinNums(int i11) {
            this.joinNums = i11;
        }

        public void setRefined(int i11) {
            this.refined = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTopicId(int i11) {
            this.topicId = i11;
        }

        public void setVisitNums(int i11) {
            this.visitNums = i11;
        }
    }

    public static class NewsInfo implements Serializable {
        private static final long serialVersionUID = 2290730036109384297L;
        private String title;
        private String url;

        public String getTitle() {
            return this.title;
        }

        public String getUrl() {
            return this.url;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static class TabInfo implements Serializable {
        private static final long serialVersionUID = 5403433978302794400L;
        private int tabId;
        private String tabName;

        public int getTabId() {
            return this.tabId;
        }

        public String getTabName() {
            return this.tabName;
        }

        public void setTabId(int i11) {
            this.tabId = i11;
        }

        public void setTabName(String str) {
            this.tabName = str;
        }
    }

    public List<CoinInfo> getCoinList() {
        return this.coinList;
    }

    public HeaderInfo getInfo() {
        return this.info;
    }

    public List<NewsInfo> getNewsList() {
        return this.newsList;
    }

    public List<TabInfo> getTabList() {
        return this.tabList;
    }

    public void setCoinList(List<CoinInfo> list) {
        this.coinList = list;
    }

    public void setInfo(HeaderInfo headerInfo) {
        this.info = headerInfo;
    }

    public void setNewsList(List<NewsInfo> list) {
        this.newsList = list;
    }

    public void setTabList(List<TabInfo> list) {
        this.tabList = list;
    }
}
