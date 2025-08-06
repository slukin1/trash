package com.tencent.ugc;

final /* synthetic */ class dh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50361a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50362b;

    private dh(UGCImageProvider uGCImageProvider, long j11) {
        this.f50361a = uGCImageProvider;
        this.f50362b = j11;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider, long j11) {
        return new dh(uGCImageProvider, j11);
    }

    public final void run() {
        UGCImageProvider.lambda$seekTo$4(this.f50361a, this.f50362b);
    }
}
