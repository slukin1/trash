package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;

public class AgentMessage extends AgentItem<AgentMessage> {
    private String message;

    public AgentMessage() {
        super.setType(RowItem.Type.AGENT_MESSAGE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentMessage) || !super.equals(obj)) {
            return false;
        }
        String str = this.message;
        String str2 = ((AgentMessage) obj).message;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        String str = this.message;
        return str != null ? str : "";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.message;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "msg: " + this.message + super.toString();
    }

    public void update(AgentMessage agentMessage) {
        super.update(agentMessage);
        this.message = agentMessage.message;
    }
}
