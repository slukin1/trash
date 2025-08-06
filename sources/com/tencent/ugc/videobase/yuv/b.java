package com.tencent.ugc.videobase.yuv;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageI420InputFilter f50892a;

    private b(TXCGPUImageI420InputFilter tXCGPUImageI420InputFilter) {
        this.f50892a = tXCGPUImageI420InputFilter;
    }

    public static Runnable a(TXCGPUImageI420InputFilter tXCGPUImageI420InputFilter) {
        return new b(tXCGPUImageI420InputFilter);
    }

    public final void run() {
        TXCGPUImageI420InputFilter.lambda$setColorFormat$1(this.f50892a);
    }
}
