package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;

final /* synthetic */ class gd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass1 f50544a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50545b;

    private gd(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12, long j11) {
        this.f50544a = r12;
        this.f50545b = j11;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12, long j11) {
        return new gd(r12, j11);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.this.seekToInFileTime(this.f50545b, false);
    }
}
