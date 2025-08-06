package com.tencent.ugc;

final /* synthetic */ class dd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50323a;

    private dd(UGCImageProvider uGCImageProvider) {
        this.f50323a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new dd(uGCImageProvider);
    }

    public final void run() {
        this.f50323a.decodeBitmapFrame();
    }
}
