package com.huochat.community.model;

import android.content.Context;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.viewholder.CommunityMenuListItemHandler;
import s9.a;

public final class CommunityMenuListItem implements a {
    private Callback callback;
    private int checkedTextColor;
    private String text;
    private int type;
    private int unCheckedTextColor;

    public interface Callback {
        boolean isChecked(CommunityMenuListItem communityMenuListItem);

        void onItemClick(CommunityMenuListItem communityMenuListItem);
    }

    public CommunityMenuListItem(int i11, String str, int i12, int i13, Callback callback2) {
        this.type = i11;
        this.text = str;
        this.checkedTextColor = i12;
        this.unCheckedTextColor = i13;
        this.callback = callback2;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final int getCheckedTextColor() {
        return this.checkedTextColor;
    }

    public final String getText() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUnCheckedTextColor() {
        return this.unCheckedTextColor;
    }

    public String getViewHandlerName() {
        return CommunityMenuListItemHandler.class.getName();
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final void setCheckedTextColor(int i11) {
        this.checkedTextColor = i11;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public final void setUnCheckedTextColor(int i11) {
        this.unCheckedTextColor = i11;
    }

    public final int getCheckedTextColor(Context context) {
        int i11 = this.checkedTextColor;
        return i11 != 0 ? i11 : CommunityThemeHelper.Companion.getColor(context, R.attr.communityMenuItemTextColor);
    }

    public final int getUnCheckedTextColor(Context context) {
        int i11 = this.unCheckedTextColor;
        return i11 != 0 ? i11 : CommunityThemeHelper.Companion.getColor(context, R.attr.communityMenuItemUnCheckTextColor);
    }

    public CommunityMenuListItem(int i11, String str, Callback callback2) {
        this(i11, str, 0, callback2);
    }

    public CommunityMenuListItem(int i11, String str, int i12, Callback callback2) {
        this(i11, str, i12, 0, callback2);
    }
}
