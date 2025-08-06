package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class gs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50569a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50570b;

    private gs(UGCVideoProcessor uGCVideoProcessor, List list) {
        this.f50569a = uGCVideoProcessor;
        this.f50570b = list;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, List list) {
        return new gs(uGCVideoProcessor, list);
    }

    public final void run() {
        UGCVideoProcessor.lambda$setSpeedList$9(this.f50569a, this.f50570b);
    }
}
