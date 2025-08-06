package com.tencent.ugc;

final /* synthetic */ class dj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50365a;

    private dj(UGCImageProvider uGCImageProvider) {
        this.f50365a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new dj(uGCImageProvider);
    }

    public final void run() {
        this.f50365a.decodeBitmapFrame();
    }
}
