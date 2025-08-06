package com.huobi.network.interceptor;

import okhttp3.Headers;

public class ContractSocketHeaderInterceptor extends SocketHeaderInterceptor {
    public void a(Headers.Builder builder) {
        super.a(builder);
        builder.set("User-Agent", "hbg_dm");
    }
}
