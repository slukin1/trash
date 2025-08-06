package com.tencent.qcloud.tuikit.tuicallengine;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.i.a;

public class b implements TUICommonDefine.ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f48310a;

    public b(a aVar) {
        this.f48310a = aVar;
    }

    public void onError(int i11, String str) {
    }

    public void onSuccess(Object obj) {
        if (obj instanceof Boolean) {
            boolean unused = this.f48310a.f48182j = ((Boolean) obj).booleanValue();
            a aVar = this.f48310a;
            a aVar2 = aVar.f48176d;
            if (aVar2 != null) {
                aVar2.f48475g = aVar.f48182j;
            }
        }
    }
}
