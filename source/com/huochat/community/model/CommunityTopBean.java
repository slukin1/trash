package com.huochat.community.model;

import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.enums.TopDataType;
import java.io.Serializable;
import java.util.List;

public final class CommunityTopBean implements Serializable {
    private int buttonFlag;
    private CommunityMenuItems communityListSort = CommunityMenuItems.DEFAULT;
    private int dataType = TopDataType.NORMAL.getType();
    private List<TopicBean> hotTopicList;
    private String totalMsg = "";

    public final int getButtonFlag() {
        return this.buttonFlag;
    }

    public final CommunityMenuItems getCommunityListSort() {
        return this.communityListSort;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final List<TopicBean> getHotTopicList() {
        return this.hotTopicList;
    }

    public final String getTotalMsg() {
        return this.totalMsg;
    }

    public final void setButtonFlag(int i11) {
        this.buttonFlag = i11;
    }

    public final void setCommunityListSort(CommunityMenuItems communityMenuItems) {
        this.communityListSort = communityMenuItems;
    }

    public final void setDataType(int i11) {
        this.dataType = i11;
    }

    public final void setHotTopicList(List<TopicBean> list) {
        this.hotTopicList = list;
    }

    public final void setTotalMsg(String str) {
        this.totalMsg = str;
    }

    public String toString() {
        return "CommunityTopBean(dataType=" + this.dataType + ", buttonFlag=" + this.buttonFlag + ", totalMsg='" + this.totalMsg + "', communityListSort=" + this.communityListSort + ", hotTopicList=" + this.hotTopicList + ')';
    }
}
