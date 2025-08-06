package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.videobase.ConvertParams;

final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50731a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50732b;

    /* renamed from: c  reason: collision with root package name */
    private final ConvertParams f50733c;

    /* renamed from: d  reason: collision with root package name */
    private final GLConstants.PixelBufferType f50734d;

    /* renamed from: e  reason: collision with root package name */
    private final GLConstants.PixelFormatType f50735e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f50736f;

    /* renamed from: g  reason: collision with root package name */
    private final VideoPreprocessorListener f50737g;

    private v(VideoPreprocessor videoPreprocessor, int i11, ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z11, VideoPreprocessorListener videoPreprocessorListener) {
        this.f50731a = videoPreprocessor;
        this.f50732b = i11;
        this.f50733c = convertParams;
        this.f50734d = pixelBufferType;
        this.f50735e = pixelFormatType;
        this.f50736f = z11;
        this.f50737g = videoPreprocessorListener;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i11, ConvertParams convertParams, GLConstants.PixelBufferType pixelBufferType, GLConstants.PixelFormatType pixelFormatType, boolean z11, VideoPreprocessorListener videoPreprocessorListener) {
        return new v(videoPreprocessor, i11, convertParams, pixelBufferType, pixelFormatType, z11, videoPreprocessorListener);
    }

    public final void run() {
        VideoPreprocessor.lambda$registerVideoProcessedListener$2(this.f50731a, this.f50732b, this.f50733c, this.f50734d, this.f50735e, this.f50736f, this.f50737g);
    }
}
