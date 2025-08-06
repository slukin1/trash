package com.tencent.liteav.base.http;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f21486a;

    /* renamed from: b  reason: collision with root package name */
    private final long f21487b;

    private d(HttpClientAndroid httpClientAndroid, long j11) {
        this.f21486a = httpClientAndroid;
        this.f21487b = j11;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, long j11) {
        return new d(httpClientAndroid, j11);
    }

    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$3(this.f21486a, this.f21487b);
    }
}
