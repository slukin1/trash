package com.tencent.ugc.videobase.chain;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageFilterChain f50841a;

    private f(TXCGPUImageFilterChain tXCGPUImageFilterChain) {
        this.f50841a = tXCGPUImageFilterChain;
    }

    public static Runnable a(TXCGPUImageFilterChain tXCGPUImageFilterChain) {
        return new f(tXCGPUImageFilterChain);
    }

    public final void run() {
        this.f50841a.initFiltersAndInterceptors();
    }
}
