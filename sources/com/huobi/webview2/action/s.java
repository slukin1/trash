package com.huobi.webview2.action;

import com.hbg.lib.core.webview.bean.JsMessage;
import com.huobi.account.entity.ChooseCityEntity;
import com.huobi.account.ui.ChooseCityFragment;
import v6.u;

public final /* synthetic */ class s implements ChooseCityFragment.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JsMessage f20869a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20870b;

    public /* synthetic */ s(JsMessage jsMessage, u uVar) {
        this.f20869a = jsMessage;
        this.f20870b = uVar;
    }

    public final void a(ChooseCityEntity chooseCityEntity) {
        JsBusinessActionHelper.lambda$dealWithTurkeyKycDialog$2(this.f20869a, this.f20870b, chooseCityEntity);
    }
}
