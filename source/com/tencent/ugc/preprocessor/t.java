package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.chain.GPUInterceptor;

final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50726a;

    /* renamed from: b  reason: collision with root package name */
    private final GPUInterceptor f50727b;

    private t(VideoPreprocessor videoPreprocessor, GPUInterceptor gPUInterceptor) {
        this.f50726a = videoPreprocessor;
        this.f50727b = gPUInterceptor;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, GPUInterceptor gPUInterceptor) {
        return new t(videoPreprocessor, gPUInterceptor);
    }

    public final void run() {
        this.f50726a.mPreprocessor.setInterceptorBeforeWatermark(this.f50727b);
    }
}
