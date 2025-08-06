package com.tencent.qcloud.tuikit.tuicallengine.i;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;

public class g implements V2TIMCallback {
    public g(c cVar) {
    }

    public void onError(int i11, String str) {
        TUILog.e("V4MultiCalling", "sendRejectSignaling failed, errorCode: " + i11 + " , errorMsg: " + str);
    }

    public void onSuccess() {
        TUILog.i("V4MultiCalling", "sendRejectSignaling success");
    }
}
