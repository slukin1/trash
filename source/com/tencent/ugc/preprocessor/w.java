package com.tencent.ugc.preprocessor;

final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50738a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50739b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoPreprocessorListener f50740c;

    private w(VideoPreprocessor videoPreprocessor, int i11, VideoPreprocessorListener videoPreprocessorListener) {
        this.f50738a = videoPreprocessor;
        this.f50739b = i11;
        this.f50740c = videoPreprocessorListener;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i11, VideoPreprocessorListener videoPreprocessorListener) {
        return new w(videoPreprocessor, i11, videoPreprocessorListener);
    }

    public final void run() {
        VideoPreprocessor.lambda$unregisterVideoProcessedListener$3(this.f50738a, this.f50739b, this.f50740c);
    }
}
