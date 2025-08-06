package com.tencent.ugc.beauty.gpufilters;

import com.tencent.ugc.beauty.gpufilters.TXCGPUGaussianBlurFilter;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUGaussianBlurFilter.a f50197a;

    private a(TXCGPUGaussianBlurFilter.a aVar) {
        this.f50197a = aVar;
    }

    public static Runnable a(TXCGPUGaussianBlurFilter.a aVar) {
        return new a(aVar);
    }

    public final void run() {
        TXCGPUGaussianBlurFilter.a.a(this.f50197a);
    }
}
