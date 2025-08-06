package com.tencent.ugc;

final /* synthetic */ class dc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50322a;

    private dc(UGCImageProvider uGCImageProvider) {
        this.f50322a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new dc(uGCImageProvider);
    }

    public final void run() {
        this.f50322a.decodeBitmapFrame();
    }
}
