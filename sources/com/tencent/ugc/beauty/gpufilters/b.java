package com.tencent.ugc.beauty.gpufilters;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUGreenScreenFilter f50198a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50199b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50200c;

    private b(TXCGPUGreenScreenFilter tXCGPUGreenScreenFilter, String str, boolean z11) {
        this.f50198a = tXCGPUGreenScreenFilter;
        this.f50199b = str;
        this.f50200c = z11;
    }

    public static Runnable a(TXCGPUGreenScreenFilter tXCGPUGreenScreenFilter, String str, boolean z11) {
        return new b(tXCGPUGreenScreenFilter, str, z11);
    }

    public final void run() {
        TXCGPUGreenScreenFilter.lambda$setGreenScreenFile$0(this.f50198a, this.f50199b, this.f50200c);
    }
}
