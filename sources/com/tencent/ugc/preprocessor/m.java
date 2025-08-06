package com.tencent.ugc.preprocessor;

import com.tencent.ugc.preprocessor.VideoPreprocessor;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50711a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoPreprocessor.SourceType f50712b;

    private m(VideoPreprocessor videoPreprocessor, VideoPreprocessor.SourceType sourceType) {
        this.f50711a = videoPreprocessor;
        this.f50712b = sourceType;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, VideoPreprocessor.SourceType sourceType) {
        return new m(videoPreprocessor, sourceType);
    }

    public final void run() {
        this.f50711a.mSourceType = this.f50712b;
    }
}
