package com.tencent.liteav.trtc;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TrtcCloudJni f21721a;

    private a(TrtcCloudJni trtcCloudJni) {
        this.f21721a = trtcCloudJni;
    }

    public static Runnable a(TrtcCloudJni trtcCloudJni) {
        return new a(trtcCloudJni);
    }

    public final void run() {
        TrtcCloudJni.lambda$enterRoom$0(this.f21721a);
    }
}
