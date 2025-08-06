package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.base.GLConstants;

final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50744a;

    /* renamed from: b  reason: collision with root package name */
    private final GLConstants.GLScaleType f50745b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50746c;

    private y(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z11) {
        this.f50744a = videoPreprocessor;
        this.f50745b = gLScaleType;
        this.f50746c = z11;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z11) {
        return new y(videoPreprocessor, gLScaleType, z11);
    }

    public final void run() {
        this.f50744a.mPreprocessor.setGreenScreenParam(this.f50745b, this.f50746c);
    }
}
