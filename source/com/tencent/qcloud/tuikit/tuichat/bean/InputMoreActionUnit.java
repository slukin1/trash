package com.tencent.qcloud.tuikit.tuichat.bean;

import android.view.View;

public class InputMoreActionUnit {
    private int actionId;
    private int actionType = 0;
    private ChatInfo chatInfo;
    private int iconResId;
    private String name;
    private OnActionClickListener onClickListener = new OnActionClickListener();
    private int priority = 0;
    private int titleId;
    private View unitView;

    public class OnActionClickListener {
        public OnActionClickListener() {
        }

        public void onClick() {
            InputMoreActionUnit inputMoreActionUnit = InputMoreActionUnit.this;
            inputMoreActionUnit.onAction(inputMoreActionUnit.getChatId(), InputMoreActionUnit.this.getChatType());
        }
    }

    public int getActionId() {
        return this.actionId;
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getChatId() {
        ChatInfo chatInfo2 = this.chatInfo;
        if (chatInfo2 != null) {
            return chatInfo2.getId();
        }
        return null;
    }

    public int getChatType() {
        ChatInfo chatInfo2 = this.chatInfo;
        if (chatInfo2 != null) {
            return chatInfo2.getType();
        }
        return 0;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public String getName() {
        return this.name;
    }

    public OnActionClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public View getUnitView() {
        return this.unitView;
    }

    public boolean isEnable(int i11) {
        return true;
    }

    public void onAction(String str, int i11) {
    }

    public void setActionId(int i11) {
        this.actionId = i11;
    }

    public void setActionType(int i11) {
        this.actionType = i11;
    }

    public void setChatInfo(ChatInfo chatInfo2) {
        this.chatInfo = chatInfo2;
    }

    public void setIconResId(int i11) {
        this.iconResId = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnClickListener(OnActionClickListener onActionClickListener) {
        this.onClickListener = onActionClickListener;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setTitleId(int i11) {
        this.titleId = i11;
    }

    public void setUnitView(View view) {
        this.unitView = view;
    }
}
