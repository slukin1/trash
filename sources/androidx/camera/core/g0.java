package androidx.camera.core;

import androidx.camera.core.ImageSaver;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageSaver f5508b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageSaver.SaveError f5509c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5510d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f5511e;

    public /* synthetic */ g0(ImageSaver imageSaver, ImageSaver.SaveError saveError, String str, Throwable th2) {
        this.f5508b = imageSaver;
        this.f5509c = saveError;
        this.f5510d = str;
        this.f5511e = th2;
    }

    public final void run() {
        this.f5508b.lambda$postError$2(this.f5509c, this.f5510d, this.f5511e);
    }
}
