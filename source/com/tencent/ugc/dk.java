package com.tencent.ugc;

final /* synthetic */ class dk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50366a;

    private dk(UGCImageProvider uGCImageProvider) {
        this.f50366a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new dk(uGCImageProvider);
    }

    public final void run() {
        this.f50366a.decodeBitmapFrame();
    }
}
