package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;

public class AgentTyping extends AgentItem<AgentTyping> {
    private boolean typing;

    public AgentTyping() {
        super.setType(RowItem.Type.AGENT_TYPING);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentTyping) || !super.equals(obj)) {
            return false;
        }
        if (this.typing == ((AgentTyping) obj).typing) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.typing ? 1 : 0);
    }

    public boolean isTyping() {
        return this.typing;
    }

    public void setTyping(boolean z11) {
        this.typing = z11;
    }

    public String toString() {
        return "typing:" + this.typing + super.toString();
    }

    public void update(AgentTyping agentTyping) {
        super.update(agentTyping);
        this.typing = agentTyping.typing;
    }
}
