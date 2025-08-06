package com.tencent.ugc.encoder;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50457a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50458b;

    private n(SoftwareEncoderWrapper softwareEncoderWrapper, int i11) {
        this.f50457a = softwareEncoderWrapper;
        this.f50458b = i11;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, int i11) {
        return new n(softwareEncoderWrapper, i11);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$setBitrate$4(this.f50457a, this.f50458b);
    }
}
