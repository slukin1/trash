package com.huobi.webview2.action;

import com.huobi.finance.bean.BalanceDetailInfo;
import rx.functions.Action1;
import v6.u;

public final /* synthetic */ class j0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20840b;

    public /* synthetic */ j0(u uVar) {
        this.f20840b = uVar;
    }

    public final void call(Object obj) {
        JsFinanceActionHelper.jumpToAssetRecordPage(this.f20840b.getActivity(), (BalanceDetailInfo) obj);
    }
}
