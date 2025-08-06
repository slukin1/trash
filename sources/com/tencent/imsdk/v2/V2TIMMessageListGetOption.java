package com.tencent.imsdk.v2;

import java.io.Serializable;
import java.util.List;

public class V2TIMMessageListGetOption implements Serializable {
    public static final int V2TIM_GET_CLOUD_NEWER_MSG = 2;
    public static final int V2TIM_GET_CLOUD_OLDER_MSG = 1;
    public static final int V2TIM_GET_LOCAL_NEWER_MSG = 4;
    public static final int V2TIM_GET_LOCAL_OLDER_MSG = 3;
    private int count;
    private long getTimeBegin;
    private long getTimePeriod;
    private int getType;
    private String groupID;
    private V2TIMMessage lastMsg;
    private long lastMsgSeq;
    private List<Long> messageSeqList;
    private List<Integer> messageTypeList;
    private String userID;

    public int getCount() {
        return this.count;
    }

    public long getGetTimeBegin() {
        return this.getTimeBegin;
    }

    public long getGetTimePeriod() {
        return this.getTimePeriod;
    }

    public int getGetType() {
        return this.getType;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public V2TIMMessage getLastMsg() {
        return this.lastMsg;
    }

    public long getLastMsgSeq() {
        return this.lastMsgSeq;
    }

    public List<Long> getMessageSeqList() {
        return this.messageSeqList;
    }

    public List<Integer> getMessageTypeList() {
        return this.messageTypeList;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setCount(int i11) {
        this.count = i11;
    }

    public void setGetTimeBegin(long j11) {
        this.getTimeBegin = j11;
    }

    public void setGetTimePeriod(long j11) {
        this.getTimePeriod = j11;
    }

    public void setGetType(int i11) {
        this.getType = i11;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setLastMsg(V2TIMMessage v2TIMMessage) {
        this.lastMsg = v2TIMMessage;
    }

    public void setLastMsgSeq(long j11) {
        this.lastMsgSeq = j11;
    }

    public void setMessageSeqList(List<Long> list) {
        this.messageSeqList = list;
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageTypeList = list;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
