package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CommunitySwitchBean implements Serializable {
    private int commentState;
    private int communityState;
    private int symbolState;

    public boolean canEqual(Object obj) {
        return obj instanceof CommunitySwitchBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommunitySwitchBean)) {
            return false;
        }
        CommunitySwitchBean communitySwitchBean = (CommunitySwitchBean) obj;
        return communitySwitchBean.canEqual(this) && getCommunityState() == communitySwitchBean.getCommunityState() && getCommentState() == communitySwitchBean.getCommentState() && getSymbolState() == communitySwitchBean.getSymbolState();
    }

    public int getCommentState() {
        return this.commentState;
    }

    public int getCommunityState() {
        return this.communityState;
    }

    public int getSymbolState() {
        return this.symbolState;
    }

    public int hashCode() {
        return ((((getCommunityState() + 59) * 59) + getCommentState()) * 59) + getSymbolState();
    }

    public void setCommentState(int i11) {
        this.commentState = i11;
    }

    public void setCommunityState(int i11) {
        this.communityState = i11;
    }

    public void setSymbolState(int i11) {
        this.symbolState = i11;
    }

    public String toString() {
        return "CommunitySwitchBean(communityState=" + getCommunityState() + ", commentState=" + getCommentState() + ", symbolState=" + getSymbolState() + ")";
    }
}
