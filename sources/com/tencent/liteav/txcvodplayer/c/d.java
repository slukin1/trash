package com.tencent.liteav.txcvodplayer.c;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21975a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21976b;

    /* renamed from: c  reason: collision with root package name */
    private final long f21977c;

    private d(a aVar, String str, long j11) {
        this.f21975a = aVar;
        this.f21976b = str;
        this.f21977c = j11;
    }

    public static Runnable a(a aVar, String str, long j11) {
        return new d(aVar, str, j11);
    }

    public final void run() {
        a.a(this.f21975a, this.f21976b, this.f21977c);
    }
}
