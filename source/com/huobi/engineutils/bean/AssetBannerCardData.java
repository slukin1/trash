package com.huobi.engineutils.bean;

import java.io.Serializable;
import java.util.List;

public class AssetBannerCardData implements Serializable {
    public static final int ASSET_BANNER_TYPE_EARN = 2;
    private String desc;
    private List<String> displayIconList;
    private String displayLeftName;
    private String displayRightName;
    private String jumpUrl;
    private String leftInfo;
    private List<String> matchLeftList;
    private List<String> matchRightList;
    private String rightInfo;
    private String title;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof AssetBannerCardData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetBannerCardData)) {
            return false;
        }
        AssetBannerCardData assetBannerCardData = (AssetBannerCardData) obj;
        if (!assetBannerCardData.canEqual(this) || getType() != assetBannerCardData.getType()) {
            return false;
        }
        String leftInfo2 = getLeftInfo();
        String leftInfo3 = assetBannerCardData.getLeftInfo();
        if (leftInfo2 != null ? !leftInfo2.equals(leftInfo3) : leftInfo3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = assetBannerCardData.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String desc2 = getDesc();
        String desc3 = assetBannerCardData.getDesc();
        if (desc2 != null ? !desc2.equals(desc3) : desc3 != null) {
            return false;
        }
        String rightInfo2 = getRightInfo();
        String rightInfo3 = assetBannerCardData.getRightInfo();
        if (rightInfo2 != null ? !rightInfo2.equals(rightInfo3) : rightInfo3 != null) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = assetBannerCardData.getJumpUrl();
        if (jumpUrl2 != null ? !jumpUrl2.equals(jumpUrl3) : jumpUrl3 != null) {
            return false;
        }
        String displayLeftName2 = getDisplayLeftName();
        String displayLeftName3 = assetBannerCardData.getDisplayLeftName();
        if (displayLeftName2 != null ? !displayLeftName2.equals(displayLeftName3) : displayLeftName3 != null) {
            return false;
        }
        String displayRightName2 = getDisplayRightName();
        String displayRightName3 = assetBannerCardData.getDisplayRightName();
        if (displayRightName2 != null ? !displayRightName2.equals(displayRightName3) : displayRightName3 != null) {
            return false;
        }
        List<String> matchLeftList2 = getMatchLeftList();
        List<String> matchLeftList3 = assetBannerCardData.getMatchLeftList();
        if (matchLeftList2 != null ? !matchLeftList2.equals(matchLeftList3) : matchLeftList3 != null) {
            return false;
        }
        List<String> matchRightList2 = getMatchRightList();
        List<String> matchRightList3 = assetBannerCardData.getMatchRightList();
        if (matchRightList2 != null ? !matchRightList2.equals(matchRightList3) : matchRightList3 != null) {
            return false;
        }
        List<String> displayIconList2 = getDisplayIconList();
        List<String> displayIconList3 = assetBannerCardData.getDisplayIconList();
        return displayIconList2 != null ? displayIconList2.equals(displayIconList3) : displayIconList3 == null;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<String> getDisplayIconList() {
        return this.displayIconList;
    }

    public String getDisplayLeftName() {
        return this.displayLeftName;
    }

    public String getDisplayRightName() {
        return this.displayRightName;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getLeftInfo() {
        return this.leftInfo;
    }

    public List<String> getMatchLeftList() {
        return this.matchLeftList;
    }

    public List<String> getMatchRightList() {
        return this.matchRightList;
    }

    public String getRightInfo() {
        return this.rightInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String leftInfo2 = getLeftInfo();
        int i11 = 43;
        int type2 = ((getType() + 59) * 59) + (leftInfo2 == null ? 43 : leftInfo2.hashCode());
        String title2 = getTitle();
        int hashCode = (type2 * 59) + (title2 == null ? 43 : title2.hashCode());
        String desc2 = getDesc();
        int hashCode2 = (hashCode * 59) + (desc2 == null ? 43 : desc2.hashCode());
        String rightInfo2 = getRightInfo();
        int hashCode3 = (hashCode2 * 59) + (rightInfo2 == null ? 43 : rightInfo2.hashCode());
        String jumpUrl2 = getJumpUrl();
        int hashCode4 = (hashCode3 * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
        String displayLeftName2 = getDisplayLeftName();
        int hashCode5 = (hashCode4 * 59) + (displayLeftName2 == null ? 43 : displayLeftName2.hashCode());
        String displayRightName2 = getDisplayRightName();
        int hashCode6 = (hashCode5 * 59) + (displayRightName2 == null ? 43 : displayRightName2.hashCode());
        List<String> matchLeftList2 = getMatchLeftList();
        int hashCode7 = (hashCode6 * 59) + (matchLeftList2 == null ? 43 : matchLeftList2.hashCode());
        List<String> matchRightList2 = getMatchRightList();
        int hashCode8 = (hashCode7 * 59) + (matchRightList2 == null ? 43 : matchRightList2.hashCode());
        List<String> displayIconList2 = getDisplayIconList();
        int i12 = hashCode8 * 59;
        if (displayIconList2 != null) {
            i11 = displayIconList2.hashCode();
        }
        return i12 + i11;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDisplayIconList(List<String> list) {
        this.displayIconList = list;
    }

    public void setDisplayLeftName(String str) {
        this.displayLeftName = str;
    }

    public void setDisplayRightName(String str) {
        this.displayRightName = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setLeftInfo(String str) {
        this.leftInfo = str;
    }

    public void setMatchLeftList(List<String> list) {
        this.matchLeftList = list;
    }

    public void setMatchRightList(List<String> list) {
        this.matchRightList = list;
    }

    public void setRightInfo(String str) {
        this.rightInfo = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "AssetBannerCardData(type=" + getType() + ", leftInfo=" + getLeftInfo() + ", title=" + getTitle() + ", desc=" + getDesc() + ", rightInfo=" + getRightInfo() + ", jumpUrl=" + getJumpUrl() + ", displayLeftName=" + getDisplayLeftName() + ", displayRightName=" + getDisplayRightName() + ", matchLeftList=" + getMatchLeftList() + ", matchRightList=" + getMatchRightList() + ", displayIconList=" + getDisplayIconList() + ")";
    }
}
