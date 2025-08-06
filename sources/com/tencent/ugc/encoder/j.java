package com.tencent.ugc.encoder;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50451a;

    private j(SoftwareEncoderWrapper softwareEncoderWrapper) {
        this.f50451a = softwareEncoderWrapper;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper) {
        return new j(softwareEncoderWrapper);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$initialize$0(this.f50451a);
    }
}
