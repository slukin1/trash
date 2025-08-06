package com.huobi.framework.im.common;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMCallback;

public final class ImManager$joinChatGroup$1 implements V2TIMCallback {
    public final /* synthetic */ ImCommonCallback $callback;

    public ImManager$joinChatGroup$1(ImCommonCallback imCommonCallback) {
        this.$callback = imCommonCallback;
    }

    public void onError(int i11, String str) {
        String tag = ImManager.INSTANCE.getTAG();
        IMLog.d(tag, "加入群失败" + i11 + ',' + str);
        ImCommonCallback imCommonCallback = this.$callback;
        if (imCommonCallback != null) {
            imCommonCallback.onFailed(i11, str);
        }
    }

    public void onSuccess() {
        IMLog.d(ImManager.INSTANCE.getTAG(), "加入群成功");
        ImCommonCallback imCommonCallback = this.$callback;
        if (imCommonCallback != null) {
            imCommonCallback.onSuccess();
        }
    }
}
