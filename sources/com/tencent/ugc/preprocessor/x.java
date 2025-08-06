package com.tencent.ugc.preprocessor;

final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50741a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50742b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50743c;

    private x(VideoPreprocessor videoPreprocessor, String str, boolean z11) {
        this.f50741a = videoPreprocessor;
        this.f50742b = str;
        this.f50743c = z11;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, String str, boolean z11) {
        return new x(videoPreprocessor, str, z11);
    }

    public final void run() {
        this.f50741a.mPreprocessor.setGreenScreenFile(this.f50742b, this.f50743c);
    }
}
