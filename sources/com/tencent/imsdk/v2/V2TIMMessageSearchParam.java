package com.tencent.imsdk.v2;

import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.message.MessageSearchParam;
import java.io.Serializable;
import java.util.List;

public class V2TIMMessageSearchParam implements Serializable {
    public static final int V2TIM_KEYWORD_LIST_MATCH_TYPE_AND = 1;
    public static final int V2TIM_KEYWORD_LIST_MATCH_TYPE_OR = 0;
    private MessageSearchParam messageSearchParam = new MessageSearchParam();

    public List<String> getKeywordList() {
        return this.messageSearchParam.getKeywordList();
    }

    public MessageSearchParam getMessageSearchParam() {
        return this.messageSearchParam;
    }

    public List<Integer> getMessageTypeList() {
        return this.messageSearchParam.getMessageTypeList();
    }

    public int getPageIndex() {
        return this.messageSearchParam.getPageIndex();
    }

    public int getPageSize() {
        return this.messageSearchParam.getPageSize();
    }

    public long getSearchTimePeriod() {
        return this.messageSearchParam.getSearchTimePeriod();
    }

    public long getSearchTimePosition() {
        return this.messageSearchParam.getSearchTimePosition();
    }

    public void setConversationID(String str) {
        ConversationKey conversationKey = V2TIMConversationManagerImpl.getInstance().getConversationKey(str);
        if (conversationKey.getConversationType() == 1 || conversationKey.getConversationType() == 2) {
            this.messageSearchParam.setConversationKey(conversationKey);
        } else {
            this.messageSearchParam.setConversationKey((ConversationKey) null);
        }
    }

    public void setKeywordList(List<String> list) {
        this.messageSearchParam.setKeywordList(list);
    }

    public void setKeywordListMatchType(int i11) {
        if (i11 == 0) {
            this.messageSearchParam.setKeywordListMatchType(0);
        } else {
            this.messageSearchParam.setKeywordListMatchType(1);
        }
    }

    public void setMessageTypeList(List<Integer> list) {
        this.messageSearchParam.setMessageTypeList(list);
    }

    public void setPageIndex(int i11) {
        this.messageSearchParam.setPageIndex(i11);
    }

    public void setPageSize(int i11) {
        this.messageSearchParam.setPageSize(i11);
    }

    public void setSearchTimePeriod(long j11) {
        this.messageSearchParam.setSearchTimePeriod(j11);
    }

    public void setSearchTimePosition(long j11) {
        this.messageSearchParam.setSearchTimePosition(j11);
    }

    public void setSenderUserIDList(List<String> list) {
        this.messageSearchParam.setSenderUserIDList(list);
    }
}
