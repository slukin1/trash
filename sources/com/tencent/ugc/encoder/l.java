package com.tencent.ugc.encoder;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50455a;

    private l(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f50455a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new l(softwareEncoderWrapper);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$encodeFrame$2(this.f50455a);
    }
}
