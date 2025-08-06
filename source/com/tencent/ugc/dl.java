package com.tencent.ugc;

final /* synthetic */ class dl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50367a;

    private dl(UGCImageProvider uGCImageProvider) {
        this.f50367a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new dl(uGCImageProvider);
    }

    public final void run() {
        this.f50367a.decodeBitmapFrame();
    }
}
