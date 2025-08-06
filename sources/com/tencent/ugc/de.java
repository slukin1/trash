package com.tencent.ugc;

final /* synthetic */ class de implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50324a;

    private de(UGCImageProvider uGCImageProvider) {
        this.f50324a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new de(uGCImageProvider);
    }

    public final void run() {
        UGCImageProvider.lambda$uninitialize$1(this.f50324a);
    }
}
