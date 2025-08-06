package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class hd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50595a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50596b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50597c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50598d;

    private hd(UGCVideoProcessor uGCVideoProcessor, List list, int i11, int i12) {
        this.f50595a = uGCVideoProcessor;
        this.f50596b = list;
        this.f50597c = i11;
        this.f50598d = i12;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, List list, int i11, int i12) {
        return new hd(uGCVideoProcessor, list, i11, i12);
    }

    public final void run() {
        UGCVideoProcessor.lambda$setSplitScreenList$2(this.f50595a, this.f50596b, this.f50597c, this.f50598d);
    }
}
