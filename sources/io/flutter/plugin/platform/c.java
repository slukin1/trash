package io.flutter.plugin.platform;

import android.view.View;

public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f55162b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f55163c;

    public /* synthetic */ c(PlatformViewsController platformViewsController, int i11) {
        this.f55162b = platformViewsController;
        this.f55163c = i11;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f55162b.lambda$initializePlatformViewIfNeeded$0(this.f55163c, view, z11);
    }
}
