package com.tencent.ugc;

final /* synthetic */ class db implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50321a;

    private db(UGCImageProvider uGCImageProvider) {
        this.f50321a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new db(uGCImageProvider);
    }

    public final void run() {
        UGCImageProvider.lambda$initialize$0(this.f50321a);
    }
}
