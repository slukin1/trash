package androidx.camera.core.impl;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5580b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5581c;

    public /* synthetic */ s(DeferrableSurface deferrableSurface, String str) {
        this.f5580b = deferrableSurface;
        this.f5581c = str;
    }

    public final void run() {
        this.f5580b.lambda$new$2(this.f5581c);
    }
}
