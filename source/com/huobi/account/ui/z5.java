package com.huobi.account.ui;

import com.hbg.lib.network.otc.core.bean.UserVO;
import rx.functions.Action1;

public final /* synthetic */ class z5 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingSettingActivity f41871b;

    public /* synthetic */ z5(TradingSettingActivity tradingSettingActivity) {
        this.f41871b = tradingSettingActivity;
    }

    public final void call(Object obj) {
        this.f41871b.Wh((UserVO) obj);
    }
}
