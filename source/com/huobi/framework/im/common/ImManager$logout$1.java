package com.huobi.framework.im.common;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMCallback;

public final class ImManager$logout$1 implements V2TIMCallback {
    public final /* synthetic */ ImCommonCallback $callback;

    public ImManager$logout$1(ImCommonCallback imCommonCallback) {
        this.$callback = imCommonCallback;
    }

    public void onError(int i11, String str) {
        ImCommonCallback imCommonCallback = this.$callback;
        if (imCommonCallback != null) {
            imCommonCallback.onFailed(i11, str);
        }
        String tag = ImManager.INSTANCE.getTAG();
        IMLog.d(tag, "退出登录失败：" + i11 + ',' + str);
    }

    public void onSuccess() {
        ImCommonCallback imCommonCallback = this.$callback;
        if (imCommonCallback != null) {
            imCommonCallback.onSuccess();
        }
        IMLog.d(ImManager.INSTANCE.getTAG(), "退出登录成功");
    }
}
