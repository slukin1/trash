package com.huobi.otc.flutter;

import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OtcFilterMenuFragment f78678b;

    public /* synthetic */ t(OtcFilterMenuFragment otcFilterMenuFragment) {
        this.f78678b = otcFilterMenuFragment;
    }

    public final void call(Object obj) {
        this.f78678b.Yh((UserVO) obj);
    }
}
