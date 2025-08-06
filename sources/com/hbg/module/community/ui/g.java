package com.hbg.module.community.ui;

import android.webkit.ValueCallback;

public final /* synthetic */ class g implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DynamicDetailActivity f17553a;

    public /* synthetic */ g(DynamicDetailActivity dynamicDetailActivity) {
        this.f17553a = dynamicDetailActivity;
    }

    public final void onReceiveValue(Object obj) {
        DynamicDetailActivity.Li(this.f17553a, (String) obj);
    }
}
