package com.huobi.domain;

import com.huobi.domain.data.source.remote.bean.config.RemoteModuleConfig;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteModuleConfig f43821b;

    public /* synthetic */ b(RemoteModuleConfig remoteModuleConfig) {
        this.f43821b = remoteModuleConfig;
    }

    public final void run() {
        AppDomainConfigUtils.g(this.f43821b);
    }
}
