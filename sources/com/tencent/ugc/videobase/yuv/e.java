package com.tencent.ugc.videobase.yuv;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageYUVOutputFilter f50895a;

    private e(TXCGPUImageYUVOutputFilter tXCGPUImageYUVOutputFilter) {
        this.f50895a = tXCGPUImageYUVOutputFilter;
    }

    public static Runnable a(TXCGPUImageYUVOutputFilter tXCGPUImageYUVOutputFilter) {
        return new e(tXCGPUImageYUVOutputFilter);
    }

    public final void run() {
        TXCGPUImageYUVOutputFilter.lambda$setColorFormat$0(this.f50895a);
    }
}
