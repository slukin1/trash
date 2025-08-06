package com.tencent.imsdk.group;

import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.message.DraftMessage;
import java.io.Serializable;

public class TopicInfo implements Serializable {
    private Conversation conversation;
    private String draftText;
    private int errorCode;
    private String errorMessage;
    private GroupInfo groupInfo = new GroupInfo();

    public Conversation getConversation() {
        return this.conversation;
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

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public String getTempDraft() {
        return this.draftText;
    }

    public void setConversation(Conversation conversation2) {
        this.conversation = conversation2;
    }

    public void setErrorCode(int i11) {
        this.errorCode = i11;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setGroupInfo(GroupInfo groupInfo2) {
        this.groupInfo = groupInfo2;
    }

    public void setTempDraft(String str) {
        this.draftText = str;
    }
}
