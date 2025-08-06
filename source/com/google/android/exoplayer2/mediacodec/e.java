package com.google.android.exoplayer2.mediacodec;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecCallback f65936b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f65937c;

    public /* synthetic */ e(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback, Runnable runnable) {
        this.f65936b = asynchronousMediaCodecCallback;
        this.f65937c = runnable;
    }

    public final void run() {
        this.f65936b.lambda$flushAsync$0(this.f65937c);
    }
}
