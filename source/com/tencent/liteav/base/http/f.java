package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f21489a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpClientAndroid.e f21490b;

    /* renamed from: c  reason: collision with root package name */
    private final long f21491c;

    private f(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar, long j11) {
        this.f21489a = httpClientAndroid;
        this.f21490b = eVar;
        this.f21491c = j11;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar, long j11) {
        return new f(httpClientAndroid, eVar, j11);
    }

    public final void run() {
        HttpClientAndroid.lambda$doReadData$5(this.f21489a, this.f21490b, this.f21491c);
    }
}
