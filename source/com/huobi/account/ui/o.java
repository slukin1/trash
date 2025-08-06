package com.huobi.account.ui;

import com.hbg.lib.network.newkyc.bean.DominicaKycPageInfo;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DominicaKycPageInfo f41771b;

    public /* synthetic */ o(DominicaKycPageInfo dominicaKycPageInfo) {
        this.f41771b = dominicaKycPageInfo;
    }

    public final void call(Object obj) {
        DominicaKycPageActivity.oh(this.f41771b, (Void) obj);
    }
}
