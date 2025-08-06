package com.tencent.liteav.base.http;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f21484a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f21485b;

    private c(HttpClientAndroid httpClientAndroid, Long l11) {
        this.f21484a = httpClientAndroid;
        this.f21485b = l11;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, Long l11) {
        return new c(httpClientAndroid, l11);
    }

    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$2(this.f21484a, this.f21485b);
    }
}
