package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class RankJumpInfo implements Serializable {
    private int filter;
    private String h5Url;
    private Integer primaryTitle;
    private Integer rankType = -1;
    private String secondaryTitle;
    private Integer target = 1;
    private RankJumpTitle title;
    private Integer type;

    public boolean canEqual(Object obj) {
        return obj instanceof RankJumpInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankJumpInfo)) {
            return false;
        }
        RankJumpInfo rankJumpInfo = (RankJumpInfo) obj;
        if (!rankJumpInfo.canEqual(this)) {
            return false;
        }
        Integer primaryTitle2 = getPrimaryTitle();
        Integer primaryTitle3 = rankJumpInfo.getPrimaryTitle();
        if (primaryTitle2 != null ? !primaryTitle2.equals(primaryTitle3) : primaryTitle3 != null) {
            return false;
        }
        Integer type2 = getType();
        Integer type3 = rankJumpInfo.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String secondaryTitle2 = getSecondaryTitle();
        String secondaryTitle3 = rankJumpInfo.getSecondaryTitle();
        if (secondaryTitle2 != null ? !secondaryTitle2.equals(secondaryTitle3) : secondaryTitle3 != null) {
            return false;
        }
        if (getFilter() != rankJumpInfo.getFilter()) {
            return false;
        }
        String h5Url2 = getH5Url();
        String h5Url3 = rankJumpInfo.getH5Url();
        if (h5Url2 != null ? !h5Url2.equals(h5Url3) : h5Url3 != null) {
            return false;
        }
        RankJumpTitle title2 = getTitle();
        RankJumpTitle title3 = rankJumpInfo.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        Integer rankType2 = getRankType();
        Integer rankType3 = rankJumpInfo.getRankType();
        if (rankType2 != null ? !rankType2.equals(rankType3) : rankType3 != null) {
            return false;
        }
        Integer target2 = getTarget();
        Integer target3 = rankJumpInfo.getTarget();
        return target2 != null ? target2.equals(target3) : target3 == null;
    }

    public int getFilter() {
        return this.filter;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public Integer getPrimaryTitle() {
        return this.primaryTitle;
    }

    public Integer getRankType() {
        return this.rankType;
    }

    public String getSecondaryTitle() {
        return this.secondaryTitle;
    }

    public Integer getTarget() {
        return this.target;
    }

    public RankJumpTitle getTitle() {
        return this.title;
    }

    public Integer getType() {
        return this.type;
    }

    public int hashCode() {
        Integer primaryTitle2 = getPrimaryTitle();
        int i11 = 43;
        int hashCode = primaryTitle2 == null ? 43 : primaryTitle2.hashCode();
        Integer type2 = getType();
        int hashCode2 = ((hashCode + 59) * 59) + (type2 == null ? 43 : type2.hashCode());
        String secondaryTitle2 = getSecondaryTitle();
        int hashCode3 = (((hashCode2 * 59) + (secondaryTitle2 == null ? 43 : secondaryTitle2.hashCode())) * 59) + getFilter();
        String h5Url2 = getH5Url();
        int hashCode4 = (hashCode3 * 59) + (h5Url2 == null ? 43 : h5Url2.hashCode());
        RankJumpTitle title2 = getTitle();
        int hashCode5 = (hashCode4 * 59) + (title2 == null ? 43 : title2.hashCode());
        Integer rankType2 = getRankType();
        int hashCode6 = (hashCode5 * 59) + (rankType2 == null ? 43 : rankType2.hashCode());
        Integer target2 = getTarget();
        int i12 = hashCode6 * 59;
        if (target2 != null) {
            i11 = target2.hashCode();
        }
        return i12 + i11;
    }

    public void setFilter(int i11) {
        this.filter = i11;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setPrimaryTitle(Integer num) {
        this.primaryTitle = num;
    }

    public void setRankType(Integer num) {
        this.rankType = num;
    }

    public void setSecondaryTitle(String str) {
        this.secondaryTitle = str;
    }

    public void setTarget(Integer num) {
        this.target = num;
    }

    public void setTitle(RankJumpTitle rankJumpTitle) {
        this.title = rankJumpTitle;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public String toString() {
        return "RankJumpInfo(primaryTitle=" + getPrimaryTitle() + ", type=" + getType() + ", secondaryTitle=" + getSecondaryTitle() + ", filter=" + getFilter() + ", h5Url=" + getH5Url() + ", title=" + getTitle() + ", rankType=" + getRankType() + ", target=" + getTarget() + ")";
    }
}
