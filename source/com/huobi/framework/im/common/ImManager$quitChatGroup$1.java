package com.huobi.framework.im.common;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.v2.V2TIMCallback;

public final class ImManager$quitChatGroup$1 implements V2TIMCallback {
    public void onError(int i11, String str) {
        IMLog.d(ImManager.INSTANCE.getTAG(), "退出直播群失败");
    }

    public void onSuccess() {
        IMLog.d(ImManager.INSTANCE.getTAG(), "退出直播群成功");
    }
}
