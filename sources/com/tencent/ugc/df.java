package com.tencent.ugc;

final /* synthetic */ class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50359a;

    private df(UGCImageProvider uGCImageProvider) {
        this.f50359a = uGCImageProvider;
    }

    public static Runnable a(UGCImageProvider uGCImageProvider) {
        return new df(uGCImageProvider);
    }

    public final void run() {
        UGCImageProvider.lambda$start$2(this.f50359a);
    }
}
