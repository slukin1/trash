package com.tencent.liteav.base.http;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f21488a;

    private e(HttpClientAndroid httpClientAndroid) {
        this.f21488a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new e(httpClientAndroid);
    }

    public final void run() {
        HttpClientAndroid.lambda$destroy$4(this.f21488a);
    }
}
