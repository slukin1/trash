package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.TUICommonDefine;

public class l implements V2TIMCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f48446a;

    public l(n nVar, TUICommonDefine.Callback callback) {
        this.f48446a = callback;
    }

    public void onError(int i11, String str) {
        TUICommonDefine.Callback callback = this.f48446a;
        if (callback != null) {
            callback.onError(i11, str);
        }
    }

    public void onSuccess() {
        TUICommonDefine.Callback callback = this.f48446a;
        if (callback != null) {
            callback.onSuccess();
        }
    }
}
