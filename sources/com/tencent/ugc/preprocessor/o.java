package com.tencent.ugc.preprocessor;

import java.util.List;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50718a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50719b;

    private o(VideoPreprocessor videoPreprocessor, List list) {
        this.f50718a = videoPreprocessor;
        this.f50719b = list;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, List list) {
        return new o(videoPreprocessor, list);
    }

    public final void run() {
        this.f50718a.mPreprocessor.setWatermarkList(this.f50719b);
    }
}
