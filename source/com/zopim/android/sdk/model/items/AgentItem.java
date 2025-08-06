package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.AgentItem;

public abstract class AgentItem<T extends AgentItem> extends RowItem<T> {
    private String avatarUri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentItem) || !super.equals(obj)) {
            return false;
        }
        String str = this.avatarUri;
        String str2 = ((AgentItem) obj).avatarUri;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getAvatarUri() {
        String str = this.avatarUri;
        return str != null ? str : "";
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.avatarUri;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public void setAvatarUri(String str) {
        this.avatarUri = str;
    }

    public void update(T t11) {
        super.update(t11);
        this.avatarUri = t11.getAvatarUri();
    }
}
