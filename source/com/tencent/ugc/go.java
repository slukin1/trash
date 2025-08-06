package com.tencent.ugc;

import com.tencent.liteav.base.util.k;

final /* synthetic */ class go implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50561a;

    /* renamed from: b  reason: collision with root package name */
    private final k f50562b;

    private go(UGCVideoProcessor uGCVideoProcessor, k kVar) {
        this.f50561a = uGCVideoProcessor;
        this.f50562b = kVar;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, k kVar) {
        return new go(uGCVideoProcessor, kVar);
    }

    public final void run() {
        this.f50561a.mRotation = this.f50562b;
    }
}
