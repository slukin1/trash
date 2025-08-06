package androidx.camera.core;

import android.net.Uri;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageSaver f5505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Uri f5506c;

    public /* synthetic */ f0(ImageSaver imageSaver, Uri uri) {
        this.f5505b = imageSaver;
        this.f5506c = uri;
    }

    public final void run() {
        this.f5505b.lambda$postSuccess$1(this.f5506c);
    }
}
