package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f21481a;

    /* renamed from: b  reason: collision with root package name */
    private final HttpClientAndroid.d f21482b;

    private a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.d dVar) {
        this.f21481a = httpClientAndroid;
        this.f21482b = dVar;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.d dVar) {
        return new a(httpClientAndroid, dVar);
    }

    public final void run() {
        this.f21481a.doRequest(this.f21482b);
    }
}
