package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.List;

public abstract class GroupChatEventListener {
    public void addMessage(TUIMessageBean tUIMessageBean, String str) {
    }

    public void clearGroupMessage(String str) {
    }

    public void exitGroupChat(String str) {
    }

    public void handleRevoke(String str) {
    }

    public void onApplied(int i11) {
    }

    public void onGroupFaceUrlChanged(String str, String str2) {
    }

    public void onGroupForceExit(String str) {
    }

    public void onGroupNameChanged(String str, String str2) {
    }

    public void onMessageChanged(TUIMessageBean tUIMessageBean, int i11) {
    }

    public void onReadReport(List<MessageReceiptInfo> list) {
    }

    public void onRecvMessageModified(TUIMessageBean tUIMessageBean) {
    }

    public void onRecvNewMessage(TUIMessageBean tUIMessageBean) {
    }
}
