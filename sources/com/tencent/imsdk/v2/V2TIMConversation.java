package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationAtInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.DraftMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class V2TIMConversation implements Serializable {
    public static final String CONVERSATION_C2C_PREFIX = "c2c_";
    public static final String CONVERSATION_C2C_TYPE = "c2c";
    public static final String CONVERSATION_GROUP_PREFIX = "group_";
    public static final String CONVERSATION_GROUP_TYPE = "group";
    public static final int CONVERSATION_TYPE_INVALID = 0;
    public static final int V2TIM_C2C = 1;
    public static long V2TIM_CONVERSATION_MARK_TYPE_FOLD = 4;
    public static long V2TIM_CONVERSATION_MARK_TYPE_HIDE = 8;
    public static long V2TIM_CONVERSATION_MARK_TYPE_STAR = 1;
    public static long V2TIM_CONVERSATION_MARK_TYPE_UNREAD = 2;
    public static final int V2TIM_GROUP = 2;
    private Conversation conversation;

    public long getC2CReadTimestamp() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return 0;
        }
        return conversation2.getC2CReadTimestamp();
    }

    public List<String> getConversationGroupList() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return null;
        }
        return conversation2.getConversationGroupList();
    }

    public String getConversationID() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return null;
        }
        if (conversation2.getConversationKey().getConversationType() == 1) {
            return "c2c_" + this.conversation.getConversationKey().getConversationID();
        } else if (this.conversation.getConversationKey().getConversationType() != 2) {
            return "";
        } else {
            return "group_" + this.conversation.getConversationKey().getConversationID();
        }
    }

    public String getCustomData() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return null;
        }
        return conversation2.getCustomData();
    }

    public String getDraftText() {
        DraftMessage draftMessage;
        byte[] userDefinedData;
        Conversation conversation2 = this.conversation;
        if (conversation2 == null || (draftMessage = conversation2.getDraftMessage()) == null || (userDefinedData = draftMessage.getUserDefinedData()) == null) {
            return null;
        }
        return new String(userDefinedData);
    }

    public long getDraftTimestamp() {
        DraftMessage draftMessage;
        Conversation conversation2 = this.conversation;
        if (conversation2 == null || (draftMessage = conversation2.getDraftMessage()) == null) {
            return 0;
        }
        return draftMessage.getEditTime();
    }

    public String getFaceUrl() {
        if (this.conversation == null) {
            return null;
        }
        if (getType() == 1) {
            return this.conversation.getC2cFaceUrl();
        }
        if (getType() == 2) {
            return this.conversation.getGroupFaceUrl();
        }
        return null;
    }

    public List<V2TIMGroupAtInfo> getGroupAtInfoList() {
        if (this.conversation == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ConversationAtInfo conversationGroupAtInfo : this.conversation.getConversationAtInfoList()) {
            V2TIMGroupAtInfo v2TIMGroupAtInfo = new V2TIMGroupAtInfo();
            v2TIMGroupAtInfo.setConversationGroupAtInfo(conversationGroupAtInfo);
            arrayList.add(v2TIMGroupAtInfo);
        }
        return arrayList;
    }

    public String getGroupID() {
        Conversation conversation2 = this.conversation;
        if (conversation2 != null && conversation2.getConversationType() == 2) {
            return this.conversation.getGroupID();
        }
        return null;
    }

    public long getGroupReadSequence() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return 0;
        }
        return conversation2.getGroupReadSequence();
    }

    public String getGroupType() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return null;
        }
        String groupType = conversation2.getGroupType();
        if (TextUtils.isEmpty(groupType)) {
            return null;
        }
        if (groupType.equals("Private")) {
            return "Work";
        }
        return groupType.equals("ChatRoom") ? "Meeting" : groupType;
    }

    public V2TIMMessage getLastMessage() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null || conversation2.getLastMessage() == null) {
            return null;
        }
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        v2TIMMessage.setMessage(this.conversation.getLastMessage());
        return v2TIMMessage;
    }

    public List<Long> getMarkList() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return null;
        }
        return conversation2.getMarkList();
    }

    public long getOrderKey() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return 0;
        }
        return conversation2.getOrderKey();
    }

    public int getRecvOpt() {
        int groupMessageReceiveOption;
        if (this.conversation != null) {
            if (getType() == 1) {
                int userMessageReceiveOption = this.conversation.getUserMessageReceiveOption();
                if (userMessageReceiveOption == 1) {
                    return 0;
                }
                if (userMessageReceiveOption == 2) {
                    return 1;
                }
                if (userMessageReceiveOption == 3) {
                    return 2;
                }
            } else if (getType() != 2 || (groupMessageReceiveOption = this.conversation.getGroupMessageReceiveOption()) == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
                return 0;
            } else {
                if (groupMessageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
                    return 1;
                }
                if (groupMessageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public String getShowName() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return null;
        }
        if (conversation2.getConversationType() == 2) {
            if (!TextUtils.isEmpty(this.conversation.getGroupName())) {
                return this.conversation.getGroupName();
            }
            return this.conversation.getGroupID();
        } else if (this.conversation.getConversationType() != 1) {
            return null;
        } else {
            if (!TextUtils.isEmpty(this.conversation.getC2cRemark())) {
                return this.conversation.getC2cRemark();
            }
            if (!TextUtils.isEmpty(this.conversation.getC2cNickname())) {
                return this.conversation.getC2cNickname();
            }
            return this.conversation.getC2cUserID();
        }
    }

    public int getType() {
        Conversation conversation2 = this.conversation;
        if (conversation2 != null) {
            return conversation2.getConversationType();
        }
        return 0;
    }

    public int getUnreadCount() {
        Conversation conversation2 = this.conversation;
        if (conversation2 != null) {
            return (int) conversation2.getUnreadMessageCount();
        }
        return 0;
    }

    public String getUserID() {
        Conversation conversation2 = this.conversation;
        if (conversation2 != null && conversation2.getConversationType() == 1) {
            return this.conversation.getC2cUserID();
        }
        return null;
    }

    public boolean isPinned() {
        Conversation conversation2 = this.conversation;
        if (conversation2 == null) {
            return false;
        }
        return conversation2.isPinned();
    }

    public void setConversation(Conversation conversation2) {
        this.conversation = conversation2;
    }
}
