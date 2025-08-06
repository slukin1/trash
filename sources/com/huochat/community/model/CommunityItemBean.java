package com.huochat.community.model;

import java.io.Serializable;
import java.util.List;

public final class CommunityItemBean implements Serializable {
    private int authType;
    private int commentCount;
    private List<CommentItemBean> commentList;
    private Integer commentNextIndex = -1;
    private String communityIds = "";
    private List<CommunitySymbolBean> communityInfoList;
    private int crownType;
    private String detailTitle;
    private int flag;
    private int forwardCount;
    private String headImage;
    private int hot;
    private List<String> images;
    private Boolean isNewPublished = Boolean.FALSE;
    private int isSelf;
    private boolean isTranslateExpanded = true;
    private int likeCount;
    private int longPicture;
    private Long markTime = 0L;
    private String mid = "";
    private String momentSource = "";
    private String momentTag = "";
    private int momentTagType;
    private String parseLink;
    private long postTime;
    private String publishedCommunityId = "";
    private String publishedCommunityName = "";
    private String publishedCommunitySymbol = "";
    private int recommand;
    private String redPacketInfo;
    private Integer redPacketStatus = 0;
    private Integer selfForward = 0;
    private int selfLike;
    private String shareSource;
    private String shareThumb;
    private String shareTitle;
    private String sharelink;
    private String showPrice;
    private List<Size> sizes;
    private String text;
    private String textTranslation;
    private String title;
    private int type;
    private long uid;
    private String userCommunityLabel;
    private String username;
    private int vFlag;
    private String vTag;
    private int vipFlag;

    public boolean equals(Object obj) {
        return obj != null && hashCode() == obj.hashCode();
    }

