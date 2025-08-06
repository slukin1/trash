package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class f implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f55167b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f55168c;

    public /* synthetic */ f(PlatformViewsController.AnonymousClass1 r12, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f55167b = r12;
        this.f55168c = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f55167b.lambda$configureForVirtualDisplay$1(this.f55168c, view, z11);
    }
}
