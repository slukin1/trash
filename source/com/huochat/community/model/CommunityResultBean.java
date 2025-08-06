package com.huochat.community.model;

import java.io.Serializable;
import java.util.List;

public class CommunityResultBean implements Serializable {
    private String baseCurrency = "";
    private int buttonFlag;
    private String communityId = "";
    private String communityName = "";
    private Integer followerNum = 0;
    private String gid = "";
    private String lastMid = "";
    private List<CommunityItemBean> list;
    private int nextIndex;
    private String priceCurrency = "";
    private List<String> redPacketMidList;
    private List<TopicBean> topicList;
    private String totalMsg = "";
    private int totalRedPacketNum = -1;

    public final String getBaseCurrency() {
        return this.baseCurrency;
    }

    public final int getButtonFlag() {
        return this.buttonFlag;
    }

    public final String getCommunityId() {
        return this.communityId;
    }

    public final String getCommunityName() {
        return this.communityName;
    }

    public final Integer getFollowerNum() {
        return this.followerNum;
    }

    public final String getGid() {
        return this.gid;
    }

    public final String getLastMid() {
        return this.lastMid;
    }

    public final List<CommunityItemBean> getList() {
        return this.list;
    }

    public final int getNextIndex() {
        return this.nextIndex;
    }

    public final String getPriceCurrency() {
        return this.priceCurrency;
    }

    public final List<String> getRedPacketMidList() {
        return this.redPacketMidList;
    }

    public final List<TopicBean> getTopicList() {
        return this.topicList;
    }

    public final String getTotalMsg() {
        return this.totalMsg;
    }

    public final int getTotalRedPacketNum() {
        return this.totalRedPacketNum;
    }

    public final void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public final void setButtonFlag(int i11) {
        this.buttonFlag = i11;
    }

    public final void setCommunityId(String str) {
        this.communityId = str;
    }

    public final void setCommunityName(String str) {
        this.communityName = str;
    }

    public final void setFollowerNum(Integer num) {
        this.followerNum = num;
    }

    public final void setGid(String str) {
        this.gid = str;
    }

    public final void setLastMid(String str) {
        this.lastMid = str;
    }

    public final void setList(List<CommunityItemBean> list2) {
        this.list = list2;
    }

    public final void setNextIndex(int i11) {
        this.nextIndex = i11;
    }

    public final void setPriceCurrency(String str) {
        this.priceCurrency = str;
    }

    public final void setRedPacketMidList(List<String> list2) {
        this.redPacketMidList = list2;
    }

    public final void setTopicList(List<TopicBean> list2) {
        this.topicList = list2;
    }

    public final void setTotalMsg(String str) {
        this.totalMsg = str;
    }

    public final void setTotalRedPacketNum(int i11) {
        this.totalRedPacketNum = i11;
    }

    public String toString() {
        return "CommunityResultBean(nextIndex=" + this.nextIndex + ", lastMid=" + this.lastMid + ", gid=" + this.gid + ", followerNum=" + this.followerNum + ", communityId=" + this.communityId + ", baseCurrency=" + this.baseCurrency + ", priceCurrency=" + this.priceCurrency + ", redPacketMidList=" + this.redPacketMidList + ", list=" + this.list + "),buttonFlag=" + this.buttonFlag + ", totalMsg=" + this.totalMsg;
    }
}