    public final int getAuthType() {
        return this.authType;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final List<CommentItemBean> getCommentList() {
        return this.commentList;
    }

    public final Integer getCommentNextIndex() {
        return this.commentNextIndex;
    }

    public final String getCommunityIds() {
        return this.communityIds;
    }

    public final List<CommunitySymbolBean> getCommunityInfoList() {
        return this.communityInfoList;
    }

    public final int getCrownType() {
        return this.crownType;
    }

    public final String getDetailTitle() {
        return this.detailTitle;
    }

    public final int getFlag() {
        return this.flag;
    }

    public final int getForwardCount() {
        return this.forwardCount;
    }

    public final String getHeadImage() {
        return this.headImage;
    }

    public final int getHot() {
        return this.hot;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final int getLongPicture() {
        return this.longPicture;
    }

    public final Long getMarkTime() {
        return this.markTime;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getMomentSource() {
        return this.momentSource;
    }

    public final String getMomentTag() {
        return this.momentTag;
    }

    public final int getMomentTagType() {
        return this.momentTagType;
    }

    public final String getParseLink() {
        return this.parseLink;
    }

    public final long getPostTime() {
        return this.postTime;
    }

    public final String getPublishedCommunityId() {
        return this.publishedCommunityId;
    }

    public final String getPublishedCommunityName() {
        return this.publishedCommunityName;
    }

    public final String getPublishedCommunitySymbol() {
        return this.publishedCommunitySymbol;
    }

    public final int getRecommand() {
        return this.recommand;
    }

    public final String getRedPacketInfo() {
        return this.redPacketInfo;
    }

    public final Integer getRedPacketStatus() {
        return this.redPacketStatus;
    }

    public final Integer getSelfForward() {
        return this.selfForward;
    }

    public final int getSelfLike() {
        return this.selfLike;
    }

    public final String getShareSource() {
        return this.shareSource;
    }

    public final String getShareThumb() {
        return this.shareThumb;
    }

    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final String getSharelink() {
        return this.sharelink;
    }

    public final String getShowPrice() {
        return this.showPrice;
    }

    public final List<Size> getSizes() {
        return this.sizes;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextTranslation() {
        return this.textTranslation;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUid() {
        return this.uid;
    }

    public final String getUserCommunityLabel() {
        return this.userCommunityLabel;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int getVFlag() {
        return this.vFlag;
    }

    public final String getVTag() {
        return this.vTag;
    }

    public final int getVipFlag() {
        return this.vipFlag;
    }

    public int hashCode() {
        return String.valueOf(this.mid).hashCode();
    }

    public final Boolean isNewPublished() {
        return this.isNewPublished;
    }

    public final int isSelf() {
        return this.isSelf;
    }

    public final boolean isTranslateExpanded() {
        return this.isTranslateExpanded;
    }

    public final void setAuthType(int i11) {
        this.authType = i11;
    }

    public final void setCommentCount(int i11) {
        this.commentCount = i11;
    }

    public final void setCommentList(List<CommentItemBean> list) {
        this.commentList = list;
    }

    public final void setCommentNextIndex(Integer num) {
        this.commentNextIndex = num;
    }

    public final void setCommunityIds(String str) {
        this.communityIds = str;
    }

    public final void setCommunityInfoList(List<CommunitySymbolBean> list) {
        this.communityInfoList = list;
    }

    public final void setCrownType(int i11) {
        this.crownType = i11;
    }

    public final void setDetailTitle(String str) {
        this.detailTitle = str;
    }

    public final void setFlag(int i11) {
        this.flag = i11;
    }

    public final void setForwardCount(int i11) {
        this.forwardCount = i11;
    }

    public final void setHeadImage(String str) {
        this.headImage = str;
    }

    public final void setHot(int i11) {
        this.hot = i11;
    }

    public final void setImages(List<String> list) {
        this.images = list;
    }

    public final void setLikeCount(int i11) {
        this.likeCount = i11;
    }

    public final void setLongPicture(int i11) {
        this.longPicture = i11;
    }

    public final void setMarkTime(Long l11) {
        this.markTime = l11;
    }

    public final void setMid(String str) {
        this.mid = str;
    }

    public final void setMomentSource(String str) {
        this.momentSource = str;
    }

    public final void setMomentTag(String str) {
        this.momentTag = str;
    }

    public final void setMomentTagType(int i11) {
        this.momentTagType = i11;
    }

    public final void setNewPublished(Boolean bool) {
        this.isNewPublished = bool;
    }

    public final void setParseLink(String str) {
        this.parseLink = str;
    }

    public final void setPostTime(long j11) {
        this.postTime = j11;
    }

    public final void setPublishedCommunityId(String str) {
        this.publishedCommunityId = str;
    }

    public final void setPublishedCommunityName(String str) {
        this.publishedCommunityName = str;
    }

    public final void setPublishedCommunitySymbol(String str) {
        this.publishedCommunitySymbol = str;
    }

    public final void setRecommand(int i11) {
        this.recommand = i11;
    }

    public final void setRedPacketInfo(String str) {
        this.redPacketInfo = str;
    }

    public final void setRedPacketStatus(Integer num) {
        this.redPacketStatus = num;
    }

    public final void setSelf(int i11) {
        this.isSelf = i11;
    }

    public final void setSelfForward(Integer num) {
        this.selfForward = num;
    }

    public final void setSelfLike(int i11) {
        this.selfLike = i11;
    }

    public final void setShareSource(String str) {
        this.shareSource = str;
    }

    public final void setShareThumb(String str) {
        this.shareThumb = str;
    }

    public final void setShareTitle(String str) {
        this.shareTitle = str;
    }

    public final void setSharelink(String str) {
        this.sharelink = str;
    }

    public final void setShowPrice(String str) {
        this.showPrice = str;
    }

    public final void setSizes(List<Size> list) {
        this.sizes = list;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTextTranslation(String str) {
        this.textTranslation = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTranslateExpanded(boolean z11) {
        this.isTranslateExpanded = z11;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUid(long j11) {
        this.uid = j11;
    }

    public final void setUserCommunityLabel(String str) {
        this.userCommunityLabel = str;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void setVFlag(int i11) {
        this.vFlag = i11;
    }

    public final void setVTag(String str) {
        this.vTag = str;
    }

    public final void setVipFlag(int i11) {
        this.vipFlag = i11;
    }

    public String toString() {
        return "CommunityItemBean(authType=" + this.authType + ", commentCount=" + this.commentCount + ", crownType=" + this.crownType + ", detailTitle=" + this.detailTitle + ", flag=" + this.flag + ", headImage=" + this.headImage + ", hot=" + this.hot + ", images=" + this.images + ", isSelf=" + this.isSelf + ", likeCount=" + this.likeCount + ", forwardCount=" + this.forwardCount + ", mid=" + this.mid + ", postTime=" + this.postTime + ", recommand=" + this.recommand + ", selfLike=" + this.selfLike + ", shareTitle=" + this.shareTitle + ", sharelink=" + this.sharelink + ", showPrice=" + this.showPrice + ", sizes=" + this.sizes + ", title=" + this.title + ", text=" + this.text + ", parseLink=" + this.parseLink + ", type=" + this.type + ", uid=" + this.uid + ", username=" + this.username + ", vFlag=" + this.vFlag + ", vipFlag=" + this.vipFlag + ", vTag=" + this.vTag + ", longPicture=" + this.longPicture + ", shareSource=" + this.shareSource + ", shareThumb=" + this.shareThumb + ", redPacketInfo=" + this.redPacketInfo + ", redPacketStatus=" + this.redPacketStatus + ", selfForward=" + this.selfForward + ", userCommunityLabel=" + this.userCommunityLabel + ", commentList=" + this.commentList + ", commentNextIndex=" + this.commentNextIndex + ", communityIds=" + this.communityIds + ", communityInfoList=" + this.communityInfoList + "), textTranslation=" + this.textTranslation + ", isTranslateExpanded=" + this.isTranslateExpanded + ", momentSource=" + this.momentSource;
    }
}
