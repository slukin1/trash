package androidx.camera.core;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Preview f5622b;

    public /* synthetic */ m0(Preview preview) {
        this.f5622b = preview;
    }

    public final void run() {
        this.f5622b.notifyReset();
    }
}
