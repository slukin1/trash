package com.tencent.ugc.decoder;

import com.tencent.ugc.decoder.UGCVideoDecodeController;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController.AnonymousClass1 f50354a;

    private q(UGCVideoDecodeController.AnonymousClass1 r12) {
        this.f50354a = r12;
    }

    public static Runnable a(UGCVideoDecodeController.AnonymousClass1 r12) {
        return new q(r12);
    }

    public final void run() {
        UGCVideoDecodeController.AnonymousClass1.a(this.f50354a);
    }
}
