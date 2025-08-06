package com.tencent.ugc.videobase.yuv;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageNV12InputFilter f50894a;

    private d(TXCGPUImageNV12InputFilter tXCGPUImageNV12InputFilter) {
        this.f50894a = tXCGPUImageNV12InputFilter;
    }

    public static Runnable a(TXCGPUImageNV12InputFilter tXCGPUImageNV12InputFilter) {
        return new d(tXCGPUImageNV12InputFilter);
    }

    public final void run() {
        TXCGPUImageNV12InputFilter.lambda$setColorFormat$1(this.f50894a);
    }
}
