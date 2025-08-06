package com.tencent.ugc.encoder;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50459a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50460b;

    private o(SoftwareEncoderWrapper softwareEncoderWrapper, int i11) {
        this.f50459a = softwareEncoderWrapper;
        this.f50460b = i11;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i11) {
        return new o(softwareEncoderWrapper, i11);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$setFps$5(this.f50459a, this.f50460b);
    }
}
