package com.huobi.index.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import java.io.Serializable;
import java.util.List;

public class IndexDeep implements Serializable {
    public CommunityFeedInfo.ListBean.AttitudeInfo attitudeInfo;
    public List<NewFlashInformationCoinTags> coinTags;
    private int commentNum;
    public String content = "";
    private long dynamicId;
    private List<CommunityFeedInfo.HotComment> hotCommentList;

    /* renamed from: id  reason: collision with root package name */
    private long f73181id;
    private String imgUrl;
    private long issueTime;
    @SerializedName("praiseNum")
    public int praiseNum;
    @SerializedName("praiseStatus")
    public int praiseStatus;
    private String promulgatorLogo = "";
    private String promulgatorTitle;
    public int shared;
    private String source;
    private String title;
    private int visit;

    public List<NewFlashInformationCoinTags> getCoinTags() {
        return this.coinTags;
    }

    public int getCommentNum() {
        return this.commentNum;
    }

    public long getDynamicId() {
        return this.dynamicId;
    }

    public List<CommunityFeedInfo.HotComment> getHotCommentList() {
        return this.hotCommentList;
    }

    public long getId() {
        return this.f73181id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public long getIssueTime() {
        return this.issueTime;
    }

    public String getPromulgatorLogo() {
        return this.promulgatorLogo;
    }

    public String getPromulgatorTitle() {
        return this.promulgatorTitle;
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVisit() {
        return this.visit;
    }

    public void setCoinTags(List<NewFlashInformationCoinTags> list) {
        this.coinTags = list;
    }

    public void setCommentNum(int i11) {
        this.commentNum = i11;
    }

    public void setDynamicId(long j11) {
        this.dynamicId = j11;
    }

    public void setHotCommentList(List<CommunityFeedInfo.HotComment> list) {
        this.hotCommentList = list;
    }

    public void setId(int i11) {
        this.f73181id = (long) i11;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setIssueTime(long j11) {
        this.issueTime = j11;
    }

    public void setPromulgatorLogo(String str) {
        this.promulgatorLogo = str;
    }

    public void setPromulgatorTitle(String str) {
        this.promulgatorTitle = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVisit(int i11) {
        this.visit = i11;
    }
}
