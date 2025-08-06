package com.huobi.webview2.action;

import com.huobi.login.usercenter.external.bean.UserToken;
import rx.functions.Action0;
import sn.l;
import v6.u;

public final /* synthetic */ class y implements Action0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserToken f20889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20890c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ u f20891d;

    public /* synthetic */ y(UserToken userToken, String str, u uVar) {
        this.f20889b = userToken;
        this.f20890c = str;
        this.f20891d = uVar;
    }

    public final void call() {
        l.q(this.f20889b, this.f20890c, this.f20891d.getActivity(), false, new x(this.f20891d));
    }
}
