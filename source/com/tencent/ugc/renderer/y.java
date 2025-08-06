package com.tencent.ugc.renderer;

import java.util.List;

final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50811a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50812b;

    /* renamed from: c  reason: collision with root package name */
    private final List f50813c;

    private y(VideoRenderer videoRenderer, List list, List list2) {
        this.f50811a = videoRenderer;
        this.f50812b = list;
        this.f50813c = list2;
    }

    public static Runnable a(VideoRenderer videoRenderer, List list, List list2) {
        return new y(videoRenderer, list, list2);
    }

    public final void run() {
        VideoRenderer.lambda$setPerspectiveCorrectionPoints$4(this.f50811a, this.f50812b, this.f50813c);
    }
}
