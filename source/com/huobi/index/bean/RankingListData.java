package com.huobi.index.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.index.viewhandler.RankingNewSymbolItemHandler;
import com.huochat.community.util.JsonTool;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import s9.a;

public class RankingListData implements Serializable {
    public static final int RANK_DROP = 6;
    public static final int RANK_HOTS = 5;
    public static final int RANK_INCREASE = 1;
    public static final int RANK_MARKET_VALUE = 10;
    public static final int RANK_NEW_SYMBOL = 4;
    public static final int RANK_TURNOVER = 2;
    public static final String RANK_TYPE = "rank_type";
    private boolean hasDownRank;
    private boolean hasHotRank;
    private boolean hasMarketValue;
    private boolean hasNewSymbol;
    private boolean hasUpRank;
    private boolean hasVolumeRank;
    private String listdata;
    private NewSymbolData newSymbolData;
    private String rankingXmlConfig;
    private String statusData;
    private List<TitleData> titleData;

    public static class NewSymbolData implements Serializable {
        private boolean isSingleList;
        private List<SectionItem> sectionList;
        private int type;

        public boolean getIsSingleList() {
            return this.isSingleList;
        }

        public List<SectionItem> getSectionList() {
            return this.sectionList;
        }

        public SectionItem getTradeableData() {
            for (SectionItem next : this.sectionList) {
                if (TextUtils.equals("tradeable", next.getSubType())) {
                    return next;
                }
            }
            return null;
        }

        public int getType() {
            return this.type;
        }

        public SectionItem getUntradeableData() {
            for (SectionItem next : this.sectionList) {
                if (TextUtils.equals("untradeable", next.getSubType())) {
                    return next;
                }
            }
            return null;
        }

