package com.tencent.imsdk.message;

import com.tencent.imsdk.conversation.ConversationKey;
import java.io.Serializable;
import java.util.List;

public class MessageSearchParam implements Serializable {
    private ConversationKey conversationKey;
    private List<String> keywordList;
    private int keywordListMatchType = 0;
    private List<Integer> messageTypeList;
    private int pageIndex = 0;
    private int pageSize = 0;
    private long searchTimePeriod = 0;
    private long searchTimePosition = 0;
    private List<String> senderUserIDList;

    public ConversationKey getConversationKey() {
        return this.conversationKey;
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public int getKeywordListMatchType() {
        return this.keywordListMatchType;
    }

    public List<Integer> getMessageTypeList() {
        return this.messageTypeList;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getSearchTimePeriod() {
        return this.searchTimePeriod;
    }

    public long getSearchTimePosition() {
        return this.searchTimePosition;
    }

    public List<String> getSenderUserIDList() {
        return this.senderUserIDList;
    }

    public void setConversationKey(ConversationKey conversationKey2) {
        this.conversationKey = conversationKey2;
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }

    public void setKeywordListMatchType(int i11) {
        this.keywordListMatchType = i11;
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageTypeList = list;
    }

    public void setPageIndex(int i11) {
        this.pageIndex = i11;
    }

    public void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public void setSearchTimePeriod(long j11) {
        this.searchTimePeriod = j11;
    }

    public void setSearchTimePosition(long j11) {
        this.searchTimePosition = j11;
    }

    public void setSenderUserIDList(List<String> list) {
        this.senderUserIDList = list;
    }
}
