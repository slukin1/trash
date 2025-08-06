package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f50550a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50551b;

    private gi(UGCThumbnailGenerator uGCThumbnailGenerator, List list) {
        this.f50550a = uGCThumbnailGenerator;
        this.f50551b = list;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator, List list) {
        return new gi(uGCThumbnailGenerator, list);
    }

    public final void run() {
        UGCThumbnailGenerator.lambda$setVideoSourceList$1(this.f50550a, this.f50551b);
    }
}
