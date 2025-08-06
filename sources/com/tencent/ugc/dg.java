package com.tencent.ugc;

final /* synthetic */ class dg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50360a;

    private dg(UGCImageProvider uGCImageProvider) {
        this.f50360a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new dg(uGCImageProvider);
    }

    public final void run() {
        UGCImageProvider.lambda$stop$3(this.f50360a);
    }
}
