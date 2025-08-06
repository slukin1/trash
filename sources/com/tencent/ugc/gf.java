package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;

final /* synthetic */ class gf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass2 f50547a;

    private gf(UGCSingleFilePixelFrameProvider.AnonymousClass2 r12) {
        this.f50547a = r12;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass2 r12) {
        return new gf(r12);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.AnonymousClass2.a(this.f50547a);
    }
}
