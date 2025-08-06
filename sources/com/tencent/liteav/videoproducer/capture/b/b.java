package com.tencent.liteav.videoproducer.capture.b;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f22594a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22595b;

    private b(a aVar, int i11) {
        this.f22594a = aVar;
        this.f22595b = i11;
    }

    public static Runnable a(a aVar, int i11) {
        return new b(aVar, i11);
    }

    public final void run() {
        a.a(this.f22594a, this.f22595b);
    }
}
