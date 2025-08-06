package com.tencent.imsdk.conversation;

import com.tencent.imsdk.message.DraftMessage;
import com.tencent.imsdk.message.Message;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Conversation implements Serializable {
    private static final int CONVERSATION_TYPE_C2C = 1;
    private static final int CONVERSATION_TYPE_GROUP = 2;
    private String c2cFaceUrl;
    private String c2cNickname;
    private long c2cReadTimestamp;
    private long c2cReceiptTimestamp;
    private String c2cRemark;
    private String c2cUserID;
    private List<ConversationAtInfo> conversationAtInfoList = new ArrayList();
    private List<String> conversationGroupList = new ArrayList();
    private ConversationKey conversationKey;
    private int conversationType;
    private String customData;
    private DraftMessage draftMessage;
    private String groupFaceUrl;
    private String groupID;
    private long groupLastSequence;
    private int groupMessageReceiveOption;
    private String groupName;
    private long groupReadSequence;
    private long groupRevokeTimestamp;
    private String groupType;
    private Message lastMessage;
    private List<Long> markList = new ArrayList();
    private long orderKey;
    private boolean pinned = false;
    private long unreadMessageCount;
    private int userMessageReceiveOption;

    public void addConversationAtInfoList(ConversationAtInfo conversationAtInfo) {
        this.conversationAtInfoList.add(conversationAtInfo);
    }

    public void addConversationGroup(String str) {
        this.conversationGroupList.add(str);
    }

    public void addMarkType(long j11) {
        this.markList.add(Long.valueOf(j11));
    }

    public long getC2CReadTimestamp() {
        return this.c2cReadTimestamp;
    }

    public String getC2cFaceUrl() {
        return this.c2cFaceUrl;
    }

    public String getC2cNickname() {
        return this.c2cNickname;
    }

    public long getC2cReceiptTimestamp() {
        return this.c2cReceiptTimestamp;
    }

    public String getC2cRemark() {
        return this.c2cRemark;
    }

    public String getC2cUserID() {
        return this.c2cUserID;
    }

    public List<ConversationAtInfo> getConversationAtInfoList() {
        return this.conversationAtInfoList;
    }

    public List<String> getConversationGroupList() {
        return this.conversationGroupList;
    }

    public ConversationKey getConversationKey() {
        ConversationKey conversationKey2 = new ConversationKey();
        conversationKey2.setConversationType(this.conversationType);
        int i11 = this.conversationType;
        if (1 == i11) {
            conversationKey2.setConversationID(this.c2cUserID);
        } else if (2 == i11) {
            conversationKey2.setConversationID(this.groupID);
        }
        return conversationKey2;
    }

    public int getConversationType() {
        return this.conversationType;
    }

    public String getCustomData() {
        return this.customData;
    }

    public DraftMessage getDraftMessage() {
        return this.draftMessage;
    }

    public String getGroupFaceUrl() {
        return this.groupFaceUrl;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public long getGroupLastSequence() {
        return this.groupLastSequence;
    }

    public int getGroupMessageReceiveOption() {
        return this.groupMessageReceiveOption;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getGroupReadSequence() {
        return this.groupReadSequence;
    }

    public long getGroupRevokeTimestamp() {
        return this.groupRevokeTimestamp;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public Message getLastMessage() {
        return this.lastMessage;
    }

    public List<Long> getMarkList() {
        return this.markList;
    }

    public long getOrderKey() {
        return this.orderKey;
    }

    public long getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public int getUserMessageReceiveOption() {
        return this.userMessageReceiveOption;
    }

    public boolean isPinned() {
        return this.pinned;
    }

    public void setPinned(boolean z11) {
        this.pinned = z11;
    }
}
