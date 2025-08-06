package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageSearchResult;
import com.tencent.imsdk.message.MessageSearchResultItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class V2TIMMessageSearchResult implements Serializable {
    private MessageSearchResult messageSearchResult;

    public List<V2TIMMessageSearchResultItem> getMessageSearchResultItems() {
        if (this.messageSearchResult == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MessageSearchResultItem messageSearchResultItem : this.messageSearchResult.getMessageSearchResultItemList()) {
            V2TIMMessageSearchResultItem v2TIMMessageSearchResultItem = new V2TIMMessageSearchResultItem();
            v2TIMMessageSearchResultItem.setMessageSearchResultItem(messageSearchResultItem);
            arrayList.add(v2TIMMessageSearchResultItem);
        }
        return arrayList;
    }

    public int getTotalCount() {
        MessageSearchResult messageSearchResult2 = this.messageSearchResult;
        if (messageSearchResult2 != null) {
            return messageSearchResult2.getTotalCount();
        }
        return 0;
    }

    public void setMessageSearchResult(MessageSearchResult messageSearchResult2) {
        this.messageSearchResult = messageSearchResult2;
    }
}
