package com.tencent.liteav.audio2;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AndroidInterruptedStateListener f21324a;

    private b(AndroidInterruptedStateListener androidInterruptedStateListener) {
        this.f21324a = androidInterruptedStateListener;
    }

    public static Runnable a(AndroidInterruptedStateListener androidInterruptedStateListener) {
        return new b(androidInterruptedStateListener);
    }

    public final void run() {
        AndroidInterruptedStateListener.lambda$unregisterAudioRecordingCallback$1(this.f21324a);
    }
}
