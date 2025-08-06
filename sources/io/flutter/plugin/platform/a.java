package io.flutter.plugin.platform;

import io.flutter.plugin.platform.PlatformPlugin;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformPlugin.AnonymousClass2 f55160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f55161c;

    public /* synthetic */ a(PlatformPlugin.AnonymousClass2 r12, int i11) {
        this.f55160b = r12;
        this.f55161c = i11;
    }

    public final void run() {
        this.f55160b.lambda$onSystemUiVisibilityChange$0(this.f55161c);
    }
}
