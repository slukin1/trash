package com.huobi.framework.im.common;

import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMValueCallback;

public final class ImManager$getGroupUnReadCount$1 implements V2TIMValueCallback<V2TIMConversation> {
    public final /* synthetic */ OnGetUnreadCountListener $listener;

    public ImManager$getGroupUnReadCount$1(OnGetUnreadCountListener onGetUnreadCountListener) {
        this.$listener = onGetUnreadCountListener;
    }

    public void onError(int i11, String str) {
        this.$listener.onGetUnreadAll(0);
    }

    public void onSuccess(V2TIMConversation v2TIMConversation) {
        if (v2TIMConversation != null) {
            this.$listener.onGetUnreadAll(v2TIMConversation.getUnreadCount());
        }
    }
}
