package com.tencent.ugc;

import android.graphics.Bitmap;

final /* synthetic */ class gv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50576a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50577b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50578c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f50579d;

    /* renamed from: e  reason: collision with root package name */
    private final float f50580e;

    /* renamed from: f  reason: collision with root package name */
    private final float f50581f;

    private gv(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        this.f50576a = uGCVideoProcessor;
        this.f50577b = bitmap;
        this.f50578c = f11;
        this.f50579d = bitmap2;
        this.f50580e = f12;
        this.f50581f = f13;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        return new gv(uGCVideoProcessor, bitmap, f11, bitmap2, f12, f13);
    }

    public final void run() {
        this.f50576a.mVideoProcessManager.setFilter(this.f50577b, this.f50578c, this.f50579d, this.f50580e, this.f50581f);
    }
}
