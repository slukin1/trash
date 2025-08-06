package com.tencent.qcloud.tuikit.timcommon.interfaces;

import android.view.View;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public abstract class OnItemClickListener {
    public void onMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onMessageLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onMessageReadStatusClick(View view, TUIMessageBean tUIMessageBean) {
    }

    public void onReEditRevokeMessage(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onReactOnClick(String str, TUIMessageBean tUIMessageBean) {
    }

    public void onRecallClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onReplyDetailClick(TUIMessageBean tUIMessageBean) {
    }

    public void onReplyMessageClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onSendFailBtnClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onTextSelected(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onUserIconClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }

    public void onUserIconLongClick(View view, int i11, TUIMessageBean tUIMessageBean) {
    }
}
