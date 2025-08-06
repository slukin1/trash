package com.huobi.domain;

import bh.u;
import com.huobi.domain.data.source.remote.bean.config.RemoteModuleConfig;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RemoteModuleConfig f43820b;

    public /* synthetic */ a(RemoteModuleConfig remoteModuleConfig) {
        this.f43820b = remoteModuleConfig;
    }

    public final void run() {
        u.g(this.f43820b.getWoodPeckerHost());
    }
}
