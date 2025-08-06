package com.tencent.ugc.decoder;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50331a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f50332b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoDecoderListener f50333c;

    private b(HardwareVideoDecoder hardwareVideoDecoder, Object obj, VideoDecoderListener videoDecoderListener) {
        this.f50331a = hardwareVideoDecoder;
        this.f50332b = obj;
        this.f50333c = videoDecoderListener;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder, Object obj, VideoDecoderListener videoDecoderListener) {
        return new b(hardwareVideoDecoder, obj, videoDecoderListener);
    }

    public final void run() {
        this.f50331a.startInternal(this.f50332b, this.f50333c);
    }
}
