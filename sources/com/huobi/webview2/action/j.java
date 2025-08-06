package com.huobi.webview2.action;

import com.huobi.contract.entity.ContractUserInfo;
import rx.functions.Action1;
import v6.u;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f20838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20839c;

    public /* synthetic */ j(u uVar, String str) {
        this.f20838b = uVar;
        this.f20839c = str;
    }

    public final void call(Object obj) {
        JsBusinessActionHelper.lambda$dealWithSession$10(this.f20838b, this.f20839c, (ContractUserInfo.UserBean) obj);
    }
}
