package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;

final /* synthetic */ class ge implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass1 f50546a;

    private ge(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        this.f50546a = r12;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        return new ge(r12);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.AnonymousClass1.a(this.f50546a);
    }
}
