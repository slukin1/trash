package com.huochat.community.network;

import c9.b;
import com.huochat.community.CommunityManager;
import i6.d;
import java.net.SocketTimeoutException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class CommunityIntercepter implements b {
    /* access modifiers changed from: private */
    public static final void buildOkHttpClient$lambda$0(String str) {
        d.j("community", str);
    }

    public void buildHeaders(String str, Headers.Builder builder) {
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(a.f38700a);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        if (builder != null) {
            builder.addInterceptor(new CommunityIntercepter$buildOkHttpClient$$inlined$addInterceptor$1());
        }
        if (builder != null) {
            builder.addInterceptor(httpLoggingInterceptor);
        }
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
    }

    public String getHost() {
        return CommunityManager.Companion.getInstance().getBaseUrl();
    }

    public String getWebSocketHost() {
        return null;
    }

    public void onSocketTimeout(String str, Interceptor.Chain chain, SocketTimeoutException socketTimeoutException) {
    }
}
