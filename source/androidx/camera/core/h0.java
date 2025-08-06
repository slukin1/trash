package androidx.camera.core;

import java.io.File;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageSaver f5514b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ File f5515c;

    public /* synthetic */ h0(ImageSaver imageSaver, File file) {
        this.f5514b = imageSaver;
        this.f5515c = file;
    }

    public final void run() {
        this.f5514b.lambda$run$0(this.f5515c);
    }
}
