package io.flutter.plugin.platform;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f55169b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VirtualDisplayController f55170c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f55171d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewBufferResized f55172e;

    public /* synthetic */ g(PlatformViewsController.AnonymousClass1 r12, VirtualDisplayController virtualDisplayController, float f11, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
        this.f55169b = r12;
        this.f55170c = virtualDisplayController;
        this.f55171d = f11;
        this.f55172e = platformViewBufferResized;
    }

    public final void run() {
        this.f55169b.lambda$resize$0(this.f55170c, this.f55171d, this.f55172e);
    }
}
