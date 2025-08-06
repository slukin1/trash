package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class e implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f55165b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f55166c;

    public /* synthetic */ e(PlatformViewsController.AnonymousClass1 r12, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f55165b = r12;
        this.f55166c = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f55165b.lambda$configureForTextureLayerComposition$2(this.f55166c, view, z11);
    }
}
