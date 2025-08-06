package androidx.camera.video.internal.audio;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f6034c;

    public /* synthetic */ d(AudioSource audioSource, boolean z11) {
        this.f6033b = audioSource;
        this.f6034c = z11;
    }

    public final void run() {
        this.f6033b.q(this.f6034c);
    }
}
