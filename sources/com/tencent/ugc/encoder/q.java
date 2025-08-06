package com.tencent.ugc.encoder;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50462a;

    private q(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f50462a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new q(softwareEncoderWrapper);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$stopSync$7(this.f50462a);
    }
}
