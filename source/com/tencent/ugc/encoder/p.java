package com.tencent.ugc.encoder;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50461a;

    private p(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f50461a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new p(softwareEncoderWrapper);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$signalEndOfStream$6(this.f50461a);
    }
}
