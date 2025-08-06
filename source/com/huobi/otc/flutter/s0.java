package com.huobi.otc.flutter;

import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class s0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcTradeSettingFlutterActivity f78677b;

    public /* synthetic */ s0(OtcTradeSettingFlutterActivity otcTradeSettingFlutterActivity) {
        this.f78677b = otcTradeSettingFlutterActivity;
    }

    public final void call(Object obj) {
        this.f78677b.Gi((UserVO) obj);
    }
}
