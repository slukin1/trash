package androidx.camera.video.internal.audio;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6035a;

    public /* synthetic */ e(AudioSource audioSource) {
        this.f6035a = audioSource;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6035a.w(aVar);
    }
}
