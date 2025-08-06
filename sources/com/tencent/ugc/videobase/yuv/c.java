package com.tencent.ugc.videobase.yuv;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageNV12InputFilter f50893a;

    private c(TXCGPUImageNV12InputFilter tXCGPUImageNV12InputFilter) {
        this.f50893a = tXCGPUImageNV12InputFilter;
    }

    public static Runnable a(TXCGPUImageNV12InputFilter tXCGPUImageNV12InputFilter) {
        return new c(tXCGPUImageNV12InputFilter);
    }

    public final void run() {
        TXCGPUImageNV12InputFilter.lambda$onInit$0(this.f50893a);
    }
}
