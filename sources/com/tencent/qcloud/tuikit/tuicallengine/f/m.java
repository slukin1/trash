package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.TUICommonDefine;

public class m implements V2TIMCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.Callback f48447a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f48448b;

    public m(n nVar, TUICommonDefine.Callback callback) {
        this.f48448b = nVar;
        this.f48447a = callback;
    }

    public void onError(int i11, String str) {
        TUICommonDefine.Callback callback = this.f48447a;
        if (callback != null) {
            callback.onError(i11, str);
        }
    }

    public void onSuccess() {
        n nVar = this.f48448b;
        nVar.f48449a = 0;
        nVar.f48450b = null;
        TUICommonDefine.Callback callback = this.f48447a;
        if (callback != null) {
            callback.onSuccess();
        }
    }
}
