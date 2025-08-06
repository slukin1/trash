package com.tencent.ugc.encoder;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50456a;

    private m(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f50456a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new m(softwareEncoderWrapper);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$restartIDRFrame$3(this.f50456a);
    }
}
