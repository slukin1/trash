package com.tencent.qcloud.tuikit.tuicallengine.j;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;

public final class b implements V2TIMCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f48516a;

    public b(String str) {
        this.f48516a = str;
    }

    public void onError(int i11, String str) {
        TUILog.e("SignalingSendUtils", "sendLineBusySignalingToInviter failed, inviteId : " + this.f48516a + " errorCode: " + i11 + " errorMsg: " + str);
    }

    public void onSuccess() {
    }
}