        public boolean isEmpty() {
            List<SectionItem> list = this.sectionList;
            if (list != null && !list.isEmpty()) {
                for (SectionItem next : this.sectionList) {
                    if (next.data != null && !next.data.isEmpty()) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void setIsSingleList(boolean z11) {
            this.isSingleList = z11;
        }

        public void setSectionList(List<SectionItem> list) {
            this.sectionList = list;
        }

        public void setType(int i11) {
            this.type = i11;
        }
    }

    public static class NewSymbolItemData implements a, Serializable {
        private String baseName;
        private Long beginDate;
        private String beginDateStr;
        private String flagURL;
        private String flagViewVisibility;
        private String iconURL;
        private String price;
        private String ratio;
        private String subType;
        private String symbol;
        private int type;

        public static boolean isSame(NewSymbolItemData newSymbolItemData, NewSymbolItemData newSymbolItemData2) {
            if (newSymbolItemData != null && newSymbolItemData2 != null) {
                return newSymbolItemData.getType() == newSymbolItemData2.getType() && TextUtils.equals(newSymbolItemData.getIconURL(), newSymbolItemData2.getIconURL()) && TextUtils.equals(newSymbolItemData.getSubType(), newSymbolItemData2.getSubType()) && TextUtils.equals(newSymbolItemData.getIconURL(), newSymbolItemData2.getIconURL()) && TextUtils.equals(newSymbolItemData.getFlagURL(), newSymbolItemData2.getFlagURL()) && TextUtils.equals(newSymbolItemData.getSymbol(), newSymbolItemData2.getSymbol()) && TextUtils.equals(newSymbolItemData.getBaseName(), newSymbolItemData2.getBaseName()) && TextUtils.equals(newSymbolItemData.getPrice(), newSymbolItemData2.getPrice()) && newSymbolItemData.getBeginDate() == newSymbolItemData2.getBeginDate() && TextUtils.equals(newSymbolItemData.getRatio(), newSymbolItemData2.getRatio()) && TextUtils.equals(newSymbolItemData.getBeginDateStr(), newSymbolItemData2.getBeginDateStr());
            }
            if (newSymbolItemData == newSymbolItemData2) {
                return true;
            }
            return false;
        }

        public String getBaseName() {
            return this.baseName;
        }

        public Long getBeginDate() {
            return this.beginDate;
        }

        public String getBeginDateStr() {
            return this.beginDateStr;
        }

        public String getFlagURL() {
            return this.flagURL;
        }

        public String getFlagViewVisibility() {
            return this.flagViewVisibility;
        }

        public String getIconURL() {
            return this.iconURL;
        }

        public String getPrice() {
            return this.price;
        }

        public String getRatio() {
            return this.ratio;
        }

        public String getSubType() {
            return this.subType;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public int getType() {
            return this.type;
        }

        public String getViewHandlerName() {
            return RankingNewSymbolItemHandler.class.getName();
        }

        public void setBaseName(String str) {
            this.baseName = str;
        }

        public void setBeginDate(Long l11) {
            this.beginDate = l11;
        }

        public void setBeginDateStr(String str) {
            this.beginDateStr = str;
        }

        public void setFlagURL(String str) {
            this.flagURL = str;
        }

        public void setFlagViewVisibility(String str) {
            this.flagViewVisibility = str;
        }

        public void setIconURL(String str) {
            this.iconURL = str;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public void setRatio(String str) {
            this.ratio = str;
        }

        public void setSubType(String str) {
            this.subType = str;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }
    }

    public static class SectionItem implements Serializable {
        /* access modifiers changed from: private */
        public List<NewSymbolItemData> data;
        private Map<String, String> sectionHeader;
        private String subType;
        private int type;

        public List<NewSymbolItemData> getData() {
            return this.data;
        }

        public Map<String, String> getSectionHeader() {
            return this.sectionHeader;
        }

        public String getSubType() {
            return this.subType;
        }

        public int getType() {
            return this.type;
        }

        public boolean isEmpty() {
            List<NewSymbolItemData> list = this.data;
            return list == null || list.isEmpty();
        }

        public void setData(List<NewSymbolItemData> list) {
            this.data = list;
        }

        public void setSectionHeader(Map<String, String> map) {
            this.sectionHeader = map;
        }

        public void setSubType(String str) {
            this.subType = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }
    }

    public static class TitleData implements Serializable {
        private String title;
        private int type;

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(int i11) {
            this.type = i11;
        }
    }

    private Boolean getBooleanData(String str, JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBooleanValue(str));
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    private JSONArray getSectionData(String str, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject(str).getJSONObject("sectionItem").getJSONArray("data");
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof RankingListData;
    }

    public boolean downRankDataIsEmpty() {
        return !this.hasDownRank;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankingListData)) {
            return false;
        }
        RankingListData rankingListData = (RankingListData) obj;
        if (!rankingListData.canEqual(this)) {
            return false;
        }
        String listdata2 = getListdata();
        String listdata3 = rankingListData.getListdata();
        if (listdata2 != null ? !listdata2.equals(listdata3) : listdata3 != null) {
            return false;
        }
        String statusData2 = getStatusData();
        String statusData3 = rankingListData.getStatusData();
        if (statusData2 != null ? !statusData2.equals(statusData3) : statusData3 != null) {
            return false;
        }
        List<TitleData> titleData2 = getTitleData();
        List<TitleData> titleData3 = rankingListData.getTitleData();
        if (titleData2 != null ? !titleData2.equals(titleData3) : titleData3 != null) {
            return false;
        }
        NewSymbolData newSymbolData2 = getNewSymbolData();
        NewSymbolData newSymbolData3 = rankingListData.getNewSymbolData();
        if (newSymbolData2 != null ? !newSymbolData2.equals(newSymbolData3) : newSymbolData3 != null) {
            return false;
        }
        String rankingXmlConfig2 = getRankingXmlConfig();
        String rankingXmlConfig3 = rankingListData.getRankingXmlConfig();
        if (rankingXmlConfig2 != null ? rankingXmlConfig2.equals(rankingXmlConfig3) : rankingXmlConfig3 == null) {
            return isHasUpRank() == rankingListData.isHasUpRank() && isHasDownRank() == rankingListData.isHasDownRank() && isHasHotRank() == rankingListData.isHasHotRank() && isHasVolumeRank() == rankingListData.isHasVolumeRank() && isHasNewSymbol() == rankingListData.isHasNewSymbol() && isHasMarketValue() == rankingListData.isHasMarketValue();
        }
        return false;
    }

    public String getListdata() {
        return this.listdata;
    }

    public NewSymbolData getNewSymbolData() {
        return this.newSymbolData;
    }

    public String getRankingXmlConfig() {
        return this.rankingXmlConfig;
    }

    public String getStatusData() {
        return this.statusData;
    }

    public List<TitleData> getTitleData() {
        return this.titleData;
    }

    public int hashCode() {
        String listdata2 = getListdata();
        int i11 = 43;
        int hashCode = listdata2 == null ? 43 : listdata2.hashCode();
        String statusData2 = getStatusData();
        int hashCode2 = ((hashCode + 59) * 59) + (statusData2 == null ? 43 : statusData2.hashCode());
        List<TitleData> titleData2 = getTitleData();
        int hashCode3 = (hashCode2 * 59) + (titleData2 == null ? 43 : titleData2.hashCode());
        NewSymbolData newSymbolData2 = getNewSymbolData();
        int hashCode4 = (hashCode3 * 59) + (newSymbolData2 == null ? 43 : newSymbolData2.hashCode());
        String rankingXmlConfig2 = getRankingXmlConfig();
        int i12 = hashCode4 * 59;
        if (rankingXmlConfig2 != null) {
            i11 = rankingXmlConfig2.hashCode();
        }
        int i13 = 79;
        int i14 = (((((((((((i12 + i11) * 59) + (isHasUpRank() ? 79 : 97)) * 59) + (isHasDownRank() ? 79 : 97)) * 59) + (isHasHotRank() ? 79 : 97)) * 59) + (isHasVolumeRank() ? 79 : 97)) * 59) + (isHasNewSymbol() ? 79 : 97)) * 59;
        if (!isHasMarketValue()) {
            i13 = 97;
        }
        return i14 + i13;
    }

    public boolean hotRankDataIsEmpty() {
        return !this.hasHotRank;
    }

    public boolean isHasDownRank() {
        return this.hasDownRank;
    }

    public boolean isHasHotRank() {
        return this.hasHotRank;
    }

    public boolean isHasMarketValue() {
        return this.hasMarketValue;
    }

    public boolean isHasNewSymbol() {
        return this.hasNewSymbol;
    }

    public boolean isHasUpRank() {
        return this.hasUpRank;
    }

    public boolean isHasVolumeRank() {
        return this.hasVolumeRank;
    }

    public boolean marketValueIsEmpty() {
        return !this.hasMarketValue;
    }

    public boolean newSymbolRankDataIsEmpty() {
        NewSymbolData newSymbolData2 = this.newSymbolData;
        return newSymbolData2 == null || newSymbolData2.isEmpty();
    }

    public void setHasDownRank(boolean z11) {
        this.hasDownRank = z11;
    }

    public void setHasHotRank(boolean z11) {
        this.hasHotRank = z11;
    }

    public void setHasMarketValue(boolean z11) {
        this.hasMarketValue = z11;
    }

    public void setHasNewSymbol(boolean z11) {
        this.hasNewSymbol = z11;
    }

    public void setHasUpRank(boolean z11) {
        this.hasUpRank = z11;
    }

    public void setHasVolumeRank(boolean z11) {
        this.hasVolumeRank = z11;
    }

    public void setListdata(String str) {
        JSONObject parseObject = JsonTool.parseObject(str);
        if (parseObject != null) {
            Object obj = parseObject.get("4");
            if (obj != null) {
                setNewSymbolData((NewSymbolData) JsonTool.parseObject(obj.toString(), NewSymbolData.class));
            }
            this.listdata = str;
        }
    }

    public void setNewSymbolData(NewSymbolData newSymbolData2) {
        this.newSymbolData = newSymbolData2;
    }

    public void setRankingXmlConfig(String str) {
        this.rankingXmlConfig = str;
    }

    public void setStatusData(String str) {
        this.statusData = str;
        JSONObject parseObject = JsonTool.parseObject(str);
        if (parseObject != null) {
            this.hasUpRank = getBooleanData("1", parseObject).booleanValue();
            this.hasDownRank = getBooleanData(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, parseObject).booleanValue();
            this.hasHotRank = getBooleanData(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, parseObject).booleanValue();
            this.hasVolumeRank = getBooleanData("2", parseObject).booleanValue();
            this.hasNewSymbol = getBooleanData("4", parseObject).booleanValue();
            this.hasMarketValue = getBooleanData(CouponReturn.TYPE_EXPERIENCE, parseObject).booleanValue();
        }
    }

    public void setTitleData(List<TitleData> list) {
        this.titleData = list;
    }

    public String toString() {
        return "RankingListData(listdata=" + getListdata() + ", statusData=" + getStatusData() + ", titleData=" + getTitleData() + ", newSymbolData=" + getNewSymbolData() + ", rankingXmlConfig=" + getRankingXmlConfig() + ", hasUpRank=" + isHasUpRank() + ", hasDownRank=" + isHasDownRank() + ", hasHotRank=" + isHasHotRank() + ", hasVolumeRank=" + isHasVolumeRank() + ", hasNewSymbol=" + isHasNewSymbol() + ", hasMarketValue=" + isHasMarketValue() + ")";
    }

    public boolean upRankDataIsEmpty() {
        return !this.hasUpRank;
    }

    public boolean volumeRankDataIsEmpty() {
        return !this.hasVolumeRank;
    }
}
