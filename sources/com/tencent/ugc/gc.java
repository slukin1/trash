package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;

final /* synthetic */ class gc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass1 f50543a;

    private gc(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        this.f50543a = r12;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12) {
        return new gc(r12);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.AnonymousClass1.b(this.f50543a);
    }
}
