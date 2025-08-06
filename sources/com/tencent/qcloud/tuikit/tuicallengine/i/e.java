package com.tencent.qcloud.tuikit.tuicallengine.i;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.qcloud.tuikit.tuicallengine.f.j;
import com.tencent.qcloud.tuikit.tuicallengine.f.k;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;

public class e implements V2TIMCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f48503a;

    public e(c cVar) {
        this.f48503a = cVar;
    }

    public void onError(int i11, String str) {
        TUILog.e("V4MultiCalling", "sendAcceptSignaling failed, errorCode: " + i11 + " , errorMsg: " + str);
        j jVar = this.f48503a.f48470b;
        if (jVar != null) {
            jVar.a(i11, str);
        }
    }

    public void onSuccess() {
        TUILog.i("V4MultiCalling", "sendAcceptSignaling success");
        k.f48439a = this.f48503a.f48469a;
        k.b.f48445a.c();
    }
}
