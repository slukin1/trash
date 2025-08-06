package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.timcommon.bean.MessageReceiptInfo;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.List;

public abstract class C2CChatEventListener {
    public void addMessage(TUIMessageBean tUIMessageBean, String str) {
    }

    public void clearC2CMessage(String str) {
    }

    public void exitC2CChat(String str) {
    }

    public void handleRevoke(String str) {
    }

    public void onFriendFaceUrlChanged(String str, String str2) {
    }

    public void onFriendNameChanged(String str, String str2) {
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
