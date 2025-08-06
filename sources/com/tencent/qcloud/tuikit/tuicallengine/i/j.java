package com.tencent.qcloud.tuikit.tuicallengine.i;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;

public class j implements V2TIMCallback {
    public j(h hVar) {
    }

    public void onError(int i11, String str) {
        TUILog.e("V4SingleCalling", "sendHangupSignaling failed , errorCode: " + i11 + " , errorMsg: " + str);
    }

    public void onSuccess() {
    }
}
