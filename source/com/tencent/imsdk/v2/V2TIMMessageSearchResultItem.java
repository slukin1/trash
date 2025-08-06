package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageSearchResultItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class V2TIMMessageSearchResultItem implements Serializable {
    private MessageSearchResultItem messageSearchResultItem;

    public String getConversationID() {
        MessageSearchResultItem messageSearchResultItem2 = this.messageSearchResultItem;
        if (messageSearchResultItem2 == null) {
            return "";
        }
        if (messageSearchResultItem2.getMessageType() == Message.MESSAGE_TYPE_C2C) {
            return "c2c_" + this.messageSearchResultItem.getConversationID();
        } else if (this.messageSearchResultItem.getMessageType() != Message.MESSAGE_TYPE_GROUP) {
            return "";
        } else {
            return "group_" + this.messageSearchResultItem.getConversationID();
        }
    }

    public int getMessageCount() {
        MessageSearchResultItem messageSearchResultItem2 = this.messageSearchResultItem;
        if (messageSearchResultItem2 != null) {
            return messageSearchResultItem2.getMessageCount();
        }
        return 0;
    }

    public List<V2TIMMessage> getMessageList() {
        MessageSearchResultItem messageSearchResultItem2 = this.messageSearchResultItem;
        if (messageSearchResultItem2 == null) {
            return null;
        }
        List<Message> messageList = messageSearchResultItem2.getMessageList();
        ArrayList arrayList = new ArrayList();
        for (Message message : messageList) {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            v2TIMMessage.setMessage(message);
            arrayList.add(v2TIMMessage);
        }
        return arrayList;
    }

    public void setMessageSearchResultItem(MessageSearchResultItem messageSearchResultItem2) {
        this.messageSearchResultItem = messageSearchResultItem2;
    }
}
