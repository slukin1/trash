package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuikit.TUICommonDefine;

public final class i implements V2TIMValueCallback<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.ValueCallback f48554a;

    public i(TUICommonDefine.ValueCallback valueCallback) {
        this.f48554a = valueCallback;
    }

    public void onError(int i11, String str) {
        TUICommonDefine.ValueCallback valueCallback = this.f48554a;
        if (valueCallback != null) {
            valueCallback.onError(i11, str);
        }
    }

    public void onSuccess(Object obj) {
        boolean z11 = ((Integer) obj).intValue() > 0;
        TUICommonDefine.ValueCallback valueCallback = this.f48554a;
        if (valueCallback != null) {
            valueCallback.onSuccess(Boolean.valueOf(z11));
        }
    }
}
