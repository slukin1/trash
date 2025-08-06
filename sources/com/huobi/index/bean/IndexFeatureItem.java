package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.huobi.account.viewhandler.AccountQuickHandler;
import com.huobi.index.viewhandler.IndexBearItemHandler;
import com.huobi.index.viewhandler.IndexQuickHandler;
import com.huobi.index.viewhandler.NewVideoGuideHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class IndexFeatureItem implements a, Serializable {
    public static final int FROM_PAGE_TYPE_ACCOUNT = 101;
    public String androidMinVersion;
    public String androidVersion;
    public String assetTabType;
    public String commentId;
    public CornerMarkContent cornerMarkContent;
    public String description;
    public String dynamicId;
    public String from;
    public String groupCode;
    public String homePageFixed;

    /* renamed from: id  reason: collision with root package name */
    public int f73183id;
    public String imgUrl;
    public int index;
    public String introduction;
    public boolean isEmptyPlaceholder = false;
    public boolean isHomeFunction;
    public boolean isSelected;
    public int jumpMode;
    public String jumpOrder;
    public String jumpSymbol;
    public int jumpType;
    public String jumpUrl;
    public int needLogin;
    public String newImgUrl;
    public String subUrl;
    public String title;
    public String topicId;
    public String topicType;
    public int type;
    public String uidUnique;
    public int weight;

    public static class CornerMarkContent implements Serializable {
        public long cornerMarkId;
        public String cornerMarkName;
        public boolean dynamic;
        public String imageUrl;
        public String nightImageUrl;
        public int oneTime;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof IndexFeatureItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexFeatureItem)) {
            return false;
        }
        IndexFeatureItem indexFeatureItem = (IndexFeatureItem) obj;
        if (!indexFeatureItem.canEqual(this) || getIndex() != indexFeatureItem.getIndex() || getId() != indexFeatureItem.getId()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = indexFeatureItem.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String introduction2 = getIntroduction();
        String introduction3 = indexFeatureItem.getIntroduction();
        if (introduction2 != null ? !introduction2.equals(introduction3) : introduction3 != null) {
            return false;
        }
        String imgUrl2 = getImgUrl();
        String imgUrl3 = indexFeatureItem.getImgUrl();
        if (imgUrl2 != null ? !imgUrl2.equals(imgUrl3) : imgUrl3 != null) {
            return false;
        }
        String newImgUrl2 = getNewImgUrl();
        String newImgUrl3 = indexFeatureItem.getNewImgUrl();
        if (newImgUrl2 != null ? !newImgUrl2.equals(newImgUrl3) : newImgUrl3 != null) {
            return false;
        }
        String subUrl2 = getSubUrl();
        String subUrl3 = indexFeatureItem.getSubUrl();
        if (subUrl2 != null ? !subUrl2.equals(subUrl3) : subUrl3 != null) {
            return false;
        }
        if (getJumpMode() != indexFeatureItem.getJumpMode()) {
            return false;
        }
        String jumpOrder2 = getJumpOrder();
        String jumpOrder3 = indexFeatureItem.getJumpOrder();
        if (jumpOrder2 != null ? !jumpOrder2.equals(jumpOrder3) : jumpOrder3 != null) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = indexFeatureItem.getJumpUrl();
        if (jumpUrl2 != null ? !jumpUrl2.equals(jumpUrl3) : jumpUrl3 != null) {
            return false;
        }
        String jumpSymbol2 = getJumpSymbol();
        String jumpSymbol3 = indexFeatureItem.getJumpSymbol();
        if (jumpSymbol2 != null ? !jumpSymbol2.equals(jumpSymbol3) : jumpSymbol3 != null) {
            return false;
        }
        if (getWeight() != indexFeatureItem.getWeight() || getNeedLogin() != indexFeatureItem.getNeedLogin()) {
            return false;
        }
        String androidVersion2 = getAndroidVersion();
        String androidVersion3 = indexFeatureItem.getAndroidVersion();
        if (androidVersion2 != null ? !androidVersion2.equals(androidVersion3) : androidVersion3 != null) {
            return false;
        }
        String androidMinVersion2 = getAndroidMinVersion();
        String androidMinVersion3 = indexFeatureItem.getAndroidMinVersion();
        if (androidMinVersion2 != null ? !androidMinVersion2.equals(androidMinVersion3) : androidMinVersion3 != null) {
            return false;
        }
        String description2 = getDescription();
        String description3 = indexFeatureItem.getDescription();
        if (description2 != null ? !description2.equals(description3) : description3 != null) {
            return false;
        }
        if (getType() != indexFeatureItem.getType()) {
            return false;
        }
        String assetTabType2 = getAssetTabType();
        String assetTabType3 = indexFeatureItem.getAssetTabType();
        if (assetTabType2 != null ? !assetTabType2.equals(assetTabType3) : assetTabType3 != null) {
            return false;
        }
        String groupCode2 = getGroupCode();
        String groupCode3 = indexFeatureItem.getGroupCode();
        if (groupCode2 != null ? !groupCode2.equals(groupCode3) : groupCode3 != null) {
            return false;
        }
        String homePageFixed2 = getHomePageFixed();
        String homePageFixed3 = indexFeatureItem.getHomePageFixed();
        if (homePageFixed2 != null ? !homePageFixed2.equals(homePageFixed3) : homePageFixed3 != null) {
            return false;
        }
        String from2 = getFrom();
        String from3 = indexFeatureItem.getFrom();
        if (from2 != null ? !from2.equals(from3) : from3 != null) {
            return false;
        }
        if (isEmptyPlaceholder() != indexFeatureItem.isEmptyPlaceholder()) {
            return false;
        }
        String topicId2 = getTopicId();
        String topicId3 = indexFeatureItem.getTopicId();
        if (topicId2 != null ? !topicId2.equals(topicId3) : topicId3 != null) {
            return false;
        }
        String commentId2 = getCommentId();
        String commentId3 = indexFeatureItem.getCommentId();
        if (commentId2 != null ? !commentId2.equals(commentId3) : commentId3 != null) {
            return false;
        }
        String topicType2 = getTopicType();
        String topicType3 = indexFeatureItem.getTopicType();
        if (topicType2 != null ? !topicType2.equals(topicType3) : topicType3 != null) {
            return false;
        }
        if (isSelected() != indexFeatureItem.isSelected()) {
            return false;
        }
        String dynamicId2 = getDynamicId();
        String dynamicId3 = indexFeatureItem.getDynamicId();
        if (dynamicId2 != null ? !dynamicId2.equals(dynamicId3) : dynamicId3 != null) {
            return false;
        }
        String uidUnique2 = getUidUnique();
        String uidUnique3 = indexFeatureItem.getUidUnique();
        if (uidUnique2 != null ? !uidUnique2.equals(uidUnique3) : uidUnique3 != null) {
            return false;
        }
        if (getJumpType() != indexFeatureItem.getJumpType()) {
            return false;
        }
        CornerMarkContent cornerMarkContent2 = getCornerMarkContent();
        CornerMarkContent cornerMarkContent3 = indexFeatureItem.getCornerMarkContent();
        if (cornerMarkContent2 != null ? cornerMarkContent2.equals(cornerMarkContent3) : cornerMarkContent3 == null) {
            return isHomeFunction() == indexFeatureItem.isHomeFunction();
        }
        return false;
    }

    public String getAndroidMinVersion() {
        return this.androidMinVersion;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getAssetTabType() {
        return this.assetTabType;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public CornerMarkContent getCornerMarkContent() {
        return this.cornerMarkContent;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDynamicId() {
        return this.dynamicId;
    }

    public String getFrom() {
        return this.from;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public String getHomePageFixed() {
        return this.homePageFixed;
    }

    public int getId() {
        return this.f73183id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getIndex() {
        return this.index;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public int getJumpMode() {
        return this.jumpMode;
    }

    public String getJumpOrder() {
        return this.jumpOrder;
    }

    public String getJumpSymbol() {
        return this.jumpSymbol;
    }

    public int getJumpType() {
        return this.jumpType;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getNeedLogin() {
        return this.needLogin;
    }

    public String getNewImgUrl() {
        return this.newImgUrl;
    }

    public String getSubUrl() {
        return this.subUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public String getTopicType() {
        return this.topicType;
    }

    public int getType() {
        return this.type;
    }

    public String getUidUnique() {
        return this.uidUnique;
    }

    public String getViewHandlerName() {
        int i11 = this.type;
        if (i11 == 8) {
            return IndexQuickHandler.class.getName();
        }
        if (i11 == 12) {
            return NewVideoGuideHandler.class.getName();
        }
        if (i11 == 2949) {
            return AccountQuickHandler.class.getName();
        }
        return IndexBearItemHandler.class.getName();
    }

    public int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int index2 = ((getIndex() + 59) * 59) + getId();
        String title2 = getTitle();
        int i11 = 43;
        int hashCode = (index2 * 59) + (title2 == null ? 43 : title2.hashCode());
        String introduction2 = getIntroduction();
        int hashCode2 = (hashCode * 59) + (introduction2 == null ? 43 : introduction2.hashCode());
        String imgUrl2 = getImgUrl();
        int hashCode3 = (hashCode2 * 59) + (imgUrl2 == null ? 43 : imgUrl2.hashCode());
        String newImgUrl2 = getNewImgUrl();
        int hashCode4 = (hashCode3 * 59) + (newImgUrl2 == null ? 43 : newImgUrl2.hashCode());
        String subUrl2 = getSubUrl();
        int hashCode5 = (((hashCode4 * 59) + (subUrl2 == null ? 43 : subUrl2.hashCode())) * 59) + getJumpMode();
        String jumpOrder2 = getJumpOrder();
        int hashCode6 = (hashCode5 * 59) + (jumpOrder2 == null ? 43 : jumpOrder2.hashCode());
        String jumpUrl2 = getJumpUrl();
        int hashCode7 = (hashCode6 * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
        String jumpSymbol2 = getJumpSymbol();
        int hashCode8 = (((((hashCode7 * 59) + (jumpSymbol2 == null ? 43 : jumpSymbol2.hashCode())) * 59) + getWeight()) * 59) + getNeedLogin();
        String androidVersion2 = getAndroidVersion();
        int hashCode9 = (hashCode8 * 59) + (androidVersion2 == null ? 43 : androidVersion2.hashCode());
        String androidMinVersion2 = getAndroidMinVersion();
        int hashCode10 = (hashCode9 * 59) + (androidMinVersion2 == null ? 43 : androidMinVersion2.hashCode());
        String description2 = getDescription();
        int hashCode11 = (((hashCode10 * 59) + (description2 == null ? 43 : description2.hashCode())) * 59) + getType();
        String assetTabType2 = getAssetTabType();
        int hashCode12 = (hashCode11 * 59) + (assetTabType2 == null ? 43 : assetTabType2.hashCode());
        String groupCode2 = getGroupCode();
        int hashCode13 = (hashCode12 * 59) + (groupCode2 == null ? 43 : groupCode2.hashCode());
        String homePageFixed2 = getHomePageFixed();
        int hashCode14 = (hashCode13 * 59) + (homePageFixed2 == null ? 43 : homePageFixed2.hashCode());
        String from2 = getFrom();
        int i12 = 79;
        int hashCode15 = (((hashCode14 * 59) + (from2 == null ? 43 : from2.hashCode())) * 59) + (isEmptyPlaceholder() ? 79 : 97);
        String topicId2 = getTopicId();
        int hashCode16 = (hashCode15 * 59) + (topicId2 == null ? 43 : topicId2.hashCode());
        String commentId2 = getCommentId();
        int hashCode17 = (hashCode16 * 59) + (commentId2 == null ? 43 : commentId2.hashCode());
        String topicType2 = getTopicType();
        int hashCode18 = (((hashCode17 * 59) + (topicType2 == null ? 43 : topicType2.hashCode())) * 59) + (isSelected() ? 79 : 97);
        String dynamicId2 = getDynamicId();
        int hashCode19 = (hashCode18 * 59) + (dynamicId2 == null ? 43 : dynamicId2.hashCode());
        String uidUnique2 = getUidUnique();
        int hashCode20 = (((hashCode19 * 59) + (uidUnique2 == null ? 43 : uidUnique2.hashCode())) * 59) + getJumpType();
        CornerMarkContent cornerMarkContent2 = getCornerMarkContent();
        int i13 = hashCode20 * 59;
        if (cornerMarkContent2 != null) {
            i11 = cornerMarkContent2.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!isHomeFunction()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public boolean isEmptyPlaceholder() {
        return this.isEmptyPlaceholder;
    }

    public boolean isHomeFunction() {
        return this.isHomeFunction;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setAndroidMinVersion(String str) {
        this.androidMinVersion = str;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public void setAssetTabType(String str) {
        this.assetTabType = str;
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setCornerMarkContent(CornerMarkContent cornerMarkContent2) {
        this.cornerMarkContent = cornerMarkContent2;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDynamicId(String str) {
        this.dynamicId = str;
    }

    public void setEmptyPlaceholder(boolean z11) {
        this.isEmptyPlaceholder = z11;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setGroupCode(String str) {
        this.groupCode = str;
    }

    public void setHomeFunction(boolean z11) {
        this.isHomeFunction = z11;
    }

    public void setHomePageFixed(String str) {
        this.homePageFixed = str;
    }

    public void setId(int i11) {
        this.f73183id = i11;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setIntroduction(String str) {
        this.introduction = str;
    }

    public void setJumpMode(int i11) {
        this.jumpMode = i11;
    }

    public void setJumpOrder(String str) {
        this.jumpOrder = str;
    }

    public void setJumpSymbol(String str) {
        this.jumpSymbol = str;
    }

    public void setJumpType(int i11) {
        this.jumpType = i11;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setNeedLogin(int i11) {
        this.needLogin = i11;
    }

    public void setNewImgUrl(String str) {
        this.newImgUrl = str;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setSubUrl(String str) {
        this.subUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopicId(String str) {
        this.topicId = str;
    }

    public void setTopicType(String str) {
        this.topicType = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUidUnique(String str) {
        this.uidUnique = str;
    }

    public void setWeight(int i11) {
        this.weight = i11;
    }

    public String toString() {
        return "IndexFeatureItem(index=" + getIndex() + ", id=" + getId() + ", title=" + getTitle() + ", introduction=" + getIntroduction() + ", imgUrl=" + getImgUrl() + ", newImgUrl=" + getNewImgUrl() + ", subUrl=" + getSubUrl() + ", jumpMode=" + getJumpMode() + ", jumpOrder=" + getJumpOrder() + ", jumpUrl=" + getJumpUrl() + ", jumpSymbol=" + getJumpSymbol() + ", weight=" + getWeight() + ", needLogin=" + getNeedLogin() + ", androidVersion=" + getAndroidVersion() + ", androidMinVersion=" + getAndroidMinVersion() + ", description=" + getDescription() + ", type=" + getType() + ", assetTabType=" + getAssetTabType() + ", groupCode=" + getGroupCode() + ", homePageFixed=" + getHomePageFixed() + ", from=" + getFrom() + ", isEmptyPlaceholder=" + isEmptyPlaceholder() + ", topicId=" + getTopicId() + ", commentId=" + getCommentId() + ", topicType=" + getTopicType() + ", isSelected=" + isSelected() + ", dynamicId=" + getDynamicId() + ", uidUnique=" + getUidUnique() + ", jumpType=" + getJumpType() + ", cornerMarkContent=" + getCornerMarkContent() + ", isHomeFunction=" + isHomeFunction() + ")";
    }
}
