package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.List;

public class MessageListGetOption implements Serializable {
    private int count;
    private boolean getCloudMessage;
    private long getTimeBegin;
    private long getTimePeriod;
    private MessageKey messageKey;
    private List<Long> messageSequenceList;
    private List<Integer> messageTypeList;
    private boolean toOlderMessage;

    public int getCount() {
        return this.count;
    }

    public long getGetTimeBegin() {
        return this.getTimeBegin;
    }

    public long getGetTimePeriod() {
        return this.getTimePeriod;
    }

    public MessageKey getMessageKey() {
        return this.messageKey;
    }

    public boolean isGetCloudMessage() {
        return this.getCloudMessage;
    }

    public boolean isToOlderMessage() {
        return this.toOlderMessage;
    }

    public void setCount(int i11) {
        this.count = i11;
    }

    public void setGetCloudMessage(boolean z11) {
        this.getCloudMessage = z11;
    }

    public void setGetTimeBegin(long j11) {
        this.getTimeBegin = j11;
    }

    public void setGetTimePeriod(long j11) {
        this.getTimePeriod = j11;
    }

    public void setMessageKey(MessageKey messageKey2) {
        this.messageKey = messageKey2;
    }

    public void setMessageSequenceList(List<Long> list) {
        this.messageSequenceList = list;
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageTypeList = list;
    }

    public void setToOlderMessage(boolean z11) {
        this.toOlderMessage = z11;
    }
}
