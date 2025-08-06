package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;

final /* synthetic */ class gb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass1 f50542a;

    private gb(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        this.f50542a = r12;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        return new gb(r12);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.this.onDecodeCompletedInternal();
    }
}
