package com.huobi.account.ui;

import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class a6 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingSettingActivity f41642b;

    public /* synthetic */ a6(TradingSettingActivity tradingSettingActivity) {
        this.f41642b = tradingSettingActivity;
    }

    public final void call(Object obj) {
        this.f41642b.Vh((UserVO) obj);
    }
}
