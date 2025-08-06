package com.tencent.ugc.beauty.gpufilters;

import com.tencent.ugc.beauty.gpufilters.TXCGPUGreenScreenFilter;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUGreenScreenFilter.AnonymousClass1 f50201a;

    private c(TXCGPUGreenScreenFilter.AnonymousClass1 r12) {
        this.f50201a = r12;
    }

    public static Runnable a(TXCGPUGreenScreenFilter.AnonymousClass1 r12) {
        return new c(r12);
    }

    public final void run() {
        TXCGPUGreenScreenFilter.AnonymousClass1.a(this.f50201a);
    }
}
