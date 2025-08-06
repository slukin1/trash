package com.tencent.qcloud.tuikit.tuicallengine.i;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;

public class f implements V2TIMCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48504a;

    public f(c cVar, String str) {
        this.f48504a = str;
    }

    public void onError(int i11, String str) {
        TUILog.e("V4MultiCalling", "sendCancelSignaling failed, errorCode: " + i11 + " , errorMsg: " + str);
    }

    public void onSuccess() {
        TUILog.i("V4MultiCalling", "sendCancelSignaling success, callID: " + this.f48504a);
    }
}
