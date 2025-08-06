package com.tencent.ugc.encoder;

final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50463a;

    private r(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f50463a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new r(softwareEncoderWrapper);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$uninitialize$8(this.f50463a);
    }
}
