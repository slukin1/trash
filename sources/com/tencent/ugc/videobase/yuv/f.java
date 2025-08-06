package com.tencent.ugc.videobase.yuv;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageYUVOutputFilter f50896a;

    private f(TXCGPUImageYUVOutputFilter tXCGPUImageYUVOutputFilter) {
        this.f50896a = tXCGPUImageYUVOutputFilter;
    }

    public static Runnable a(TXCGPUImageYUVOutputFilter tXCGPUImageYUVOutputFilter) {
        return new f(tXCGPUImageYUVOutputFilter);
    }

    public final void run() {
        TXCGPUImageYUVOutputFilter.lambda$onOutputSizeChanged$1(this.f50896a);
    }
}
