package com.tencent.qcloud.tuikit.timcommon.component.action;

import android.graphics.Bitmap;

public class PopMenuAction {
    private PopActionClickListener actionClickListener;
    private String actionName;
    private Bitmap icon;
    private int iconResId;

    public PopActionClickListener getActionClickListener() {
        return this.actionClickListener;
    }

    public String getActionName() {
        return this.actionName;
    }

    public Bitmap getIcon() {
        return this.icon;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public void setActionClickListener(PopActionClickListener popActionClickListener) {
        this.actionClickListener = popActionClickListener;
    }

    public void setActionName(String str) {
        this.actionName = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.icon = bitmap;
    }

    public void setIconResId(int i11) {
        this.iconResId = i11;
    }
}
