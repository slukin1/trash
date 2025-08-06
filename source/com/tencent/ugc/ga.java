package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;

final /* synthetic */ class ga implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass1 f50541a;

    private ga(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        this.f50541a = r12;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        return new ga(r12);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.this.decodeInternal();
    }
}
