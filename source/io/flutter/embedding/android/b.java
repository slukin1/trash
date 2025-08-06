package io.flutter.embedding.android;

import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;

public final /* synthetic */ class b implements KeyEventChannel.EventResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyboardManager.Responder.OnKeyEventHandledCallback f55118a;

    public /* synthetic */ b(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.f55118a = onKeyEventHandledCallback;
    }

    public final void onFrameworkResponse(boolean z11) {
        this.f55118a.onKeyEventHandled(z11);
    }
}
