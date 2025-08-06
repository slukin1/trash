package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.TUICommonDefine;

public final class h implements V2TIMCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f48553a;

    public h(TUICommonDefine.Callback callback) {
        this.f48553a = callback;
    }

    public void onError(int i11, String str) {
        TUICommonDefine.Callback callback = this.f48553a;
        if (callback != null) {
            callback.onError(i11, str);
        }
    }

    public void onSuccess() {
        TUICommonDefine.Callback callback = this.f48553a;
        if (callback != null) {
            callback.onSuccess();
        }
    }
}
