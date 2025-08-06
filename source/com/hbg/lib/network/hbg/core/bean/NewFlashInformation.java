package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.List;

public class NewFlashInformation implements Serializable {
    public static final int VOTED_TYPE_DOWN = 2;
    public static final int VOTED_TYPE_NORMAL = 0;
    public static final int VOTED_TYPE_UP = 1;
    private static final long serialVersionUID = -604423280219609139L;
    public CommunityFeedInfo.ListBean.AttitudeInfo attitudeInfo;
    private int badVote;
    private int bullVote;
    private List<NewFlashInformationCoinTags> coinTags;
    private int comments;
    private String content;
    private long dynamicId;
    private List<CommunityFeedInfo.HotComment> hotCommentList;

    /* renamed from: id  reason: collision with root package name */
    private long f70260id;
    private List<NewFlashInformationImage> images;
    private boolean isTrans;
    private int isTranslateTag;
    private long issueTime;
    private int languageId;
    private String link;
    private String linkTitle;
    private String oldContent;
    private String oldTitle;
    @SerializedName("praiseNum")
    public int praiseNum;
    @SerializedName("praiseStatus")
    public int praiseStatus;
    private int rank;
    public String recom_base_info;
    private int recommend;
    private List<DeepNewsInfo> recommends;
    private int shared;
    private String title;
    private int visit;
    private int votedType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getBadVote() {
        return this.badVote;
    }

    public int getBullVote() {
        return this.bullVote;
    }

    public List<NewFlashInformationCoinTags> getCoinTags() {
        return this.coinTags;
    }

    public String getCoinTagsSymbols() {
        List<NewFlashInformationCoinTags> list = this.coinTags;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < this.coinTags.size(); i11++) {
            sb2.append(this.coinTags.get(i11).getSymbol());
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return sb2.substring(0, sb2.length() - 1);
    }

    public int getComments() {
        return this.comments;
    }

    public String getContent() {
        return this.content;
    }

    public long getDynamicId() {
        return this.dynamicId;
    }

    public List<CommunityFeedInfo.HotComment> getHotCommentList() {
        return this.hotCommentList;
    }

    public long getId() {
        return this.f70260id;
    }

    public List<NewFlashInformationImage> getImages() {
        return this.images;
    }

    public int getIsTranslateTag() {
        return this.isTranslateTag;
    }

    public long getIssueTime() {
        return this.issueTime;
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkTitle() {
        return this.linkTitle;
    }

    public String getOldContent() {
        return this.oldContent;
    }

    public String getOldTitle() {
        return this.oldTitle;
    }

    public int getRank() {
        return this.rank;
    }

    public int getRecommend() {
        return this.recommend;
    }

    public List<DeepNewsInfo> getRecommends() {
        return this.recommends;
    }

    public int getShared() {
        return this.shared;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getTrans() {
        return this.isTrans;
    }

    public int getVisit() {
        return this.visit;
    }

    public int getVotedType() {
        return this.votedType;
    }

    public void setBadVote(int i11) {
        this.badVote = i11;
    }

    public void setBullVote(int i11) {
        this.bullVote = i11;
    }

    public void setCoinTags(List<NewFlashInformationCoinTags> list) {
        this.coinTags = list;
    }

    public void setComments(int i11) {
        this.comments = i11;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDynamicId(long j11) {
        this.dynamicId = j11;
    }

    public void setHotCommentList(List<CommunityFeedInfo.HotComment> list) {
        this.hotCommentList = list;
    }

    public void setId(long j11) {
        this.f70260id = j11;
    }

    public void setImages(List<NewFlashInformationImage> list) {
        this.images = list;
    }

    public void setIsTranslateTag(int i11) {
        this.isTranslateTag = i11;
    }

    public void setIssueTime(long j11) {
        this.issueTime = j11;
    }

    public void setLanguageId(int i11) {
        this.languageId = i11;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setLinkTitle(String str) {
        this.linkTitle = str;
    }

    public void setOldContent(String str) {
        this.oldContent = str;
    }

    public void setOldTitle(String str) {
        this.oldTitle = str;
    }

    public void setRank(int i11) {
        this.rank = i11;
    }

    public void setRecommend(int i11) {
        this.recommend = i11;
    }

    public void setRecommends(List<DeepNewsInfo> list) {
        this.recommends = list;
    }

    public void setShared(int i11) {
        this.shared = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrans(boolean z11) {
        this.isTrans = z11;
    }

    public void setVisit(int i11) {
        this.visit = i11;
    }

    public void setVotedType(int i11) {
        this.votedType = i11;
    }
}
