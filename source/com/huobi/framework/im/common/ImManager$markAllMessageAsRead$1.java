package com.huobi.framework.im.common;

import com.tencent.imsdk.v2.V2TIMCallback;

public final class ImManager$markAllMessageAsRead$1 implements V2TIMCallback {
    public final /* synthetic */ ImCommonCallback $callback;

    public ImManager$markAllMessageAsRead$1(ImCommonCallback imCommonCallback) {
        this.$callback = imCommonCallback;
    }

    public void onError(int i11, String str) {
        this.$callback.onFailed(i11, str);
    }

    public void onSuccess() {
        this.$callback.onSuccess();
    }
}
