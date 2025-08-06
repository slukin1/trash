package com.huobi.framework.im.common;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import java.util.List;

public final class ImManager$getGroupLastMessage$1 implements V2TIMValueCallback<List<? extends V2TIMMessage>> {
    public final /* synthetic */ OnGetLastMessageListener $listener;

    public ImManager$getGroupLastMessage$1(OnGetLastMessageListener onGetLastMessageListener) {
        this.$listener = onGetLastMessageListener;
    }

    public void onError(int i11, String str) {
    }

    public void onSuccess(List<? extends V2TIMMessage> list) {
        ImManager imManager = ImManager.INSTANCE;
        String tag = imManager.getTAG();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("获取历史消息：");
        V2TIMMessage v2TIMMessage = null;
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        IMLog.d(tag, sb2.toString());
        boolean z11 = false;
        long j11 = 0;
        if ((list != null ? list.size() : 0) > 0) {
            if (list != null) {
                v2TIMMessage = (V2TIMMessage) list.get(0);
            }
            if (v2TIMMessage != null && v2TIMMessage.getElemType() == 1) {
                z11 = true;
            }
            if (z11) {
                String str = v2TIMMessage.getNickName() + ':' + v2TIMMessage.getTextElem().getText();
                v2TIMMessage.getTimestamp();
                IMLog.d(imManager.getTAG(), "获取历史消息：" + str);
                this.$listener.onGetLastMessage(str, v2TIMMessage.getElemType(), v2TIMMessage.getTimestamp());
                return;
            }
            OnGetLastMessageListener onGetLastMessageListener = this.$listener;
            int elemType = v2TIMMessage != null ? v2TIMMessage.getElemType() : -1;
            if (v2TIMMessage != null) {
                j11 = v2TIMMessage.getTimestamp();
            }
            onGetLastMessageListener.onGetLastMessage("", elemType, j11);
            return;
        }
        this.$listener.onGetLastMessage("", 0, 0);
    }
}
