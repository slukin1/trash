package com.huochat.community.model;

import android.view.View;
import com.huochat.community.enums.CommunityMenuItems;
import com.huochat.community.viewholder.CommunityMenuPopwindowItemHandler;
import java.io.Serializable;
import s9.a;

public final class CommunityMenuPopwindowItem implements a, Serializable {
    private Callback callback;
    private CommunityMenuItems communityMenuItems;
    private boolean isItemSelected;
    private String itemName;

    public interface Callback {
        void onItemClick(View view, CommunityMenuPopwindowItem communityMenuPopwindowItem);
    }

    public CommunityMenuPopwindowItem(CommunityMenuItems communityMenuItems2, String str, Callback callback2) {
        this.communityMenuItems = communityMenuItems2;
        this.itemName = str;
        this.callback = callback2;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final CommunityMenuItems getCommunityMenuItems() {
        return this.communityMenuItems;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public String getViewHandlerName() {
        return CommunityMenuPopwindowItemHandler.class.getName();
    }

    public final boolean isItemSelected() {
        return this.isItemSelected;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final void setCommunityMenuItems(CommunityMenuItems communityMenuItems2) {
        this.communityMenuItems = communityMenuItems2;
    }

    public final void setItemName(String str) {
        this.itemName = str;
    }

    public final void setItemSelected(boolean z11) {
        this.isItemSelected = z11;
    }

    public String toString() {
        return "CommunityMenuPopwindowItem(communityMenuItems=" + this.communityMenuItems + ", itemName=" + this.itemName + ", callback=" + this.callback + ')';
    }
}
