package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RankList implements Serializable {
    private static final long serialVersionUID = 2414730259352068440L;
    private int dataType;
    private Map<String, List<RankListItemBean>> multipleMap;
    private boolean screen;
    private List<RankScreenBean> screenListObject;
    private boolean showUsdtSwapTab;
    private List<RankListItemBean> singleList;
    private String tagUrl;
    private List<RankLabelBean> title;
    private Map<String, List<RankLabelBean>> titleMap;
    private int type;
    private String typeTitle;

    public boolean canEqual(Object obj) {
        return obj instanceof RankList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankList)) {
            return false;
        }
        RankList rankList = (RankList) obj;
        if (!rankList.canEqual(this) || getType() != rankList.getType()) {
            return false;
        }
        String typeTitle2 = getTypeTitle();
        String typeTitle3 = rankList.getTypeTitle();
        if (typeTitle2 != null ? !typeTitle2.equals(typeTitle3) : typeTitle3 != null) {
            return false;
        }
        List<RankLabelBean> title2 = getTitle();
        List<RankLabelBean> title3 = rankList.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        Map<String, List<RankLabelBean>> titleMap2 = getTitleMap();
        Map<String, List<RankLabelBean>> titleMap3 = rankList.getTitleMap();
        if (titleMap2 != null ? !titleMap2.equals(titleMap3) : titleMap3 != null) {
            return false;
        }
        if (isScreen() != rankList.isScreen()) {
            return false;
        }
        List<RankScreenBean> screenListObject2 = getScreenListObject();
        List<RankScreenBean> screenListObject3 = rankList.getScreenListObject();
        if (screenListObject2 != null ? !screenListObject2.equals(screenListObject3) : screenListObject3 != null) {
            return false;
        }
        String tagUrl2 = getTagUrl();
        String tagUrl3 = rankList.getTagUrl();
        if (tagUrl2 != null ? !tagUrl2.equals(tagUrl3) : tagUrl3 != null) {
            return false;
        }
        if (getDataType() != rankList.getDataType()) {
            return false;
        }
        Map<String, List<RankListItemBean>> multipleMap2 = getMultipleMap();
        Map<String, List<RankListItemBean>> multipleMap3 = rankList.getMultipleMap();
        if (multipleMap2 != null ? !multipleMap2.equals(multipleMap3) : multipleMap3 != null) {
            return false;
        }
        List<RankListItemBean> singleList2 = getSingleList();
        List<RankListItemBean> singleList3 = rankList.getSingleList();
        if (singleList2 != null ? singleList2.equals(singleList3) : singleList3 == null) {
            return isShowUsdtSwapTab() == rankList.isShowUsdtSwapTab();
        }
        return false;
    }

    public int getDataType() {
        return this.dataType;
    }

    public Map<String, List<RankListItemBean>> getMultipleMap() {
        return this.multipleMap;
    }

    public List<RankScreenBean> getScreenListObject() {
        return this.screenListObject;
    }

    public List<RankListItemBean> getSingleList() {
        return this.singleList;
    }

    public String getTagUrl() {
        return this.tagUrl;
    }

    public List<RankLabelBean> getTitle() {
        return this.title;
    }

    public Map<String, List<RankLabelBean>> getTitleMap() {
        return this.titleMap;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeTitle() {
        return this.typeTitle;
    }

    public int hashCode() {
        String typeTitle2 = getTypeTitle();
        int i11 = 43;
        int type2 = ((getType() + 59) * 59) + (typeTitle2 == null ? 43 : typeTitle2.hashCode());
        List<RankLabelBean> title2 = getTitle();
        int hashCode = (type2 * 59) + (title2 == null ? 43 : title2.hashCode());
        Map<String, List<RankLabelBean>> titleMap2 = getTitleMap();
        int i12 = 79;
        int hashCode2 = (((hashCode * 59) + (titleMap2 == null ? 43 : titleMap2.hashCode())) * 59) + (isScreen() ? 79 : 97);
        List<RankScreenBean> screenListObject2 = getScreenListObject();
        int hashCode3 = (hashCode2 * 59) + (screenListObject2 == null ? 43 : screenListObject2.hashCode());
        String tagUrl2 = getTagUrl();
        int hashCode4 = (((hashCode3 * 59) + (tagUrl2 == null ? 43 : tagUrl2.hashCode())) * 59) + getDataType();
        Map<String, List<RankListItemBean>> multipleMap2 = getMultipleMap();
        int hashCode5 = (hashCode4 * 59) + (multipleMap2 == null ? 43 : multipleMap2.hashCode());
        List<RankListItemBean> singleList2 = getSingleList();
        int i13 = hashCode5 * 59;
        if (singleList2 != null) {
            i11 = singleList2.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!isShowUsdtSwapTab()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public boolean isSameSubTab(RankList rankList) {
        if (this == rankList) {
            return true;
        }
        return rankList != null && this.screen == rankList.screen;
    }

    public boolean isSameTab(RankList rankList) {
        if (this == rankList) {
            return true;
        }
        if (rankList == null || this.type != rankList.type || this.dataType != rankList.dataType || !Objects.equals(this.typeTitle, rankList.typeTitle) || !Objects.equals(this.tagUrl, rankList.tagUrl)) {
            return false;
        }
        return true;
    }

    public boolean isScreen() {
        return this.screen;
    }

    public boolean isShowUsdtSwapTab() {
        return this.showUsdtSwapTab;
    }

    public void setDataType(int i11) {
        this.dataType = i11;
    }

    public void setMultipleMap(Map<String, List<RankListItemBean>> map) {
        this.multipleMap = map;
    }

    public void setScreen(boolean z11) {
        this.screen = z11;
    }

    public void setScreenListObject(List<RankScreenBean> list) {
        this.screenListObject = list;
    }

    public void setShowUsdtSwapTab(boolean z11) {
        this.showUsdtSwapTab = z11;
    }

    public void setSingleList(List<RankListItemBean> list) {
        this.singleList = list;
    }

    public void setTagUrl(String str) {
        this.tagUrl = str;
    }

    public void setTitle(List<RankLabelBean> list) {
        this.title = list;
    }

    public void setTitleMap(Map<String, List<RankLabelBean>> map) {
        this.titleMap = map;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setTypeTitle(String str) {
        this.typeTitle = str;
    }

    public String toString() {
        return "RankList(type=" + getType() + ", typeTitle=" + getTypeTitle() + ", title=" + getTitle() + ", titleMap=" + getTitleMap() + ", screen=" + isScreen() + ", screenListObject=" + getScreenListObject() + ", tagUrl=" + getTagUrl() + ", dataType=" + getDataType() + ", multipleMap=" + getMultipleMap() + ", singleList=" + getSingleList() + ", showUsdtSwapTab=" + isShowUsdtSwapTab() + ")";
    }
}
