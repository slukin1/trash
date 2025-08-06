package com.tencent.imsdk.conversation;

import android.text.TextUtils;
import java.io.Serializable;

public class ConversationListFilter implements Serializable {
    private String conversationGroup;
    private int conversationType = 0;
    private long markType = 0;

    public String getConversationGroup() {
        return this.conversationGroup;
    }

    public int getConversationType() {
        return this.conversationType;
    }

    public long getMarkType() {
        return this.markType;
    }

    public boolean isNull() {
        if (this.conversationType == 0 && true == TextUtils.isEmpty(this.conversationGroup) && 0 == this.markType) {
            return true;
        }
        return false;
    }

    public void setConversationGroup(String str) {
        this.conversationGroup = str;
    }

    public void setConversationType(int i11) {
        this.conversationType = i11;
    }

    public void setMarkType(long j11) {
        this.markType = j11;
    }
}
