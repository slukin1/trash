package com.tencent.qcloud.tuikit.tuicallengine.k;

import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import java.util.List;

public final class g implements V2TIMValueCallback<List<V2TIMUserStatus>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TUICommonDefine.ValueCallback f48552a;

    public g(TUICommonDefine.ValueCallback valueCallback) {
        this.f48552a = valueCallback;
    }

    public void onError(int i11, String str) {
        TUICommonDefine.ValueCallback valueCallback = this.f48552a;
        if (valueCallback != null) {
            valueCallback.onError(i11, str);
        }
    }

    public void onSuccess(Object obj) {
        List list = (List) obj;
        if (list == null || list.isEmpty()) {
            this.f48552a.onError(-1, "getUserStatus failed");
            return;
        }
        TUICommonDefine.ValueCallback valueCallback = this.f48552a;
        if (valueCallback != null) {
            valueCallback.onSuccess(list);
        }
    }
}
