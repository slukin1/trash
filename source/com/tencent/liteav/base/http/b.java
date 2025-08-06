package com.tencent.liteav.base.http;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f21483a;

    private b(HttpClientAndroid httpClientAndroid) {
        this.f21483a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new b(httpClientAndroid);
    }

    public final void run() {
        HttpClientAndroid.lambda$cancelAll$1(this.f21483a);
    }
}
