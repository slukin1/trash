package androidx.camera.video.internal.audio;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f6024c;

    public /* synthetic */ c(AudioSource audioSource, boolean z11) {
        this.f6023b = audioSource;
        this.f6024c = z11;
    }

    public final void run() {
        this.f6023b.z(this.f6024c);
    }
}
