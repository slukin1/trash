package com.tencent.liteav.audio2;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AndroidInterruptedStateListener f21323a;

    private a(AndroidInterruptedStateListener androidInterruptedStateListener) {
        this.f21323a = androidInterruptedStateListener;
    }

    public static Runnable a(AndroidInterruptedStateListener androidInterruptedStateListener) {
        return new a(androidInterruptedStateListener);
    }

    public final void run() {
        AndroidInterruptedStateListener.lambda$registerAudioRecordingCallback$0(this.f21323a);
    }
}
