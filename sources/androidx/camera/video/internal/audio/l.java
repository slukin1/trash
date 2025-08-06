package androidx.camera.video.internal.audio;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6047b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f6048c;

    public /* synthetic */ l(AudioSource audioSource, CallbackToFutureAdapter.a aVar) {
        this.f6047b = audioSource;
        this.f6048c = aVar;
    }

    public final void run() {
        this.f6047b.v(this.f6048c);
    }
}
