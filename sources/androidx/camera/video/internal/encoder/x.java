package androidx.camera.video.internal.encoder;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f6279b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6280c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6281d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f6282e;

    public /* synthetic */ x(m mVar, int i11, String str, Throwable th2) {
        this.f6279b = mVar;
        this.f6280c = i11;
        this.f6281d = str;
        this.f6282e = th2;
    }

    public final void run() {
        this.f6279b.c(new EncodeException(this.f6280c, this.f6281d, this.f6282e));
    }
}
