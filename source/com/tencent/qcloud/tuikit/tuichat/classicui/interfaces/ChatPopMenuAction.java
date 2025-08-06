package com.tencent.qcloud.tuikit.tuichat.classicui.interfaces;

public class ChatPopMenuAction {
    public OnClickListener actionClickListener;
    public int actionIcon;
    public String actionName;
    public int backGroundColor;
    private int priority;
    public int textColor = Integer.MAX_VALUE;

    @FunctionalInterface
    public interface OnClickListener {
        void onClick();
    }

    public OnClickListener getActionClickListener() {
        return this.actionClickListener;
    }

    public int getActionIcon() {
        return this.actionIcon;
    }

    public String getActionName() {
        return this.actionName;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setActionClickListener(OnClickListener onClickListener) {
        this.actionClickListener = onClickListener;
    }

    public void setActionIcon(int i11) {
        this.actionIcon = i11;
    }

    public void setActionName(String str) {
        this.actionName = str;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setTextColor(int i11) {
        this.textColor = i11;
    }
}
