package com.huobi.otc.flutter;

import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcC2cOrderActivity f78664b;

    public /* synthetic */ o(OtcC2cOrderActivity otcC2cOrderActivity) {
        this.f78664b = otcC2cOrderActivity;
    }

    public final void call(Object obj) {
        this.f78664b.Ii((UserVO) obj);
    }
}
